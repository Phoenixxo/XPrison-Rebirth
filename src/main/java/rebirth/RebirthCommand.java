package rebirth;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RebirthCommand implements CommandExecutor {

    private final RebirthManager rebirthManager;

    public RebirthCommand(RebirthManager rebirthManager) {
        this.rebirthManager = rebirthManager;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!(sender instanceof Player player)) return true;
        if (!rebirthManager.canRebirth(player)) {
            sender.sendMessage(ChatColor.RED + "You must be Rank Z and Prestige 5 to rebirth.");
            return true;
        }
        rebirthMenu.open(player);
        return true;
    }
}
