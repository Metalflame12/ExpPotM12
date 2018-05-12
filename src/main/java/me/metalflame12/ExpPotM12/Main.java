package me.metalflame12.ExpPotM12;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin {

    private static Main m; 
    private static FileConfiguration cf;
    private static Main instancia;


    @Override
    public void onEnable() {
        m = Main.this;
        cf = getConfig();
        instancia = this;

        Bukkit.getPluginManager().registerEvents(new Eventos(), this);
        Comandos();

        if (!(new File(getDataFolder(), "config.yml").exists())) {
            saveResource("config.yml", false);
        }
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
    }

    private void Comandos(){
        getCommand("exppot").setExecutor(new Comandos());
    }
}
