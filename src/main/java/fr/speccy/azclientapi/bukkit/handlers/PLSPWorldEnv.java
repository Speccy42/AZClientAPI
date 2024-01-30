package fr.speccy.azclientapi.bukkit.handlers;

public enum PLSPWorldEnv {
    NETHER,
    NORMAL,
    THE_END;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
