package fr.speccy.azclientapi.bukkit.packets;

import fr.speccy.azclientapi.bukkit.AZClientPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import pactify.client.api.plsp.packet.client.PLSPPacketWorldEnv;

public class PacketWorldEnv {

    public static void setWorldEnv(String world, String type) {
        for (Player players : Bukkit.getOnlinePlayers()) {
            AZClientPlugin.main.getAZManager().sendPLSPMessage(players, new PLSPPacketWorldEnv(world, type));
        }
    }
}
