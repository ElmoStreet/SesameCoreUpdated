package com.sesamepvp.kitpvp.quests;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.kitpvp.quests.GUI.QuestGUI;
import com.sesamepvp.utilites.Messages;

public class Quest implements CommandExecutor {

	
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("quests")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				QuestGUI.openQuestGUI(p);
			} else {
				sender.sendMessage(Messages.notPlayer());
			}
		}
		return true;
	}

}
