package com.sesamepvp.staffmode.commands.report.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ReportGUI {
	public static Inventory reportGUI = Bukkit.createInventory(null, 54, "Reports");
	public static void gui(Player p){
		
		ItemStack panel = new ItemStack(Material.STAINED_GLASS_PANE, 1,
				(short) 7);
		ItemMeta panelim = panel.getItemMeta();
		panelim.setDisplayName(ChatColor.RED + "");
		panel.setItemMeta(panelim);
		
		ItemStack close = new ItemStack(Material.WOOL, 1,
				(short) 14);
		ItemMeta closem = close.getItemMeta();
		closem.setDisplayName(ChatColor.RED+"Close");
		close.setItemMeta(closem);	
		
		ItemStack removeall = new ItemStack(Material.WOOL, 1,
				(short) 4);
		ItemMeta removeallm = removeall.getItemMeta();
		removeallm.setDisplayName(ChatColor.YELLOW+"Clear all reports.");
		removeall.setItemMeta(removeallm);	
		
		reportGUI.setItem(53, close);
		reportGUI.setItem(45, removeall);
		reportGUI.setItem(46, panel);
		reportGUI.setItem(47, panel);
		reportGUI.setItem(48, panel);
		reportGUI.setItem(49, panel);
		reportGUI.setItem(50, panel);
		reportGUI.setItem(51, panel);
		reportGUI.setItem(52, panel);
		p.playSound(p.getLocation(), Sound.NOTE_PLING, 2F, 1F);
		p.openInventory(reportGUI);
	}
}
