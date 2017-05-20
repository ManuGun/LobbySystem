package Listener;

import Main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Created by ManuGun on 13.05.2017.
 */
public class ChatListener implements Listener{

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();

        if(p.hasPermission("lobby.rang.premium")){
            e.setFormat("§4Premium §8| §7" + p.getName() + " §8» §f" + e.getMessage());
        } else if(p.hasPermission("lobby.rang.premiumplus")){
            e.setFormat("§6PremiumPlus §8| §7" + p.getName() + " §8» §f" + e.getMessage());
        } else if(p.hasPermission("lobby.rang.yt")){
            e.setFormat("§5YouTuber §8| §7" + p.getName() + " §8» §f" + e.getMessage());
        } else if(p.hasPermission("lobby.rang.sup")){
            e.setFormat("§bSupporter §8| §7" + p.getName() + " §8» §f" + e.getMessage());
        } else if(p.hasPermission("lobby.rang.mod")){
            e.setFormat("§2Moderator §8| §7" + p.getName() + " §8» §f" + e.getMessage());
        } else if(p.hasPermission("lobby.rang.srmod")){
            e.setFormat("§aSrModerator §8| §7" + p.getName() + " §8» §f" + e.getMessage());
        } else if(p.hasPermission("lobby.rang.dev")){
            e.setFormat("§9Developer §8| §7" + p.getName() + " §8» §f" + e.getMessage());
        } else if(p.hasPermission("lobby.rang.admin")){
            e.setFormat("§8Admin §8| §7" + p.getName() + " §8» §f" + e.getMessage());
        } else {
            e.setFormat("§cSpieler §8| §7" + p.getName() + " §8» §f" + e.getMessage());
        }

        if(ItemUse.SilentLobby){
            p.sendMessage(Main.prefix + "In der SilentLobby ist der Chat nicht verfügbar");
            e.setCancelled(true);
        }
    }

}
