package com.sesamepvp.punishments;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.files.PunishmentsFile;
import com.sesamepvp.punishments.manager.BanManager;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class Ban implements CommandExecutor {
	PunishmentsFile pf = PunishmentsFile.getInstance();

	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("ban")) {
			if (sender.hasPermission("core.ban")) {
				if (args.length == 0) {
					sender.sendMessage(Messages.prefix(Methods.format("&cUsage: /ban <player> <reason>")));
				} else {
					if (args.length == 1) {
						sender.sendMessage(Messages.prefix(Methods.format("&cUsage: /ban <player> <reason>")));
					} else {
						Player t = Bukkit.getServer().getPlayer(args[0]);
						if (t == null) {
							sender.sendMessage(Messages.playerNull());
						} else {

							if (pf.getData().getBoolean("Bans." + t.getName() + ".banned") == true) {
								if (BanManager.isBanned(t) == false) {

									StringBuilder sb = new StringBuilder();

									for (int i = 1; i < args.length; i++) {
										sb.append(args[i] + " ");
									}

									BanManager.banPlayer(t, sender, sb);
									sender.sendMessage(Messages
											.prefix(Methods.format("&aOverriding previous ban for &2" + t.getName())));

								} else {
									sender.sendMessage(
											Messages.prefix(Methods.format("&cThat player is already banned!")));
								}
							} else {
								if (BanManager.isBanned(t) == false) {

									StringBuilder sb = new StringBuilder();

									for (int i = 1; i < args.length; i++) {
										sb.append(args[i] + " ");
									}

									BanManager.banPlayer(t, sender, sb);
								} else {
									sender.sendMessage(
											Messages.prefix(Methods.format("&cThat player is already banned!")));
								}
							}
						}

					}
				}
			}
		} else if (cmd.getName().equalsIgnoreCase("banofflineplayer")) {
			if (sender.hasPermission("core.ban")) {
				if (args.length == 0) {
					sender.sendMessage(Messages.prefix(Methods.format("&cUsage: /ban <player> <reason>")));
				} else {
					if (args.length == 1) {
						sender.sendMessage(Messages.prefix(Methods.format("&cUsage: /ban <player> <reason>")));
					} else {
						@SuppressWarnings("deprecation")
						OfflinePlayer t = Bukkit.getServer().getOfflinePlayer(args[0]);
						if (t == null) {
							sender.sendMessage(Messages.playerNull());
						} else {

							if (pf.getData().getBoolean("Bans." + t.getName() + ".banned") == true) {
								if (BanManager.isBanned(t) == false) {

									StringBuilder sb = new StringBuilder();

									for (int i = 1; i < args.length; i++) {
										sb.append(args[i] + " ");
									}

									BanManager.banPlayer2(t, sender, sb);
									sender.sendMessage(Messages
											.prefix(Methods.format("&aOverriding previous ban for &2" + t.getName())));

								} else {
									sender.sendMessage(
											Messages.prefix(Methods.format("&cThat player is already banned!")));
								}
							} else {
								if (BanManager.isBanned(t) == false) {

									StringBuilder sb = new StringBuilder();

									for (int i = 1; i < args.length; i++) {
										sb.append(args[i] + " ");
									}

									BanManager.banPlayer2(t, sender, sb);
								} else {
									sender.sendMessage(
											Messages.prefix(Methods.format("&cThat player is already banned!")));
								}
							}
						}

					}
				}
				return true;
			}
		}
		return true;
	}
}
