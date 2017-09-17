package com.sesamepvp.kitpvp.managers;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.sesamepvp.files.KitpvpFile;
import com.sesamepvp.kitpvp.gui.KitsGUI;
import com.sesamepvp.staffmode.StaffmodeManager;

public class StatsManager implements Listener {
	KitpvpFile manager = KitpvpFile.getInstance();
	private ArrayList<Player> chattester = new ArrayList<Player>();

	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getCurrentItem() == null) {
			e.setCancelled(true);
		}
		if (e.getInventory().getTitle().equalsIgnoreCase("Stats")) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.WOOL
					&& e.getCurrentItem().getItemMeta()
							.getDisplayName()
							.equalsIgnoreCase(ChatColor.RED + "Close")) {
				p.closeInventory();
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 2F, 1F);

			}else{
				if (e.getCurrentItem().getType() == Material.WOOL
						&& e.getCurrentItem().getItemMeta().getDisplayName()
								.equalsIgnoreCase(ChatColor.GREEN + "To Kits")) {
					p.closeInventory();
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2F, 1F);
					KitsGUI.gui(p);

				}
			}
		}
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String msg = e.getMessage();

		if (chattester.contains(p)) {
			StaffmodeManager.cmd("setpath int " + p.getName() + ".Kills"
					+ Integer.parseInt(msg));
			manager.saveData();
			manager.reloadData();
			p.sendMessage(ChatColor.GREEN + "Kills updated!");
			chattester.remove(p);
		} else {
			e.setCancelled(false);
			return;
		}
	}
}
