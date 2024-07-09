package org.reddev.playerlogs;

import org.bukkit.Bukkit;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class CustomLog {
    private static File file;
    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("PlayerLogs").getDataFolder(), "logs.csv");
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (IOException e) {
                e.printStackTrace();
        }
    }
    public static File getCustomLog(){
        return file;
    }
    public static void log(String message){
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(message);
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
