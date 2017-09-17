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

public class Default implements Listener {
	KitpvpFile manager = KitpvpFile.getInstance();

	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getTitle().equalsIgnoreCase("Kits")) {
			if (e.getCurrentItem() == null) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.LEATHER_CHESTPLATE) {
				if (KitListener.kitselected.contains(p)) {
					e.setCancelled(true);
					e.getWhoClicked().closeInventory();
					p.sendMessage(Messages.kitSelected());
					return;
				} else {
					if (manager.getData().getBoolean(
							p.getUniqueId() + ".Kits.Default.Upgraded") == true) {
						p.getInventory().clear();
						p.getActivePotionEffects().clear();
						KitListener.kitselected.add(p);
						Bukkit.getServer().dispatchCommand(
								Bukkit.getServer().getConsoleSender(),
								"kit PvpUpgraded " + p.getName());
						p.getInventory().setLeggings(
								new ItemStack(Material.IRON_LEGGINGS));
						p.getInventory().setHelmet(
								new ItemStack(Material.IRON_HELMET));
						p.getInventory().setChestplate(
								new ItemStack(Material.IRON_CHESTPLATE));
						p.getInventory().setBoots(
								new ItemStack(Material.IRON_BOOTS));
						p.closeInventory();
						StaffmodeManager.pvp.add(p);
					} else {
						p.getInventory().clear();
						p.getActivePotionEffects().clear();
						KitListener.kitselected.add(p);
						Bukkit.getServer().dispatchCommand(
								Bukkit.getServer().getConsoleSender(),
								"kit Pvp " + p.getName());
						p.getInventory().setLeggings(
								new ItemStack(Material.IRON_LEGGINGS));
						p.getInventory().setHelmet(
								new ItemStack(Material.IRON_HELMET));
						p.getInventory().setChestplate(
								new ItemStack(Material.IRON_CHESTPLATE));
						p.getInventory().setBoots(
								new ItemStack(Material.IRON_BOOTS));
						p.closeInventory();
						StaffmodeManager.pvp.add(p);
					}
				}
			}
		}
	}
}