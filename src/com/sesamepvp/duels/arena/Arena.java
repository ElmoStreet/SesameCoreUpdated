package com.sesamepvp.duels.arena;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.files.ArenaFile;
import com.sesamepvp.tokens.Token;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class Arena implements CommandExecutor {
	ArenaFile af = ArenaFile.getInstance();

	private static void sendArgs(Player p) {
		p.sendMessage(Methods
				.format("&m&l&8---------&c Arena  &8&m&l---------"));
		p.sendMessage(Methods.format("&c /arena create <arenaname>"));
		p.sendMessage(Methods.format("&c /arena delete <arenaname>"));
		p.sendMessage(Methods.format("&c /arena setspawn1 <arenaname>"));
		p.sendMessage(Methods.format("&c /arena setspawn2 <arenaname>"));
		//p.sendMessage(Methods.format("&c /arena setkit <arenaname>"));
		p.sendMessage(Methods
				.format("&m&l&8---------&c -----  &8&m&l---------"));
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("arena")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (p.hasPermission("core.arena")) {
					if (args.length == 0) {
						sendArgs(p);
					} else {
						if (args.length == 1) {
							sendArgs(p);
						} else {
							if (args.length == 2) {
								if (args[0].equalsIgnoreCase("create")
										|| args[0].equalsIgnoreCase("delete")
										|| args[0]
												.equalsIgnoreCase("setspawn1")
										|| args[0]
												.equalsIgnoreCase("setspawn2") || args[0].equalsIgnoreCase("setkit")) {
									if (args[0].equalsIgnoreCase("create")) {
										if (Token.isInt(args[1])) {
											p.sendMessage(Messages.prefix(Methods
													.format("&cMust be a string! No numbers")));
										} else {
											if (ArenaManager.isArena(args[1])) {
												p.sendMessage(Messages.prefix(Methods
														.format("&cThere is already an arena named that!")));
											} else {
												ArenaManager.newArena(args[1]);
												p.sendMessage(Messages.prefix(Methods
														.format("&aSuccessfully created Arena &2"
																+ args[1])));
											}
										}
									}
									if (args[0].equalsIgnoreCase("delete")) {
										if (Token.isInt(args[1])) {
											p.sendMessage(Messages.prefix(Methods
													.format("&cMust be a string! No numbers")));
										} else {
											if (!ArenaManager.isArena(args[1])) {
												p.sendMessage(Messages.prefix(Methods
														.format("&cThat arena doesn't exist!")));
											} else {
												ArenaManager.delArena(args[1]);
												p.sendMessage(Messages.prefix(Methods
														.format("&cSuccessfully deleted Arena &4"
																+ args[1])));
											}
										}
									}
									if (args[0].equalsIgnoreCase("setspawn1")) {
										if (Token.isInt(args[1])) {
											p.sendMessage(Messages.prefix(Methods
													.format("&cMust be a string! No numbers")));
										} else {
											if (!ArenaManager.isArena(args[1])) {
												p.sendMessage(Messages.prefix(Methods
														.format("&cThat arena doesn't exist!")));
											} else {
												af.getData()
														.set(args[1]
																+ ".spawnlocation1",
																p.getLocation());
												af.saveData();
												p.sendMessage(Messages.prefix(Methods
														.format("&aSet spawnpoint 1 for &2"
																+ args[1])));
											}
										}
									}
									if (args[0].equalsIgnoreCase("setspawn2")) {
										if (Token.isInt(args[1])) {
											p.sendMessage(Messages.prefix(Methods
													.format("&cMust be a string! No numbers")));
										} else {
											if (!ArenaManager.isArena(args[1])) {
												p.sendMessage(Messages.prefix(Methods
														.format("&cThat arena doesn't exist!")));
											} else {
												af.getData()
														.set(args[1]
																+ ".spawnlocation2",
																p.getLocation());
												af.saveData();
												p.sendMessage(Messages.prefix(Methods
														.format("&aSet spawnpoint 2 for &2"
																+ args[1])));
											}
										}
									}
//									if (args[0].equalsIgnoreCase("setkit")) {
//										if (Token.isInt(args[1])) {
//											p.sendMessage(Messages.prefix(Methods
//													.format("&cMust be a string! No numbers")));
//										} else {
//											if (!ArenaManager.isArena(args[1])) {
//												p.sendMessage(Messages.prefix(Methods
//														.format("&cThat arena doesn't exist!")));
//											} else {
//												KitManager.saveKit(p, args[1]);
//												p.sendMessage(Messages.prefix(Methods
//														.format("&aSet kit for &2"
//																+ args[1])));
//											}
//										}
//									}
								} else {
									sendArgs(p);
								}
							} else {
								sendArgs(p);
							}
						}
					}
				}else{
					p.sendMessage(Messages.noPermission());
				}
			} else {
				sender.sendMessage(Messages.notPlayer());
			}
		}
		return true;
	}

}
