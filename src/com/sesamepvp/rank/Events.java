package com.sesamepvp.rank;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.sesamepvp.files.Rankfile;
import com.sesamepvp.main.SesameCore;

public class Events implements Listener {
	SesameCore instance;
	public Events(SesameCore instance){
		this.instance = instance;
	}
	Rankfile rf = Rankfile.getInstance();
	
	
	@EventHandler
	public void onTalk(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String playerrank = RankManager.getRank(p);
		String rankprefix = RankManager.getPrefix(playerrank);
		if (playerrank == null) {
			return;
		} else {
			p.setDisplayName(rankprefix + ChatColor.RESET + " " + p.getName());
		}
		
		
		
	}
}
