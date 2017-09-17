package com.sesamepvp.essentials.msg;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.utilites.Messages;

public class Message implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (command.getName().equalsIgnoreCase("message")
				|| command.getName().equalsIgnoreCase("msg")
				|| command.getName().equalsIgnoreCase("m")) {
			if (sender instanceof Player) {
				final Player p = (Player) sender;
				if (sender instanceof Player) {
					if (args.length == 0) {
						p.sendMessage(Messages.messageUsage());
					}
					if (args.length >= 2) {
						Player target = Bukkit.getPlayer(args[0]);
						if (target == null) {
							p.sendMessage(Messages.playerNull());
							return true;
						}
						if (MessageManager.getRecepient(p) == target) {
							StringBuilder sb = new StringBuilder();
							for (int i = 1; i < args.length; i++) {
								sb.append(args[i]);
								if (i < args.length) {
									sb.append(" ");
								}
							}
							p.sendMessage(Messages.prefix("§a(To §r"
									+ target.getDisplayName() + " §a)§2 "
									+ sb.toString()));
							target.sendMessage(Messages.prefix("§a(From §r"
									+ p.getDisplayName() + " §a)§2 "
									+ sb.toString()));
						} else {
							MessageManager.newConvo(p, target);
							StringBuilder sb = new StringBuilder();
							for (int i = 1; i < args.length; i++) {
								sb.append(args[i]);
								if (i < args.length) {
									sb.append(" ");
								}
							}
							p.sendMessage(Messages.prefix("§a(To §r"
									+ target.getDisplayName() + " §a)§2 "
									+ sb.toString()));
							target.sendMessage(Messages.prefix("§a(From §r"
									+ p.getDisplayName() + " §a)§2 "
									+ sb.toString()));
						}
					}
				}
			}else {
				sender.sendMessage(Messages.notPlayer());
			}

		} 

		return true;
	}
}
