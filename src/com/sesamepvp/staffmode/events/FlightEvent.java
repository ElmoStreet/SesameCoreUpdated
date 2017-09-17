package com.sesamepvp.staffmode.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import com.sesamepvp.files.StaffmodeFile;
import com.sesamepvp.staffmode.StaffmodeManager;
import com.sesamepvp.staffmode.commands.StaffMode;
import com.sesamepvp.utilites.Messages;

public class FlightEvent implements Listener {
	StaffmodeFile sfm = StaffmodeFile.getInstance();

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		if (StaffMode.staffmode.contains(e.getPlayer())) {
			e.getPlayer().setHealth(20);
			e.getPlayer().setFoodLevel(20);
		}
	}

	@EventHandler
	public void onInteract3(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((p.getItemInHand().getType() == Material.getMaterial(sfm.getData().getString("Flight.material")))
				&& (StaffMode.staffmode.contains(p))
				&& ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))) {

			if (StaffmodeManager.fly.contains(p)) {
				p.setAllowFlight(false);
				StaffmodeManager.fly.remove(p);
				p.sendMessage(Messages.flightDisabled());
			} else {
				if (!(StaffmodeManager.fly.contains(p))) {
					p.setAllowFlight(true);
					StaffmodeManager.fly.add(p);
					p.sendMessage(Messages.flightEnabled());
				}
			}

		} else {
			return;
		}
	}
}
