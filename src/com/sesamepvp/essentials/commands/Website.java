package com.sesamepvp.essentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.sesamepvp.staffmode.StaffmodeManager;
import com.sesamepvp.utilites.Messages;

public class Website implements CommandExecutor{

	
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(cmd.getName().equalsIgnoreCase("website")){
			sender.sendMessage(Messages.prefix(StaffmodeManager.format("&chttps://sesamepvp.enjin.com")));
		}
		return true;
	}
}
