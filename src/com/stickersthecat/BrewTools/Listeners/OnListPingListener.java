package com.stickersthecat.BrewTools.Listeners;

import com.stickersthecat.BrewTools.BrewTools;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class OnListPingListener extends EventListener implements Listener {

    public OnListPingListener(BrewTools Plugin) {

        super(Plugin);
    }

    @EventHandler
    public void OnPing(ServerListPingEvent Event) {

        Event.setMotd("I am a test \nalso a test");
        Event.setMaxPlayers(250);
    }
}
