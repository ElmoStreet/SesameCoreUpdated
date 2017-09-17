package com.sesamepvp.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.staffmode.StaffmodeManager;
import com.sesamepvp.utilites.Messages;

public class Vanish implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("vanish") || cmd.getName().equalsIgnoreCase("v")) {
			Player p = (Player) sender;
			if (sender instanceof Player) {
				if (p.hasPermission("core.vanish") || p.isOp()) {
					if (args.length == 0) {
						if (StaffmodeManager.vanish.contains(p)) {
							StaffmodeManager.vanish.remove(p);
							StaffmodeManager.Vanish(p);
							p.sendMessage(Messages.vanishDisabled());
						} else {
							if (!(StaffmodeManager.vanish.contains(p))) {
								StaffmodeManager.vanish.add(p);
								StaffmodeManager.Vanish(p);
								p.sendMessage(Messages.vanishEnabled());
							}
						}
					} else if (args.length == 1) {
						Player target = Bukkit.getServer().getPlayer(args[0]);
						if (target == null) {
							p.sendMessage(Messages.playerNull());
						} else {
							if (StaffmodeManager.vanish.contains(target)) {
								StaffmodeManager.vanish.remove(target);
								StaffmodeManager.Vanish(target);
								p.sendMessage(Messages
										.targetVanishDisabled(target));
								target.sendMessage(Messages.vanishDisabled());
							} else {
								if (!(StaffmodeManager.vanish.contains(target))) {
									StaffmodeManager.vanish.add(target);
									StaffmodeManager.Vanish(target);
									p.sendMessage(Messages
											.targetVanishEnabled(target));
									target.sendMessage(Messages.vanishEnabled());
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
