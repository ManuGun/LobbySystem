package Listener;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Created by ManuGun on 13.05.2017.
 */
public class BootsListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if(p.getInventory().getBoots().getType() == Material.LEATHER_BOOTS){
            p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.WATERDRIP, 1);
        }
        if(p.getInventory().getBoots().getType() == Material.CHAINMAIL_BOOTS){
            p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.FIREWORKS_SPARK, 1);
            p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.FLAME, 1);
        }
        if(p.getInventory().getBoots().getType() == Material.GOLD_BOOTS){
            p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.HEART, 1);
        }
        if(p.getInventory().getBoots().getType() == Material.IRON_BOOTS){
            p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.FLAME, 1);
            p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.WATERDRIP, 1);
            p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.CLOUD, 1);
            p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.MAGIC_CRIT, 1);
            p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.SNOW_SHOVEL, 1);
            p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.ENDER_SIGNAL, 1);
            p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.FIREWORKS_SPARK, 1);
        }
    }
}
