package org.reddev.playerlogs;

import java.util.Date;
import java.text.SimpleDateFormat;

public class PlayerLogger {
    private String playerName;
    private Date joinTime;
    public PlayerLogger(){}
    public PlayerLogger(String playerName) {
        this.playerName = playerName;
        this.joinTime = new Date();
    }
    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return playerName + "," + sdf.format(joinTime) + ",";
    }
    public String getPlayerName() {
        return playerName;
    }

}
