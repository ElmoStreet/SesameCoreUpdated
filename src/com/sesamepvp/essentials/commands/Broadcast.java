package com.sesamepvp.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.main.SesameCore;
import com.sesamepvp.staffmode.StaffmodeManager;
import com.sesamepvp.utilites.Messages;

public class Broadcast implements CommandExecutor {
	static SesameCore plugin;

	public Broadcast(SesameCore instance) {
		plugin = instance;
	}

	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("broadcast") || cmd.getName().equalsIgnoreCase("bc")) {
			Player p = (Player) sender;
			if (sender instanceof Player) {
				if (args.length == 0) {
					p.sendMessage(Messages.broadcastUsage());
				} else {
					if (p.hasPermission("core.broadcast")) {
						StringBuilder message = new StringBuilder("");
						for (String part : args) {
							if (!message.toString().equals(""))
								message.append(" ");

							message.append(part);
						}
						Bukkit.getServer().broadcastMessage(Messages.prefix(StaffmodeManager.format(message.toString())));
					}
				}
			} else {
				p.sendMessage(Messages.noPermission());
			}
		} else {
			sender.sendMessage(Messages.notPlayer());
		}

		return true;
	}

}
