package fr.speccy.azclientapi.bukkit.packets;

import fr.speccy.azclientapi.bukkit.AZClientPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import pactify.client.api.plprotocol.metadata.PactifyModelMetadata;
import pactify.client.api.plsp.packet.client.PLSPPacketPlayerModel;

public class PacketPlayerModel {

    public static void setPlayerModel(Player player, Integer entityID) {
        for (Player players : Bukkit.getOnlinePlayers()) {
            AZClientPlugin.main.getAZManager().sendPLSPMessage(players, new PLSPPacketPlayerModel(player.getUniqueId(), new PactifyModelMetadata(entityID)));
        }
    }

    public static void resetPlayerModel(Player player) {
        for (Player players : Bukkit.getOnlinePlayers()) {
            AZClientPlugin.main.getAZManager().sendPLSPMessage(players, new PLSPPacketPlayerModel(player.getUniqueId(), new PactifyModelMetadata(-1)));
        }
    }
}
