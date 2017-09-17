package com.sesamepvp.staffmode.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import com.sesamepvp.staffmode.commands.StaffMode;

public class BlockPlace implements Listener {
	@EventHandler
	public void onPlaceBook(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if (StaffMode.staffmode.contains(p)) {
			e.setCancelled(true);
		}
	}
}
