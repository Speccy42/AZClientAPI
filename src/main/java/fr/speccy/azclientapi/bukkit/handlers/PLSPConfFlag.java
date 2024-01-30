package fr.speccy.azclientapi.bukkit.handlers;

public enum PLSPConfFlag {
    ATTACK_COOLDOWN,
    PLAYER_PUSH,
    LARGE_HITBOX,
    SWORD_BLOCKING,
    HIT_AND_BLOCK,
    OLD_ENCHANTEMENTS,
    PVP_HIT_PRIORITY,
    SEE_CHUNKS,
    SIDEBAR_SCORES,
    SMOOTH_EXPERIENCE_BAR,
    SORT_TAB_LIST_BY_NAMES;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
