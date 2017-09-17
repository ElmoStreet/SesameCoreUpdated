package com.sesamepvp.staffmode.gui.miner;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import com.sesamepvp.staffmode.commands.StaffMode;
import com.sesamepvp.staffmode.gui.Miner;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class EventManager implements Listener {

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		if (MinerManager.yUnderRequirements(e.getPlayer()) == true) {

		}
	}
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		Player interacter = e.getPlayer();
		if(StaffMode.staffmode.contains(interacter)){
			if(e.getItem().getType() == Material.IRON_PICKAXE){
				Miner.gui(interacter);
			}
		}
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getCurrentItem() == null) {
			return;
		} else {
			if (e.getInventory().getTitle().equalsIgnoreCase("Miners")) {
				e.setCancelled(true);
				if (e.getCurrentItem().getType() == Material.IRON_PICKAXE) {
					Player clickedplayer = Bukkit.getServer().getPlayer(
							e.getCurrentItem().getItemMeta().getDisplayName());
					if (clickedplayer == null) {
						p.sendMessage(Methods.format("&cPlayer is null"));
						return;
					} else {
						p.teleport(clickedplayer);
						p.closeInventory();
						p.sendMessage(Messages.prefix(Methods.format("&aTeleported to miner " + clickedplayer.getName())));
					}
				} else {
					if (e.getCurrentItem().getType() == Material.WOOL
							&& e.getCurrentItem().getItemMeta()
									.getDisplayName()
									.equalsIgnoreCase(ChatColor.RED + "Close")) {
						p.closeInventory();
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 2F, 1F);

					}
				}
			} else {
				return;
			}
		}
	}

}
