package fr.speccy.azclientapi.bukkit.packets;

import fr.speccy.azclientapi.bukkit.AZClientPlugin;
import org.bukkit.entity.Player;
import pactify.client.api.plsp.packet.client.PLSPPacketVignette;

public class PacketVignette {
    
    public static void setVignette(Player player, Integer red, Integer green, Integer blue) {
        float redFloat = (float) red / 255;
        float greenFloat = (float) green / 255;
        float blueFloat = (float) blue / 255;
        AZClientPlugin.main.getAZManager().sendPLSPMessage(player, new PLSPPacketVignette(true, redFloat, greenFloat, blueFloat));
    }

    public static void resetVignette(Player player) {
        AZClientPlugin.main.getAZManager().sendPLSPMessage(player, new PLSPPacketVignette(false, 0, 0, 0));
    }
}
