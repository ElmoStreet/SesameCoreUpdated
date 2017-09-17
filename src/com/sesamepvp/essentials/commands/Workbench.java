package com.sesamepvp.essentials.commands;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;

import com.sesamepvp.utilites.Messages;

public class Workbench implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(cmd.getName().equalsIgnoreCase("craft") || cmd.getName().equalsIgnoreCase("workbench")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(p.hasPermission("core.workbench")){
					if(args.length == 0){
						p.closeInventory();
						p.openInventory(Bukkit.getServer().createInventory(p, InventoryType.WORKBENCH, p.getName() + "'s Workbench"));
					}else{
						if(args.length == 1){
							Player t = Bukkit.getServer().getPlayer(args[0]);
							if(t == null){
								p.sendMessage(Messages.playerNull());
							}else{
								t.closeInventory();
								p.sendMessage(Messages.prefix(ChatColor.GREEN+"Opened " + ChatColor.DARK_GREEN+t.getName()+"'s " + ChatColor.GREEN+"workbench."));
								t.openInventory(Bukkit.getServer().createInventory(t, InventoryType.WORKBENCH, t.getName() + "'s Workbench"));
							}
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
