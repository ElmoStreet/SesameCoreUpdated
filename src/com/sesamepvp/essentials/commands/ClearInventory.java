package com.sesamepvp.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.staffmode.StaffmodeManager;
import com.sesamepvp.staffmode.gui.Miner;
import com.sesamepvp.utilites.Messages;

public class ClearInventory implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(cmd.getName().equalsIgnoreCase("ci") || cmd.getName().equalsIgnoreCase("clear") || cmd.getName().equalsIgnoreCase("clearinventory")){
			Player p = (Player) sender;
			if(sender instanceof Player){
				if(p.hasPermission("core.clearinventory") || p.isOp()){
					Miner.gui(p);
					if(args.length == 0){
						p.sendMessage(Messages.clearedInventory());
						p.getInventory().clear();
						StaffmodeManager.clearArmor(p);
					}else{
						if(args.length == 1){
							Player t = Bukkit.getServer().getPlayer(args[0]);
							if(t == null){
								p.sendMessage(Messages.playerNull());
							}else{
								t.getInventory().clear();
								StaffmodeManager.clearArmor(t);
								t.sendMessage(Messages.clearedInventory());
								p.sendMessage(Messages.playerClearedInventory(t));
							}
						}else{
							p.sendMessage(Messages.clearinventoryUsage());
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
