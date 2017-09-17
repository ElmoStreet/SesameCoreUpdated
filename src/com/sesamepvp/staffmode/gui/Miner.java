package com.sesamepvp.staffmode.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Miner {
	
	public static Inventory minerGUI = Bukkit.createInventory(null, 54, "Miners");
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

		
		minerGUI.setItem(53, close);
		minerGUI.setItem(45, panel);
		minerGUI.setItem(46, panel);
		minerGUI.setItem(47, panel);
		minerGUI.setItem(48, panel);
		minerGUI.setItem(49, panel);
		minerGUI.setItem(50, panel);
		minerGUI.setItem(51, panel);
		minerGUI.setItem(52, panel);
		p.playSound(p.getLocation(), Sound.NOTE_PLING, 2F, 1F);
		p.openInventory(minerGUI);
	}
}
