package de.outdev.gameserver;

import de.outdev.gameserver.config.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Optional;

public final class ShardBackend extends JavaPlugin {

    public ConfigManager configManager;

    @Override
    public void onEnable() {
        configManager = new ConfigManager(this);

        if (!loadConfig()) {
            getServer().getPluginManager().disablePlugin(this);
            getServer().shutdown();
            return;
        }

        registerCommands();
        registerListeners();
        registerTasks();
    }

    @Override
    public void onDisable() {
    }

    private void registerCommands() {
        // register commands here
    }

    private void registerListeners() {
        // register listeners here
    }

    private void registerTasks() {
        // register tasks here
    }

    private boolean loadConfig() {
        final Optional<Throwable> error = configManager.loadConfig();
        if (error.isPresent()) {
            getLogger().log(java.util.logging.Level.SEVERE, "Failed to load configuration", error.get());
            return false;
        }
        return true;
    }
}
