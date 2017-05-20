package Listener;

import Main.Main;
import Utils.ItemManager;
import Utils.LocationManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

/**
 * Created by ManuGun on 13.05.2017.
 */
public class InventoryListener implements Listener{

    @EventHandler
    public void onClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(e.getInventory().getName().equalsIgnoreCase("§cHüte §8| §fAuswahl")){
            e.setCancelled(true);
            if(e.getCurrentItem().getType() == Material.PUMPKIN){
                p.getInventory().setHelmet(ItemManager.createItem(Material.PUMPKIN,1,0,"§cKürbis"));
                p.closeInventory();
            }
            if(e.getCurrentItem().getType() == Material.LEAVES){
                p.getInventory().setHelmet(ItemManager.createItem(Material.LEAVES,1,0,"§cBlätter"));
                p.closeInventory();
            }
            if(e.getCurrentItem().getType() == Material.GOLD_BLOCK){
                p.getInventory().setHelmet(ItemManager.createItem(Material.GOLD_BLOCK,1,0,"§cGoldblock"));
                p.closeInventory();
            }
            if(e.getCurrentItem().getType() == Material.TNT){
                p.getInventory().setHelmet(ItemManager.createItem(Material.TNT,1,0,"§cTNT"));
                p.closeInventory();
            }
            if(e.getCurrentItem().getType() == Material.BARRIER){
                p.getInventory().setHelmet(null);
                p.closeInventory();
            }
        }
        if(e.getInventory().getName().equalsIgnoreCase("§cExtras §8| §fAuswahl")){
            e.setCancelled(true);
            if(e.getCurrentItem().getType() == Material.PUMPKIN){
                Inventory inv = Bukkit.createInventory(p,18,"§cHüte §8| §fAuswahl");
                inv.setItem(0,ItemManager.createItem(Material.PUMPKIN,1,0,"§cKürbis"));
                inv.setItem(2,ItemManager.createItem(Material.LEAVES,1,0,"§cBlätter"));
                inv.setItem(4,ItemManager.createItem(Material.GOLD_BLOCK,1,0,"§cGoldblock"));
                inv.setItem(6,ItemManager.createItem(Material.TNT,1,0,"§cTNT"));
                inv.setItem(17,ItemManager.createItem(Material.BARRIER,1,0,"§4Hüte entfernen"));
                p.openInventory(inv);
            }
            if(e.getCurrentItem().getType() == Material.DIAMOND_BOOTS){
                Inventory inv = Bukkit.createInventory(p, 18, "§cBoots §8| §fAuswahl");
                inv.setItem(0, ItemManager.createItem(Material.LEATHER_BOOTS,1,0,"§bAuquaboots"));
                inv.setItem(2, ItemManager.createItem(Material.CHAINMAIL_BOOTS,1,0,"§cFeuerboots"));
                inv.setItem(4, ItemManager.createItem(Material.GOLD_BOOTS,1,0,"§5Loveboots"));
                inv.setItem(6, ItemManager.createItem(Material.IRON_BOOTS,1,0,"§3CrazyBoots"));
                inv.setItem(17,ItemManager.createItem(Material.BARRIER,1,0,"§4Boots entfernen"));
                p.openInventory(inv);
            }
            if(e.getCurrentItem().getType() == Material.FEATHER){
                if(DoppelsprungListener.DoppelsprungSettings){
                    DoppelsprungListener.DoppelsprungSettings = false;
                    p.sendMessage(Main.prefix + "Der Doppelsprung wurde §cdeaktiviert");
                    p.closeInventory();
                } else {
                    DoppelsprungListener.DoppelsprungSettings = true;
                    p.sendMessage(Main.prefix + "Der Doppelsprung wurde §aaktiviert");
                    p.closeInventory();
                }
            }
        }
        if(e.getCurrentItem().getType() == Material.LEATHER_BOOTS){
            p.getInventory().setBoots(ItemManager.createItem(Material.LEATHER_BOOTS,1,0, "§bAuquaboots"));
            p.closeInventory();
        }
        if(e.getCurrentItem().getType() == Material.CHAINMAIL_BOOTS){
            p.getInventory().setBoots(ItemManager.createItem(Material.CHAINMAIL_BOOTS,1,0, "§cFeuerboots"));
            p.closeInventory();
        }
        if(e.getCurrentItem().getType() == Material.GOLD_BOOTS){
            p.getInventory().setBoots(ItemManager.createItem(Material.GOLD_BOOTS,1,0, "§5Loveboots"));
            p.closeInventory();
        }
        if(e.getCurrentItem().getType() == Material.IRON_BOOTS){
            p.getInventory().setBoots(ItemManager.createItem(Material.IRON_BOOTS,1,0, "§3CrazyBoots"));
            p.closeInventory();
        }
        if(e.getCurrentItem().getType() == Material.BARRIER){
            p.getInventory().setBoots(ItemManager.createItem(Material.DIAMOND_BOOTS, 1,0,"§cKeine Boots"));
            p.closeInventory();
        }
    }
}
