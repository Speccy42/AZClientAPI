package fr.speccy.azclientapi.bungee;

import net.md_5.bungee.api.plugin.Plugin;

public class AZClientPlugin extends Plugin {

    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerListener(this, new HandshakeFix());
    }

    @Override
    public void onDisable() {

    }
}
