package fr.speccy.azclientapi.bukkit.packets;

import fr.speccy.azclientapi.bukkit.AZClientPlugin;
import org.bukkit.entity.Player;
import pactify.client.api.plsp.packet.client.PLSPPacketConfFlag;

public class PacketConfFlag {

    public static void setFlag(Player player, String flag, Boolean enabled) {
        AZClientPlugin.main.getAZManager().sendPLSPMessage(player, new PLSPPacketConfFlag(flag, enabled));
    }
}
