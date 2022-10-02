package de.crazypokemondev.mcpaper.customblocks.network;

import net.minecraft.network.FriendlyByteBuf;

public class CustomBlockTexturesPacket implements Packet<CustomBlockTexturesPacket> {
    @Override
    public CustomBlockTexturesPacket fromBytes(FriendlyByteBuf buf) {
        return null;
    }

    @Override
    public void toBytes(FriendlyByteBuf buf) {

    }
}
