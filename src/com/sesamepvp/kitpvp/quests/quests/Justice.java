package com.sesamepvp.kitpvp.quests.quests;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.sesamepvp.kitpvp.quests.managers.QuestManager;
import com.sesamepvp.staffmode.StaffmodeManager;

public class Justice implements QuestManager {

	
	public String getName() {
		return StaffmodeManager.format("Justice");
	}

	
	public ItemStack getItem() {
		ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
		return item;
	}

	
	public String getDisplayName() {
		return StaffmodeManager.format("&1Justice");
	}

	
	public String getLore() {
		return StaffmodeManager.format("&bUnlock God kit and all the kits below it!");
	}
	

	
	public void applyQuest(Inventory inventory, int position) {
		ItemStack item = new ItemStack(this.getItem());
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(this.getDisplayName());
		ArrayList<String> itemlore = new ArrayList<String>();
		itemlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
				+ "--------------");
		itemlore.add(this.getLore());
		itemlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
				+ "--------------");
		itemlore.add(this.getReward());
		itemlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
				+ "--------------");
		im.setLore(itemlore);
		item.setItemMeta(im);
		inventory.setItem(position, item);
	}
	
	
	public String getReward(){
		return StaffmodeManager.format("&aReward: &2$&a2500");
	}

}
