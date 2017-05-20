package Utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by ManuGun on 13.05.2017.
 */
public class ItemManager {

    public static ItemStack createItem(Material material, int anzahl, int subid, String displayname)
    {
        short neuesubid = (short)subid;
        ItemStack i = new ItemStack(material, anzahl, neuesubid);
        ItemMeta m = i.getItemMeta();
        m.setDisplayName(displayname);
        i.setItemMeta(m);

        return i;
    }
    public static ItemStack createItemWithID(int ID, int anzahl, int subid, String displayname)
    {
        short neuesubid = (short)subid;
        @SuppressWarnings("deprecation")
        ItemStack i = new ItemStack(ID, anzahl, neuesubid);
        ItemMeta m = i.getItemMeta();
        m.setDisplayName(displayname);
        i.setItemMeta(m);

        return i;
    }

}
