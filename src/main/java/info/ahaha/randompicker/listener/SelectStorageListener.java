package info.ahaha.randompicker.listener;

import info.ahaha.randompicker.cmd.Cmd;
import info.ahaha.randompicker.items.ItemUtils;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SelectStorageListener implements Listener {


    @EventHandler
    public void onPick(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getClickedBlock() == null) return;
            if (!e.getPlayer().getInventory().getItemInMainHand().isSimilar(ItemUtils.getSelectStorageStick())) return;
            Block b = e.getClickedBlock();
            if (b.getType() == Material.CHEST) {
                if (b.getState() instanceof Chest) {
                    e.setCancelled(true);
                    Chest chest = (Chest) b.getState();
                    Cmd.setLocation(chest.getLocation());
                    e.getPlayer().sendMessage("X : " + chest.getLocation().getBlockX() + " , "
                            + "Y : " + chest.getLocation().getBlockY() + " , " +
                            "Z : " + chest.getLocation().getBlockZ() + " にあるチェストを登録しました！"
                    );
                }
            }
        }
    }

}
