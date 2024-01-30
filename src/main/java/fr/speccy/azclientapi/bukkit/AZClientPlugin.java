package fr.speccy.azclientapi.bukkit;

import fr.speccy.azclientapi.bukkit.packets.PacketWindow;
import org.bukkit.plugin.java.JavaPlugin;

public final class AZClientPlugin extends JavaPlugin {
    public static AZClientPlugin main;
    private static AZManager AZManager;

    @Override
    public void onEnable() {
        AZManager = new AZManager(this);
        getServer().getPluginManager().registerEvents(new PacketWindow(this), this);
        getLogger().info("Plugin is now loaded! (Authors: Speccy and THE_BATTEUR)");
        main = this;
    }

    @Override
    public void onDisable() {
    }

    public AZManager getAZManager() {
        return AZManager;
    }
}
