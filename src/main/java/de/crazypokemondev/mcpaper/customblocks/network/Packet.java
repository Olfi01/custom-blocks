package de.crazypokemondev.mcpaper.customblocks.network;

import net.minecraft.network.FriendlyByteBuf;
import org.bukkit.entity.Player;

public interface Packet<T extends Packet<T>> {
    T fromBytes(FriendlyByteBuf buf);

    void toBytes(FriendlyByteBuf buf);

    default void onPacket(Player player) {

    }
}
