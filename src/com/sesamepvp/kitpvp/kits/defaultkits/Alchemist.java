package com.sesamepvp.kitpvp.kits.defaultkits;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.sesamepvp.files.KitpvpFile;
import com.sesamepvp.kitpvp.managers.KitListener;
import com.sesamepvp.staffmode.StaffmodeManager;
import com.sesamepvp.utilites.Messages;

public class Alchemist implements Listener {

	KitpvpFile manager = KitpvpFile.getInstance();

	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getTitle().equalsIgnoreCase("Kits")) {
			if (e.getCurrentItem() == null) {
				e.setCancelled(true);
				return;
			}

			if (e.getCurrentItem().getType() == Material.GLASS_BOTTLE) {
				if (KitListener.kitselected.contains(p)) {
					e.setCancelled(true);
					e.getWhoClicked().closeInventory();
					p.sendMessage(Messages.kitSelected());
					return;
				} else {
					if (manager.getData().getBoolean(
							p.getUniqueId() + ".Kits.Alchemist.Upgraded") == true) {
						p.getInventory().clear();
						KitListener.kitselected.add(p);
						p.closeInventory();
						Bukkit.getServer().dispatchCommand(
								Bukkit.getServer().getConsoleSender(),
								"kit AlchemistUpgraded " + p.getName());

						p.addPotionEffect(new PotionEffect(
								PotionEffectType.INVISIBILITY, 40000, 2));
						p.closeInventory();
						StaffmodeManager.alchemist.add(p);
					} else {
						p.getInventory().clear();
						KitListener.kitselected.add(p);
						p.closeInventory();
						Bukkit.getServer().dispatchCommand(
								Bukkit.getServer().getConsoleSender(),
								"kit Alchemist " + p.getName());

						p.addPotionEffect(new PotionEffect(
								PotionEffectType.INVISIBILITY, 40000, 2));
						p.closeInventory();
						StaffmodeManager.alchemist.add(p);
					}
				}
			}
		}
	}
}
