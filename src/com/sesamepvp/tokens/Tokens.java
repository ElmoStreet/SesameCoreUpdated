package com.sesamepvp.tokens;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.main.SesameCore;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class Tokens implements CommandExecutor {
	SesameCore instance;

	public Tokens(SesameCore instance) {
		this.instance = instance;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("tokens")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (args.length == 0) {
					TokenManager.sendBalance(p, p);
				} else {
					if (args.length == 1) {
						Player target = Bukkit.getServer().getPlayer(args[0]);
						if (target == null) {
							p.sendMessage(Messages.playerNull());
						} else {
							TokenManager.getBalance(p);
							p.sendMessage(ChatColor.RED+"REAL BAL : " + TokenManager.getBalance(p));
							TokenManager.sendBalance(p, target);
						}
					} else {
						if (args.length == 3) {
							if (args[0].equalsIgnoreCase("give")) {
								Player target = Bukkit.getServer().getPlayer(
										args[1]);
								if (target == null) {
									p.sendMessage(Messages.playerNull());
								} else {
									if (Token.isInt(args[2])) {
										TokenManager.pay(p, target,
												Integer.parseInt(args[2]));
									} else {
										p.sendMessage(Messages.prefix(Methods
												.format("&cYou must enter a number!")));
									}
								}
							}
						}
					}
				}
			} else {
				sender.sendMessage(Messages.notPlayer());
			}
		}
		return true;
	}
	// tokens (shows your tokens)
	// tokens <player>
	// tokens <give> <player> <amount>
	// token shop

}
