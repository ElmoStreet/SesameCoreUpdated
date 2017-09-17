package com.sesamepvp.essentials.msg;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class MessageManager {
	public static HashMap<Player,Player> inconvo = new HashMap<Player,Player>();
	
	public static void newConvo(Player p, Player t){
		inconvo.remove(p);
		inconvo.remove(t);
		inconvo.put(p, t);
		return;
	}
	
	public static Player getRecepient(Player p){
		return inconvo.get(p);
	}
	
	public static void removeRecepients(Player p, Player t){
		inconvo.remove(t);
		inconvo.remove(p);
		return;
	}
}
