package com.sesamepvp.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class Gamemode implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("gamemode")
				|| cmd.getName().equalsIgnoreCase("gm")) {
			Player p = (Player) sender;
			if (sender instanceof Player) {
				if (p.hasPermission("core.gamemode")) {

					if (args.length == 0) {
						p.sendMessage(Messages.gamemodeUsage());
					} else {
						// /gamemode 1 [player]
						if (args.length == 1) {
							if (args[0].equalsIgnoreCase("creative")
									|| args[0].equalsIgnoreCase("1")) {
								p.setGameMode(GameMode.CREATIVE);
								p.sendMessage(Messages.gamemodeCreative());
							}
							if (args[0].equalsIgnoreCase("survival")
									|| args[0].equalsIgnoreCase("0")) {
								p.setGameMode(GameMode.SURVIVAL);
								p.sendMessage(Messages.gamemodeSurvival());
							}
							if (args[0].equalsIgnoreCase("creative")
									|| args[0].equalsIgnoreCase("2")) {
								p.setGameMode(GameMode.ADVENTURE);
								p.sendMessage(Messages.gamemodeAdventure());
							}
							if (args[0].equalsIgnoreCase("spectator")
									|| args[0].equalsIgnoreCase("3")) {
								p.setGameMode(GameMode.SPECTATOR);
								p.sendMessage(Messages.gamemodeSpectator());
							}
						} else {
							if(args.length == 2){
								Player t = Bukkit.getServer().getPlayer(args[1]);
								if(!(t == null)){
									if (args[0].equalsIgnoreCase("creative")
											|| args[0].equalsIgnoreCase("1")) {
										t.setGameMode(GameMode.CREATIVE);
										p.sendMessage(Messages.prefix(Methods.format("&aChanged &2"+t.getName()+"'s &aGamemode to &2Creative." )));
										t.sendMessage(Messages.gamemodeCreative());
									}
									if (args[0].equalsIgnoreCase("survival")
											|| args[0].equalsIgnoreCase("0")) {
										t.setGameMode(GameMode.SURVIVAL);
										p.sendMessage(Messages.prefix(Methods.format("&aChanged &2"+t.getName()+"'s &aGamemode to &2Survival." )));
										t.sendMessage(Messages.gamemodeSurvival());
									}
									if (args[0].equalsIgnoreCase("creative")
											|| args[0].equalsIgnoreCase("2")) {
										t.setGameMode(GameMode.ADVENTURE);
										p.sendMessage(Messages.prefix(Methods.format("&aChanged &2"+t.getName()+"'s &aGamemode to &2Adventure." )));
										t.sendMessage(Messages.gamemodeAdventure());
									}
									if (args[0].equalsIgnoreCase("spectator")
											|| args[0].equalsIgnoreCase("3")) {
										t.setGameMode(GameMode.SPECTATOR);
										p.sendMessage(Messages.prefix(Methods.format("&aChanged &2"+t.getName()+"'s &aGamemode to &2Spectator." )));
										t.sendMessage(Messages.gamemodeSpectator());
									}
								}else{
									p.sendMessage(Messages.playerNull());
								}
							}else{
								p.sendMessage(Messages.gamemodeUsage());
							}
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
