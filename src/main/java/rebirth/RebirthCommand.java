package rebirth;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getLogger;

public class RebirthCommand implements CommandExecutor {

    private final RebirthManager rebirthManager;
    private final Rebirth plugin;

    public RebirthCommand(RebirthManager rebirthManager, Rebirth plugin) {
        this.rebirthManager = rebirthManager;
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!(sender instanceof Player player)) return true;
        if (!rebirthManager.canRebirth(player)) {
            sender.sendMessage(ChatColor.RED + "You must be Rank Z and Prestige 5 to rebirth.");
            return true;
        }
        rebirthMenu.open(player, plugin);
        return true;
    }
}
