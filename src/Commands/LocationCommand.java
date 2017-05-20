package Commands;

import Main.Main;
import Utils.LocationManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;

/**
 * Created by ManuGun on 19.05.2017.
 */
public class LocationCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args){
        Player p = (Player) sender;

        File ordner = new File("plugins//Lobby//");
        File file = new File("plugins//Lobby//" + args[0] + ".yml");

        if(p.hasPermission("lobby.admin")){
            LocationManager.setLocation(args[0], p);
            p.sendMessage(Main.prefix + "Du hast die Location §c" + args[0] + " §fgesetzt");
        } else {
            p.sendMessage(Main.err_noperms);
        }
        return false;
    }

}
