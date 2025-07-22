package rebirth;

import dev.drawethree.xprison.api.XPrisonAPI;
import dev.drawethree.xprison.api.prestiges.model.Prestige;
import dev.drawethree.xprison.api.ranks.model.Rank;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class RebirthManager {

    private final XPrisonAPI prisonAPI;

    public RebirthManager(XPrisonAPI prisonAPI) {
        this.prisonAPI = prisonAPI;
    }

    public void performRebirth(Player player) {
        // Reset rank and prestige

        Rank firstRank = prisonAPI.getRanksApi().getRankById(1);

        prisonAPI.getRanksApi().setPlayerRank(player, firstRank);
        prisonAPI.getPrestigesApi().setPlayerPrestige(player, 0);

        // Optional: clear inventory, give rewards, or custom logic here
//        player.getInventory().clear();

        // Message the player
        player.sendMessage(ChatColor.GOLD + "You have been reborn!");
        player.sendTitle(ChatColor.GREEN + "Rebirth Complete", ChatColor.YELLOW + "Back to Rank A", 10, 70, 20);
    }

    public boolean canRebirth(Player player) {
        int playerRank = prisonAPI.getRanksApi().getPlayerRank(player).getId();
        long playerPrestige = prisonAPI.getPrestigesApi().getPlayerPrestige(player).getId();

        if ((playerRank == 26) && playerPrestige >= 5) {
            return true;
        } else {
            Bukkit.getLogger().info("[Rebirth DEBUG] Player rank: " + playerRank);
            Bukkit.getLogger().info("[Rebirth DEBUG] Player is max prestige: " + playerPrestige);
            return false;
        }
    }
}
