package com.sesamepvp.staffmode.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.sesamepvp.staffmode.commands.StaffMode;

public class InvClickEvent implements Listener {
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("Inspect")){
			e.setCancelled(true);
		}
		if (e.getCurrentItem() == null) {
			e.setCancelled(true);
			return;
		}
		if (StaffMode.staffmode.contains(player)) {
			e.setCancelled(true);
		}

		if (e.getCurrentItem().getType() == Material.ICE
				&& StaffMode.staffmode.contains(player)) {
			e.setCancelled(true);
			Bukkit.dispatchCommand(player, "freeze "
					+ e.getInventory().getName());
		}
	}

}
