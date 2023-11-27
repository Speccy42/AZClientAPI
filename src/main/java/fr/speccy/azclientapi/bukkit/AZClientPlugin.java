package fr.speccy.azclientapi.bukkit;

import fr.speccy.azclientapi.bukkit.packets.PacketWindow;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class AZClientPlugin extends JavaPlugin {
    public static AZClientPlugin main;
    private static AZManager AZManager;

    @Override
    public void onEnable() {
        AZManager = new AZManager((Plugin)this);
        getServer().getPluginManager().registerEvents(new PacketWindow(this), (Plugin)this);
        main = this;
    }

    @Override
    public void onDisable() {
    }

    public AZManager getAZManager() {
        return AZManager;
    }
}
