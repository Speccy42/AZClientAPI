package fr.speccy.azclientapi.bukkit.packets;

import fr.speccy.azclientapi.bukkit.AZClientPlugin;
import org.bukkit.entity.Player;
import pactify.client.api.plsp.packet.client.PLSPPacketReset;

public class AllPacketReset {

    public static void reset(Player player) {
        AZClientPlugin.main.getAZManager().sendPLSPMessage(player, new PLSPPacketReset());
    }
}
