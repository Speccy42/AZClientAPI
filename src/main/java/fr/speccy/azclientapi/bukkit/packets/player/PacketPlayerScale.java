package fr.speccy.azclientapi.bukkit.packets.player;

import fr.speccy.azclientapi.bukkit.AZClientPlugin;
import fr.speccy.azclientapi.bukkit.AZManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import pactify.client.api.plprotocol.metadata.PactifyScaleMetadata;
import pactify.client.api.plsp.packet.client.PLSPPacketEntityMeta;

public class PacketPlayerScale {
    private static final AZManager AZManager = AZClientPlugin.main.getAZManager();

    public static void reset(Player player) {
        PLSPPacketEntityMeta EntityMetaPacket = new PLSPPacketEntityMeta(player.getEntityId());
        PactifyScaleMetadata scaleMetadata = new PactifyScaleMetadata();
        scaleMetadata.setDefined(false);
        EntityMetaPacket.setScale(scaleMetadata);

        AZManager.sendPLSPMessage(player, EntityMetaPacket);
        for (Player players : Bukkit.getOnlinePlayers()) {
            AZManager.sendPLSPMessage(players, EntityMetaPacket);
        }
    }

    public static void setScale(Player player, Float BboxH, Float BboxW, Float RenderD, Float RenderH, Float RenderW, Float Tags) {
        PLSPPacketEntityMeta EntityMetaPacket = new PLSPPacketEntityMeta(player.getEntityId());
        PactifyScaleMetadata scaleMetadata = new PactifyScaleMetadata();
        scaleMetadata.setBboxH(BboxH);
        scaleMetadata.setBboxW(BboxW);
        scaleMetadata.setRenderD(RenderD);
        scaleMetadata.setRenderH(RenderH);
        scaleMetadata.setRenderW(RenderW);
        scaleMetadata.setTags(Tags);
        scaleMetadata.setDefined(true);
        EntityMetaPacket.setScale(scaleMetadata);

        AZManager.sendPLSPMessage(player, EntityMetaPacket);
        for (Player players : Bukkit.getOnlinePlayers()) {
            AZManager.sendPLSPMessage(players, EntityMetaPacket);
        }
    }

    public static void setScale(Player player, Float BboxH, Float BboxW, Float RenderD, Float RenderH, Float RenderW, Float ItemD, Float ItemH, Float ItemW, Float Tags) {
        PLSPPacketEntityMeta EntityMetaPacket = new PLSPPacketEntityMeta(player.getEntityId());
        PactifyScaleMetadata scaleMetadata = new PactifyScaleMetadata();
        scaleMetadata.setBboxH(BboxH);
        scaleMetadata.setBboxW(BboxW);
        scaleMetadata.setRenderD(RenderD);
        scaleMetadata.setRenderH(RenderH);
        scaleMetadata.setRenderW(RenderW);
        scaleMetadata.setItemD(ItemD);
        scaleMetadata.setItemH(ItemH);
        scaleMetadata.setItemW(ItemW);
        scaleMetadata.setTags(Tags);
        scaleMetadata.setDefined(true);
        EntityMetaPacket.setScale(scaleMetadata);

        AZManager.sendPLSPMessage(player, EntityMetaPacket);
        for (Player players : Bukkit.getOnlinePlayers()) {
            AZManager.sendPLSPMessage(players, EntityMetaPacket);
        }
    }
}
