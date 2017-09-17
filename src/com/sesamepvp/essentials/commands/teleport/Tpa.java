package com.sesamepvp.essentials.commands.teleport;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class Tpa implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("tpa")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if(args.length == 0){
					p.sendMessage(Messages.prefix(Methods.format("&cUsage: /tpa <player>")));
				}else{
					if(args.length == 1){
						Player t = Bukkit.getPlayer(args[0]);
						if(t == null){
							p.sendMessage(Messages.playerNull());
						}else{
							TPManager.setPlayerRequest(p, t);
							t.sendMessage(Messages.prefix(Methods.format("&aYou have recieved a teleport request from &2" + p.getName())));
							t.sendMessage(Messages.prefix(Methods.format("&a Type /tpaccept to accept, or ignore this request to deny!")));
							p.sendMessage(Messages.prefix(Methods.format("&aRequest sent to &2" + t.getName())));
						}
					}
				}
			} else {
				sender.sendMessage(Messages.notPlayer());
			}
		}
		return false;
	}
}
