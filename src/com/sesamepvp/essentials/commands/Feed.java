package com.sesamepvp.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.utilites.Messages;

public class Feed implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(cmd.getName().equalsIgnoreCase("feed")){
			Player p = (Player) sender;
			if(sender instanceof Player){
				if(p.hasPermission("core.feed")){
					if(args.length == 0){
						p.sendMessage(Messages.feed());
						p.setFoodLevel(20);
					}else{
						if(args.length == 1){
							Player t = Bukkit.getServer().getPlayer(args[0]);
							if(t == null){
								p.sendMessage(Messages.playerNull());
							}else{
								t.setFoodLevel(20);
								t.sendMessage(Messages.feed());
								p.sendMessage(Messages.playerFeed(t));
							}
						}else{
							p.sendMessage(Messages.feedUsage());
						}
					}
				}else{
					p.sendMessage(Messages.noPermission());
				}
			}else{
				sender.sendMessage(Messages.notPlayer());
			}
		}
		return true;
	}
	
}
