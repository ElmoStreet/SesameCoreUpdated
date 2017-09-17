package com.sesamepvp.adminfun;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.main.SesameCore;
import com.sesamepvp.tokens.Token;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class AdminFun implements CommandExecutor {
	SesameCore instance;

	public AdminFun(SesameCore instance) {
		this.instance = instance;
	}

	private void sendArgs(Player p) {
		p.sendMessage(Methods.format("&8&m&l-----------------------"));
		p.sendMessage(Methods.format("&c /adminfun fakejoin <String>"));
		p.sendMessage(Methods.format("&c /adminfun fakeleave <String>"));
		p.sendMessage(Methods.format("&c /adminfun fakeop <Player>"));
		p.sendMessage(Methods.format("&c /adminfun fakeban <Player>"));
		p.sendMessage(Methods.format("&8&m&l-----------------------"));
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("adminfun")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (args.length == 0) {
					sendArgs(p);
				} else {
					if (args.length == 1) {
						sendArgs(p);
					} else {
						if (args.length == 2) {
							if (args[0].equalsIgnoreCase("fakejoin")
									|| args[0].equalsIgnoreCase("fakeleave")
									|| args[0].equalsIgnoreCase("fakeop")
									|| args[0].equalsIgnoreCase("fakeban")) {
								if (args[0].equalsIgnoreCase("fakejoin")) {
									if (Token.isInt(args[1])) {
										p.sendMessage(Messages.prefix(Methods
												.format("&cMust be a string! Example: SesamePvP")));
									} else {
										p.sendMessage(Messages.prefix(Methods
												.format("&aSucessfully fakejoined player &2"
														+ args[1])));
										Bukkit.broadcastMessage(Methods
												.format("&e"
														+ args[1]
														+ " has joined the server!"));
									}
								}
								if (args[0].equalsIgnoreCase("fakeleave")) {
									if (Token.isInt(args[1])) {
										p.sendMessage(Messages.prefix(Methods
												.format("&cMust be a string! Example: SesamePvP")));
									} else {
										p.sendMessage(Messages.prefix(Methods
												.format("&aSucessfully fakeleft player &2"
														+ args[1])));
										Bukkit.broadcastMessage(Methods
												.format("&e"
														+ args[1]
														+ " has left the server!"));
									}
								}
								if (args[0].equalsIgnoreCase("fakeop")) {
									Player t = Bukkit.getServer().getPlayer(
											args[1]);
									if (t == null) {
										p.sendMessage(Messages.playerNull());
									} else {
										p.sendMessage(Messages.prefix(Methods
												.format("&aSucessfully fakeoped &2 "
														+ t.getName())));
										t.sendMessage(Methods
												.format("&eYou are now op!"));
										t.sendMessage(Methods.format("&7["
												+ p.getName() + ": Opped "
												+ t.getName() + " ! ]"));
									}
								}
								if (args[0].equalsIgnoreCase("fakeban")) {
									Player t = Bukkit.getServer().getPlayer(
											args[1]);
									if (t == null) {
										p.sendMessage(Messages.playerNull());
									} else {
										p.sendMessage(Messages.prefix(Methods
												.format("&aSucessfully fakebanned "
														+ t.getName())));
										t.kickPlayer(Methods
												.format("&cYou have been banned from this server by an Operator!\n&4Reason:\n&cCheating! (Hacked Client)"));
									}
								}
							} else {
								sendArgs(p);
							}
						} else {
							sendArgs(p);
						}
					}
				}
			} else {
				sender.sendMessage(Messages.notPlayer());
			}
		}
		return true;
	}

}
