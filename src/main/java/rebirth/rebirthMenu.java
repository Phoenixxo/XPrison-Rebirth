package rebirth;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import javax.swing.plaf.SplitPaneUI;

public class rebirthMenu implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return false;
    }

    public static void open(Player player, Rebirth plugin) {
        Inventory gui = Bukkit.createInventory(null, 45, ChatColor.GREEN + "!! CONFIRM REBIRTH !!");

        // Accept
        ItemStack accept = new ItemStack(Material.EMERALD_BLOCK);
        ItemMeta acceptMeta = accept.getItemMeta();
        acceptMeta.setDisplayName(ChatColor.GREEN + "Confirm");
        accept.setItemMeta(acceptMeta);

        // Deny Button
        ItemStack deny = new ItemStack(Material.REDSTONE_BLOCK);
        ItemMeta denyMeta = deny.getItemMeta();
        denyMeta.setDisplayName(ChatColor.RED + "Deny");
        deny.setItemMeta(denyMeta);

        // Set items in GUI
        for (int row = 1; row <= 3; row++) {
            for (int col = 1; row <= 3; col++) {
                int slot = row * 9 + col;
                gui.setItem(slot, accept);
            }
        }

        for (int row = 1; row <= 3; row++) {
            for (int col = 5; row <= 3; col++) {
                int slot = row * 9 + col;
                gui.setItem(slot, accept);
            }
        }

        plugin.getRebirthViewers().add(player.getUniqueId());
        player.openInventory(gui);
    }

}
