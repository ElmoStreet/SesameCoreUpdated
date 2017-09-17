package com.sesamepvp.punishments;

import java.net.InetAddress;
import java.net.InetSocketAddress;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.punishments.manager.BanManager;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class BanIP implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("ipban")) {
			if (args.length == 0) {
				sender.sendMessage(Messages.prefix(Methods.format("&cUsage: /ipban <player> <reason>")));
			} else {
				if (args.length == 1) {
					sender.sendMessage(Messages.prefix(Methods.format("&cUsage: /ipban <player> <reason>")));
				} else {
					Player t = Bukkit.getServer().getPlayer(args[0]);
					if (t == null) {
						sender.sendMessage(Messages.playerNull());
					} else {
						if (!(BanManager.isBanned(t) == true)) {
							
							StringBuilder sb = new StringBuilder();

							for (int i = 1; i < args.length; i++) {
								sb.append(args[i] + " ");
							}
							InetSocketAddress ip = t.getAddress();
							InetAddress adress = ip.getAddress();
							String s = adress.getHostAddress();
							s.replaceAll("/", "");
							BanManager.banipPlayer(t, sender, sb, s);
						} else {
							sender.sendMessage(Messages.prefix(Methods.format("&cThat player is already banned!")));
						}
					}

				}
			}
		}
		return true;
	}
}
