package Listener;

import Commands.BuildCommand;
import Utils.*;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by ManuGun on 13.05.2017.
 */
public class JoinEvent implements Listener{

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if(p.hasPlayedBefore()){
            e.setJoinMessage(null);
            p.setHealth(20);
            p.setFoodLevel(20);
            p.getInventory().setBoots(ItemManager.createItem(Material.DIAMOND_BOOTS, 1,0,"§cKeine Boots"));
            p.getInventory().clear();
            p.setGameMode(GameMode.ADVENTURE);
            LocationManager.useLocation(p,"Spawn");
            ScoreboardManager.OnlinePlayers.add(p.getName());

            //Ränge (Tab)
            if(p.hasPermission("lobby.rang.premium")){
                p.setDisplayName("§4" + p.getName());
            } else if(p.hasPermission("lobby.rang.premiumplus")){
                p.setDisplayName("§6" + p.getName());
            } else if(p.hasPermission("lobby.rang.yt")){
                p.setDisplayName("§5" + p.getName());
            } else if(p.hasPermission("lobby.rang.sup")){
                p.setDisplayName("§bSup §7| §b" + p.getName());
            } else if(p.hasPermission("lobby.rang.mod")){
                p.setDisplayName("§2Mod §7| §2" + p.getName());
            } else if(p.hasPermission("lobby.rang.srmod")){
                p.setDisplayName("§aSrMod §7| §a" + p.getName());
            } else if(p.hasPermission("lobby.rang.dev")){
                p.setDisplayName("§9Dev §7| §9" + p.getName());
            } else if(p.hasPermission("lobby.rang.admin")){
                p.setDisplayName("§8Admin §7| §8" + p.getName());
            } else {
                p.setDisplayName("§c" + p.getName());
            }
            p.setPlayerListName(p.getDisplayName());

            for(Player all : Bukkit.getOnlinePlayers()){
                ScoreboardManager.setScoreboard(all);
            }

            TitleManager.sendTabTitle(p, "§cManuGun.de §8» §fNetzwerk", "§cWebseite: §fManuGun.de");

            if(p.hasPermission("lobby.more")){
                p.getInventory().setItem(1,ItemManager.createItem(Material.SLIME_BALL, 1, 0, "§cSpieler verstecken"));
                p.getInventory().setItem(4,ItemManager.createItem(Material.WATCH, 1, 0, "§cNavigator"));
                p.getInventory().setItem(5, ItemManager.createItem(Material.TNT,1, 0, "§cSilentLobby"));
                p.getInventory().setItem(7,ItemManager.createItem(Material.ENDER_CHEST, 1, 0, "§cExtras"));
            } else {
                p.getInventory().setItem(1,ItemManager.createItem(Material.SLIME_BALL, 1, 0, "§cSpieler verstecken"));
                p.getInventory().setItem(4,ItemManager.createItem(Material.WATCH, 1, 0, "§cNavigator"));
                p.getInventory().setItem(7,ItemManager.createItem(Material.ENDER_CHEST, 1, 0, "§cExtras"));
            }
        } else {
            Bukkit.broadcastMessage("§8§l============================================");
            Bukkit.broadcastMessage("");
            Bukkit.broadcastMessage("§c§l" + p.getName() + " §f§list neu auf dem Netzwerk!");
            Bukkit.broadcastMessage("");
            Bukkit.broadcastMessage("§8§l============================================");
            for(Player all : Bukkit.getOnlinePlayers()){
                all.playSound(all.getLocation(), Sound.CHEST_CLOSE,1,1);
            }
            e.setJoinMessage(null);
            p.setHealth(20);
            p.setFoodLevel(20);
            p.getInventory().setBoots(ItemManager.createItem(Material.DIAMOND_BOOTS, 1,0,"§cKeine Boots"));
            p.getInventory().clear();
            p.setGameMode(GameMode.ADVENTURE);
            LocationManager.useLocation(p,"Spawn");
            ScoreboardManager.OnlinePlayers.add(p.getName());

            //Ränge (Tab)
            if(p.hasPermission("lobby.rang.premium")){
                p.setDisplayName("§4" + p.getName());
            } else if(p.hasPermission("lobby.rang.premiumplus")){
                p.setDisplayName("§6" + p.getName());
            } else if(p.hasPermission("lobby.rang.yt")){
                p.setDisplayName("§5" + p.getName());
            } else if(p.hasPermission("lobby.rang.sup")){
                p.setDisplayName("§bSup §7| §b" + p.getName());
            } else if(p.hasPermission("lobby.rang.mod")){
                p.setDisplayName("§2Mod §7| §2" + p.getName());
            } else if(p.hasPermission("lobby.rang.srmod")){
                p.setDisplayName("§aSrMod §7| §a" + p.getName());
            } else if(p.hasPermission("lobby.rang.dev")){
                p.setDisplayName("§9Dev §7| §9" + p.getName());
            } else if(p.hasPermission("lobby.rang.admin")){
                p.setDisplayName("§8Admin §7| §8" + p.getName());
            } else {
                p.setDisplayName("§c" + p.getName());
            }
            p.setPlayerListName(p.getDisplayName());

            for(Player all : Bukkit.getOnlinePlayers()){
                ScoreboardManager.setScoreboard(all);
            }

            TitleManager.sendTabTitle(p, "§cManuGun.de §8» §fNetzwerk", "§cWebseite: §fManuGun.de");

            if(p.hasPermission("lobby.more")){
                p.getInventory().setItem(1,ItemManager.createItem(Material.SLIME_BALL, 1, 0, "§cSpieler verstecken"));
                p.getInventory().setItem(4,ItemManager.createItem(Material.WATCH, 1, 0, "§cNavigator"));
                p.getInventory().setItem(5, ItemManager.createItem(Material.TNT,1, 0, "§cSilentLobby"));
                p.getInventory().setItem(7,ItemManager.createItem(Material.ENDER_CHEST, 1, 0, "§cExtras"));
            } else {
                p.getInventory().setItem(1,ItemManager.createItem(Material.SLIME_BALL, 1, 0, "§cSpieler verstecken"));
                p.getInventory().setItem(4,ItemManager.createItem(Material.WATCH, 1, 0, "§cNavigator"));
                p.getInventory().setItem(7,ItemManager.createItem(Material.ENDER_CHEST, 1, 0, "§cExtras"));
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player p = e.getPlayer();
        e.setQuitMessage(null);
        BuildCommand.Build = false;
        ScoreboardManager.OnlinePlayers.remove(p.getName());
        for(Player all : Bukkit.getOnlinePlayers()){
            ScoreboardManager.setScoreboard(all);
        }
    }

}
