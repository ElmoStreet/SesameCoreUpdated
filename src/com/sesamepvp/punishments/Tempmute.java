package com.sesamepvp.punishments;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.sesamepvp.files.PunishmentsFile;
import com.sesamepvp.main.SesameCore;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class Tempmute implements CommandExecutor, Listener {
	PunishmentsFile pf = PunishmentsFile.getInstance();

	SesameCore instance;

	public Tempmute(SesameCore instance) {
		this.instance = instance;
	}

	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("tempmute")) {
			if (sender.hasPermission("core.tempmute")) {
				if (args.length == 0) {
					sender.sendMessage(Messages.prefix(Methods.format("&cUsage: /tempmute <player> <time> <reason>")));
				} else if (args.length == 1) {
					sender.sendMessage(Messages.prefix(Methods.format("&cUsage: /tempmute <player> <time> <reason>")));
				} else if (args.length == 2) {
					sender.sendMessage(Messages.prefix(Methods.format("&cUsage: /tempmute <player> <time> <reason>")));
				} else {
					final Player target = Bukkit.getPlayer(args[0]);

					if (target == null) {
						sender.sendMessage(Messages.playerNull());
						return true;
					}

					int seconds;

					try {
						seconds = Integer.parseInt(args[1]);
					} catch (NumberFormatException e) {
						sender.sendMessage(Messages.prefix(Methods.format("&cPlease use numbers as time.")));
						return true;
					}

					StringBuilder x = new StringBuilder();

					for (int i = 2; i < args.length; i++) {
						x.append(args[i] + " ");
					}

					String muter = "Server";

					if (sender instanceof Player) {
						muter = sender.getName();
					}
					target.sendMessage(Methods.format(
							"&aYou have been tempmuted by&2 " + sender.getName() + " for &2" + formatTime(seconds)));
					pf.getData().set("Mutes." + target.getUniqueId() + ".muter", muter);
					pf.getData().set("Mutes." + target.getUniqueId() + ".muted", true);
					pf.getData().set("Mutes." + target.getUniqueId() + ".reason", x.toString().trim());
					pf.getData().set("Mutes." + target.getUniqueId() + ".time", seconds);
					pf.saveData();

					/**
					 * banned_players: DeveloperB: banner: Server reason: You
					 * suck at coding
					 */

					sender.sendMessage(Messages.prefix(Methods.format("&aTempmuted player &2" + target.getName())));

					new BukkitRunnable() {
						public void run() {
							if (pf.getData().getInt("Mutes." + target.getUniqueId() + ".time") < 0) {
								pf.getData().get("Mutes." + target.getUniqueId() + ".time", null);
								return;
							} else {
								pf.getData().set("Mutes." + target.getUniqueId() + ".time",
										pf.getData().getInt("Mutes." + target.getUniqueId() + ".time") - 1);
								pf.saveData();
							}
							if (pf.getData().getInt("Mutes." + target.getUniqueId() + ".time") == 0) {
								pf.getData().set("Mutes." + target.getUniqueId(), null);
								pf.getData().set("Mutes." + target.getUniqueId() + ".time", null);
								pf.saveData();
							}

						}
					}.runTaskTimerAsynchronously(instance, 0, 20);
				}
			}
		}
		return true;
	}

	public static String formatTime(int seconds) {
		/**
		 * You have been banned from the server! By: DeveloperB Reason: You suck
		 * Time: 9 days 3 hours 27 minutes 34 seconds
		 */
		String day = "";
		String hour = "";
		String min = "";
		String sec = "";

		int days = seconds / (60 * 60 * 24);
		if (days == 1) {
			day = "1 day";
		} else if (days > 1) {
			day = days + " days";
		}
		seconds -= days * (60 * 60 * 24);

		int hours = seconds / (60 * 60);
		if (hours == 1) {
			hour = "1 hour";
		} else if (hours > 1) {
			hour = hours + " hours";
		}
		seconds -= hours * (60 * 60);

		int minutes = seconds / 60;
		if (minutes == 1) {
			min = "1 minute";
		} else if (minutes > 1) {
			min = minutes + " minutes";
		}
		seconds -= minutes * 60;

		if (seconds == 1) {
			sec = "1 second";
		} else if (seconds > 1) {
			sec = seconds + " seconds";
		}
		String fin = day + " " + hour + " " + min + " " + sec;

		if (hour.equals("")) {
			fin = day + " " + min + " " + sec;
			if (min.equals("")) {
				fin = day + " " + sec;
			}
		} else if (min.equals("")) {
			fin = day + " " + hour + " " + sec;
		}

		return fin.trim();
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player player = e.getPlayer();

		if (pf.getData().getConfigurationSection("Mutes") != null) {
			for (String section : pf.getData().getConfigurationSection("Mutes").getKeys(false)) {
				if (section.equals(player.getUniqueId())) {
					if (pf.getData().get("Mutes." + player.getUniqueId() + ".time") != null) {
						int seconds = pf.getData().getInt("Mutes." + player.getName() + ".time");
						player.sendMessage(
								Messages.prefix(Methods.format("&aYou are still muted for " + formatTime(seconds))));
						e.setCancelled(true);

					}
				}
			}
		}
	}
}
