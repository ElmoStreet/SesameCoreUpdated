package com.sesamepvp.essentials.commands.teleport;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.utilites.Messages;

public class Teleport implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("teleport")
				|| cmd.getName().equalsIgnoreCase("tp")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (p.hasPermission("core.teleport")) {
					if (args.length == 0) {
						p.sendMessage(Messages.teleportUsage());
					} else {
						if (args.length == 1) {
							Player t = Bukkit.getServer().getPlayer(args[0]);
							if (t == null) {
								p.sendMessage(Messages.notPlayer());
								return false;
							} else {
								p.teleport(t);
								p.sendMessage(Messages.teleportedtoPlayer(t));
							}
						} else {
							p.sendMessage(Messages.teleportUsage());
						}
					}
				} else {
					p.sendMessage(Messages.noPermission());
				}
			} else {
				sender.sendMessage(Messages.notPlayer());
			}
		}
		return true;
	}

}
