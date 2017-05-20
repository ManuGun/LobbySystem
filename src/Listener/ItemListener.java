package Listener;

import Commands.BuildCommand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;

import java.awt.event.ItemEvent;

/**
 * Created by ManuGun on 13.05.2017.
 */
public class ItemListener implements Listener {

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e){
        if(BuildCommand.Build){
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onItemPickup(PlayerPickupItemEvent e){
        if(BuildCommand.Build){
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onItemMove(InventoryClickEvent e){
        if(BuildCommand.Build){
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onItemPlace(BlockPlaceEvent e){
        if(BuildCommand.Build){
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onItemBreak(BlockBreakEvent e){
        if(BuildCommand.Build){
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

}
