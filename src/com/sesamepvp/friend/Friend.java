package com.sesamepvp.friend;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.friend.managers.FriendManager;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class Friend implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(cmd.getName().equalsIgnoreCase("friend")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(args.length == 0){
					p.sendMessage(Messages.prefix(Methods.format("&cUsage: /friend <add> <player>")));
				}else{
					if(args.length == 1){
						p.sendMessage(Messages.prefix(Methods.format("&cUsage: /friend <add> <player>")));
					}else{
						if(args.length == 2){
							if(args[0].equalsIgnoreCase("add")){
								Player t = Bukkit.getServer().getPlayer(args[1]);
								if(t == null){
									p.sendMessage(Messages.playerNull());
								}else{
									FriendManager.newRequest(p, t);
								}
							}else{
								if(args[0].equalsIgnoreCase("accept")){
									Player t = Bukkit.getServer().getPlayer(args[1]);
									if(t == null){
										p.sendMessage(Messages.playerNull());
									}else{
										if(FriendManager.getRequest(p) == true){
											FriendManager.addFriend(p, t);
											
										}else{
											p.sendMessage(Messages.prefix(Methods.format("No request!")));
										}
									}
								}
							}
						}
					}
				}
			}else{
				sender.sendMessage(Messages.notPlayer());
			}
		}
		return true;
	}

}
