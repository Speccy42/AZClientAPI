package fr.speccy.azclientapi.bukkit.utils;

import org.bukkit.entity.Player;
import java.util.regex.Matcher;
import org.bukkit.Bukkit;
import java.util.regex.Pattern;
import java.lang.reflect.Method;

public final class BukkitUtil {
    private static final Method PLAYER_ADDCHANNEL_METHOD;
    private static final Pattern SERVER_VERSION;

    static {
        SERVER_VERSION = Pattern.compile("\\(MC: (?<major>[0-9]{1,3})\\.(?<minor>[0-9]{1,3})(?:\\.(?<patch>[0-9]{1,3}))?\\)");
        final String ocbPackage = Bukkit.getServer().getClass().getName().replaceAll("\\.[^.]+$", "");
        try {
            final Class<?> playerClass = Class.forName(String.valueOf(ocbPackage) + ".entity.CraftPlayer");
            final Method addChannelMethod = playerClass.getDeclaredMethod("addChannel", String.class);
            addChannelMethod.setAccessible(true);
            PLAYER_ADDCHANNEL_METHOD = addChannelMethod;
        }
        catch (ReflectiveOperationException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static int findServerVersion() {
        final Matcher m = BukkitUtil.SERVER_VERSION.matcher(Bukkit.getVersion());
        if (m.find()) {
            final int major = Integer.parseInt(m.group("major"));
            final int minor = Integer.parseInt(m.group("minor"));
            final int patch = (m.group("patch") != null) ? Integer.parseInt(m.group("patch")) : 0;
            return major * 1000000 + minor * 1000 + patch;
        }
        throw new RuntimeException("Unable to detect server version! Bukkit.getVersion()=" + Bukkit.getVersion());
    }

    public static void addChannel(final Player player, final String channel) {
        try {
            BukkitUtil.PLAYER_ADDCHANNEL_METHOD.invoke(player, channel);
        }
        catch (ReflectiveOperationException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String getAlpha(final int index, final boolean inverse) {
        final String alpha = "abcdefghijklmnopqrstuvwxyz";
        return inverse ? Character.toString(alpha.charAt(26 - index)) : Character.toString(alpha.charAt(index));
    }

    private BukkitUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
