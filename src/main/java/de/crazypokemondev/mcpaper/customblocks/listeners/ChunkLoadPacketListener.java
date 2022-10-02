package de.crazypokemondev.mcpaper.customblocks.listeners;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.nbt.NbtBase;
import com.comphenix.protocol.wrappers.nbt.NbtCompound;
import com.comphenix.protocol.wrappers.nbt.NbtFactory;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.game.ClientboundLevelChunkPacketData;
import net.minecraft.network.protocol.game.ClientboundLevelChunkWithLightPacket;
import net.minecraft.world.level.chunk.LevelChunkSection;
import org.bukkit.Chunk;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class ChunkLoadPacketListener extends PacketAdapter {

    public ChunkLoadPacketListener(Plugin plugin) {
        super(plugin, ListenerPriority.NORMAL, PacketType.Play.Server.MAP_CHUNK);
    }

    @Override
    public void onPacketSending(PacketEvent event) {
        if (event.getPacketType() == PacketType.Play.Server.MAP_CHUNK) {
            PacketContainer packet = event.getPacket();
            int chunkX = packet.getIntegers().readSafely(0);
            int chunkZ = packet.getIntegers().readSafely(1);
            Chunk chunk = event.getPlayer().getWorld().getChunkAt(chunkX, chunkZ);

        }
    }
}
