package com.sesamepvp.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.utilites.Messages;

public class Heal implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(cmd.getName().equalsIgnoreCase("heal")){
			Player p = (Player) sender;
			if(sender instanceof Player){
				if(p.hasPermission("core.heal")){
					if(args.length == 0){
						p.sendMessage(Messages.healed());
						p.setFoodLevel(20);
						p.setHealth(20);
						p.getActivePotionEffects().clear();
					}else{
						if(args.length == 1){
							Player t = Bukkit.getServer().getPlayer(args[0]);
							if(t == null){
								p.sendMessage(Messages.playerNull());
							}else{
								t.setFoodLevel(20);
								t.setHealth(20);
								t.getActivePotionEffects().clear();
								t.sendMessage(Messages.healed());
								p.sendMessage(Messages.playerHealed(t));
							}
						}else{
							p.sendMessage(Messages.healUsage());
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
