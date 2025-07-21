package rebirth;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class rebirthMenu {
    public static void open(Player player, Rebirth plugin) {
        Inventory gui = Bukkit.createInventory(null, 45, ChatColor.GREEN + "!! CONFIRM REBIRTH !!");

        // Accept
        ItemStack accept = new ItemStack(Material.EMERALD_BLOCK);
        ItemMeta acceptMeta = accept.getItemMeta();
        if (acceptMeta != null) {
            acceptMeta.setDisplayName(ChatColor.GREEN + "Confirm");
        }
        accept.setItemMeta(acceptMeta);

        // Deny Button
        ItemStack deny = new ItemStack(Material.REDSTONE_BLOCK);
        ItemMeta denyMeta = deny.getItemMeta();
        if (denyMeta != null) {
            denyMeta.setDisplayName(ChatColor.RED + "Deny");
        }
        deny.setItemMeta(denyMeta);

        // Set items in GUI
        for (int row = 1; row <= 3; row++) {
            for (int col = 1; col <= 3; col++) {
                int slot = row * 9 + col;
                gui.setItem(slot, accept);
            }
        }

        for (int row = 1; row <= 3; row++) {
            for (int col = 5; col <= 7; col++) {
                int slot = row * 9 + col;
                gui.setItem(slot, deny);
            }
        }

        plugin.getRebirthViewers().add(player.getUniqueId());
        player.openInventory(gui);
    }

}
