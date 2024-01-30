package fr.speccy.azclientapi.bukkit.packets;

import fr.speccy.azclientapi.bukkit.AZClientPlugin;
import fr.speccy.azclientapi.bukkit.AZManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import pactify.client.api.plprotocol.metadata.PactifyScaleMetadata;
import pactify.client.api.plprotocol.metadata.PactifyTagMetadata;
import pactify.client.api.plsp.packet.client.PLSPPacketEntityMeta;

public class PacketEntityMeta {

    public static void setPlayerScale(Player player, Float BboxH, Float BboxW, Float RenderD, Float RenderH, Float RenderW, Boolean ScaleItems) {
        AZManager azManager = AZClientPlugin.main.getAZManager();
        PLSPPacketEntityMeta entityMetaPacket = new PLSPPacketEntityMeta(player.getEntityId());
        PactifyScaleMetadata scaleMetadata = new PactifyScaleMetadata();
        scaleMetadata.setBboxH(BboxH);
        scaleMetadata.setBboxW(BboxW);
        scaleMetadata.setRenderD(RenderD);
        scaleMetadata.setRenderH(RenderH);
        scaleMetadata.setRenderW(RenderW);
        scaleMetadata.setScaleItems(ScaleItems);
        scaleMetadata.setDefined(true);
        entityMetaPacket.setScale(scaleMetadata);

        for (Player players : Bukkit.getOnlinePlayers()) {
            azManager.sendPLSPMessage(players, entityMetaPacket);
        }
    }

    public static void resetPlayerScale(Player player) {
        AZManager azManager = AZClientPlugin.main.getAZManager();
        PLSPPacketEntityMeta entityMetaPacket = new PLSPPacketEntityMeta(player.getEntityId());
        PactifyScaleMetadata scaleMetadata = new PactifyScaleMetadata();
        scaleMetadata.setDefined(false);
        entityMetaPacket.setScale(scaleMetadata);

        for (Player players : Bukkit.getOnlinePlayers()) {
            azManager.sendPLSPMessage(players, entityMetaPacket);
        }
    }

    public static void setPlayerOpacity(Player player, Float opacity) {
        AZManager azManager = AZClientPlugin.main.getAZManager();
        PLSPPacketEntityMeta entityMetaPacket = new PLSPPacketEntityMeta(player.getEntityId());
        entityMetaPacket.setOpacity(opacity);

        for (Player players : Bukkit.getOnlinePlayers()) {
            azManager.sendPLSPMessage(players, entityMetaPacket);
        }
    }

    public static void resetPlayerOpacity(Player player) {
        AZManager azManager = AZClientPlugin.main.getAZManager();
        PLSPPacketEntityMeta entityMetaPacket = new PLSPPacketEntityMeta(player.getEntityId());
        entityMetaPacket.setOpacity(-1.0F);

        for (Player players : Bukkit.getOnlinePlayers()) {
            azManager.sendPLSPMessage(players, entityMetaPacket);
        }
    }

    public static void setNameTagOpacity(Player player, Float opacity) {
        AZManager azManager = AZClientPlugin.main.getAZManager();
        PLSPPacketEntityMeta entityMetaPacket = new PLSPPacketEntityMeta(player.getEntityId());
        PactifyTagMetadata entityTagPacket = new PactifyTagMetadata();
        entityTagPacket.setOpacity(opacity);
        entityMetaPacket.setTag(entityTagPacket);

        for (Player players : Bukkit.getOnlinePlayers()) {
            azManager.sendPLSPMessage(players, entityMetaPacket);
        }
    }

    public static void resetNameTagOpacity(Player player) {
        AZManager azManager = AZClientPlugin.main.getAZManager();
        PLSPPacketEntityMeta entityMetaPacket = new PLSPPacketEntityMeta(player.getEntityId());
        PactifyTagMetadata entityTagPacket = new PactifyTagMetadata();
        entityTagPacket.setOpacity(-1.0F);
        entityMetaPacket.setTag(entityTagPacket);

        for (Player players : Bukkit.getOnlinePlayers()) {
            azManager.sendPLSPMessage(players, entityMetaPacket);
        }
    }

    public static void setSneakNameTagOpacity(Player player, Float opacity) {
        AZManager azManager = AZClientPlugin.main.getAZManager();
        PLSPPacketEntityMeta entityMetaPacket = new PLSPPacketEntityMeta(player.getEntityId());
        PactifyTagMetadata entityTagPacket = new PactifyTagMetadata();
        entityTagPacket.setSneakOpacity(opacity);
        entityMetaPacket.setTag(entityTagPacket);

        for (Player players : Bukkit.getOnlinePlayers()) {
            azManager.sendPLSPMessage(players, entityMetaPacket);
        }
    }

    public static void resetSneakNameTagOpacity(Player player) {
        AZManager azManager = AZClientPlugin.main.getAZManager();
        PLSPPacketEntityMeta entityMetaPacket = new PLSPPacketEntityMeta(player.getEntityId());
        PactifyTagMetadata entityTagPacket = new PactifyTagMetadata();
        entityTagPacket.setSneakOpacity(-1.0F);
        entityMetaPacket.setTag(entityTagPacket);

        for (Player players : Bukkit.getOnlinePlayers()) {
            azManager.sendPLSPMessage(players, entityMetaPacket);
        }
    }

    public static void setNameTag(Player player, String tag) {
        AZManager azManager = AZClientPlugin.main.getAZManager();
        PLSPPacketEntityMeta entityMetaPacket = new PLSPPacketEntityMeta(player.getEntityId());
        PactifyTagMetadata entityTagPacket = new PactifyTagMetadata();
        entityTagPacket.setText(ChatColor.translateAlternateColorCodes('&', tag));
        entityMetaPacket.setTag(entityTagPacket);

        for (Player players : Bukkit.getOnlinePlayers()) {
            azManager.sendPLSPMessage(players, entityMetaPacket);
        }
    }

    public static void setSubTag(Player player, String tag) {
        AZManager azManager = AZClientPlugin.main.getAZManager();
        PLSPPacketEntityMeta entityMetaPacket = new PLSPPacketEntityMeta(player.getEntityId());
        entityMetaPacket.setSubTag(new PactifyTagMetadata(ChatColor.translateAlternateColorCodes('&', tag)));

        for (Player players : Bukkit.getOnlinePlayers()) {
            azManager.sendPLSPMessage(players, entityMetaPacket);
        }
    }

    public static void setSupTag(Player player, String tag) {
        AZManager azManager = AZClientPlugin.main.getAZManager();
        PLSPPacketEntityMeta entityMetaPacket = new PLSPPacketEntityMeta(player.getEntityId());
        entityMetaPacket.setSupTag(new PactifyTagMetadata(ChatColor.translateAlternateColorCodes('&', tag)));

        for (Player players : Bukkit.getOnlinePlayers()) {
            azManager.sendPLSPMessage(players, entityMetaPacket);
        }
    }
}
