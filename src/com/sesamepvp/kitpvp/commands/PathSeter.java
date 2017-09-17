package com.sesamepvp.kitpvp.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.files.KitpvpFile;
import com.sesamepvp.utilites.Messages;

public class PathSeter implements CommandExecutor {
	KitpvpFile manager = KitpvpFile.getInstance();

	
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("setpath")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (p.hasPermission("core.setpath") || p.isOp()) {
					if (args.length == 0) {
						p.sendMessage(ChatColor.RED
								+ "/setpath <type> <path> <value>");
					} else {
						if (args.length == 1) {
							p.sendMessage(ChatColor.RED
									+ "/setpath <type> <path> <value>");
						} else {
							if (args.length == 2) {
								p.sendMessage(ChatColor.RED
										+ "/setpath <type> <path> <value>");
							} else {
								if (args.length == 3) {
									if (args[0].equalsIgnoreCase("int")) {
										String path = args[1];
										String value = args[2];
										manager.getData().set(path,
												Integer.parseInt(value));
										p.sendMessage(ChatColor.GREEN + "Set "
												+ path + " to " + value);
										manager.saveData();
										manager.saveConfig();
										manager.reloadData();
										manager.reloadConfig();

									} else {
										if (args[0].equalsIgnoreCase("string")) {
											String path = args[1];
											String value = args[2];
											manager.getData().set(path, value);
											p.sendMessage(ChatColor.GREEN
													+ "Set " + path + " to "
													+ value);
											manager.saveData();
											manager.saveConfig();
											manager.reloadData();
											manager.reloadConfig();

										} else {
											if (args[0]
													.equalsIgnoreCase("boolean")) {
												String path = args[1];
												String value = args[2];
												manager.getData()
														.set(path,
																Boolean.parseBoolean(value));
												p.sendMessage(ChatColor.GREEN
														+ "Set " + path
														+ " to " + value);
												manager.saveData();
												manager.saveConfig();
												manager.reloadData();
												manager.reloadConfig();
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

}
