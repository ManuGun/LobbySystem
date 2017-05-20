package Listener;

import Main.Main;
import Utils.ItemManager;
import Utils.TitleManager;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ManuGun on 13.05.2017.
 */
public class ItemUse implements Listener {

    static ArrayList<String> SpielerVerstecken = new ArrayList<String>();
    public static boolean SilentLobby = false;

    @EventHandler
    public void onUse(PlayerInteractEvent e){
        Player p = e.getPlayer();

        //Extras
        if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR)){
            if(p.getItemInHand().getType() == Material.ENDER_CHEST){
                Inventory inv = Bukkit.createInventory(p, 9, "§cExtras §8| §fAuswahl");

                inv.setItem(2, ItemManager.createItem(Material.DIAMOND_BOOTS, 1,0,"§cBoots"));

                if(DoppelsprungListener.DoppelsprungSettings){
                    inv.setItem(4,ItemManager.createItem(Material.FEATHER,1,0,"§7Doppelsprung §8» §aAktiviert"));
                } else {
                    inv.setItem(4,ItemManager.createItem(Material.FEATHER,1,0,"§7Doppelsprung §8» §cDeaktiviert"));
                }

                inv.setItem(6,ItemManager.createItem(Material.PUMPKIN,1,0,"§cHüte"));

                p.openInventory(inv);
            }
        }

        //Navigator
        if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR)){
            if(p.getItemInHand().getType() == Material.WATCH){
                Inventory inv = Bukkit.createInventory(p, 18, "§cSpielmodi §8| §fAuswahl");

                inv.setItem(2, ItemManager.createItem(Material.IRON_SWORD,1,0,"§cQSG"));
                inv.setItem(6, ItemManager.createItem(Material.GRASS,1,0,"§cSkyWars"));
                inv.setItem(13, ItemManager.createItem(Material.COOKIE,1,0,"§cSpawn"));
                inv.setItem(16, ItemManager.createItem(Material.BEDROCK,1,0,"§cFreebuild"));
                inv.setItem(10, ItemManager.createItem(Material.BED,1,0,"§cBedWars"));

                p.openInventory(inv);
            }
        }

        //Spieler verstecken
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if(p.getItemInHand().getType() == Material.SLIME_BALL){
                if(SpielerVerstecken.contains(p.getName())){
                    SpielerVerstecken.remove(p.getName());
                    for(Player all : Bukkit.getOnlinePlayers()){
                        p.showPlayer(all);
                    }
                    TitleManager.sendActionBar(p,"Alle Spieler sind nun §asichtbar");
                } else {
                    SpielerVerstecken.add(p.getName());
                    for(Player all : Bukkit.getOnlinePlayers()){
                        p.hidePlayer(all);
                    }
                    TitleManager.sendActionBar(p,"Alle Spieler sind nun §cunsichtbar");
                }
            }
        }

        //SilentLobby
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if(p.getItemInHand().getType() == Material.TNT){
                if(SpielerVerstecken.contains(p.getName())){
                    SpielerVerstecken.remove(p.getName());
                    for(Player all : Bukkit.getOnlinePlayers()){
                        p.showPlayer(all);
                        all.showPlayer(p);
                    }
                    TitleManager.sendActionBar(p,"§cDu bist nun nicht mehr in der SilentLobby");
                    SilentLobby = false;
                } else {
                    SpielerVerstecken.add(p.getName());
                    for(Player all : Bukkit.getOnlinePlayers()){
                        p.hidePlayer(all);
                        all.hidePlayer(p);
                    }
                    TitleManager.sendActionBar(p,"§aDu bist nun in der SilentLobby");
                    SilentLobby = true;
                }
            }
        }

    }
}
