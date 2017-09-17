package com.sesamepvp.kitpvp.quests.events;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickEvents implements Listener{
		@EventHandler
		public void onInventoryClickEvent(InventoryClickEvent e){
			HumanEntity p = e.getWhoClicked();
			if(e.getCurrentItem() == null){
				return;
			}else{
				if(e.getInventory().getTitle().equalsIgnoreCase("Quests")){
					e.setCancelled(true);
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("&cClose") && e.getCurrentItem().getType() == Material.WOOL){
						p.closeInventory();
					}
				}
			}
		}
}
