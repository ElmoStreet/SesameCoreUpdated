package com.sesamepvp.kitpvp.kits.defaultkits;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import com.sesamepvp.files.KitpvpFile;
import com.sesamepvp.kitpvp.managers.KitListener;
import com.sesamepvp.staffmode.StaffmodeManager;
import com.sesamepvp.utilites.Messages;

public class Golden implements Listener {
	KitpvpFile manager = KitpvpFile.getInstance();

	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getTitle().equalsIgnoreCase("Kits")) {
			if (e.getCurrentItem() == null) {
				e.setCancelled(true);
				return;
			}

			if (e.getCurrentItem().getType() == Material.GOLDEN_APPLE) {
				if (KitListener.kitselected.contains(p)) {
					e.setCancelled(true);
					e.getWhoClicked().closeInventory();
					p.sendMessage(Messages.kitSelected());
					return;
				} else {
					if (manager.getData().getBoolean(
							p.getUniqueId() + ".Kits.Golden.Upgraded") == true) {
						p.getInventory().clear();
						KitListener.kitselected.add(p);
						p.closeInventory();
						Bukkit.getServer().dispatchCommand(
								Bukkit.getServer().getConsoleSender(),
								"kit GoldenUpgraded " + p.getName());
						p.getInventory().setLeggings(
								new ItemStack(Material.GOLD_LEGGINGS));
						p.getInventory().setHelmet(
								new ItemStack(Material.GOLD_HELMET));
						p.getInventory().setChestplate(
								new ItemStack(Material.IRON_CHESTPLATE));
						p.getInventory().setBoots(
								new ItemStack(Material.GOLD_LEGGINGS));
						p.closeInventory();
						StaffmodeManager.golden.add(p);
					} else {
						p.getInventory().clear();
						KitListener.kitselected.add(p);
						p.closeInventory();
						Bukkit.getServer().dispatchCommand(
								Bukkit.getServer().getConsoleSender(),
								"kit Golden " + p.getName());
						p.getInventory().setLeggings(
								new ItemStack(Material.GOLD_LEGGINGS));
						p.getInventory().setHelmet(
								new ItemStack(Material.GOLD_HELMET));
						p.getInventory().setChestplate(
								new ItemStack(Material.GOLD_CHESTPLATE));
						p.getInventory().setBoots(
								new ItemStack(Material.GOLD_LEGGINGS));
						p.closeInventory();
						StaffmodeManager.golden.add(p);
					}
				}
			}

		}
	}
}
