package com.sesamepvp.tokens;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.main.SesameCore;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class Token implements CommandExecutor {

	SesameCore instance;

	public Token(SesameCore instance) {
		this.instance = instance;
	}
	
	public static boolean isInt(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("token")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (p.hasPermission("core.tokenmanager")) {
					if (args.length == 0) {
						p.sendMessage(Messages.prefix(Methods
								.format("&cUsage: /token <reset give set take> <player>")));
					} else {
						if (args.length == 1) {
							p.sendMessage(Messages.prefix(Methods
									.format("&cUsage: /token <reset give set take> <player>")));
						} else {
							
							if (args.length == 2) {
								if (args[0].equalsIgnoreCase("reset")) {
									Player target = Bukkit.getServer()
											.getPlayer(args[1]);
									if (target == null) {
										p.sendMessage(Messages.playerNull());
									} else {
										TokenManager.resetBalance(target);
										p.sendMessage(Messages.prefix(Methods
												.format("&aYou have reset &e"
														+ target.getName()
														+ "'s &atokens.")));
									}
								}
							} else {
								if (args.length == 3) {
									if (args[0].equalsIgnoreCase("set")) {
										Player target = Bukkit.getServer()
												.getPlayer(args[1]);
										if (target == null) {
											p.sendMessage(Messages.playerNull());
										} else {
											if (isInt(args[2])) {
												TokenManager
														.setBalance(
																target,
																Integer.parseInt(args[2]));
												p.sendMessage(Messages.prefix(Methods.format("&aYou have set &e"
														+ target.getName()
														+ "'s &atokens to &e"
														+ Integer
																.parseInt(args[2]))));
												target.sendMessage(Messages.prefix(Methods.format("&aYou're tokens have been set to &e"
														+ Integer
																.parseInt(args[2]))));
											} else {
												p.sendMessage(Messages.prefix(Methods
														.format("&cYou must enter a number!")));
											}
										}
									} else {
										if (args[0].equalsIgnoreCase("give")) {
											Player target = Bukkit.getServer().getPlayer(args[1]);
											if(target == null){
												p.sendMessage(Messages.playerNull());
											}else{
												if(isInt(args[2])){
													p.sendMessage(Messages.prefix(Methods.format("&aYou have been added &e" + Integer.parseInt(args[2])+ "&a tokens to your account")));
													p.sendMessage(Messages.prefix(Methods.format("&aYou added &e" + Integer.parseInt(args[2])+ "&a tokens to &e" + target.getName() +"'s &a account")));
													TokenManager.addBalance(target, Integer.parseInt(args[2]));
												}else{
													p.sendMessage(Messages.prefix(Methods
															.format("&cYou must enter a number!")));
												}
											}
										}else{
											if (args[0].equalsIgnoreCase("take")) {
												Player target = Bukkit.getServer().getPlayer(args[1]);
												if(target == null){
													p.sendMessage(Messages.playerNull());
												}else{
													if(isInt(args[2])){
														p.sendMessage(Messages.prefix(Methods.format("&aYou have been removed of &e" + Integer.parseInt(args[2])+ "&a tokens from your account.")));
														p.sendMessage(Messages.prefix(Methods.format("&aYou removed &e" + Integer.parseInt(args[2])+ "&a tokens from &e" + target.getName() +"'s &aaccount")));
														TokenManager.takeBalance(target, Integer.parseInt(args[2]));
													}else{
														p.sendMessage(Messages.prefix(Methods
																.format("&cYou must enter a number!")));
													}
												}
											}
										}
									}
								}
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
	// token reset player, token give player amount, token set player amount

}
