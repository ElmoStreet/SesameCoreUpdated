package com.sesamepvp.essentials.msg;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class Reply implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(cmd.getName().equalsIgnoreCase("r") || cmd.getName().equalsIgnoreCase("reply")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(args.length == 0){
					p.sendMessage(Messages.prefix(Methods.format("Usage: /r <msg>")));
				}else{
					if(args.length >= 1){
						if(MessageManager.inconvo.containsKey(p)){
							Player t = MessageManager.getRecepient(p);
							if(t == null){
								p.sendMessage(Messages.prefix(Methods.format("&cRecepient is null")));
							}else{
								StringBuilder sb = new StringBuilder();
								for (int i = 0; i < args.length; i++) {
									sb.append(args[i]);
									if (i < args.length) {
										sb.append(" ");
									}
								}
								p.sendMessage(Messages.prefix("§a(To §r"
										+ t.getDisplayName() + " §a)§2 "
										+ sb.toString()));
								t.sendMessage(Messages.prefix("§a(From §r"
										+ p.getDisplayName() + " §a)§2 " + sb.toString()));
							}
						}else{
							p.sendMessage(Messages.prefix(Methods.format("&cYou have no one to reply to")));
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
