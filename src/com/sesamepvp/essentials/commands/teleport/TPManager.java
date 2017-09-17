package com.sesamepvp.essentials.commands.teleport;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class TPManager {
private static HashMap<Player, Player> request = new HashMap<Player, Player>();
	
	public static void setPlayerRequest(Player sender, Player receiver) {
		if(request.containsKey(sender)) {
			request.remove(sender);
		}
		request.put(sender, receiver);
	}
	public static Player getPlayerRequest(Player player) {
		return request.get(player);
	}
	public static Player getSender(Player player) {
		for(Player entry : request.keySet()) {
			return entry;
		}
		return null;
	}
}
