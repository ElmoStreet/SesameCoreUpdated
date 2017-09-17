package com.sesamepvp.staffmode.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import com.sesamepvp.staffmode.commands.StaffMode;
import com.sesamepvp.utilites.Messages;

public class ItemDrop implements Listener {
	@EventHandler
	public void onDropEvent(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		if (StaffMode.staffmode.contains(p)) {
			e.setCancelled(true);
			p.sendMessage(Messages.mustleaveMod());
		}

	}

	@EventHandler
	public void onItemPick(PlayerPickupItemEvent e) {
		if (StaffMode.staffmode.contains(e.getPlayer())) {
			e.setCancelled(true);
		}
	}
}
