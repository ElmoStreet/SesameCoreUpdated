package com.sesamepvp.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.staffmode.gui.Inspect;
import com.sesamepvp.utilites.Messages;

public class Invsee implements CommandExecutor{

	
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(cmd.getName().equalsIgnoreCase("invsee") || cmd.getName().equalsIgnoreCase("inspect")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(p.hasPermission("core.invsee")){
					if(args.length == 0){
						p.sendMessage(Messages.invseeUsage());
					}else{
						if(args.length == 1){
							Player t = Bukkit.getServer().getPlayer(args[0]);
							if(t == null){
								p.sendMessage(Messages.playerNull());
							}else{
								Inspect.InpsectGUI(p, t);
							}
						}
					}
				}else{
					p.sendMessage( Messages.noPermission());
				}
			}else{
				sender.sendMessage(Messages.notPlayer());
			}
		}
		return true;
		
	}

}
