package fr.speccy.azclientapi.bukkit.packets.player;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import fr.speccy.azclientapi.bukkit.AZClientPlugin;
import fr.speccy.azclientapi.bukkit.AZPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;

import java.util.*;

public class PacketWindow implements Listener {
    private final Map<UUID, Integer> windowId = new HashMap<>();
    private static final Set<UUID> customWindow = new HashSet<>();
    private static final Map<UUID, String> inventoryType = new HashMap<>();

    public PacketWindow(AZClientPlugin plugin) {
        ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(plugin, ListenerPriority.NORMAL, PacketType.Play.Server.TRANSACTION) {
            @Override
            public void onPacketSending(PacketEvent event) {
                Player player = event.getPlayer();
                UUID uuid = event.getPlayer().getUniqueId();
                PacketContainer packet = event.getPacket();
                if (AZPlayer.hasAZLauncher(player)) {
                    if (customWindow.contains(uuid)) {
                        if (!inventoryType.containsKey(uuid)) {
                            packet.getIntegers().write(0, windowId.get(uuid));
                        } else {
                            packet.getIntegers().write(0, windowId.get(uuid)-100);
                        }
                        boolean getAccepted = packet.getBooleans().read(0);
                        if (!getAccepted) {
                            packet.getBooleans().write(0, true);
                        }
                        event.setPacket(packet);
                    }
                }
            }
        });

        ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(plugin, ListenerPriority.NORMAL, PacketType.Play.Server.OPEN_WINDOW) {
            @Override
            public void onPacketSending(PacketEvent event) {
                Player player = event.getPlayer();
                UUID uuid = event.getPlayer().getUniqueId();
                PacketContainer packet = event.getPacket();
                if (AZPlayer.hasAZLauncher(player)) {
                    windowId.put(uuid, windowId.get(uuid)+1);
                    if (windowId.get(uuid) >= 201) {
                        windowId.put(uuid, windowId.get(uuid)-100);
                    }
                    if (customWindow.contains(uuid)) {
                        if (packet.getStrings().read(0).equalsIgnoreCase("minecraft:container")) {
                            packet.getIntegers().write(0, windowId.get(uuid));
                            event.setPacket(packet);
                        } else {
                            inventoryType.put(uuid, packet.getStrings().read(0));
                        }
                    }
                }
            }
        });

        ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(plugin, ListenerPriority.NORMAL, PacketType.Play.Client.CLOSE_WINDOW) {
            @Override
            public void onPacketReceiving(PacketEvent event) {
                Player player = event.getPlayer();
                UUID uuid = event.getPlayer().getUniqueId();
                PacketContainer packet = event.getPacket();
                if (AZPlayer.hasAZLauncher(player)) {
                    if (customWindow.contains(uuid)) {
                        inventoryType.remove(uuid);
                        packet.getIntegers().write(0, windowId.get(uuid)-100);
                        event.setPacket(packet);
                        remove(player);
                    }
                }
            }
        });

        ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(plugin, ListenerPriority.NORMAL, PacketType.Play.Client.WINDOW_CLICK) {
            @Override
            public void onPacketReceiving(PacketEvent event) {
                Player player = event.getPlayer();
                UUID uuid = event.getPlayer().getUniqueId();
                PacketContainer packet = event.getPacket();
                if (AZPlayer.hasAZLauncher(player)) {
                    if (customWindow.contains(uuid)) {
                        packet.getIntegers().write(0, windowId.get(uuid)-100);
                        event.setPacket(packet);
                    }
                }
            }
        });

        ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(plugin, ListenerPriority.NORMAL, PacketType.Play.Server.WINDOW_ITEMS) {
            @Override
            public void onPacketSending(PacketEvent event) {
                Player player = event.getPlayer();
                UUID uuid = event.getPlayer().getUniqueId();
                PacketContainer packet = event.getPacket();
                if (AZPlayer.hasAZLauncher(player)) {
                    if (customWindow.contains(uuid)) {
                        if (!inventoryType.containsKey(uuid)) {
                            packet.getIntegers().write(0, windowId.get(uuid));
                        } else {
                            packet.getIntegers().write(0, windowId.get(uuid)-100);
                        }
                        event.setPacket(packet);
                    }
                }
            }
        });

        ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(plugin, ListenerPriority.NORMAL, PacketType.Play.Server.WINDOW_DATA) {
            @Override
            public void onPacketSending(PacketEvent event) {
                Player player = event.getPlayer();
                UUID uuid = event.getPlayer().getUniqueId();
                PacketContainer packet = event.getPacket();
                if (AZPlayer.hasAZLauncher(player)) {
                    if (customWindow.contains(uuid)) {
                        if (!inventoryType.containsKey(uuid)) {
                            packet.getIntegers().write(0, windowId.get(uuid));
                        } else {
                            packet.getIntegers().write(0, windowId.get(uuid)-100);
                        }
                        event.setPacket(packet);
                    }
                }
            }
        });
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        UUID uuid = event.getPlayer().getUniqueId();
        if (AZPlayer.hasAZLauncher(player)) {
            windowId.put(uuid, 100);
            remove(player);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        UUID uuid = event.getPlayer().getUniqueId();
        if (AZPlayer.hasAZLauncher(player)) {
            windowId.remove(uuid);
            remove(player);
        }
    }

    public static void openInventory(Player player, Inventory inventory) {
        UUID uuid = player.getUniqueId();
        if (AZPlayer.hasAZLauncher(player)) {
            customWindow.add(uuid);
            player.openInventory(inventory);
        }
    }

    public void remove(Player player) {
        UUID uuid = player.getUniqueId();
        if (AZPlayer.hasAZLauncher(player)) {
            customWindow.remove(uuid);
        }
    }
}
