package com.stickersthecat.BrewTools.Listeners;

import com.stickersthecat.BrewTools.BrewTools;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;


public class OnJoinListener extends EventListener implements Listener {

    public OnJoinListener(BrewTools Plugin) {

        super(Plugin);
        this.SaveDefaultConfig("Events"+File.separator+"OnJoin.yml");
        this.Config = YamlConfiguration.loadConfiguration(new File(this.Plugin.getDataFolder(), "Events"+File.separator+"OnJoin.yml"));
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent E) {

        // start the event by seeing if we have to run any commands on players join
        this.CheckCommands(E);
        this.MOTD(E);
    }

    public void CheckCommands(PlayerJoinEvent E) {

        for (String Key : this.Config.getConfigurationSection("Commands").getKeys(false)) {

            if (this.Config.contains("Commands." + Key + ".enabled") && this.Config.getBoolean("Commands." + Key + ".enabled")) {

                int Ticks = this.Config.getInt("Commands." + Key + ".delay");
                if( Ticks > 0) {

                    this.Plugin.Players.GetOrLoad(E.getPlayer().getUniqueId());
                    this.Plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.Plugin, () -> this.RunCMD(Key, E), Ticks);
                }
            }
        }
    }

    public void RunCMD(String Key, PlayerJoinEvent E) {

        String CMD = this.Filters(this.Config.getString("Commands." + Key + ".cmd"), E);
        this.Plugin.getLogger().info("/" + CMD);
        this.Plugin.getServer().dispatchCommand(this.Plugin.getServer().getConsoleSender(), CMD);
    }

    public void MOTD(PlayerJoinEvent E) {

        for (String Value : this.Config.getStringList("ChatMOTD") ) {

            this.Plugin.getLogger().info("/" + Value);
        }
        E.getPlayer().sendMessage(" i am a test");
    }
}

