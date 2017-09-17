package com.sesamepvp.essentials.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.utilites.Messages;

public class List implements CommandExecutor {

	public static ArrayList<String> playercount = new ArrayList<String>();
	public static ArrayList<String> onlinestaff = new ArrayList<String>();

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("list")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				
				p.sendMessage("§8§m-----------------------------");
				
				p.sendMessage("§cPlayers : §8[§a" + playercount.size() + "§8/§a"+ Bukkit.getServer().getMaxPlayers()+"§8]");
				p.sendMessage("§cOnline Staff :");
				p.sendMessage("§a" + onlinestaff.toString());
				
				p.sendMessage("§c§lSesame§f§lPvP §8>>");
				p.sendMessage("      §cStore - §asesamepvp.buycraft.net");
				p.sendMessage("      §eWebsite - §asesamepvp.enjin.com");
				
				p.sendMessage("§8§m-----------------------------");
			} else {
				sender.sendMessage(Messages.notPlayer());
			}
		}
		return true;
	}
}
