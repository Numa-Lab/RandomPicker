package info.ahaha.randompicker;

import info.ahaha.randompicker.cmd.Cmd;
import info.ahaha.randompicker.listener.RandomPickListener;
import info.ahaha.randompicker.listener.SelectStorageListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class RandomPicker extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getServer().getPluginManager().registerEvents(new RandomPickListener(),this);
        getServer().getPluginManager().registerEvents(new SelectStorageListener(),this);

        getCommand("randompick").setExecutor(new Cmd());
        getCommand("randompick").setTabCompleter(new Cmd());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
