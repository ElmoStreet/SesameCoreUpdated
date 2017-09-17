package com.sesamepvp.kitpvp.signs;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.sesamepvp.kitpvp.gui.KitShopGUI;
import com.sesamepvp.kitpvp.gui.KitsGUI;
import com.sesamepvp.kitpvp.gui.StatsGUI;
import com.sesamepvp.kitpvp.quests.GUI.QuestGUI;
import com.sesamepvp.kitpvp.upgrades.UpgradeManager;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class SignsManager implements Listener {
	@EventHandler
	public void onSignChange(SignChangeEvent e){
		if(e.getLine(0).equalsIgnoreCase("[KitPvP]") && e.getLine(1).equalsIgnoreCase("Kits")){
			e.setLine(0, Methods.format("&c&lKit&f&lPvP &8>>"));
			e.setLine(1, Methods.format("&8&m---------------"));
			e.setLine(2, Methods.format("&cKit Selector"));
			e.setLine(3, Methods.format("&8&m---------------"));
		}
		
		if(e.getLine(0).equalsIgnoreCase("[KitPvP]") && e.getLine(1).equalsIgnoreCase("Soup")){
			e.setLine(0, Methods.format("&c&lKit&f&lPvP &8>>"));
			e.setLine(1, Methods.format("&8&m---------------"));
			e.setLine(2, Methods.format("&cSoup"));
			e.setLine(3, Methods.format("&8&m---------------"));
		}
		
		if(e.getLine(0).equalsIgnoreCase("[KitPvP]") && e.getLine(1).equalsIgnoreCase("Quests")){
			e.setLine(0, Methods.format("&c&lKit&f&lPvP &8>>"));
			e.setLine(1, Methods.format("&8&m---------------"));
			e.setLine(2, Methods.format("&cQuests"));
			e.setLine(3, Methods.format("&8&m---------------"));
		}
		
		if(e.getLine(0).equalsIgnoreCase("[KitPvP]") && e.getLine(1).equalsIgnoreCase("KitShop")){
			e.setLine(0, Methods.format("&c&lKit&f&lPvP &8>>"));
			e.setLine(1, Methods.format("&8&m---------------"));
			e.setLine(2, Methods.format("&cKit Shop"));
			e.setLine(3, Methods.format("&8&m---------------"));
		}
		
		if(e.getLine(0).equalsIgnoreCase("[KitPvP]") && e.getLine(1).equalsIgnoreCase("Stats")){
			e.setLine(0, Methods.format("&c&lKit&f&lPvP &8>>"));
			e.setLine(1, Methods.format("&8&m---------------"));
			e.setLine(2, Methods.format("&cStats"));
			e.setLine(3, Methods.format("&8&m---------------"));
		}
		
		if(e.getLine(0).equalsIgnoreCase("[KitPvP]") && e.getLine(1).equalsIgnoreCase("Upgrades")){
			e.setLine(0, Methods.format("&c&lKit&f&lPvP &8>>"));
			e.setLine(1, Methods.format("&8&m---------------"));
			e.setLine(2, Methods.format("&cUpgrades"));
			e.setLine(3, Methods.format("&8&m---------------"));
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if (event.getClickedBlock().getTypeId() == 63 || event.getClickedBlock().getTypeId() == 68) {

				Sign sign = (Sign) event.getClickedBlock().getState();

				String[] ln = sign.getLines();
				if (ln[0].toLowerCase().equalsIgnoreCase(Methods.format("&c&lKit&f&lPvP &8>>"))
						&& ln[2].toLowerCase().equalsIgnoreCase(Methods.format("&cKit Selector"))) {
					event.getPlayer().sendMessage(Messages.prefix(Methods.format("&aOpening Kit Selector!")));
					KitsGUI.gui(event.getPlayer());
				} else {
					if (ln[0].toLowerCase().equalsIgnoreCase(Methods.format("&c&lKit&f&lPvP &8>>"))
							&& ln[2].toLowerCase().equalsIgnoreCase(Methods.format("&cSoup"))) {
						Inventory inv = Bukkit.createInventory(null, 36, "Soup");
						int soupCounter = 0;
						while(soupCounter < inv.getSize()){
							inv.setItem(soupCounter, new ItemStack(Material.MUSHROOM_SOUP));
							soupCounter++;
						}
						event.getPlayer().openInventory(inv);
					}
					if (ln[0].toLowerCase().equalsIgnoreCase(Methods.format("&c&lKit&f&lPvP &8>>"))
							&& ln[2].toLowerCase().equalsIgnoreCase(Methods.format("&cQuests"))) {
						QuestGUI.openQuestGUI(event.getPlayer());
					}
					if (ln[0].toLowerCase().equalsIgnoreCase(Methods.format("&c&lKit&f&lPvP &8>>"))
							&& ln[2].toLowerCase().equalsIgnoreCase(Methods.format("&cStats"))) {
						StatsGUI.playerStats(event.getPlayer());
					}
					
					if (ln[0].toLowerCase().equalsIgnoreCase(Methods.format("&c&lKit&f&lPvP &8>>"))
							&& ln[2].toLowerCase().equalsIgnoreCase(Methods.format("&cKit Shop"))) {
						KitShopGUI.openKitshop(event.getPlayer());
					}
					
					if (ln[0].toLowerCase().equalsIgnoreCase(Methods.format("&c&lKit&f&lPvP &8>>"))
							&& ln[2].toLowerCase().equalsIgnoreCase(Methods.format("&cUpgrades"))) {
						UpgradeManager.upgradeGUI(event.getPlayer());
					}
				}
			}
		}
	}
}
