package rebirth;

import dev.drawethree.xprison.api.XPrisonAPI;
import dev.drawethree.xprison.api.prestiges.model.Prestige;
import dev.drawethree.xprison.api.ranks.model.Rank;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class RebirthManager {

    private final XPrisonAPI prisonAPI;

    public RebirthManager(XPrisonAPI prisonAPI) {
        this.prisonAPI = prisonAPI;
    }

    public void performRebirth(Player player) {
        // Reset rank and prestige

        Rank firstRank = prisonAPI.getRanksApi().getRankById(0);

        prisonAPI.getRanksApi().setPlayerRank(player, firstRank);
        prisonAPI.getPrestigesApi().setPlayerPrestige(player, 0);

        // Optional: clear inventory, give rewards, or custom logic here
        player.getInventory().clear();

        // Message the player
        player.sendMessage(ChatColor.GOLD + "You have been reborn!");
        player.sendTitle(ChatColor.GREEN + "Rebirth Complete", ChatColor.YELLOW + "Back to Rank A", 10, 70, 20);
    }

    public boolean canRebirth(Player player) {
        int rank = prisonAPI.getRanksApi().getPlayerRank(player).getId();
        boolean maxPrestige = prisonAPI.getPrestigesApi().isMaxPrestige(player);

        return (rank == 26) && maxPrestige;
    }
}
