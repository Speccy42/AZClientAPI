package fr.speccy.azclientapi.bukkit.packets;

import com.google.common.io.ByteStreams;
import com.google.common.io.ByteArrayDataOutput;
import pactify.client.api.mcprotocol.AbstractNotchianPacketBuffer;

public class PacketOutBuffer extends AbstractNotchianPacketBuffer<PacketOutBuffer> {
    private final ByteArrayDataOutput handle;

    public PacketOutBuffer() {
        this.handle = ByteStreams.newDataOutput();
    }

    public PacketOutBuffer writeBytes(final byte[] src) {
        this.handle.write(src);
        return this;
    }

    public PacketOutBuffer writeBytes(final byte[] src, final int offset, final int len) {
        this.handle.write(src, offset, len);
        return this;
    }

    public PacketOutBuffer writeBoolean(final boolean value) {
        this.handle.writeBoolean(value);
        return this;
    }

    public PacketOutBuffer writeByte(final int value) {
        this.handle.writeByte(value);
        return this;
    }

    public PacketOutBuffer writeShort(final int value) {
        this.handle.writeShort(value);
        return this;
    }

    public PacketOutBuffer writeInt(final int value) {
        this.handle.writeInt(value);
        return this;
    }

    public PacketOutBuffer writeLong(final long value) {
        this.handle.writeLong(value);
        return this;
    }

    public PacketOutBuffer writeFloat(final float value) {
        this.handle.writeFloat(value);
        return this;
    }

    public PacketOutBuffer writeDouble(final double value) {
        this.handle.writeDouble(value);
        return this;
    }

    public PacketOutBuffer writeVarInt(int value) {
        while ((value & 0xFFFFFF80) != 0x0) {
            this.handle.writeByte((value & 0x7F) | 0x80);
            value >>>= 7;
        }
        this.handle.writeByte(value);
        return this;
    }

    public PacketOutBuffer writeVarLong(long value) {
        while ((value & 0xFFFFFFFFFFFFFF80L) != 0x0L) {
            this.writeByte((int)(value & 0x7FL) | 0x80);
            value >>>= 7;
        }
        this.writeByte((int)value);
        return this;
    }

    public PacketOutBuffer writeByteArray(final byte[] bytes) {
        this.writeVarInt(bytes.length);
        this.writeBytes(bytes);
        return this;
    }

    public PacketOutBuffer writeVarIntArray(final int[] ints) {
        this.writeVarInt(ints.length);
        for (final int value : ints) {
            this.writeVarInt(value);
        }
        return this;
    }

    public PacketOutBuffer writeLongArray(final long[] longs) {
        this.writeVarInt(longs.length);
        for (final long value : longs) {
            this.writeLong(value);
        }
        return this;
    }

    public byte[] toBytes() {
        return this.handle.toByteArray();
    }
}
