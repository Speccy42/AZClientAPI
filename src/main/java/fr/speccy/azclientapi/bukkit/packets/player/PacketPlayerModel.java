package fr.speccy.azclientapi.bukkit.packets.player;

import fr.speccy.azclientapi.bukkit.AZClientPlugin;
import fr.speccy.azclientapi.bukkit.AZManager;
import fr.speccy.azclientapi.bukkit.handlers.PLSPPlayerModel;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import pactify.client.api.plprotocol.metadata.PactifyModelMetadata;
import pactify.client.api.plsp.packet.client.PLSPPacketPlayerMeta;

public class PacketPlayerModel {
    private static final AZManager AZManager = AZClientPlugin.main.getAZManager();

    public static void reset(Player player) {
        PLSPPacketPlayerMeta PlayerMetaPacket = new PLSPPacketPlayerMeta(player.getUniqueId());
        PactifyModelMetadata model = new PactifyModelMetadata(-1);
        PlayerMetaPacket.setModel(model);

        AZManager.sendPLSPMessage(player, PlayerMetaPacket);
        for (Player players : Bukkit.getOnlinePlayers()) {
            AZManager.sendPLSPMessage(players, PlayerMetaPacket);
        }
    }

    public static void setModel(Player player, PLSPPlayerModel entity) {
        PLSPPacketPlayerMeta PlayerMetaPacket = new PLSPPacketPlayerMeta(player.getUniqueId());
        PactifyModelMetadata model = new PactifyModelMetadata();
        model.setId(entity.getId());
        PlayerMetaPacket.setModel(model);

        AZManager.sendPLSPMessage(player, PlayerMetaPacket);
        for (Player players : Bukkit.getOnlinePlayers()) {
            AZManager.sendPLSPMessage(players, PlayerMetaPacket);
        }
    }

    public static void setModel(Player player, PLSPPlayerModel entity, Float OffsetX, Float OffsetY, Float OffsetZ) {
        PLSPPacketPlayerMeta PlayerMetaPacket = new PLSPPacketPlayerMeta(player.getUniqueId());
        PactifyModelMetadata model = new PactifyModelMetadata();
        model.setId(entity.getId());
        model.setOffsetX(OffsetX);
        model.setOffsetY(OffsetY);
        model.setOffsetZ(OffsetZ);
        PlayerMetaPacket.setModel(model);

        AZManager.sendPLSPMessage(player, PlayerMetaPacket);
        for (Player players : Bukkit.getOnlinePlayers()) {
            AZManager.sendPLSPMessage(players, PlayerMetaPacket);
        }
    }

    public static void setModel(Player player, PLSPPlayerModel entity, Float EyeHeightStand, Float EyeHeightElytra, Float EyeHeightSleep, Float EyeHeightSneak) {
        PLSPPacketPlayerMeta PlayerMetaPacket = new PLSPPacketPlayerMeta(player.getUniqueId());
        PactifyModelMetadata model = new PactifyModelMetadata();
        model.setId(entity.getId());
        model.setEyeHeightStand(EyeHeightStand);
        model.setEyeHeightElytra(EyeHeightElytra);
        model.setEyeHeightSleep(EyeHeightSleep);
        model.setEyeHeightSneak(EyeHeightSneak);
        PlayerMetaPacket.setModel(model);

        AZManager.sendPLSPMessage(player, PlayerMetaPacket);
        for (Player players : Bukkit.getOnlinePlayers()) {
            AZManager.sendPLSPMessage(players, PlayerMetaPacket);
        }
    }

    public static void setModel(Player player, PLSPPlayerModel entity, Float OffsetX, Float OffsetY, Float OffsetZ, Float EyeHeightStand, Float EyeHeightElytra, Float EyeHeightSleep, Float EyeHeightSneak) {
        PLSPPacketPlayerMeta PlayerMetaPacket = new PLSPPacketPlayerMeta(player.getUniqueId());
        PactifyModelMetadata model = new PactifyModelMetadata();
        model.setId(entity.getId());
        model.setOffsetX(OffsetX);
        model.setOffsetY(OffsetY);
        model.setOffsetZ(OffsetZ);
        model.setEyeHeightStand(EyeHeightStand);
        model.setEyeHeightElytra(EyeHeightElytra);
        model.setEyeHeightSleep(EyeHeightSleep);
        model.setEyeHeightSneak(EyeHeightSneak);
        PlayerMetaPacket.setModel(model);

        AZManager.sendPLSPMessage(player, PlayerMetaPacket);
        for (Player players : Bukkit.getOnlinePlayers()) {
            AZManager.sendPLSPMessage(players, PlayerMetaPacket);
        }
    }
}
