package fr.speccy.azclientapi.bukkit.packets.player;

import fr.speccy.azclientapi.bukkit.AZClientPlugin;
import fr.speccy.azclientapi.bukkit.AZManager;
import org.bukkit.entity.Player;
import pactify.client.api.plsp.packet.client.PLSPPacketReset;

public class PacketReset {
    private static final AZManager AZManager = AZClientPlugin.main.getAZManager();

    public static void reset(Player player) {
        AZManager.sendPLSPMessage(player, new PLSPPacketReset());
    }
}
