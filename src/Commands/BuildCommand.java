package Commands;

import Main.Main;
import Utils.ItemManager;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by ManuGun on 18.05.2017.
 */

public class BuildCommand implements CommandExecutor{

    public static boolean Build = false;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        Player p = (Player) sender;
        if(p.hasPermission("lobby.build")){
            if(Build){
                Build = false;
                p.sendMessage(Main.prefix + "Der Baumodus wurde §cdeaktiviert");
                p.setGameMode(GameMode.ADVENTURE);
                p.getInventory().clear();
                if(p.hasPermission("lobby.more")){
                    p.getInventory().setItem(1, ItemManager.createItem(Material.SLIME_BALL, 1, 0, "§cSpieler verstecken"));
                    p.getInventory().setItem(4,ItemManager.createItem(Material.WATCH, 1, 0, "§cNavigator"));
                    p.getInventory().setItem(5, ItemManager.createItem(Material.TNT,1, 0, "§cSilentLobby"));
                    p.getInventory().setItem(7,ItemManager.createItem(Material.ENDER_CHEST, 1, 0, "§cExtras"));
                    p.getInventory().setBoots(ItemManager.createItem(Material.DIAMOND_BOOTS,1,0,"§cKeine Boots"));
                } else {
                    p.getInventory().setItem(1,ItemManager.createItem(Material.SLIME_BALL, 1, 0, "§cSpieler verstecken"));
                    p.getInventory().setItem(4,ItemManager.createItem(Material.WATCH, 1, 0, "§cNavigator"));
                    p.getInventory().setItem(7,ItemManager.createItem(Material.ENDER_CHEST, 1, 0, "§cExtras"));
                    p.getInventory().setBoots(ItemManager.createItem(Material.DIAMOND_BOOTS,1,0,"§cKeine Boots"));
                }
            } else {
                Build = true;
                p.sendMessage(Main.prefix + "Der Baumodus wurde §aaktiviert");
                p.setGameMode(GameMode.CREATIVE);
                p.getInventory().clear();
            }
        } else {
            p.sendMessage(Main.err_noperms);
        }
        return false;
    }

}
