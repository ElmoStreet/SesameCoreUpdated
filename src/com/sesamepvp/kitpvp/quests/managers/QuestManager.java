package com.sesamepvp.kitpvp.quests.managers;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.sesamepvp.kitpvp.quests.quests.Hunter;

public interface QuestManager {
	QuestManager Quests = new Hunter();
	public String getName();

	public  ItemStack getItem();

	public  String getDisplayName();
	
	public  String getLore();
	
	public void applyQuest(Inventory inventory, int position);
	
	public String getReward();
}
