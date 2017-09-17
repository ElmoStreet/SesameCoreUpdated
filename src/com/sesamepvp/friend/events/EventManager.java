package com.sesamepvp.friend.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.sesamepvp.friend.managers.FriendManager;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class EventManager implements Listener{
	
	@EventHandler
	public static void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		for(Player o : Bukkit.getOnlinePlayers()){
			if(FriendManager.isFriendsWith(o, p)){
				o.sendMessage(Messages.prefix(Methods.format("&aFriend &e" + p.getName() + " &ahas joined!")));
			}else{
				return;
			}
		}
	}
}
