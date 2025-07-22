package rebirth;

import dev.drawethree.xprison.api.XPrisonAPI;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Rebirth extends JavaPlugin {

    private XPrisonAPI prisonAPI;
    private final Set<UUID> rebirthViewers = new HashSet<>();
    private RebirthManager rebirthManager;
    private rebirthListener listener;

    public Set<UUID> getRebirthViewers() {
        return this.rebirthViewers;
    }

    @Override
    public void onEnable() {
            // Check if X-Prison plugin is enabled
            if (getServer().getPluginManager().isPluginEnabled("X-Prison")) {
                prisonAPI = XPrisonAPI.getInstance();
                getLogger().info("Successfully hooked into X-Prison API");
            } else {
                getLogger().severe("X-Prison plugin not found, disabling!");
                getServer().getPluginManager().disablePlugin(this);
                return;
            }
        this.rebirthManager = new RebirthManager(prisonAPI);
        this.listener = new rebirthListener(this, rebirthManager);
        this.getCommand("rebirth").setExecutor(new RebirthCommand(rebirthManager, this));
        this.getServer().getPluginManager().registerEvents(this.listener, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("[Rebirth] Shutting down...");
    }

}
