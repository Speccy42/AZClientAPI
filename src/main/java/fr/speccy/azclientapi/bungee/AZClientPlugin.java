package fr.speccy.azclientapi.bungee;

import net.md_5.bungee.api.plugin.Plugin;

public class AZClientPlugin extends Plugin {

    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerListener(this, new HandshakeFix());
        getLogger().info("Plugin is now loaded! (Authors: Speccy and THE_BATTEUR)");
    }

    @Override
    public void onDisable() {

    }
}
