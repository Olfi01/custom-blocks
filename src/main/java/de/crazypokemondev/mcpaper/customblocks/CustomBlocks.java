package de.crazypokemondev.mcpaper.customblocks;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import de.crazypokemondev.mcpaper.customblocks.listeners.ChunkLoadPacketListener;
import net.minecraft.network.protocol.Packet;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomBlocks extends JavaPlugin {
    public static CustomBlocks INSTANCE;
    private ProtocolManager protocolManager;

    @Override
    public void onEnable() {
        INSTANCE = this;
        protocolManager = ProtocolLibrary.getProtocolManager();
        protocolManager.addPacketListener(new ChunkLoadPacketListener(this));
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "custom-blocks:main");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
