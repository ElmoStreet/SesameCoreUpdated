package com.sesamepvp.punishments;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class Kick implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("kick")) {
			if (args.length == 0) {
				sender.sendMessage(Messages.prefix(Methods.format("&cUsage: /kick <player> <reason>")));
			} else {
				if (args.length == 1) {
					sender.sendMessage(Messages.prefix(Methods.format("&cUsage: /kick <player> <reason>")));
				} else {
					Player t = Bukkit.getServer().getPlayer(args[0]);
					if (t == null) {
						sender.sendMessage(Messages.playerNull());
					} else {

						StringBuilder sb = new StringBuilder();

						for (int i = 1; i < args.length; i++) {
							sb.append(args[i] + " ");
						}

						t.kickPlayer(Messages.prefix(Methods.format("&cYou have been kicked!\n&4By: &c" + sender.getName() + "\n&4Reason: &c" + sb.toString())));
					}

				}
			}
		}
		return true;
	}
}
