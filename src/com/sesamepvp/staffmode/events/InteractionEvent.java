package com.sesamepvp.staffmode.events;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.sesamepvp.files.StaffmodeFile;
import com.sesamepvp.staffmode.commands.StaffMode;
import com.sesamepvp.staffmode.commands.report.gui.ReportGUI;
import com.sesamepvp.staffmode.gui.Inspect;

public class InteractionEvent implements Listener {
	StaffmodeFile sfm = StaffmodeFile.getInstance();

	@EventHandler
	public void onInteractOnPlayer(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK
				|| e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_AIR) {
			if (p.getItemInHand().getType() == Material.getMaterial(sfm.getData().getString("Reports.material"))
					&& StaffMode.staffmode.contains(p)) {
				ReportGUI.gui(p);
			}
		}
	}

	@EventHandler
	public void onInteract(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();
		Entity t = e.getRightClicked();

		if (!(t instanceof Player)) {
			e.setCancelled(true);
			return;
		} else {

			if (p.getItemInHand().getType() == Material.getMaterial(sfm.getData().getString("Inspect.material"))
					&& StaffMode.staffmode.contains(p)) {
				Inspect.InpsectGUI(p, t);
			}
		}
	}
}
