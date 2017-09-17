package com.sesamepvp.kitpvp.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.sesamepvp.files.KitpvpFile;

public class StatsGUI {
	public static KitpvpFile manager = KitpvpFile.getInstance();
	final static Inventory stats = Bukkit.createInventory(null, 27, "Stats");

	public static void playerStats(Player p) {

		int playerkills = manager.getData().getInt(p.getUniqueId() + ".Kills");
		int playerdeaths = manager.getData().getInt(p.getUniqueId() + ".Deaths");
		String playerrank = manager.getData().getString(p.getUniqueId() + ".Rank");

		if (playerrank == null) {
			ItemStack rank = new ItemStack(Material.NAME_TAG, 1);
			ItemMeta rankmeta = rank.getItemMeta();
			rankmeta.setDisplayName("§aRank §8: §2" + "None");
			rank.setItemMeta(rankmeta);
			stats.setItem(15, rank);
		} else {
			ItemStack rank = new ItemStack(Material.NAME_TAG, 1);
			ItemMeta rankmeta = rank.getItemMeta();
			rankmeta.setDisplayName("§aRank §8: §2" + playerrank);
			rank.setItemMeta(rankmeta);
			stats.setItem(15, rank);
		}

		ItemStack kills = new ItemStack(Material.SKULL_ITEM, 1);
		ItemMeta killsmeta = kills.getItemMeta();
		killsmeta.setDisplayName("§aKills §8: §2" + playerkills);
		kills.setItemMeta(killsmeta);

		ItemStack deaths = new ItemStack(Material.LAVA_BUCKET);
		ItemMeta deathsmeta = deaths.getItemMeta();
		deathsmeta.setDisplayName("§aDeaths §8: §2" + playerdeaths);
		deaths.setItemMeta(deathsmeta);

		ItemStack panel = new ItemStack(Material.STAINED_GLASS_PANE, 1,
				(short) 7);
		ItemMeta panelim = panel.getItemMeta();
		panelim.setDisplayName(ChatColor.RED + "");
		panel.setItemMeta(panelim);

		ItemStack close = new ItemStack(Material.WOOL, 1, (short) 14);
		ItemMeta closem = close.getItemMeta();
		closem.setDisplayName(ChatColor.RED + "Close");
		close.setItemMeta(closem);

		ItemStack tokits = new ItemStack(Material.WOOL, 1, (short) 5);
		ItemMeta tokitsm = tokits.getItemMeta();
		tokitsm.setDisplayName(ChatColor.GREEN + "To Kits");
		tokits.setItemMeta(tokitsm);

		stats.setItem(11, kills);
		stats.setItem(13, deaths);

		stats.setItem(0, panel);
		stats.setItem(1, panel);
		stats.setItem(2, panel);
		stats.setItem(3, panel);
		stats.setItem(4, panel);
		stats.setItem(5, panel);
		stats.setItem(6, panel);
		stats.setItem(7, panel);
		stats.setItem(8, close);
		stats.setItem(9, panel);
		stats.setItem(17, panel);
		stats.setItem(18, panel);
		stats.setItem(19, panel);
		stats.setItem(20, panel);
		stats.setItem(21, panel);
		stats.setItem(22, panel);
		stats.setItem(23, panel);
		stats.setItem(24, panel);
		stats.setItem(25, panel);
		stats.setItem(26, tokits);

		p.openInventory(stats);
	}

	public static void targetStats(Player p, Player t) {

		int playerkills = manager.getData().getInt(t.getUniqueId() + ".Kills");
		int playerdeaths = manager.getData().getInt(t.getUniqueId() + ".Deaths");
		String playerrank = manager.getData().getString(t.getUniqueId() + ".Rank");

		if (playerrank == null) {
			ItemStack rank = new ItemStack(Material.NAME_TAG, 1);
			ItemMeta rankmeta = rank.getItemMeta();
			rankmeta.setDisplayName("§aRank §8: §2" + "None");
			rank.setItemMeta(rankmeta);
			stats.setItem(15, rank);
		} else {
			ItemStack rank = new ItemStack(Material.NAME_TAG, 1);
			ItemMeta rankmeta = rank.getItemMeta();
			rankmeta.setDisplayName("§aRank §8: §2" + playerrank);
			rank.setItemMeta(rankmeta);
			stats.setItem(15, rank);
		}

		ItemStack kills = new ItemStack(Material.SKULL_ITEM, 1);
		ItemMeta killsmeta = kills.getItemMeta();
		killsmeta.setDisplayName("§aKills §8: §2" + playerkills);
		kills.setItemMeta(killsmeta);

		ItemStack deaths = new ItemStack(Material.LAVA_BUCKET);
		ItemMeta deathsmeta = deaths.getItemMeta();
		deathsmeta.setDisplayName("§aDeaths §8: §2" + playerdeaths);
		deaths.setItemMeta(deathsmeta);

		ItemStack panel = new ItemStack(Material.STAINED_GLASS_PANE, 1,
				(short) 7);
		ItemMeta panelim = panel.getItemMeta();
		panelim.setDisplayName(ChatColor.RED + t.getName());
		panel.setItemMeta(panelim);

		ItemStack close = new ItemStack(Material.WOOL, 1, (short) 14);
		ItemMeta closem = close.getItemMeta();
		closem.setDisplayName(ChatColor.RED + "Close");
		close.setItemMeta(closem);

		ItemStack tokits = new ItemStack(Material.WOOL, 1, (short) 5);
		ItemMeta tokitsm = tokits.getItemMeta();
		tokitsm.setDisplayName(ChatColor.GREEN + "To Kits");
		tokits.setItemMeta(tokitsm);

		stats.setItem(11, kills);
		stats.setItem(13, deaths);

		stats.setItem(0, panel);
		stats.setItem(1, panel);
		stats.setItem(2, panel);
		stats.setItem(3, panel);
		stats.setItem(4, panel);
		stats.setItem(5, panel);
		stats.setItem(6, panel);
		stats.setItem(7, panel);
		stats.setItem(8, close);
		stats.setItem(9, panel);
		stats.setItem(17, panel);
		stats.setItem(18, panel);
		stats.setItem(19, panel);
		stats.setItem(20, panel);
		stats.setItem(21, panel);
		stats.setItem(22, panel);
		stats.setItem(23, panel);
		stats.setItem(24, panel);
		stats.setItem(25, panel);
		stats.setItem(26, tokits);

		p.openInventory(stats);
	}
}
