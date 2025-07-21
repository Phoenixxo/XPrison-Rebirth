package rebirth;

import dev.drawethree.xprison.api.XPrisonAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Rebirth extends JavaPlugin {

    private XPrisonAPI prisonAPI;
    private final Set<UUID> rebirthViewers = new HashSet<>();
    private RebirthManager rebirthManager;

    public Set<UUID> getRebirthViewers() {
        return rebirthViewers;
    }

    public RebirthManager getRebirthManager() {
        return rebirthManager;
    }

    @Override
    public void onEnable() {
        if (Bukkit.getPluginManager().isPluginEnabled("X-Prison")) {
            this.prisonAPI = XPrisonAPI.getInstance();
            getLogger().info("[Rebirth] Hooked into X-Prison API");
        }

        this.rebirthManager = new RebirthManager(prisonAPI);
        this.getCommand("rebirth").setExecutor(new RebirthCommand(rebirthManager, this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
