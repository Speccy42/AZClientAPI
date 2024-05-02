package fr.thebatteur.items;

import fr.thebatteur.items.handlers.MenuState;
import fr.thebatteur.items.handlers.Sprite;
import net.minecraft.server.v1_9_R2.NBTTagCompound;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_9_R2.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public class AZItem {
    private ItemStack itemStack;

    public AZItem(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public AZItem addPacDisplay(PacDisplay display) {
        this.addNBTTags("PacDisplay", display.getNbtUtil().toNBT());
        return this;
    }

    public AZItem addPacRender(PacRender render) {
        this.addNBTTags("PacRender", render.getNbtUtil().toNBT());
        return this;
    }

    public AZItem addPacMenu(PacMenu menu) {
        this.addNBTTags("PacMenu", menu.getNbtUtil().toNBT());
        return this;
    }

    private void addNBTTags(String name, NBTTagCompound compound) {
        net.minecraft.server.v1_9_R2.ItemStack nmsItemStack = CraftItemStack.asNMSCopy(this.itemStack);
        NBTTagCompound nmsCompound = nmsItemStack.getTag();
        if (nmsCompound == null) {
            nmsCompound = new NBTTagCompound();
        }
        nmsCompound.set(name, compound);
        nmsItemStack.setTag(nmsCompound);
        this.itemStack = CraftItemStack.asBukkitCopy(nmsItemStack);
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public static class PacDisplay {
        private final NBTUtil nbtUtil;

        public PacDisplay() {
            this.nbtUtil = new NBTUtil();
        }

        /**
         * Utiliser un sprite qui remplace la texture de l'item
         * @param sprite
         * @return
         */
        public PacDisplay setSprite(Sprite sprite) {
            this.nbtUtil.addTag("Sprite", sprite.name());
            return this;
        }

        /**
         * Si Sprite="EMOJI" il s'agit de l'emoji à afficher
         * @param spriteData
         * @return
         */
        public PacDisplay setSpriteData(String spriteData) {
            this.nbtUtil.addTag("SpriteData", spriteData);
            return this;
        }

        /**
         * Re-colore la la texture (int au format 0xAARRGGBB, ex pour du vert pur c'est 0xFF00FF00, ce qui donne -16711936)
         * @param color
         * @return
         */
        public PacDisplay setColor(int color) {
            this.nbtUtil.addTag("Color", color);
            return this;
        }

        /**
         * Déplace la texture sur l'axe X
         * @param translatX
         * @return
         */
        public PacDisplay setTranslatX(float translatX) {
            this.nbtUtil.addTag("TranslatX", translatX);
            return this;
        }

        /**
         * Déplace la texture sur l'axe Y
         * @param translatY
         * @return
         */
        public PacDisplay setTranslatY(float translatY) {
            this.nbtUtil.addTag("TranslatY", translatY);
            return this;
        }

        /**
         * Fait tourner la texture
         * @param rotation
         * @return
         */
        public PacDisplay setRotation(float rotation) {
            this.nbtUtil.addTag("Rotation", rotation);
            return this;
        }

        /**
         * Change la taille de la texture (1 = taille normale)
         * @param scale
         * @return
         */
        public PacDisplay setScale(float scale) {
            this.nbtUtil.addTag("Scale", scale);
            return this;
        }

        /**
         * Change la taille de la texture sur l'axe X (1 = taille normale, seulement si Scale n'est pas défini)
         * @param scaleX
         * @return
         */
        public PacDisplay setScaleX(float scaleX) {
            this.nbtUtil.addTag("ScaleX", scaleX);
            return this;
        }

        /**
         * Change la taille de la texture sur l'axe Y (1 = taille normale, seulement si Scale n'est pas défini)
         * @param scaleY
         * @return
         */
        public PacDisplay setScaleY(float scaleY) {
            this.nbtUtil.addTag("ScaleY", scaleY);
            return this;
        }

        /**
         * Change l'ordre de rendu de la texture (à n'utiliser que si la texture apparait derrière une autre, etc)
         * @param zIndex
         * @return
         */
        public PacDisplay setZIndex(float zIndex) {
            this.nbtUtil.addTag("ZIndex", zIndex);
            return this;
        }

        /**
         * Permet d'afficher plusieurs items en un en les superposant
         * @param childs
         * @return
         */
        public PacDisplay setChilds(PacDisplayChild childs) {
            this.nbtUtil.addTag("Childs", new NBTUtil.NBTListUtil().addTag(childs.getNbtUtil().toNBT()).toList());
            return this;
        }

        public NBTUtil getNbtUtil() {
            return nbtUtil;
        }
    }

    public static class PacDisplayChild {
        private final NBTUtil nbtUtil;

        public PacDisplayChild() {
            this.nbtUtil = new NBTUtil();
        }

        /**
         * Type de l'item
         * @param material
         */
        public PacDisplayChild setMaterial(Material material) {
            this.nbtUtil.addTag("id", "minecraft:" + material.name().toLowerCase());
            return this;
        }

        /**
         * Nombre d'items
         * @param count
         */
        public PacDisplayChild setCount(int count) {
            this.nbtUtil.addTag("Count", count);
            return this;
        }

        /**
         * Damage de l'item
         * @param damage
         */
        public PacDisplayChild setDamage(int damage) {
            this.nbtUtil.addTag("Damage", damage);
            return this;
        }

        /**
         * Ajouter des caractéristiques PacDisplay à l'item
         * @param pacDisplay
         */
        public PacDisplayChild setPactifyDisplay(PacDisplay pacDisplay) {
            this.nbtUtil.addTag("tag", new NBTUtil().addTag("PacDisplay", pacDisplay.getNbtUtil().toNBT()).toNBT());
            return this;
        }

        public NBTUtil getNbtUtil() {
            return nbtUtil;
        }
    }

    public static class PacRender {
        private final NBTUtil nbtUtil;

        public PacRender() {
            this.nbtUtil = new NBTUtil();
        }

        /**
         * Re-colore la texture (int au format 0xAARRGGBB)
         * @param color
         */
        public PacRender setColor(int color) {
            this.nbtUtil.addTag("Color", color);
            return this;
        }

        /**
         * Change la taille (1 = taille normale)
         * @param scale
         */
        public PacRender setScale(float scale) {
            this.nbtUtil.addTag("Scale", scale);
            return this;
        }

        public NBTUtil getNbtUtil() {
            return nbtUtil;
        }
    }

    public static class PacMenu {
        private final NBTUtil nbtUtil;

        public PacMenu() {
            this.nbtUtil = new NBTUtil();
        }

        /**
         * Afficher ou non le background (la texture de "bouton" cliquable)
         * @param background
         */
        public PacMenu setBackground(boolean background) {
            this.nbtUtil.addTag("Background", background);
            return this;
        }

        /**
         * Modifier l'état de la texture du background
         * @param menuState
         */
        public PacMenu setState(MenuState menuState) {
            this.nbtUtil.addTag("State", menuState.name());
            return this;
        }

        public NBTUtil getNbtUtil() {
            return nbtUtil;
        }
    }

    public static String customColorText(String text, int color) {
        StringBuilder sb = new StringBuilder("§#");
        String hex = Integer.toHexString(color);
        for (int i = 0; i < hex.length(); i += 2) {
            String str = hex.substring(i, i + 2);
            int charCode = Integer.parseInt(str, 16);
            sb.append((char) charCode);
        }
        return sb.append(text).toString();
    }
}
