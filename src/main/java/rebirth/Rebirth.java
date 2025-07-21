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

    public Set<UUID> getRebirthViewers() {
        return rebirthViewers;
    }

    @Override
    public void onEnable() {
        if (Bukkit.getPluginManager().isPluginEnabled("X-Prison")) {
            this.prisonAPI = XPrisonAPI.getInstance();
            getLogger().info("[Rebirth] Hooked into X-Prison API");
        }

        RebirthManager rebirthManager = new RebirthManager(prisonAPI);
        getCommand("rebirth").setExecutor(new RebirthCommand(rebirthManager, this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
