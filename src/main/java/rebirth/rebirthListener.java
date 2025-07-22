package rebirth;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

public class rebirthListener implements Listener {

    private final Rebirth plugin;
    private final RebirthManager manager;

    public rebirthListener(Rebirth plugin, RebirthManager manager){
        this.plugin = plugin;
        this.manager = manager;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player player)) return;
        if (!plugin.getRebirthViewers().contains(player.getUniqueId())) return;

        String title = event.getView().getTitle();
        if (!title.equals(ChatColor.GREEN + "Confirm Rebirth")) return;

        event.setCancelled(true);

        ItemStack clicked = event.getCurrentItem();
        if (clicked == null || !clicked.hasItemMeta()) return;

        Material obj = clicked.getType();

        if (obj.equals(Material.EMERALD_BLOCK)) {
            player.closeInventory();
            manager.performRebirth(player);
            player.sendMessage(ChatColor.GOLD + "You have been reborn!");
        } else if (obj.equals(Material.REDSTONE_BLOCK)) {
            player.closeInventory();
            player.sendMessage(ChatColor.GRAY + "Rebirth cancelled.");
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        plugin.getRebirthViewers().remove(event.getPlayer().getUniqueId());
    }

}
