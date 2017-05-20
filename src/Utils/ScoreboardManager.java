package Utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.util.ArrayList;

/**
 * Created by ManuGun on 19.05.2017.
 */
public class ScoreboardManager {

    public static ArrayList<String> OnlinePlayers = new ArrayList<String>();

    public static void setScoreboard(Player p){
        Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective ob = sb.registerNewObjective("lobby", "system");
        ob.setDisplaySlot(DisplaySlot.SIDEBAR);
        ob.setDisplayName("§f» §cManuGun.de");
        ob.getScore("  ").setScore(9);
        ob.getScore("§fOnline").setScore(8);
        ob.getScore("§c" + OnlinePlayers.size() + " §8/§c " + Bukkit.getMaxPlayers()).setScore(7);
        ob.getScore(" ").setScore(6);
        ob.getScore("§fRang").setScore(5);

        if(p.hasPermission("lobby.rang.premium")){
            ob.getScore("§4Premium").setScore(4);
        } else if(p.hasPermission("lobby.rang.premiumplus")){
            ob.getScore("§6PremiumPlus").setScore(4);
        } else if(p.hasPermission("lobby.rang.yt")){
            ob.getScore("§5YouTuber").setScore(4);
        } else if(p.hasPermission("lobby.rang.sup")){
            ob.getScore("§bSupporter").setScore(4);
        } else if(p.hasPermission("lobby.rang.mod")){
            ob.getScore("§2Moderator").setScore(4);
        } else if(p.hasPermission("lobby.rang.srmod")){
            ob.getScore("§aSrMod").setScore(4);
        } else if(p.hasPermission("lobby.rang.dev")){
            ob.getScore("§9Developer").setScore(4);
        } else if(p.hasPermission("lobby.rang.admin")){
            ob.getScore("§8Admin").setScore(4);
        } else {
            ob.getScore("§cSpieler").setScore(4);
        }

        ob.getScore("").setScore(3);
        ob.getScore("§fWebseite").setScore(2);
        ob.getScore("§cManuGun.de").setScore(1);
        p.setScoreboard(sb);
    }
}
