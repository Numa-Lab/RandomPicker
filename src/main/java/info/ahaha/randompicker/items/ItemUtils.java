package info.ahaha.randompicker.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtils {

    public static ItemStack getRandomPickStick(){
        ItemStack item = new ItemStack(Material.STICK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD+"RandomPickStick");
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getSelectStorageStick(){
        ItemStack item = new ItemStack(Material.STICK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD+"SelectStorageStick");
        item.setItemMeta(meta);
        return item;
    }
}
