package Main;

import Listener.*;
import Commands.*;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by ManuGun on 13.05.2017.
 */

public class Main extends JavaPlugin{

    public static String prefix = "§cLobby §8» §f";
    public static String err_noperms = "§cLobby §8» §cDie benötigte Berechtigung fehlt";

    public void onEnable(){
        registerListener();
        registerCommands();
    }

    private void registerListener(){
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        getServer().getPluginManager().registerEvents(new ItemListener(),this);
        getServer().getPluginManager().registerEvents(new ItemUse(),this);
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
        getServer().getPluginManager().registerEvents(new LobbyListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryListener(), this);
        getServer().getPluginManager().registerEvents(new BootsListener(), this);
        getServer().getPluginManager().registerEvents(new DoppelsprungListener(),this);
        getServer().getPluginManager().registerEvents(new Navigator(), this);
        getServer().getPluginManager().registerEvents(new RespawnListener(), this);
    }

    private void registerCommands(){
        getCommand("build").setExecutor(new BuildCommand());
        getCommand("setloc").setExecutor(new LocationCommand());
        getCommand("hub").setExecutor(new SpawnCommand());
    }

}
