package info.ahaha.randompicker.cmd;

import info.ahaha.randompicker.items.ItemUtils;
import info.ahaha.randompicker.listener.RandomPickListener;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Cmd implements CommandExecutor, TabCompleter {

    public static Location location;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player))return true;
        Player player = (Player) sender;
        if (args[0].equalsIgnoreCase("get")){
            if (args[1].equalsIgnoreCase("RandomPickStick")){
                player.getInventory().addItem(ItemUtils.getRandomPickStick());
            }else if (args[1].equalsIgnoreCase("SelectStorageStick")){
                player.getInventory().addItem(ItemUtils.getSelectStorageStick());

            }
        }
        if (args[0].equalsIgnoreCase("pick")){
            if (location == null){
                player.sendMessage("RandomPickStickで元のチェストの登録をしてください！");
                return true;
            }
            Block block = location.getBlock();
            if (block.getType() != Material.CHEST){
                player.sendMessage("登録されているブロックがチェストじゃありません");
                return true;
            }
            Chest chest = null;
            if (block.getState() instanceof Chest){
                chest = (Chest) block.getState();
            }
            if (chest == null)return true;

            List<ItemStack>list = RandomPickListener.randoms;
            for (int i = 0; i < 4;i++){
                Random r = new Random();
                int random = r.nextInt(list.size());
                ItemStack item = list.get(random);
                item.setAmount(1);
                chest.getInventory().addItem(item);
                player.sendMessage(item.getType().name()+"を追加しました！");
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1)
        return new ArrayList<>(Arrays.asList("get","pick"));
        if (args.length == 2){
            if (args[0].equalsIgnoreCase("get"))
            return new ArrayList<>(Arrays.asList("RandomPickStick","SelectStorageStick"));
        }
        return null;
    }

    public static void setLocation(Location location) {
        Cmd.location = location;
    }
}
