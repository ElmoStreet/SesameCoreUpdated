package com.sesamepvp.chatmanagement.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.utilites.Messages;

public class ClearChat implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("clearchat") || cmd.getName().equalsIgnoreCase("cc")){
			Player p = (Player) sender;
			if(p.hasPermission("core.clearchat") || p.isOp()){
				for(int i =0; i <=100;i++){
					Bukkit.broadcastMessage("");
				}
				Bukkit.broadcastMessage(Messages.chatClear());
			}else{
				p.sendMessage(Messages.noPermission());
			}
			
		}
		return true;
		
		
	}
	
	
}
