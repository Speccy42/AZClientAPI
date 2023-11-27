package fr.speccy.azclientapi.bukkit.packets;

import fr.speccy.azclientapi.bukkit.AZClientPlugin;
import org.bukkit.entity.Player;
import pactify.client.api.plsp.packet.client.PLSPPacketVignette;

public class PacketVignette {
    public static void setVignette(Player player, Integer r, Integer g, Integer b) {
        AZClientPlugin.main.getAZManager().sendPLSPMessage(player, new PLSPPacketVignette(true, r, g, b));
    }

    public static void resetVignette(Player player) {
        AZClientPlugin.main.getAZManager().sendPLSPMessage(player, new PLSPPacketVignette(false, 0, 0, 0));
    }
}
