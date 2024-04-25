package fr.speccy.azclientapi.bukkit.utils;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import pactify.client.api.mcprotocol.model.NotchianChatComponent;
import pactify.client.api.plprotocol.AbstractPactifyPacketBuffer;
import pactify.client.api.plprotocol.ChatComponentContext;

public class PacketBuffer extends AbstractPactifyPacketBuffer<PacketBuffer> {
    private final ByteArrayDataOutput handle = ByteStreams.newDataOutput();

    @Override
    public PacketBuffer a(NotchianChatComponent notchianChatComponent, ChatComponentContext chatComponentContext) {
        return null;
    }

    @Override
    public PacketBuffer writeBytes(byte[] bytes) {
        this.handle.write(bytes);
        return this;
    }

    @Override
    public PacketBuffer writeBytes(byte[] bytes, int i, int i1) {
        this.handle.write(bytes, i, i1);
        return this;
    }

    @Override
    public PacketBuffer readBytes(byte[] bytes) {
        return null;
    }

    @Override
    public PacketBuffer readBytes(byte[] bytes, int i, int i1) {
        return null;
    }

    @Override
    public byte readByte() {
        return 0;
    }

    @Override
    public PacketBuffer writeByte(int i) {
        this.handle.write(i);
        return this;
    }

    public byte[] toBytes() {
        return this.handle.toByteArray();
    }
}
