package Listener;

import Utils.LocationManager;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Created by ManuGun on 19.05.2017.
 */
public class Navigator implements Listener {

    @EventHandler
    public void onNavigator(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(e.getInventory().getName().equalsIgnoreCase("§cSpielmodi §8| §fAuswahl")){
            e.setCancelled(true);
            if(e.getCurrentItem().getType() == Material.IRON_SWORD){
                LocationManager.useLocation(p, "QSG");
                p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.ENDER_SIGNAL, 1);
                p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1,2);
            }
            if(e.getCurrentItem().getType() == Material.GRASS){
                LocationManager.useLocation(p, "SkyWars");
                p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.ENDER_SIGNAL, 1);
                p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1,2);
            }
            if(e.getCurrentItem().getType() == Material.BED){
                LocationManager.useLocation(p, "BedWars");
                p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.ENDER_SIGNAL, 1);
                p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1,2);
            }
            if(e.getCurrentItem().getType() == Material.COOKIE){
                LocationManager.useLocation(p, "Spawn");
                p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.ENDER_SIGNAL, 1);
                p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1,2);
            }
            if(e.getCurrentItem().getType() == Material.BEDROCK){
                LocationManager.useLocation(p, "Freebuild");
                p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.ENDER_SIGNAL, 1);
                p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1,2);
            }
        }
    }
}
