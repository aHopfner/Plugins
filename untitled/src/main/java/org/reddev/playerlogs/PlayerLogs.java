package org.reddev.playerlogs;

import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerLogs extends JavaPlugin {
    @Override
    public void onEnable() {
        CustomLog.setup();
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);
    }
}
