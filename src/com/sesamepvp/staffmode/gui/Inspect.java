package com.sesamepvp.staffmode.gui;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import com.sesamepvp.staffmode.commands.Freeze;

public class Inspect implements Listener {
	public static void InpsectGUI(Player p, Entity t) {
		Inventory Inspection = Bukkit.createInventory(null, 54, "Inspect");

		int exp = ((HumanEntity) t).getExpToLevel();
		int foodLevel = ((Player) t).getFoodLevel();
		double healthLevel = ((Damageable) t).getHealth();
		boolean fly = ((Player) t).getAllowFlight();
		GameMode gamemode = ((HumanEntity) t).getGameMode();
		PlayerInventory ti = ((HumanEntity) t).getInventory();

		// Health
		ItemStack health = new ItemStack(Material.BREAD, 1);
		ItemMeta healthim = health.getItemMeta();
		healthim.setDisplayName(ChatColor.RED + "Health : " + ChatColor.GREEN + healthLevel);
		health.setItemMeta(healthim);

		// Food
		ItemStack food = new ItemStack(Material.APPLE, 1);
		ItemMeta foodim = food.getItemMeta();
		foodim.setDisplayName(ChatColor.RED + "Hunger : " + ChatColor.GREEN + foodLevel);
		food.setItemMeta(foodim);

		// Flight
		ItemStack flight = new ItemStack(Material.FEATHER, 1);
		ItemMeta flightim = flight.getItemMeta();
		flightim.setDisplayName(ChatColor.RED + "Flight : " + ChatColor.GREEN + fly);
		flight.setItemMeta(flightim);

		// Frozen
		ItemStack freeze = new ItemStack(Material.ICE, 1);
		ItemMeta freezeim = freeze.getItemMeta();
		if (Freeze.frozen.contains(t)) {
			freezeim.setDisplayName(ChatColor.GREEN + "Unfreeze " + t.getName() + "?");
		} else {
			freezeim.setDisplayName(ChatColor.RED + "Freeze " + t.getName() + "?");
		}
		freeze.setItemMeta(freezeim);

		// GameMode
		ItemStack gm = new ItemStack(Material.GRASS, 1);
		ItemMeta gmim = gm.getItemMeta();
		gmim.setDisplayName(ChatColor.RED + "Gamemode : " + ChatColor.GREEN + gamemode);
		gm.setItemMeta(gmim);
		
		// Potion
		ItemStack potion = new ItemStack(Material.GLASS_BOTTLE, 1);
		ItemMeta potionim = potion.getItemMeta();
		potionim.setDisplayName(ChatColor.RED + "Potion Effects : ");
		
		ArrayList<String> potionlore = new ArrayList<String>();
		potionlore.add(ChatColor.GREEN + "Admins Only");
		potionim.setLore(potionlore);
		potion.setItemMeta(potionim);
		// exp
		ItemStack expb = new ItemStack(Material.EXP_BOTTLE, 1);
		ItemMeta expbim = expb.getItemMeta();
		expbim.setDisplayName(ChatColor.RED + "XP : " + ChatColor.GREEN + exp);
		expb.setItemMeta(expbim);

		// panel
		ItemStack panel = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
		ItemMeta panelim = panel.getItemMeta();
		panelim.setDisplayName(ChatColor.RED + "XP : " + ChatColor.GREEN + "");
		panel.setItemMeta(panelim);
		
		
		
		
		// Contents
		ItemStack helmet = ti.getHelmet();
		ItemStack boots = ti.getBoots();
		ItemStack chestplate = ti.getChestplate();
		ItemStack legs = ti.getLeggings();
		
		ItemStack ItemInHand = ti.getItemInHand();

		ItemStack[] contents = ti.getContents();
		Inspection.setContents(contents);

		// Data
		Inspection.setItem(53, health);
		Inspection.setItem(47, flight);
		Inspection.setItem(49, freeze);
		Inspection.setItem(45, gm);
		Inspection.setItem(52, expb);
		Inspection.setItem(51, food);

		// Armor
		Inspection.setItem(36, helmet);
		Inspection.setItem(37, chestplate);
		Inspection.setItem(38, legs);
		Inspection.setItem(39, boots);
		Inspection.setItem(40, ItemInHand);

		// Panels
		Inspection.setItem(41, panel);
		Inspection.setItem(42, panel);
		Inspection.setItem(43, panel);
		Inspection.setItem(44, panel);
		p.openInventory(Inspection);
	}



}
