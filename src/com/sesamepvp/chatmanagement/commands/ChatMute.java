package com.sesamepvp.chatmanagement.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.utilites.Messages;

public class ChatMute implements CommandExecutor{
	public static boolean chatmuted = false;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(cmd.getName().equalsIgnoreCase("mutechat") || cmd.getName().equalsIgnoreCase("mc")){
			Player p = (Player) sender;
			if(p.hasPermission("core.mutechat")){
				if(chatmuted){
					chatmuted = false;
					Bukkit.broadcastMessage(Messages.chatUnmuted());
				}else{
					chatmuted = true;
					Bukkit.broadcastMessage(Messages.chatMuted());
				}
			}
		}
		return true;
		
	}
	
	
}
