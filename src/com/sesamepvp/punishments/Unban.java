package com.sesamepvp.punishments;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.sesamepvp.files.KitpvpFile;
import com.sesamepvp.files.PunishmentsFile;
import com.sesamepvp.punishments.manager.BanManager;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class Unban implements CommandExecutor {
	PunishmentsFile pf = PunishmentsFile.getInstance();
	KitpvpFile kpf = KitpvpFile.getInstance();

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("unban")) {
			if (sender.hasPermission("core.unban")) {
				if (args.length == 0) {
					sender.sendMessage(Messages.prefix(Methods.format("&cUsage: /unban <player>")));
				} else {
					if (args.length == 1) {
						OfflinePlayer t = Bukkit.getServer().getOfflinePlayer(args[0]);
						if (BanManager.isBanned(t) == true
								|| pf.getData().get("Bans." + t.getName() + ".time") != null) {
							pf.getData().set("Bans." + t.getName() + ".banned", false);
							pf.getData().set("Bans." + t.getName() + ".banner", null);
							pf.getData().set("Bans." + t.getName() + ".reason", null);
							pf.getData().set("Bans." + t.getName() + ".time", null);
							sender.sendMessage(Messages.prefix(Methods.format("&aYou have unbanned &a" + t.getName())));
							pf.saveData();
						} else {
							sender.sendMessage(Messages.prefix(Methods.format("&cThat player is not banned!")));
						}

					} else {
						sender.sendMessage(Messages.prefix(Methods.format("&cUsage: /unban <player>")));
					}

				}
			}
		}
		return true;
	}
}
