package com.sesamepvp.kitpvp.managers;

import java.util.ArrayList;

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
import com.sesamepvp.staffmode.StaffmodeManager;
import com.sesamepvp.utilites.Messages;

public class KitListener implements Listener {
	KitpvpFile manager = KitpvpFile.getInstance();

	public static ArrayList<Player> kitselected = new ArrayList<Player>();

	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e) {
		// Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Kit")) {
			if (e.getCurrentItem() == null) {
				return;
			}

			if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
				e.setCancelled(true);
			}
		}
	}

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
			if (event.getCurrentItem().getType() == Material.IRON_SWORD) {
				if (event.getWhoClicked().hasPermission("kits"
						+ ".warrior")) {
					if (kitselected.contains(event.getWhoClicked())) {
						event.setCancelled(true);
						event.getWhoClicked().closeInventory();
						event.getWhoClicked().sendMessage(
								Messages.kitSelected());

					} else {
						p.getInventory().clear();
						kitselected.add((Player) event.getWhoClicked());
						event.getWhoClicked().closeInventory();
						Bukkit.getServer().dispatchCommand(
								Bukkit.getServer().getConsoleSender(),
								"kit Warrior "
										+ event.getWhoClicked().getName());
						p.getInventory().setLeggings(
								new ItemStack(Material.IRON_LEGGINGS));
						p.getInventory().setHelmet(
								new ItemStack(Material.IRON_HELMET));
						p.getInventory().setChestplate(
								new ItemStack(Material.IRON_CHESTPLATE));
						p.getInventory().setBoots(
								new ItemStack(Material.IRON_BOOTS));
						StaffmodeManager.warrior.add(p);
					}
				} else {
					event.getWhoClicked().sendMessage(Messages.noPermission());
				}
			}

			// GLADIATOR
			if (event.getCurrentItem().getType() == Material.GOLD_SWORD) {

				if (event.getWhoClicked().hasPermission("kits.gladiator")) {
					if (kitselected.contains(event.getWhoClicked())) {
						event.setCancelled(true);
						event.getWhoClicked().closeInventory();
						event.getWhoClicked().sendMessage(
								Messages.kitSelected());

					} else {
						p.getInventory().clear();
						kitselected.add((Player) event.getWhoClicked());
						event.getWhoClicked().closeInventory();
						Bukkit.getServer().dispatchCommand(
								Bukkit.getServer().getConsoleSender(),
								"kit Gladiator "
										+ event.getWhoClicked().getName());
						p.getInventory().setLeggings(
								new ItemStack(Material.IRON_LEGGINGS));
						p.getInventory().setHelmet(
								new ItemStack(Material.IRON_HELMET));
						p.getInventory().setChestplate(
								new ItemStack(Material.DIAMOND_CHESTPLATE));
						p.getInventory().setBoots(
								new ItemStack(Material.IRON_BOOTS));
						StaffmodeManager.gladiator.add(p);
					}
				} else {
					event.getWhoClicked().sendMessage(Messages.noPermission());
				}
			}

			// guardian

			if (event.getCurrentItem().getType() == Material.DIAMOND_SWORD) {

				if (event.getWhoClicked().hasPermission("kits.Guardian")) {
					if (kitselected.contains(event.getWhoClicked())) {
						event.setCancelled(true);
						event.getWhoClicked().closeInventory();
						event.getWhoClicked().sendMessage(
								Messages.kitSelected());

					} else {
						p.getInventory().clear();
						kitselected.add((Player) event.getWhoClicked());
						event.getWhoClicked().closeInventory();
						Bukkit.getServer().dispatchCommand(
								Bukkit.getServer().getConsoleSender(),
								"kit Guardian "
										+ event.getWhoClicked().getName());
						p.getInventory().setLeggings(
								new ItemStack(Material.DIAMOND_LEGGINGS));
						p.getInventory().setHelmet(
								new ItemStack(Material.IRON_HELMET));
						p.getInventory().setChestplate(
								new ItemStack(Material.DIAMOND_CHESTPLATE));
						p.getInventory().setBoots(
								new ItemStack(Material.IRON_BOOTS));
						// s1 kb1sword
						StaffmodeManager.guardian.add(p);
					}
				} else {
					event.getWhoClicked().sendMessage(Messages.noPermission());
				}
			}

			// berserk
			if (event.getCurrentItem().getType() == Material.REDSTONE) {

				if (event.getWhoClicked().hasPermission("kits.Berserk")) {
					if (kitselected.contains(event.getWhoClicked())) {
						event.setCancelled(true);
						event.getWhoClicked().closeInventory();
						event.getWhoClicked().sendMessage(
								Messages.kitSelected());

					} else {
						p.getInventory().clear();
						kitselected.add((Player) event.getWhoClicked());
						event.getWhoClicked().closeInventory();
						Bukkit.getServer().dispatchCommand(
								Bukkit.getServer().getConsoleSender(),
								"kit Berserk "
										+ event.getWhoClicked().getName());
						p.getInventory().setLeggings(
								new ItemStack(Material.IRON_LEGGINGS));
						p.getInventory().setHelmet(
								new ItemStack(Material.IRON_HELMET));
						p.getInventory().setChestplate(
								new ItemStack(Material.DIAMOND_CHESTPLATE));
						p.getInventory().setBoots(
								new ItemStack(Material.DIAMOND_BOOTS));
						StaffmodeManager.berserk.add(p);
					}
				} else {
					event.getWhoClicked().sendMessage(Messages.noPermission());
				}
			}

			// legend
			if (event.getCurrentItem().getType() == Material.IRON_INGOT) {

				if (event.getWhoClicked().hasPermission("kits.Legend")) {
					if (kitselected.contains(event.getWhoClicked())) {
						event.setCancelled(true);
						event.getWhoClicked().closeInventory();
						event.getWhoClicked().sendMessage(
								Messages.kitSelected());

					} else {
						p.getInventory().clear();
						kitselected.add((Player) event.getWhoClicked());
						event.getWhoClicked().closeInventory();
						Bukkit.getServer()
								.dispatchCommand(
										Bukkit.getServer().getConsoleSender(),
										"kit Legend "
												+ event.getWhoClicked()
														.getName());
						p.getInventory().setLeggings(
								new ItemStack(Material.DIAMOND_LEGGINGS));
						p.getInventory().setHelmet(
								new ItemStack(Material.DIAMOND_HELMET));
						p.getInventory().setChestplate(
								new ItemStack(Material.DIAMOND_CHESTPLATE));
						p.getInventory().setBoots(
								new ItemStack(Material.DIAMOND_BOOTS));
						// S2
						StaffmodeManager.legend.add(p);
					}
				} else {
					event.getWhoClicked().sendMessage(Messages.noPermission());
				}
			}

			// demigod
			if (event.getCurrentItem().getType() == Material.GOLD_INGOT) {

				if (event.getWhoClicked().hasPermission("kits.demigod")) {
					if (kitselected.contains(event.getWhoClicked())) {
						event.setCancelled(true);
						event.getWhoClicked().closeInventory();
						event.getWhoClicked().sendMessage(
								Messages.kitSelected());

					} else {
						p.getInventory().clear();
						kitselected.add((Player) event.getWhoClicked());
						event.getWhoClicked().closeInventory();
						Bukkit.getServer().dispatchCommand(
								Bukkit.getServer().getConsoleSender(),
								"kit Demigod "
										+ event.getWhoClicked().getName());
						p.getInventory().setLeggings(
								new ItemStack(Material.DIAMOND_LEGGINGS));
						p.getInventory().setHelmet(
								new ItemStack(Material.DIAMOND_HELMET));
						p.getInventory().setChestplate(
								new ItemStack(Material.DIAMOND_CHESTPLATE));
						p.getInventory().setBoots(
								new ItemStack(Material.DIAMOND_BOOTS));
						p.addPotionEffect(new PotionEffect(
								PotionEffectType.SPEED, 40000, 1));
						StaffmodeManager.demigod.add(p);

					}
				} else {
					event.getWhoClicked().sendMessage(Messages.noPermission());
				}
			}

			// god
			if (event.getCurrentItem().getType() == Material.DIAMOND) {

				if (event.getWhoClicked().hasPermission("kits.god")) {
					if (kitselected.contains(event.getWhoClicked())) {
						event.setCancelled(true);
						event.getWhoClicked().closeInventory();
						event.getWhoClicked().sendMessage(
								Messages.kitSelected());

					} else {
						p.getInventory().clear();
						kitselected.add((Player) event.getWhoClicked());
						event.getWhoClicked().closeInventory();
						Bukkit.getServer().dispatchCommand(
								Bukkit.getServer().getConsoleSender(),
								"kit God " + event.getWhoClicked().getName());
						p.getInventory().setLeggings(
								new ItemStack(Material.DIAMOND_LEGGINGS));
						p.getInventory().setHelmet(
								new ItemStack(Material.DIAMOND_HELMET));
						p.getInventory().setChestplate(
								new ItemStack(Material.DIAMOND_CHESTPLATE));
						p.getInventory().setBoots(
								new ItemStack(Material.DIAMOND_BOOTS));
						p.addPotionEffect(new PotionEffect(
								PotionEffectType.SPEED, 40000, 2));
						// s3
						StaffmodeManager.god.add(p);
					}
				} else {
					event.getWhoClicked().sendMessage(Messages.noPermission());
				}
			}
		}

		if (event.getInventory().getTitle().equals("Kit")) {
			event.setCancelled(true);
			if (event.getCurrentItem().getType() == Material.STAINED_GLASS) {
				event.setCancelled(true);
			}
		}
	}

}
