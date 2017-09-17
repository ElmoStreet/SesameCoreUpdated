package com.sesamepvp.kitpvp.kits.defaultkits;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.sesamepvp.files.KitpvpFile;
import com.sesamepvp.kitpvp.managers.KitListener;
import com.sesamepvp.staffmode.StaffmodeManager;
import com.sesamepvp.utilites.Messages;

public class Fisherman implements Listener {

	KitpvpFile manager = KitpvpFile.getInstance();

	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getTitle().equalsIgnoreCase("Kits")) {
			if (e.getCurrentItem() == null) {
				e.setCancelled(true);
				return;
			}

			if (e.getCurrentItem().getType() == Material.FISHING_ROD) {
				if (KitListener.kitselected.contains(p)) {
					e.setCancelled(true);
					e.getWhoClicked().closeInventory();
					p.sendMessage(Messages.kitSelected());
					return;
				} else {
					if (manager.getData().getBoolean(
							p.getUniqueId() + ".Kits.Fisherman.Upgraded") == true) {
						p.getInventory().clear();
						KitListener.kitselected.add(p);
						p.closeInventory();
						Bukkit.getServer().dispatchCommand(
								Bukkit.getServer().getConsoleSender(),
								"kit FishermanUpgraded " + p.getName());
						p.getInventory().setLeggings(
								new ItemStack(Material.IRON_LEGGINGS));
						p.getInventory().setHelmet(
								new ItemStack(Material.IRON_HELMET));
						p.getInventory().setChestplate(
								new ItemStack(Material.IRON_CHESTPLATE));
						p.getInventory().setBoots(
								new ItemStack(Material.DIAMOND_BOOTS));

						ItemStack depthstrider = new ItemStack(Material.BOW, 1);
						ItemMeta depthstridermeta = depthstrider.getItemMeta();
						depthstridermeta.addEnchant(Enchantment.DEPTH_STRIDER,
								10, true);
						depthstrider.setItemMeta(depthstridermeta);

						p.addPotionEffect(new PotionEffect(
								PotionEffectType.SPEED, 40000, 0));
						p.addPotionEffect(new PotionEffect(
								PotionEffectType.FAST_DIGGING, 40000, 1));
						p.closeInventory();
						StaffmodeManager.fisherman.add(p);
					} else {
						p.getInventory().clear();
						KitListener.kitselected.add(p);
						p.closeInventory();
						Bukkit.getServer().dispatchCommand(
								Bukkit.getServer().getConsoleSender(),
								"kit Fisherman " + p.getName());
						p.getInventory().setLeggings(
								new ItemStack(Material.LEATHER_LEGGINGS));
						p.getInventory().setHelmet(
								new ItemStack(Material.IRON_HELMET));
						p.getInventory().setChestplate(
								new ItemStack(Material.IRON_CHESTPLATE));
						p.getInventory().setBoots(
								new ItemStack(Material.DIAMOND_BOOTS));

						ItemStack depthstrider = new ItemStack(Material.BOW, 1);
						ItemMeta depthstridermeta = depthstrider.getItemMeta();
						depthstridermeta.addEnchant(Enchantment.DEPTH_STRIDER,
								10, true);
						depthstrider.setItemMeta(depthstridermeta);

						p.addPotionEffect(new PotionEffect(
								PotionEffectType.SPEED, 40000, 0));
						p.closeInventory();
						StaffmodeManager.fisherman.add(p);
					}
				}
			}
		}
	}
}
