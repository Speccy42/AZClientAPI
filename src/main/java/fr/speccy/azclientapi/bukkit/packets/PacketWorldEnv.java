package fr.speccy.azclientapi.bukkit.packets;

import fr.speccy.azclientapi.bukkit.AZClientPlugin;
import fr.speccy.azclientapi.bukkit.handlers.PLSPWorldEnv;
import org.bukkit.World;
import org.bukkit.entity.Player;
import pactify.client.api.plsp.packet.client.PLSPPacketWorldEnv;

public class PacketWorldEnv {

    public static void setWorldEnv(Player player, PLSPWorldEnv env) {
        World world = player.getWorld();
        AZClientPlugin.main.getAZManager().sendPLSPMessage(player, new PLSPPacketWorldEnv(world.getName(), env.name()));
    }
}
