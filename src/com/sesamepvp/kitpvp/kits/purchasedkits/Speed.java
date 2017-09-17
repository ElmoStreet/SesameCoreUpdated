package com.sesamepvp.kitpvp.kits.purchasedkits;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
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

public class Speed implements Listener {

	KitpvpFile manager = KitpvpFile.getInstance();
	@EventHandler
	public void InventoryClickEvent(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();

		if (event.getInventory().getTitle().equals("Kits")) {

			if (event.getCurrentItem() == null) {
				return;
			}

			ItemStack pane = new ItemStack(Material.STAINED_GLASS_PANE, 1,
					(short) 7);
			if (event.getCurrentItem() == pane) {
				event.setCancelled(true);
			}

			if (event.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
				event.setCancelled(true);
			}

			if (event.getCurrentItem().getType() == Material.REDSTONE_BLOCK) {
				Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(),
						"kits2 " + p.getName());

			}

			if (event.getCurrentItem().getType() == Material.FEATHER) {

				if (KitListener.kitselected.contains(p)) {
					event.setCancelled(true);
					event.getWhoClicked().closeInventory();
					p.sendMessage(Messages.kitSelected());
					return;

				} else {
					boolean KitSpeedyOwned = this.manager.getData().getBoolean(
							p.getUniqueId() + ".Kits.Speedy");
					if (KitSpeedyOwned == true) {
						p.getInventory().clear();
						p.getActivePotionEffects().clear();
						KitListener.kitselected.add(p);
						event.getWhoClicked().closeInventory();
						Bukkit.getServer()
								.dispatchCommand(
										Bukkit.getServer().getConsoleSender(),
										"kit Speedy "
												+ event.getWhoClicked()
														.getName());

						ItemStack legs = new ItemStack(Material.IRON_LEGGINGS);
						legs.addEnchantment(Enchantment.DURABILITY, 10);
						ItemStack chestplate = new ItemStack(
								Material.IRON_CHESTPLATE);
						legs.addEnchantment(Enchantment.DURABILITY, 10);
						ItemStack helmet = new ItemStack(Material.IRON_HELMET);
						legs.addEnchantment(Enchantment.DURABILITY, 10);
						ItemStack boots = new ItemStack(Material.IRON_BOOTS);
						legs.addEnchantment(Enchantment.DURABILITY, 10);

						p.getInventory().setLeggings(legs);
						p.getInventory().setHelmet(helmet);
						p.getInventory().setChestplate(chestplate);
						p.getInventory().setBoots(boots);
						p.getActivePotionEffects().clear();
						p.addPotionEffect(new PotionEffect(
								PotionEffectType.SPEED, 40000, 1));
						StaffmodeManager.speedy.add(p);
					} else {
						if (KitSpeedyOwned == false) {
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
