package com.sesamepvp.staffmode.events;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.sesamepvp.files.StaffmodeFile;
import com.sesamepvp.staffmode.commands.StaffMode;
import com.sesamepvp.utilites.Messages;


public class RandomTeleport implements Listener {
	StaffmodeFile sfm = StaffmodeFile.getInstance();
	@EventHandler
	public void onItemInteraction(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Random r = new Random();
		ArrayList<Player> players = new ArrayList<Player>();
		if (e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_AIR) {

			if (p.getItemInHand().getType() == Material.getMaterial(sfm.getData().getString("RandomTP.material"))&& StaffMode.staffmode.contains(p)) {
				for (Player online : Bukkit.getServer().getOnlinePlayers()) {
					players.add(online);
					if (players.contains(p)) {
						players.remove(p);
					}
				}
				if (players.size() == 0) {
					p.sendMessage(Messages.notenoughPlayers());
				} else {
					int index = r.nextInt(players.size());
					Player loc = (Player) players.get(index);
					p.teleport(loc);
					p.sendMessage(Messages.randomteleportedTo(loc));
				}
			} else {
				return;
			}
		}
	}
}
