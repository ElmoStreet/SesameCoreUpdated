package com.sesamepvp.essentials.commands.Locations.spawn;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.files.KitpvpFile;
import com.sesamepvp.utilites.Messages;

public class Setspawn implements CommandExecutor {
	KitpvpFile manager = KitpvpFile.getInstance();

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
			if(cmd.getName().equalsIgnoreCase("setspawn")){
				Player p = (Player) sender;
				if(p.hasPermission("core.setspawn")){
					p.sendMessage(Messages.spawnSet());
					this.manager.getData().set("Spawn", p.getLocation());
					this.manager.saveData();
					this.manager.saveConfig();
				}else{
					p.sendMessage(Messages.noPermission());
				}
			}
			return true;
	}
}
