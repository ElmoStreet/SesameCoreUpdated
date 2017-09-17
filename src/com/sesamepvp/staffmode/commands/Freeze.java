package com.sesamepvp.staffmode.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.utilites.Messages;

public class Freeze implements CommandExecutor {

	public static ArrayList<Player> frozen = new ArrayList<Player>();

	
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if ((cmd.getName().equalsIgnoreCase("freeze"))) {
			Player p = (Player) sender;
			if (sender.hasPermission("core.freeze")) {
				if ((args.length == 0) || (args.length > 1)) {
					p.sendMessage(Messages.freezeArgs());
				} else if (Bukkit.getPlayer(args[0]) == null) {
					p.sendMessage(Messages.playerNull());
				} else {
					Player target = Bukkit.getPlayer(args[0]);
					if (frozen.contains(target)) {
						frozen.remove(target);
						p.sendMessage(Messages.unfrozePlayer(Bukkit
								.getPlayer(args[0])));
						target.sendMessage(Messages.unFrozen(p));
					} else {
						frozen.add(target);
						p.sendMessage(Messages.frozePlayer(target));
						target.sendMessage(" ");
						target.sendMessage(ChatColor.RED
								+ " Would you like to admit? ");
						target.sendMessage("");
						target.sendMessage(ChatColor.GREEN + " YES "
								+ ChatColor.RED + " NO ");
						target.sendMessage("");
						target.sendMessage(ChatColor.YELLOW
								+ "Please say in chat.");
					}
				}
			} else {
				sender.sendMessage(Messages.notPlayer());
			}
		}
		return true;
	}

}
