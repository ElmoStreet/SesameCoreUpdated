package com.sesamepvp.kitpvp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.sesamepvp.files.KitpvpFile;
import com.sesamepvp.kitpvp.gui.KitsGUI;
import com.sesamepvp.utilites.Messages;

public class Kits implements CommandExecutor, Listener {
	KitpvpFile manager = KitpvpFile.getInstance();

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("kits")) {
			if (sender instanceof Player) {

				KitsGUI.gui((Player) sender);
			} else {
				sender.sendMessage(Messages.notPlayer());
			}
		}
		return true;

	}
}
