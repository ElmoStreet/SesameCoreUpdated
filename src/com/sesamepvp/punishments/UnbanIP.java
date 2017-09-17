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

public class UnbanIP implements CommandExecutor{
	PunishmentsFile pf = PunishmentsFile.getInstance();
	KitpvpFile kpf = KitpvpFile.getInstance();
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("unbanip")) {
			if (args.length == 0) {
				sender.sendMessage(Messages.prefix(Methods.format("&cUsage: /unbanip <player>")));
			} else {
				if (args.length == 1) {
					OfflinePlayer t = Bukkit.getServer().getOfflinePlayer(args[0]);
						if (BanManager.isBanned(t) == false) {
							pf.getData().set("Bans." + t.getName() + ".banned", false);
							
							BanManager.bannedips.remove(kpf.getData().getInt(t.getName()+".ip"));
							pf.getData().set("Bans." + t.getName() + ".banner", "");
							pf.getData().set("Bans." + t.getName() + ".reason", "");
							sender.sendMessage(Messages.prefix(Methods.format("&aYou have unbanned the ip of &a" + t.getName())));
							pf.saveData();
						} else {
							sender.sendMessage(Messages.prefix(Methods.format("&cThat player is not banned!")));
						}
					
				} else {
					sender.sendMessage(Messages.prefix(Methods.format("&cUsage: /unbanip <player>")));
				}

			}
		}
		return true;
	}
}
