package Listener;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

import java.util.ArrayList;

/**
 * Created by ManuGun on 19.05.2017.
 */
public class DoppelsprungListener implements Listener {

    ArrayList<String> Doppelsprung = new ArrayList<String>();
    public static boolean DoppelsprungSettings = true;

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if(p.getGameMode() == GameMode.ADVENTURE && p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR){
            if(DoppelsprungSettings){
                if(!p.isOnGround())
                    return;
                p.setAllowFlight(true);
                Doppelsprung.add(p.getName());
            } else {
                p.setAllowFlight(false);
            }
        }
    }

    @EventHandler
    public void onDoppelsprung(PlayerToggleFlightEvent e){
        Player p = e.getPlayer();
        if(p.getGameMode() == GameMode.ADVENTURE && Doppelsprung.contains(p.getName())){
            if(DoppelsprungSettings){
                e.setCancelled(true);
                p.setAllowFlight(false);
                p.setFlying(false);
                p.setVelocity(p.getLocation().getDirection().multiply(2.0D + 1).setY(0.5D + 1));
                p.setFallDistance(0.0F);
                p.getLocation().getWorld().playSound(p.getLocation(), Sound.CREEPER_HISS, (float) 1, 1);
                Doppelsprung.remove(p.getName());
            } else {

            }
        }
    }
}
