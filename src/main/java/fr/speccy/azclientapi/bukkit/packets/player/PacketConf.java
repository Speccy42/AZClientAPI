package fr.speccy.azclientapi.bukkit.packets.player;

import fr.speccy.azclientapi.bukkit.AZClientPlugin;
import fr.speccy.azclientapi.bukkit.AZManager;
import fr.speccy.azclientapi.bukkit.handlers.PLSPConfFlag;
import fr.speccy.azclientapi.bukkit.handlers.PLSPConfInt;
import org.bukkit.entity.Player;
import pactify.client.api.plsp.packet.client.PLSPPacketConfFlag;
import pactify.client.api.plsp.packet.client.PLSPPacketConfInt;

public class PacketConf {
    private static final AZManager AZManager = AZClientPlugin.main.getAZManager();

    public static void setFlag(Player player, PLSPConfFlag flag, Boolean enabled) {
        PLSPPacketConfFlag PacketConfFlag = new PLSPPacketConfFlag();
        PacketConfFlag.setFlag(flag.name().toLowerCase());
        PacketConfFlag.setEnabled(enabled);

        AZManager.sendPLSPMessage(player, PacketConfFlag);
    }

    public static void setInt(Player player, PLSPConfInt param, Integer value) {
        PLSPPacketConfInt PacketConfInt = new PLSPPacketConfInt();
        PacketConfInt.setParam(param.name().toLowerCase());
        PacketConfInt.setValue(value);

        AZManager.sendPLSPMessage(player, PacketConfInt);
    }
}
