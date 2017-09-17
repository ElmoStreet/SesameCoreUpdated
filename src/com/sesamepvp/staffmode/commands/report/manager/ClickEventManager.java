package com.sesamepvp.staffmode.commands.report.manager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.sesamepvp.staffmode.commands.report.gui.ReportGUI;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class ClickEventManager implements Listener {
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getCurrentItem() == null) {
			return;
		} else {
			if (e.getInventory().getTitle().equalsIgnoreCase("Reports")) {
				e.setCancelled(true);
				if (e.getCurrentItem().getType() == Material.PAPER) {
					Player clickedreport = Bukkit.getServer()
							.getPlayer(e.getCurrentItem().getItemMeta().getDisplayName());
					if (clickedreport == null) {
						p.sendMessage(Methods.format("&cPlayer is null"));
						return;
					} else {
						ReportManager.removeReport(clickedreport, ReportGUI.reportGUI, ReportManager.slotnumberMAX - 1);
						p.sendMessage(Messages.prefix(Methods.format("&aCleared report!")));
					}
				} else {
					if (e.getCurrentItem().getType() == Material.WOOL && e.getCurrentItem().getItemMeta()
							.getDisplayName().equalsIgnoreCase(ChatColor.RED + "Close")) {
						p.closeInventory();
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 2F, 1F);

					} else

					if (e.getCurrentItem().getType() == Material.WOOL && e.getCurrentItem().getItemMeta()
							.getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Clear all reports.")) {
						ReportManager.clearAllReports();
						ReportManager.removeAllReports(ReportGUI.reportGUI);
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 2F, 1F);

					}
				}
			} else {
				return;
			}
		}
	}

}
