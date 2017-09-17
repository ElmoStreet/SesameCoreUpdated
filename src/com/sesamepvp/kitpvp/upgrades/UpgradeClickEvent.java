package com.sesamepvp.kitpvp.upgrades;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.sesamepvp.kitpvp.gui.KitShopGUI;
import com.sesamepvp.kitpvp.gui.KitsGUI;

public class UpgradeClickEvent implements Listener {

	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getCurrentItem() == null) {
			e.setCancelled(true);
		}

		if (e.getInventory().getTitle().equalsIgnoreCase("Kits")) {
			if (e.getCurrentItem().getType() == Material.WOOL
					&& e.getCurrentItem().getItemMeta().getDisplayName()
							.equalsIgnoreCase(ChatColor.GREEN + "Upgrades")) {
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 2F, 1F);
				p.closeInventory();
				UpgradeManager.upgradeGUI(p);
			} else {
				if (e.getCurrentItem().getType() == Material.WOOL
						&& e.getCurrentItem().getItemMeta().getDisplayName()
								.equalsIgnoreCase(ChatColor.GREEN + "Kit Shop")) {
					p.closeInventory();
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2F, 1F);
					KitShopGUI.openKitshop(p);

				} else {
					if (e.getCurrentItem().getType() == Material.WOOL
							&& e.getCurrentItem().getItemMeta()
									.getDisplayName()
									.equalsIgnoreCase(ChatColor.RED + "Close")) {
						p.closeInventory();
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 2F, 1F);

					}

				}
			}
		} else {
			if (e.getInventory().getTitle().equalsIgnoreCase("Kit Upgrades")) {
				if (e.getCurrentItem().getType() == Material.WOOL
						&& e.getCurrentItem()
								.getItemMeta()
								.getDisplayName()
								.equalsIgnoreCase(
										ChatColor.GREEN + "To Kit Shop")) {
					p.closeInventory();
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2F, 1F);
					KitShopGUI.openKitshop(p);
				}
				if (e.getCurrentItem().getType() == Material.WOOL
						&& e.getCurrentItem().getItemMeta().getDisplayName()
								.equalsIgnoreCase(ChatColor.GREEN + "To Kits")) {
					p.closeInventory();
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2F, 1F);
					KitsGUI.gui(p);

				} else {
					if (e.getInventory().getTitle()
							.equalsIgnoreCase("Kit Upgrades")) {
						if (e.getCurrentItem().getType() == Material.WOOL
								&& e.getCurrentItem()
										.getItemMeta()
										.getDisplayName()
										.equalsIgnoreCase(
												ChatColor.RED + "Close")) {
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.NOTE_PLING, 2F,
									1F);

						}
					}

				}
			}
		}
	}
}
