package com.sesamepvp.staffmode.commands.report;

import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.sesamepvp.files.ReportsFile;
import com.sesamepvp.main.SesameCore;
import com.sesamepvp.staffmode.commands.report.gui.ReportGUI;
import com.sesamepvp.staffmode.commands.report.manager.ReportManager;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class Report implements CommandExecutor {
	ReportsFile rf = ReportsFile.getInstance();
	SesameCore plugin;

	public Report(SesameCore instance) {
		this.plugin = instance;
	}

	private HashMap<Player, BukkitRunnable> cooldownTask = new HashMap<Player, BukkitRunnable>();
	private HashMap<Player, Integer> cooldownTime = new HashMap<Player, Integer>();

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("report")) {

			final Player p = (Player) sender;
			if (sender instanceof Player) {
				if (cooldownTime.containsKey(p)) {
					p.sendMessage(Messages
							.prefix("§cYou are on cooldown for §4" + cooldownTime.get(p) + " §c more seconds"));
				} else {
					if (args.length == 0) {
						p.sendMessage(Messages.reportUsage());
					}
					if (args.length >= 2) {
						Player target = Bukkit.getPlayer(args[0]);
						if (target == null) {
							p.sendMessage(Messages.playerNull());
							return true;
						}

						StringBuilder sb = new StringBuilder();
						for (int i = 1; i < args.length; i++) {
							sb.append(args[i]);
							if (i < args.length) {
								sb.append(" ");
							}
						}

						List<String> reportslist = rf.getData()
								.getStringList("Reports." + target.getUniqueId() + ".reasons");
						reportslist.add(sb.toString());
						List<String> reporterslist = rf.getData()
								.getStringList("Reports." + target.getUniqueId() + ".reporters");
						reporterslist.add(p.getName());
						rf.getData().set("Reports." + target.getUniqueId() + ".username", target.getName());
						rf.getData().set("Reports." + target.getUniqueId() + ".reasons", reportslist);
						rf.getData().set("Reports." + target.getUniqueId() + ".reporters", reporterslist);
						rf.saveData();

						ReportManager.addReport(target, ReportGUI.reportGUI, ReportManager.slotnumberMAX);

						p.sendMessage(Messages.reported(target, sb.toString()));

						for (Player online : Bukkit.getServer().getOnlinePlayers()) {
							if (online.hasPermission("core.readreports") || online.isOp()) {
								online.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "---------"
										+ ChatColor.DARK_RED + " Report :" + ChatColor.DARK_GRAY + ""
										+ ChatColor.STRIKETHROUGH + "---------");

								online.sendMessage(ChatColor.RED + " Player: " + ChatColor.DARK_RED + p.getName());
								online.sendMessage(
										ChatColor.RED + " Reported: " + ChatColor.DARK_RED + target.getName());
								online.sendMessage(ChatColor.RED + " Reason: " + ChatColor.DARK_RED + sb.toString());
								online.sendMessage(
										ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "---------------"
												+ ChatColor.DARK_GRAY + ChatColor.STRIKETHROUGH + "----------");
							}
						}
						cooldownTime.put(p, 60);
						cooldownTask.put(p, new BukkitRunnable() {
							public void run() {
								cooldownTime.put(p, cooldownTime.get(p) - 1);
								if (cooldownTime.get(p) == 0) {
									cooldownTask.remove(p);
									cancel();
								}

							}

						});
						cooldownTask.get(p).runTaskTimer(plugin, 20, 20);
					}
				}

			} else {
				sender.sendMessage(Messages.notPlayer());
			}
		} else if (command.getName().equalsIgnoreCase("reports")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (p.hasPermission("core.reports")) {
					if (args.length == 0) {
						ReportGUI.gui(p);
					} else {
						if (args.length == 1) {
							if (args[0].equalsIgnoreCase("clearall")) {
								ReportManager.clearAllReports();
							}else{
								if(args[0].equalsIgnoreCase("clear") && args.length == 2){
									Player target = Bukkit.getPlayer(args[1]);
									if(target == null){
										p.sendMessage(Messages.playerNull());
									}else{
										p.sendMessage(Messages.prefix(Methods.format("&aYou cleared " + target.getName() + "'s reports.")));
										ReportManager.clearReports(target);
									}
								}
							}
						}
					}
				} else {
					p.sendMessage(Messages.noPermission());
				}
			}

		}
		return true;
	}

}
