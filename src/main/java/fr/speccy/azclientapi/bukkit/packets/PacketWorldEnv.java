package fr.speccy.azclientapi.bukkit.packets;

import fr.speccy.azclientapi.bukkit.AZClientPlugin;
import org.bukkit.World;
import org.bukkit.entity.Player;
import pactify.client.api.plsp.packet.client.PLSPPacketWorldEnv;

public class PacketWorldEnv {

    public static void setWorldEnv(Player player, String env) {
        World world = player.getWorld();
        AZClientPlugin.main.getAZManager().sendPLSPMessage(player, new PLSPPacketWorldEnv(String.valueOf(world), env));
    }
}
