package me.peridot.mckdisco;

import me.peridot.mckdisco.commands.DiscoCommand;
import me.peridot.mckdisco.data.Config;
import me.peridot.mckdisco.listener.InventoryClickListener;
import me.peridot.mckdisco.listener.PlayerJoinListener;
import me.peridot.mckdisco.scheduler.ColorScheduler;
import me.peridot.mckdisco.scheduler.UpdateArmorScheduler;
import me.peridot.mckdisco.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MCKDisco extends JavaPlugin {

    private Config config;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        config = new Config(this);
        config.loadConfig();

        getCommand("disco").setExecutor(new DiscoCommand(this));
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(this), this);

        new UpdateArmorScheduler(this).start();
        new ColorScheduler(this).start();

        new Metrics(this, 7249);
    }

    public Config getConfiguration() {
        return config;
    }
}
