package fr.thebatteur.items;

import net.minecraft.server.v1_9_R2.NBTBase;
import net.minecraft.server.v1_9_R2.NBTTagCompound;
import net.minecraft.server.v1_9_R2.NBTTagList;

public class NBTUtil {
    private final NBTTagCompound compound;

    public NBTUtil(NBTTagCompound compound) {
        this.compound = compound;
    }

    public NBTUtil() {
        this.compound = new NBTTagCompound();
    }

    public NBTUtil addTag(String name, int value) {
        this.compound.setInt(name, value);
        return this;
    }

    public NBTUtil addTag(String name, String value) {
        this.compound.setString(name, value);
        return this;
    }

    public NBTUtil addTag(String name, NBTBase value) {
        this.compound.set(name, value);
        return this;
    }

    public NBTUtil addTag(String name, boolean value) {
        this.compound.setBoolean(name, value);
        return this;
    }

    public NBTUtil addTag(String name, double value) {
        this.compound.setDouble(name, value);
        return this;
    }

    public NBTUtil addTag(String name, float value) {
        this.compound.setFloat(name, value);
        return this;
    }

    public NBTUtil addTag(String name, long value) {
        this.compound.setLong(name, value);
        return this;
    }

    public NBTUtil addCompound(String name, NBTTagCompound compound) {
        this.compound.set(name, compound);
        return this;
    }

    public NBTUtil addList(String name, NBTTagList list) {
        this.compound.set(name, list);
        return this;
    }

    public NBTTagCompound toNBT() {
        return this.compound;
    }

    @Override
    public String toString() {
        return this.compound.toString();
    }

    public static class NBTListUtil {
        private final NBTTagList list;

        public NBTListUtil() {
            list = new NBTTagList();
        }

        public NBTListUtil addTag(NBTBase value) {
            list.add(value);
            return this;
        }

        public NBTTagList toList() {
            return this.list;
        }
    }
}
