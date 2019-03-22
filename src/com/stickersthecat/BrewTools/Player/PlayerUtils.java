package com.stickersthecat.BrewTools.Player;

import com.stickersthecat.BrewTools.BrewTools;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class PlayerUtils {


    public HashMap<UUID, PlayerObj> Players;
    public BrewTools Plugin;

    public PlayerUtils(BrewTools Plugin) {

        this.Players = new HashMap<>();
        this.Plugin = Plugin;
    }

    public void GetOrLoad(UUID UUID) {

        // for now skip to create
        File IO = new File(this.Plugin.getDataFolder() + File.separator + "Players" + File.separator + UUID + File.separator + "Data.yml");
        if(!IO.exists()) {

            this.CreateProfile(IO);

        }
    }

    public void CreateProfile(File IO) {

        try {
            IO.createNewFile();
        } catch (IOException e) {
            this.Plugin.getLogger().info(e.getMessage());
        }
    }
}
