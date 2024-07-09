package org.reddev.playerlogs;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class JoinLeaveListener implements Listener {
    public static ArrayList<PlayerLogger> logs = new ArrayList<PlayerLogger>();
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        logs.add(new PlayerLogger(p.getPlayer().getName()));
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Player p = e.getPlayer();
            //O(n)
            for (PlayerLogger pl : logs) {
                if (pl.getPlayerName().contentEquals(p.getPlayer().getName())) {
                    logs.remove(pl);
                    CustomLog.log(pl.toString() + sdf.format(new Date()) + "\n");
                }
            }
        }catch(Exception ex) {

        }
    }
}
