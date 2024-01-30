package fr.thebatteur.items.handlers;

public enum MenuState {
    DISABLED,
    NORMAL,
    HOVER,
    ACTIVE;

    @Override
    public String toString() {
        return super.toString().toUpperCase();
    }
}
