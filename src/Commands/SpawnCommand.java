package Commands;

import Utils.LocationManager;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by ManuGun on 19.05.2017.
 */
public class SpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player p = (Player) sender;
        LocationManager.useLocation(p, "Spawn");
        p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.ENDER_SIGNAL, 1);
        p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1,2);
        return false;
    }
}
