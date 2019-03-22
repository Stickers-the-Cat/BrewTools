package com.stickersthecat.BrewTools;

import com.stickersthecat.BrewTools.Listeners.OnJoinListener;
import com.stickersthecat.BrewTools.Listeners.OnListPingListener;
import com.stickersthecat.BrewTools.Player.PlayerUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.HashMap;
import java.util.UUID;

public class BrewTools extends JavaPlugin {

    public FileConfiguration Config;
    public PlayerUtils Players = new PlayerUtils(this);

    @Override
    public void onEnable() {

        // do config
        this.saveDefaultConfig();
        this.Config = this.getConfig();

        // do events
        this.getServer().getPluginManager().registerEvents(new OnJoinListener(this), this);
        this.getServer().getPluginManager().registerEvents(new OnListPingListener(this), this);
    }
}
