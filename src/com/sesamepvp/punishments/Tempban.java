package com.sesamepvp.punishments;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.sesamepvp.files.PunishmentsFile;
import com.sesamepvp.main.SesameCore;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class Tempban implements CommandExecutor, Listener {
	PunishmentsFile pf = PunishmentsFile.getInstance();

	SesameCore instance;

	public Tempban(SesameCore instance) {
		this.instance = instance;
	}

	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("tempban")) {
			if (sender.hasPermission("core.tempban")) {
				if (args.length == 0) {
					sender.sendMessage(Messages.prefix(Methods.format("&cUsage: /tempban <player> <time> <reason>")));
				} else if (args.length == 1) {
					sender.sendMessage(Messages.prefix(Methods.format("&cUsage: /tempban <player> <time> <reason>")));
				} else if (args.length == 2) {
					sender.sendMessage(Messages.prefix(Methods.format("&cUsage: /tempban <player> <time> <reason>")));
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

					String banner = "Server";

					if (sender instanceof Player) {
						banner = sender.getName();
					}
					target.kickPlayer(Messages.prefix(Methods.format(
							"&cYou have been temporarily banned from the server!\n&4By: &c" + banner + "\n&4Reason: &c"
									+ x.toString().trim() + "\n&4Duration: &c" + formatTime(seconds))));
					pf.getData().set("Bans." + target.getName() + ".banner", banner);
					pf.getData().set("Bans." + target.getName() + ".reason", x.toString().trim());
					pf.getData().set("Bans." + target.getName() + ".time", seconds);
					pf.saveData();

					/**
					 * banned_players: DeveloperB: banner: Server reason: You
					 * suck at coding
					 */

					sender.sendMessage(Messages.prefix(Methods.format("&aTempbanned player &2" + target.getName())));

					new BukkitRunnable() {
						public void run() {
							if (pf.getData().getInt("Bans." + target.getName() + ".time") < 0) {
								pf.getData().get("Bans." + target.getName() + ".time", null);
								return;
							} else {
								pf.getData().set("Bans." + target.getName() + ".time",
										pf.getData().getInt("Bans." + target.getName() + ".time") - 1);
								pf.saveData();
							}
							if (pf.getData().getInt("Bans." + target.getName() + ".time") == 0) {
								pf.getData().set("Bans." + target.getName(), null);
								pf.getData().set("Bans." + target.getName() + ".time", null);
								pf.saveData();
							}

						}
					}.runTaskTimerAsynchronously(instance, 0, 20 * 1);
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
	public void onJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();

		if (pf.getData().getConfigurationSection("Bans") != null) {
			for (String section : pf.getData().getConfigurationSection("Bans").getKeys(false)) {
				if (section.equals(player.getName())) {
					if (pf.getData().get("Bans." + player.getName() + ".time") != null) {
						String banner = pf.getData().getString("Bans." + player.getName() + ".banner");
						int seconds = pf.getData().getInt("Bans." + player.getName() + ".time");
						String reason = pf.getData().getString("Bans." + player.getName() + ".reason");
						if (pf.getData().getInt("Bans." + player.getName() + ".time") < 0) {
							return;
						} else {
							player.kickPlayer(Messages.prefix(
									Methods.format("&cYou have been temporarily banned from the server!\n&4By: &c"
											+ banner + "\n&4Reason: &c" + reason.toString() + "\n&4Duration: &c"
											+ formatTime(seconds))));
						}
					}
				}
			}
		}
	}
}