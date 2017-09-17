package com.sesamepvp.kitpvp.kits.purchasedkits;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.sesamepvp.files.KitpvpFile;
import com.sesamepvp.kitpvp.managers.KitListener;
import com.sesamepvp.staffmode.StaffmodeManager;
import com.sesamepvp.utilites.Messages;

public class Assassin implements Listener {

	KitpvpFile manager = KitpvpFile.getInstance();

	@EventHandler
	public void InventoryClickEvent(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();

		if (event.getInventory().getTitle().equals("Kits")) {

			if (event.getCurrentItem() == null) {
				return;
			}
			if (event.getCurrentItem().getType() == Material.CHAINMAIL_BOOTS) {

				if (KitListener.kitselected.contains(p)) {
					event.setCancelled(true);
					event.getWhoClicked().closeInventory();
					p.sendMessage(Messages.kitSelected());
					return;

				} else {
					boolean KitAssassinOwned = this.manager.getData()
							.getBoolean(p.getUniqueId() + ".Kits.Assasin");
					if (KitAssassinOwned == true) {
						p.getActivePotionEffects().clear();
						p.getInventory().clear();
						KitListener.kitselected.add(p);
						event.getWhoClicked().closeInventory();
						Bukkit.getServer().dispatchCommand(
								Bukkit.getServer().getConsoleSender(),
								"kit Assasin "
										+ event.getWhoClicked().getName());
						p.getInventory().setLeggings(
								new ItemStack(Material.AIR));
						p.getInventory().setHelmet(new ItemStack(Material.AIR));
						p.getInventory().setChestplate(
								new ItemStack(Material.AIR));
						p.getInventory().setBoots(
								new ItemStack(Material.IRON_BOOTS));
						p.addPotionEffect(new PotionEffect(
								PotionEffectType.SPEED, 40000, 3));
						p.addPotionEffect(new PotionEffect(
								PotionEffectType.INCREASE_DAMAGE, 40000, 0));
						StaffmodeManager.assassin.add(p);
					} else {
						if (KitAssassinOwned == false) {
							event.setCancelled(true);
							p.sendMessage(Messages.kitnotOwned());
							return;

						}
					}
				}
			}

		}
	}

}
