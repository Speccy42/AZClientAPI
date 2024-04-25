package fr.speccy.azclientapi.bukkit.packets.player;

import fr.speccy.azclientapi.bukkit.AZClientPlugin;
import fr.speccy.azclientapi.bukkit.AZManager;
import fr.speccy.azclientapi.bukkit.handlers.PLSPWorldEnv;
import org.bukkit.World;
import org.bukkit.entity.Player;
import pactify.client.api.plsp.packet.client.PLSPPacketWorldEnv;

public class PacketWorldEnv {
    private static final AZManager AZManager = AZClientPlugin.main.getAZManager();

    public static void reset(Player player) {
        PLSPPacketWorldEnv WorldEnvPacket = new PLSPPacketWorldEnv();
        World world = player.getWorld();
        WorldEnvPacket.setName(world.getName());
        WorldEnvPacket.setType(world.getWorldType().name());

        AZManager.sendPLSPMessage(player, WorldEnvPacket);
    }

    public static void setEnv(Player player, PLSPWorldEnv env) {
        PLSPPacketWorldEnv WorldEnvPacket = new PLSPPacketWorldEnv();
        WorldEnvPacket.setName(player.getWorld().getName());
        WorldEnvPacket.setType(env.name());

        AZManager.sendPLSPMessage(player, WorldEnvPacket);
    }
}
