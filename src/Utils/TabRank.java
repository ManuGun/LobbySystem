package Utils;

import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

/**
 * Created by ManuGun on 20.05.2017.
 */
public class TabRank {

    public static void rmTab(CraftPlayer cp){
        PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, cp.getHandle());
        sendPacket(packet);
    }

    public static void sendPacket(Packet<?> packet) {
        for(Player all : Bukkit.getOnlinePlayers()){
            ((CraftPlayer)all).getHandle().playerConnection.sendPacket(packet);
        }
    }

    public static void addTab(CraftPlayer cp){
        PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, cp.getHandle());
        sendPacket(packet);
    }

}
