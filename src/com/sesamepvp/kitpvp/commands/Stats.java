package com.sesamepvp.kitpvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.files.KitpvpFile;
import com.sesamepvp.kitpvp.gui.StatsGUI;
import com.sesamepvp.utilites.Messages;

public class Stats implements CommandExecutor {
	KitpvpFile manager = KitpvpFile.getInstance();

	
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("stats")) {
			Player p = (Player) sender;
			if(args.length == 0){
				StatsGUI.playerStats(p);
			}else{
				if(args.length == 1){
					Player t = Bukkit.getServer().getPlayer(args[0]);
					if(t == null){
						p.sendMessage(Messages.playerNull());
					}else{
						StatsGUI.targetStats(p, t);
					}
				}
			}
		}

		return true;

	}

}
