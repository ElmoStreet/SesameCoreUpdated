package com.sesamepvp.duels;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.duels.arena.ArenaManager;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class Duel implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("duel")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (args.length == 0) {
					p.sendMessage(Messages.prefix(Methods
							.format("&cUsage: /duel <player> <arena>")));
				} else {
					if (args.length == 1) {
						p.sendMessage(Messages.prefix(Methods
								.format("&cUsage: /duel <player> <arena>")));
					} else {
						if (args.length == 2) {
							if (args[0].equalsIgnoreCase("accept")) {
								Player t = ArenaManager.request.get(p);
								Bukkit.broadcastMessage("1");
								if (ArenaManager.isArena(args[1])) {
									Bukkit.broadcastMessage("2");
									if (ArenaManager.request.containsKey(p)) {
										ArenaManager.newDuel(t, p, args[1]);
										Bukkit.broadcastMessage("3");
									} else {
										p.sendMessage(Messages.prefix(Methods
												.format("&cNo active requests!")));
									}
								} else {
									p.sendMessage(Messages.prefix(Methods
											.format("&cThat arena does not exist!")));
								}
							} else {
								Player t = Bukkit.getServer()
										.getPlayer(args[0]);

								if (t == null) {
									p.sendMessage(Messages.playerNull());
								} else {
									if (ArenaManager.isArena(args[1])) {
										if (ArenaManager.inArena(p)
												|| ArenaManager.inArena(t)) {
											p.sendMessage(Messages.prefix(Methods
													.format("&cEither you or the target is in a duel already!")));
										} else {
											if(!ArenaManager.ArenaEmpty(args[1])){
												ArenaManager.newRequest(p, t,
														args[1]);
												}else{
													p.sendMessage(Messages.prefix(Methods.format("&cArena is not empty!")));
												}
										}
									} else {
										p.sendMessage(Messages.prefix(Methods
												.format("&cThat arena does not exist!")));
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
}
