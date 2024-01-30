package fr.speccy.azclientapi.bukkit;

import fr.speccy.azclientapi.bukkit.utils.BukkitUtil;
import fr.speccy.azclientapi.bukkit.utils.SchedulerUtil;
import org.bukkit.entity.Player;
import org.bukkit.metadata.MetadataValue;
import pactify.client.api.plsp.packet.client.PLSPPacketReset;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AZPlayer {
    private static final Pattern AZ_HOSTNAME_PATTERN;
    private final AZManager service;
    private final Player player;
    private final Set<Integer> scheduledTasks;
    private boolean joined;
    private int launcherProtocolVersion;

    static {
        AZ_HOSTNAME_PATTERN = Pattern.compile("[\u0000\u0002]PAC([0-9A-F]{5})[\u0000\u0002]");
    }

    public void init() {
        final List<MetadataValue> hostnameMeta = this.player.getMetadata("AZClientPlugin:hostname");
        if (!hostnameMeta.isEmpty()) {
            final String hostname = hostnameMeta.get(0).asString();
            final Matcher m = AZPlayer.AZ_HOSTNAME_PATTERN.matcher(hostname);
            if (m.find()) {
                this.launcherProtocolVersion = Math.max(1, Integer.parseInt(m.group(1), 16));
            }
        }
        else {
            this.service.getPlugin().getLogger().warning("Unable to verify the launcher of " + this.player.getName() + ": it probably logged when the plugin was disabled!");
        }
        BukkitUtil.addChannel(this.player, "PLSP");
    }

    public void join() {
        this.joined = true;
        this.service.sendPLSPMessage(this.player, new PLSPPacketReset());
    }

    public void free(final boolean onQuit) {
        SchedulerUtil.cancelTasks(AZClientPlugin.main, this.scheduledTasks);
        if (!onQuit) {
            this.service.sendPLSPMessage(this.player, new PLSPPacketReset());
        }
    }

    public boolean hasLauncher() {
        return this.launcherProtocolVersion > 0;
    }

    public int getLauncherProtocolVersion() {
        return this.launcherProtocolVersion;
    }

    public AZPlayer(final AZManager service, final Player player) {
        this.scheduledTasks = new HashSet<Integer>();
        this.service = service;
        this.player = player;
    }

    public AZManager getService() {
        return this.service;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Set<Integer> getScheduledTasks() {
        return this.scheduledTasks;
    }

    public boolean isJoined() {
        return this.joined;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AZPlayer)) {
            return false;
        }
        final AZPlayer other = (AZPlayer)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$service = this.getService();
        final Object other$service = other.getService();
        Label_0065: {
            if (this$service == null) {
                if (other$service == null) {
                    break Label_0065;
                }
            }
            else if (this$service.equals(other$service)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$player = this.getPlayer();
        final Object other$player = other.getPlayer();
        Label_0102: {
            if (this$player == null) {
                if (other$player == null) {
                    break Label_0102;
                }
            }
            else if (this$player.equals(other$player)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$scheduledTasks = this.getScheduledTasks();
        final Object other$scheduledTasks = other.getScheduledTasks();
        if (this$scheduledTasks == null) {
            if (other$scheduledTasks == null) {
                return this.isJoined() == other.isJoined() && this.getLauncherProtocolVersion() == other.getLauncherProtocolVersion();
            }
        }
        else if (this$scheduledTasks.equals(other$scheduledTasks)) {
            return this.isJoined() == other.isJoined() && this.getLauncherProtocolVersion() == other.getLauncherProtocolVersion();
        }
        return false;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AZPlayer;
    }

    @Override
    public int hashCode() {
        int result = 1;
        final Object $service = this.getService();
        result = result * 59 + (($service == null) ? 43 : $service.hashCode());
        final Object $player = this.getPlayer();
        result = result * 59 + (($player == null) ? 43 : $player.hashCode());
        final Object $scheduledTasks = this.getScheduledTasks();
        result = result * 59 + (($scheduledTasks == null) ? 43 : $scheduledTasks.hashCode());
        result = result * 59 + (this.isJoined() ? 79 : 97);
        result = result * 59 + this.getLauncherProtocolVersion();
        return result;
    }

    @Override
    public String toString() {
        return "AZClientPlayer(service=" + this.getService() + ", player=" + this.getPlayer() + ", scheduledTasks=" + this.getScheduledTasks() + ", joined=" + this.isJoined() + ", launcherProtocolVersion=" + this.getLauncherProtocolVersion() + ")";
    }

    public static boolean hasAZLauncher(final Player player) {
        return AZClientPlugin.main.getAZManager().getPlayer(player).hasLauncher();
    }
}
