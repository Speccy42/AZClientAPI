package fr.speccy.azclientapi.bukkit.packets;

import fr.speccy.azclientapi.bukkit.AZClientPlugin;
import org.bukkit.entity.Player;
import pactify.client.api.plsp.packet.client.PLSPPacketVignette;

public class PacketVignette {
    public static void setVignette(Player player, Float red, Float green, Float blue) {
        AZClientPlugin.main.getAZManager().sendPLSPMessage(player, new PLSPPacketVignette(true, red, green, blue));
    }

    public static void resetVignette(Player player) {
        AZClientPlugin.main.getAZManager().sendPLSPMessage(player, new PLSPPacketVignette(false, 0, 0, 0));
    }
}
