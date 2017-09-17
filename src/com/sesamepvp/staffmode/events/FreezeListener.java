package com.sesamepvp.staffmode.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import com.sesamepvp.files.StaffmodeFile;
import com.sesamepvp.staffmode.commands.Freeze;
import com.sesamepvp.staffmode.commands.StaffMode;

public class FreezeListener implements Listener {
	StaffmodeFile sfm = StaffmodeFile.getInstance();
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (Freeze.frozen.contains(p)) {
			p.teleport(p);
		} else {
			return;
		}
	}
	

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();

		if (e.getCurrentItem() == null) {
			e.setCancelled(true);
			return;
		}
		if (StaffMode.staffmode.contains(player)) {
			e.setCancelled(true);
		}

		if (e.getCurrentItem().getType() == Material.getMaterial(sfm.getData().getString("Freeze.material"))
				&& StaffMode.staffmode.contains(player)) {
			e.setCancelled(true);
			Bukkit.dispatchCommand(player, "freeze "
					+ e.getInventory().getName());
		}
	}
}
