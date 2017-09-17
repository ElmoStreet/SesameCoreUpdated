package com.sesamepvp.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.staffmode.StaffmodeManager;
import com.sesamepvp.utilites.Messages;

public class Fly implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("fly")) {
			Player p = (Player) sender;
			if (sender instanceof Player) {
				if (p.hasPermission("core.fly") || p.isOp()) {
					if (args.length == 0) {
						if (StaffmodeManager.fly.contains(p)) {
							StaffmodeManager.fly.remove(p);
							StaffmodeManager.Fly(p);
							p.sendMessage(Messages.flightDisabled());
						} else {
							if (!(StaffmodeManager.fly.contains(p))) {
								StaffmodeManager.fly.add(p);
								StaffmodeManager.Fly(p);
								p.sendMessage(Messages.flightEnabled());
							}
						}
					} else if (args.length == 1) {

						Player target = Bukkit.getServer().getPlayer(args[0]);
						if (target == null) {
							p.sendMessage(Messages.playerNull());
						} else {
							if (StaffmodeManager.fly.contains(target)) {
								StaffmodeManager.fly.remove(target);
								StaffmodeManager.Fly(target);
								p.sendMessage(Messages.targetFlightDisabled(target));
								target.sendMessage(Messages.flightDisabled());
							} else {
								if (!(StaffmodeManager.fly.contains(target))) {
									StaffmodeManager.fly.add(target);
									StaffmodeManager.Fly(target);
									p.sendMessage(Messages.targetFlightEnabled(target));
									target.sendMessage(Messages.flightEnabled());
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
