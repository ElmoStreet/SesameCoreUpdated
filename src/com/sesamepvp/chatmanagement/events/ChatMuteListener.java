package com.sesamepvp.chatmanagement.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.sesamepvp.chatmanagement.commands.ChatMute;
import com.sesamepvp.staffmode.StaffmodeManager;
import com.sesamepvp.utilites.Messages;

public class ChatMuteListener implements Listener{
	
	@EventHandler
	public void onTalk(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		if(ChatMute.chatmuted == true){
			if(p.hasPermission("core.mod") || p.isOp()){
				e.setCancelled(false);
			}else{
				e.setCancelled(true);
				p.sendMessage(Messages.talkDenied());
			}
		}		
		e.setFormat(p.getDisplayName()+ "§8 : §r" + StaffmodeManager.format(e.getMessage()));
	}
}
