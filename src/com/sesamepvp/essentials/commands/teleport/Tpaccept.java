package com.sesamepvp.essentials.commands.teleport;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class Tpaccept implements CommandExecutor {
	public boolean onCommand(org.bukkit.command.CommandSender sender,
			Command cmd, String commandLabel, String[] args) {
		String command = cmd.getName();

		if (command.equalsIgnoreCase("tpaccept")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (args.length == 0) {
					if (TPManager.getSender(p) != null) {
						Player target = TPManager.getSender(p);
						target.teleport(p.getLocation());
					} else {
						p.sendMessage(Messages.prefix(Methods.format("&cThat player is null, or you did not recieve a request!")));
					}
				}
			} else {
				sender.sendMessage(Messages.notPlayer());
			}
		}
		return false;
	}
}
