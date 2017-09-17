package com.sesamepvp.staffmode.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.sesamepvp.staffmode.commands.Freeze;

public class LoggedWhilstFrozen implements Listener {
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (Freeze.frozen.contains(p)) {
			for (Player online : Bukkit.getServer().getOnlinePlayers()) {
				if (online.hasPermission("sesame.freeze")) {
					online.sendMessage(ChatColor.DARK_RED + p.getName()
							+ ChatColor.YELLOW + " has logged whilst "
							+ ChatColor.RED + "" + ChatColor.BOLD + "FROZEN.");
				}
			}
		}
	}
}
