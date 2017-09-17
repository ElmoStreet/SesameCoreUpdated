package com.sesamepvp.kitpvp.upgrades.kits;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.sesamepvp.files.KitpvpFile;
import com.sesamepvp.tokens.TokenManager;
import com.sesamepvp.utilites.Messages;

public class TankUpgraded implements Listener {
	KitpvpFile manager = KitpvpFile.getInstance();

	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getTitle().equalsIgnoreCase("Kit Upgrades")) {
			if (e.getCurrentItem() == null) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE) {
				boolean TankKitUpgraded = this.manager.getData().getBoolean(
						p.getUniqueId() + ".Kits.Tank.Upgraded");
				if (TankKitUpgraded == true) {
					
					p.sendMessage(Messages.kitalreadyOwned());
				} else {
					if(TokenManager.canBuy(p, 250)){
						TokenManager.takeBalance(p, 250);
						p.playSound(p.getLocation(), Sound.ANVIL_USE, 2F, 1F);
						p.sendMessage(Messages.upgraded());
						this.manager.getData().set(
								p.getUniqueId() + ".Kits.Tank.Upgraded", true);
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
