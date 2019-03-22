package com.stickersthecat.BrewTools.Listeners;

import com.stickersthecat.BrewTools.BrewTools;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.player.PlayerEvent;

import java.io.File;


public abstract class EventListener {

    protected BrewTools Plugin;
    public FileConfiguration Config;

    public EventListener(BrewTools Plugin) {

        this.Plugin = Plugin;
    }

    public String Filters(String Old, PlayerEvent E) {

        String NewS = Old.replace("{PLAYER_NAME}", E.getPlayer().getName());
        return NewS;
    }

    public void SaveDefaultConfig(String Config) {

        File ConfigFile = null;
        if (this.Config == null) {

            ConfigFile = new File(this.Plugin.getDataFolder()+File.separator+"Events" , Config);
        }
        if ( !ConfigFile.exists() ) {

            this.Plugin.saveResource(Config, false);
        }
    }
}
