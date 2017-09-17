package com.sesamepvp.punishments.manager;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.sesamepvp.essentials.commands.List;
import com.sesamepvp.files.PunishmentsFile;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class BanManager implements Listener {
	public static ArrayList<String> bannedips = new ArrayList<String>();
	public static HashMap<OfflinePlayer, Boolean> banned = new HashMap<OfflinePlayer, Boolean>();

	static PunishmentsFile pf = PunishmentsFile.getInstance();
	public static boolean isBanned = false;

	public static boolean isBanned(OfflinePlayer t) {
		if (pf.getData().getBoolean("Bans." + t.getName() + ".banned") == true) {
			isBanned = true;
		} else {
			isBanned = false;
		}
		return isBanned;
	}

	public static void banPlayer2(OfflinePlayer t, CommandSender p, StringBuilder sb) {
		if (isBanned(t) == true) {
			p.sendMessage(Messages.prefix(Methods.format("&aThat player is already banned!")));
		} else {
			pf.getData().set("Bans." + t.getName() + ".banned", true);
			pf.getData().set("Bans." + t.getName() + ".banner", p.getName());
			pf.getData().set("Bans." + t.getName() + ".reason", sb.toString());
			pf.getData().set("Bans." + t.getName() + ".time", null);
			if (List.playercount.contains(t) || List.onlinestaff.contains(t)) {
				pf.getData().set("Bans." + t.getName() + ".banned", true);
				pf.getData().set("Bans." + t.getName() + ".banner", p.getName());
				pf.getData().set("Bans." + t.getName() + ".reason", sb.toString());
				pf.getData().set("Bans." + t.getName() + ".time", null);

				((Player) t)
						.kickPlayer(Messages.prefix(Methods.format("&cYou have been banned from the server.\n&4By: &c"
								+ pf.getData().getString("Bans." + t.getName() + ".banner") + "\n&4Reason:&c "
								+ sb)));
				p.sendMessage(Messages.prefix(Methods.format("&aYou have banned &a" + t.getName())));
				pf.saveData();
			} else {
				pf.getData().set("Bans." + t.getName() + ".banned", true);
				pf.getData().set("Bans." + t.getName() + ".banner", p.getName());
				pf.getData().set("Bans." + t.getName() + ".reason", sb.toString());
				pf.getData().set("Bans." + t.getName() + ".time", null);
				p.sendMessage(Messages.prefix(Methods.format("&aYou have banned &a" + t.getName())));
				pf.saveData();
			}

		}
	}
	
	public static void banPlayer(Player t, CommandSender p, StringBuilder sb) {
		if (isBanned(t) == true) {
			p.sendMessage(Messages.prefix(Methods.format("&aThat player is already banned!")));
		} else {
			pf.getData().set("Bans." + t.getName() + ".banned", true);
			pf.getData().set("Bans." + t.getName() + ".banner", p.getName());
			pf.getData().set("Bans." + t.getName() + ".reason", sb.toString());
			pf.getData().set("Bans." + t.getName() + ".time", null);
				pf.getData().set("Bans." + t.getName() + ".banned", true);
				pf.getData().set("Bans." + t.getName() + ".banner", p.getName());
				pf.getData().set("Bans." + t.getName() + ".reason", sb.toString());
				pf.getData().set("Bans." + t.getName() + ".time", null);

		
						t.kickPlayer(Messages.prefix(Methods.format("&cYou have been banned from the server.\n&4By: &c"
								+ pf.getData().getString("Bans." + t.getName() + ".banner") + "\n&4Reason:&c "
								+ sb.toString())));
				p.sendMessage(Messages.prefix(Methods.format("&aYou have banned &a" + t.getName())));
				pf.saveData();
		}
	}

	public static void banipPlayer(Player target, CommandSender p, StringBuilder sb, String ip) {
		if (isBanned(target) == true) {
			p.sendMessage(Messages.prefix(Methods.format("&aThat player is already banned!")));
		} else {
			pf.getData().set("Bans." + target.getName() + ".banned", true);
			bannedips.add(ip);
			pf.getData().set("BannedIPs", bannedips);
			pf.getData().set("Bans." + target.getName() + ".banner", p.getName());
			pf.getData().set("Bans." + target.getName() + ".reason", sb.toString());
			target.kickPlayer(Messages.prefix(Methods.format("&cYou have been banned from the server.\n&4By: &c"
					+ pf.getData().getString("Bans." + target.getName() + ".banner") + "\n&4Reason:&c "
					+ sb.toString())));
			p.sendMessage(Messages.prefix(Methods.format("&aYou have banned &a" + target.getName())));
			pf.saveData();
		}
	}

	public static void unbanPlayer(OfflinePlayer t, CommandSender sender) {
		if (!(isBanned(t) == true)) {
			sender.sendMessage(Messages.prefix(Methods.format("&aThat player is not banned!")));
		} else {
			pf.getData().set("Bans." + t.getName() + ".banned", false);
			pf.getData().getConfigurationSection("Bans." + t.getName() + ".banner")
					.set("Bans." + t.getName() + ".banner", null);
			;
			pf.getData().getConfigurationSection("Bans." + t.getName() + ".reason")
					.set("Bans." + t.getName() + ".reason", null);
			;
			sender.sendMessage(Messages.prefix(Methods.format("&aYou have unbanned &a" + t.getName())));
			pf.saveData();
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (isBanned(p) == true) {
			String banner = (String) pf.getData().get("Bans." + p.getName() + ".banner");
			String reason = (String) pf.getData().get("Bans." + p.getName() + ".reason");
			p.kickPlayer(Messages.prefix(Methods
					.format("&cYou have been banned from the server.\n&4By:&c " + banner + "\n&4Reason:&c " + reason)));
		} else {
			if (bannedips.contains(p.getAddress().getAddress().getHostAddress())) {
				p.kickPlayer(
						Messages.prefix(Methods.format("&cYou're ip is banned from this server! No ban evading!")));
			}
		}
	}
}
