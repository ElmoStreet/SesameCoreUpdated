package com.sesamepvp.punishments;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.punishments.manager.MuteManager;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class Unmute implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("unmute")) {
			if (sender.hasPermission("core.unmute")) {
				if (args.length == 0) {
					sender.sendMessage(Messages.prefix(Methods.format("&cUsage: /unmute <player>")));
				} else {
					if (args.length == 1) {
						Player t = Bukkit.getServer().getPlayer(args[0]);
						if (t == null) {
							sender.sendMessage(Messages.playerNull());
						} else {
							if (MuteManager.isMuted(t) == true) {
								MuteManager.unmutePlayer(sender, t);
							} else {
								sender.sendMessage(Messages.prefix(Methods.format("&cThat player is not muted!")));
							}
						}
					}
				}
			}
		}
		return true;
	}
}
