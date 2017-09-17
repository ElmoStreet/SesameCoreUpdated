package com.sesamepvp.punishments;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.files.PunishmentsFile;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class Warn implements CommandExecutor {
	PunishmentsFile pf = PunishmentsFile.getInstance();

	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("warn")) {
			if (sender.hasPermission("core.warn")) {
				if (args.length == 0) {
					sender.sendMessage(Messages.prefix(Methods.format("&cUsage: /warn <player> <reason>")));
				} else {
					if (args.length == 1) {
						sender.sendMessage(Messages.prefix(Methods.format("&cUsage: /warn <player> <reason>")));
					} else {
						Player t = Bukkit.getServer().getPlayer(args[0]);
						if (t == null) {
							sender.sendMessage(Messages.playerNull());
						} else {
							StringBuilder x = new StringBuilder();

							for (int i = 1; i < args.length; i++) {
								x.append(args[i] + " ");
							}
							List<String> warns = new ArrayList<String>();
							warns.add(x.toString());
							List<String> warners = new ArrayList<String>();
							warners.add(sender.getName());
							pf.getData().set("Warns." + t.getUniqueId() + ".list", warns);
							pf.getData().set("Warns." + t.getUniqueId() + ".warners", warners);
							pf.saveData();
							t.sendMessage(Messages.prefix(Methods.format("&aYou have warned " + t.getName())));
							t.sendMessage(Messages.prefix(Methods.format("&aYou have been warned by &2" + sender.getName() + " &afor &2" + x.toString())));
						}

					}
				}
			}
		}
		return true;
	}
}
