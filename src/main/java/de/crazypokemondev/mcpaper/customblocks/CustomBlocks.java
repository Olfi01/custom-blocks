package de.crazypokemondev.mcpaper.customblocks;

import de.crazypokemondev.mcpaper.customblocks.listeners.PlayerJoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomBlocks extends JavaPlugin {
    public static CustomBlocks INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
