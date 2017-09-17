package com.sesamepvp.punishments.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClickEventHandler implements Listener{
	@EventHandler
	public void onClick(InventoryClickEvent e){
		if(e.getCurrentItem() == null){
			return;
		}
		if(e.getInventory().getName().contains("Punish")){
			if(e.getCurrentItem().getType() == Material.BOOK && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("&a&lGeneral Ban")){
				//if(e.getInventory().getItem(4).getItemMeta().getDisplayName().equalsIgnoreCase(""));
			}
		}else{
			return;
		}
	}
}
