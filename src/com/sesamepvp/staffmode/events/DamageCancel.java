package com.sesamepvp.staffmode.events;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import com.sesamepvp.staffmode.commands.Freeze;
import com.sesamepvp.staffmode.commands.StaffMode;
import com.sesamepvp.utilites.Messages;

public class DamageCancel implements Listener {

	@EventHandler(priority = EventPriority.NORMAL)
	public void dmg(final EntityDamageEvent e) {
		if (e.getCause() == DamageCause.FALL) {
			e.setCancelled(true);
		}

		Entity e1 = (Entity) e.getEntity();
		if (e1 == null) {
			e.setCancelled(true);
			return;
		} else {
			if (e instanceof Player) {
				Player p = (Player) e1;
				if (StaffMode.staffmode.contains(p)) {
					e.setCancelled(true);
					p.setHealth(20);
					p.setFoodLevel(20);
					return;
				} else {
					if (!(StaffMode.staffmode.contains(p))) {
						return;
					}
				}
			}
		}
	}

	@EventHandler
	public void onDamagePlayer(EntityDamageByEntityEvent e) {
		if (e.getDamager() == null) {

		} else {
			if (e.getDamager() instanceof Player) {
				if (StaffMode.staffmode.contains(e.getDamager())) {
					e.setCancelled(true);
					((CommandSender) e.getDamager()).sendMessage(Messages
							.mustleaveMod());
				} else {
					if (Freeze.frozen.contains(e.getDamager())) {
						e.setCancelled(true);
					}
				}
			}
		}
	}
}
