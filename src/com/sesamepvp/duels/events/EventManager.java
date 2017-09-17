package com.sesamepvp.duels.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.sesamepvp.duels.arena.ArenaManager;
import com.sesamepvp.tokens.TokenManager;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class EventManager implements Listener{
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e){
		if(ArenaManager.duel.containsKey(e.getPlayer())){
			e.setCancelled(true);
			e.getPlayer().sendMessage(ChatColor.RED+"Commands not allowed in duels!");
		}
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e){
		if(ArenaManager.inArena(e.getPlayer())){
			Player winner = ArenaManager.duel.get(e.getPlayer());
			ArenaManager.endDuel(e.getPlayer(), winner, ArenaManager.getArena(e.getPlayer()));
			TokenManager.addBalance(winner, 15); 
			winner.sendMessage(Messages.prefix(Methods.format("&aYou have won the duel!")));
			winner.sendMessage(Messages.prefix(Methods.format("&aYou have been rewarded 15 tokens!")));
		}else{
			return;
		}
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player p = (Player) e.getEntity();
		Player k = (Player) p.getKiller();
		if(p instanceof Player){
			if(ArenaManager.inArena(p)){
				ArenaManager.endDuel(p, k, ArenaManager.getArena(p));
				TokenManager.addBalance(k, 15); 
				k.sendMessage(Messages.prefix(Methods.format("&aYou have won the duel!")));
				k.sendMessage(Messages.prefix(Methods.format("&aYou have been rewarded 15 tokens!")));
			}else{
				return;
			}
		}else{
			return;
		}
	}
}
