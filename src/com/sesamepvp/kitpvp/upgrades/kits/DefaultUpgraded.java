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

public class DefaultUpgraded implements Listener {
	KitpvpFile manager = KitpvpFile.getInstance();

	
	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getTitle().equalsIgnoreCase("Kit Upgrades")) {
			if (e.getCurrentItem() == null) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.LEATHER_CHESTPLATE) {
				boolean DefaultKitUpgraded = this.manager.getData().getBoolean(
						p.getUniqueId()+ ".Kits.Default.Upgraded");
				if (DefaultKitUpgraded == true) {

					p.sendMessage(Messages.kitalreadyOwned());
				} else {
					if(TokenManager.canBuy(p, 250)){
						TokenManager.takeBalance(p, 250);
						p.sendMessage(Messages.upgraded());
						this.manager.getData().set(
								p.getUniqueId() + ".Kits.Default.Upgraded", true);
						this.manager.saveData();
						p.playSound(p.getLocation(), Sound.ANVIL_USE, 2F, 1F);
					} else {
						p.sendMessage(Messages.insufficientFunds());
						return;
					}
				}
			}
		}
	}
}