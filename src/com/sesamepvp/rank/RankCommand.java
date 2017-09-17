package com.sesamepvp.rank;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.sesamepvp.files.Rankfile;
import com.sesamepvp.main.SesameCore;
import com.sesamepvp.tokens.Token;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class RankCommand implements CommandExecutor {
	Rankfile rf = Rankfile.getInstance();
	SesameCore instance;

	public RankCommand(SesameCore instance) {
		this.instance = instance;
	}

	public void sendUsage(CommandSender sender) {
		sender.sendMessage(Methods.format("&a : /rm create <Group Name>"));
		sender.sendMessage(Methods.format("&a : /rm delete <Group Name>"));
		sender.sendMessage(Methods.format("&a : /rm set <Player> <Group Name>"));
		sender.sendMessage(Methods
				.format("&a : /rm addpermission <Group Name> <Permission Node>"));
		sender.sendMessage(Methods
				.format("&a : /rm removepermission <Group Name> <Permission Node>"));
		sender.sendMessage(Methods
				.format("&a : /rm setprefix <Group Name> <Prefix>"));
		sender.sendMessage(Methods
				.format("&a : /rm setparents <Group Name> <Parent Group Name>"));
		sender.sendMessage(Methods
				.format("&a : /rm delparents <Group Name> <Parent Group Name>"));
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("rm")) {
			if (sender.hasPermission("core.*")
					|| sender.hasPermission("core.rankmanage") || sender.isOp()) {
				if (args.length <= 1) {
					sendUsage(sender);
				} else {
					if (args.length == 2) {
						if (args[0].equalsIgnoreCase("create")) {
							if (Token.isInt(args[1]) == false) {
								String rankname = args[1];
								if (RankManager.rankExists(rankname) == true) {
									sender.sendMessage(Messages.prefix(Methods
											.format("&cThat rank already exists!")));
								} else {
									RankManager.newRank(rankname);
									sender.sendMessage(Messages.prefix(Methods
											.format("&aCreated rank &2"
													+ rankname + "&a!")));
								}
							} else {
								sender.sendMessage(Messages.prefix(Methods
										.format("&cYou must enter a string! No numbers.")));
							}
						} else {
							if (args[0].equalsIgnoreCase("delete")) {
								if (Token.isInt(args[1]) == false) {
									String rankname = args[1];
									if (!RankManager.rankExists(rankname) == true) {
										sender.sendMessage(Messages.prefix(Methods
												.format("&cThat rank doesnt exist!")));
									} else {
										RankManager.removeRank(rankname);
										sender.sendMessage(Messages.prefix(Methods
												.format("&aDeleted rank &2"
														+ rankname + "&a!")));
									}
								} else {
									sender.sendMessage(Messages.prefix(Methods
											.format("&cYou must enter a string! No numbers.")));
								}
							}
						}
					} else {
						if (args.length == 3) {
							/*
							 * if (args[0].equalsIgnoreCase("set")) { Player
							 * target = Bukkit.getServer().getPlayer( args[1]);
							 * if (target == null) {
							 * sender.sendMessage(Messages.playerNull()); } else
							 * { String rankname = args[2];
							 * 
							 * List<String> oldpermission = new
							 * ArrayList<String>(); if
							 * (RankManager.rankExists(rankname)) { for(int i =
							 * 0; i < rf.getData().getStringList("Ranks." +
							 * RankManager.getRank(target)
							 * +".permissions").size(); i++){
							 * oldpermission.add(rf
							 * .getData().getStringList("Ranks." +
							 * RankManager.getRank(target)
							 * +".permissions").get(i)); } for(int i = 0; i <
							 * oldpermission.size(); i++){
							 * PermissionManager.removePermission(target); }
							 * RankManager.setRank(target, rankname);
							 * rf.saveData(); List<String> newpermission = new
							 * ArrayList<String>(); for(int i = 0; i <
							 * RankManager
							 * .getPermissions(RankManager.getRank(target
							 * )).size(); i++){
							 * newpermission.add(RankManager.getPermissions
							 * (RankManager.getRank(target)).get(i)); } for(int
							 * i = 0; i < newpermission.size(); i++){
							 * PermissionManager.addPermission(target, instance,
							 * newpermission.get(i)); }
							 * 
							 * sender.sendMessage(Messages.prefix(Methods
							 * .format("&aYou have set &2" + target.getName() +
							 * "'s &arank to &2" + rankname))); } else {
							 * sender.sendMessage(Messages.prefix(Methods
							 * .format("&cThat rank does not exist!"))); } }
							 */
						} else {
							if (args[0].equalsIgnoreCase("setprefix")) {
								if (Token.isInt(args[1]) == false) {
									String rankname = args[1];
									if (RankManager.rankExists(rankname)) {
										if (Token.isInt(args[2]) == false) {
											RankManager.setPrefix(rankname,
													args[2]);
											sender.sendMessage(Messages.prefix(Methods.format("&aChanged prefix to "
													+ Methods.format(args[2])
													+ " &afor group &2"
													+ rankname + "&a!")));
										} else {
											sender.sendMessage(Messages.prefix(Methods
													.format("&cYou must enter a string! No numbers.")));
										}
									} else {
										sender.sendMessage(Messages.prefix(Methods
												.format("&cThat rank does not exist!")));
									}
								} else {
									sender.sendMessage(Messages.prefix(Methods
											.format("&cYou must enter a string! No numbers.")));
								}
							} else {
								if (args[0].equalsIgnoreCase("addpermission")) {
									if (Token.isInt(args[1]) == false) {
										String rankname = args[1];
										if (RankManager.rankExists(rankname)) {
											List<String> permissionlist = new ArrayList<String>();
											String permissionnode = args[2];
											permissionlist.add(permissionnode);
											for (String output : rf
													.getData()
													.getStringList(
															"Ranks."
																	+ rankname
																	+ ".permissions")) {
												permissionlist.add(output);
											}
											rf.getData().set(
													"Ranks." + rankname
															+ ".permissions",
													permissionlist);
											rf.saveData();
											sender.sendMessage(ChatColor.GREEN
													+ "Updated permissions!");
										} else {
											return false;
										}
									} else {
										sender.sendMessage(Messages.prefix(Methods
												.format("&cYou must enter a string! No numbers.")));
									}
								}
							}
						}
					}
				}
			}
		}

		return true;
	}
	// rm create Helper
	// rm delete Helper
	// rm set SesamePvP Helper
	// rm addpermission Helper permissionnode
	// rm setprefix Helper permissionnode
	// rm removepermission Helper permissionnode
	// rm promote player
	// rm demote player

}
