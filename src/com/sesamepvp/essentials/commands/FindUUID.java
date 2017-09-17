package com.sesamepvp.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.staffmode.StaffmodeManager;
import com.sesamepvp.utilites.Messages;

public class FindUUID implements CommandExecutor{

	
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(cmd.getName().equalsIgnoreCase("uuid")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(p.hasPermission("core.finduuid")){
					if(args.length == 0){
						p.sendMessage(Messages.prefix(StaffmodeManager.format("&cUUID &8:&4 &rhttps://" + p.getUniqueId() + ".com")));
					}else{
						if(args.length == 1){
							Player t = Bukkit.getServer().getPlayer(args[0]);
							if(t == null){
								p.sendMessage(Messages.playerNull());
							}else{
								p.sendMessage(Messages.prefix(StaffmodeManager.format("&4"+t.getName() + "'s &cUUID &8:&4 &rhttps://" + t.getUniqueId() + ".com")));
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
