package com.sesamepvp.kitpvp.managers;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.sesamepvp.files.KitpvpFile;
import com.sesamepvp.kitpvp.gui.KitsGUI;
import com.sesamepvp.kitpvp.upgrades.UpgradeManager;
import com.sesamepvp.tokens.TokenManager;
import com.sesamepvp.utilites.Messages;

public class KitShopManager implements Listener {

	KitpvpFile manager = KitpvpFile.getInstance();

	@EventHandler
	public void InventoryClickEvent(InventoryClickEvent event) {

		Player p = (Player) event.getWhoClicked();

		if (event.getInventory().getTitle().equalsIgnoreCase("Kit Upgrades")) {
			if (event.getCurrentItem() == null) {
				event.setCancelled(true);
				return;
			}
		}

		if (event.getInventory().getTitle().equalsIgnoreCase("KitShop")) {
			if (event.getCurrentItem().getType() == Material.WOOL
					&& event.getCurrentItem().getItemMeta().getDisplayName()
							.equalsIgnoreCase(ChatColor.GREEN + "To Upgrades")) {
				p.closeInventory();
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 2F, 1F);
				UpgradeManager.upgradeGUI(p);
			}

			if (event.getCurrentItem().getType() == Material.WOOL
					&& event.getCurrentItem().getItemMeta().getDisplayName()
							.equalsIgnoreCase(ChatColor.GREEN + "To Kits")) {
				p.closeInventory();
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 2F, 1F);
				KitsGUI.gui(p);

			}

			if (event.getCurrentItem().getType() == Material.WOOL
					&& event.getCurrentItem().getItemMeta().getDisplayName()
							.equalsIgnoreCase(ChatColor.RED + "Close")) {
				p.closeInventory();
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 2F, 1F);

			}

		}

		if (event.getInventory().getTitle().equals("KitShop")) {
			if (event.getCurrentItem() == null) {
				event.setCancelled(true);
				return;
			}
			event.setCancelled(true);
			if (event.getCurrentItem().getType() == Material.FEATHER) {
				boolean KitSpeedyOwned = this.manager.getData().getBoolean(
						p.getUniqueId() + ".Kits.Speedy");
				if (KitSpeedyOwned == true) {
					p.sendMessage(Messages.kitalreadyOwned());
				} else {
					if(TokenManager.canBuy(p, 500)){
						TokenManager.takeBalance(p, 500);
						p.sendMessage(Messages.purchasedSpeedyKit());
						this.manager.getData().set(
								p.getUniqueId() + ".Kits.Speedy", true);
						this.manager.saveData();
					} else {
						p.sendMessage(Messages.insufficientFunds());
						return;
					}
				}
			}

			if (event.getCurrentItem().getType() == Material.ARROW) {
				boolean KitGodArcherOwned = this.manager.getData().getBoolean(
						p.getUniqueId()+ ".Kits.GodArcher");
				if (KitGodArcherOwned == true) {
					p.sendMessage(Messages.kitalreadyOwned());
				} else {
					if(TokenManager.canBuy(p,600)){
						TokenManager.takeBalance(p, 600);
						p.sendMessage(Messages.purchasedGodArcherKit());
						this.manager.getData().set(
								p.getUniqueId() + ".Kits.GodArcher", true);
						this.manager.saveData();
						p.playSound(p.getLocation(), Sound.ANVIL_USE, 2F, 1F);
					} else {
						p.sendMessage(Messages.insufficientFunds());
						return;
					}
				}
			}

			if (event.getCurrentItem().getType() == Material.FLINT_AND_STEEL) {
				boolean KitBurnerOwned = this.manager.getData().getBoolean(
						p.getUniqueId() + ".Kits.Burner");
				if (KitBurnerOwned == true) {
					p.sendMessage(Messages.kitalreadyOwned());
				} else {
					if(TokenManager.canBuy(p, 1000)){
						TokenManager.takeBalance(p, 1000);
						p.sendMessage(Messages.purchasedBurnerKit());
						this.manager.getData().set(
								p.getUniqueId() + ".Kits.Burner", true);
						this.manager.saveData();
						p.playSound(p.getLocation(), Sound.ANVIL_USE, 2F, 1F);
					} else {
						p.sendMessage(Messages.insufficientFunds());
						return;
					}
				}
			}
			if (event.getCurrentItem().getType() == Material.CHAINMAIL_BOOTS) {
				boolean KitAssasinOwned = this.manager.getData().getBoolean(
						p.getUniqueId() + ".Kits.Assasin");
				if (KitAssasinOwned == true) {

					p.sendMessage(Messages.kitalreadyOwned());
				} else {
					if(TokenManager.canBuy(p, 800)){
						TokenManager.takeBalance(p, 800);
						p.sendMessage(Messages.purchasedAssassinKit());
						this.manager.getData().set(
								p.getUniqueId() + ".Kits.Assasin", true);
						this.manager.saveData();
					} else {
						p.sendMessage(Messages.insufficientFunds());
						return;
					}
				}
			}

			if (event.getCurrentItem().getType() == Material.LAVA_BUCKET) {
				boolean InsaneKitOwned = this.manager.getData().getBoolean(
						p.getUniqueId() + ".Kits.Insane");
				if (InsaneKitOwned == true) {

					p.sendMessage(Messages.kitalreadyOwned());
				} else {
					if(TokenManager.canBuy(p, 1500)){
						TokenManager.takeBalance(p, 1500);
						p.sendMessage(Messages.purchasedInsaneKit());
						this.manager.getData().set(
								p.getUniqueId() + ".Kits.Insane", true);
						this.manager.saveData();
					} else {
						p.sendMessage(Messages.insufficientFunds());
						return;
					}
				}
			}

		}

	}
}
