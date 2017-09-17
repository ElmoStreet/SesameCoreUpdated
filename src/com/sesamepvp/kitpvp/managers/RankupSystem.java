package com.sesamepvp.kitpvp.managers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.sesamepvp.files.KitpvpFile;
import com.sesamepvp.staffmode.StaffmodeManager;
import com.sesamepvp.tokens.TokenManager;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class RankupSystem implements Listener {

	KitpvpFile manager = KitpvpFile.getInstance();

	@EventHandler
	public void death(PlayerDeathEvent e) {

		e.getDrops().clear();

	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		Player k = e.getEntity().getKiller();

		if (KitListener.kitselected.contains(p)) {
			KitListener.kitselected.remove(p);
		}

		if(k == null){
			this.manager.getData().set(p.getUniqueId() + ".Deaths",
					this.manager.getData().getInt(p.getUniqueId() + ".Deaths") + 1);
			this.manager.saveData();
		}
		
		if (e.getEntity() instanceof Player && k instanceof Player) {
			if (KitListener.kitselected.contains(p)) {
				KitListener.kitselected.remove(p);
			}
			this.manager.getData().set(k.getUniqueId() + ".Kills",
					this.manager.getData().getInt(k.getUniqueId() + ".Kills") + 1);
			this.manager.saveData();
			if (k.getName() == p.getName() || p.getName() == k.getName()) {
				return;
			} else {
				StaffmodeManager.cmd("eco give " + k.getName() + " 10");
			}
		} else {
			return;
		}
	}

	
	@EventHandler
	public void onDeath2(PlayerDeathEvent e) {
		Player p = e.getEntity();
		Player k = p.getKiller();

		if (k instanceof Player && p instanceof Player) {
			int killCounter = this.manager.getData().getInt(
					k.getUniqueId() + ".Kills");

			TokenManager.addBalance(k, 5);
			
			// WARRIOR 5
			if (killCounter == 150) {
				Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(),
						"pex user " + k.getName() + " add kits.warrior");
				Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(),
						"pex user " + k.getName() + " suffix &f[&bWarrior&f]");
				Bukkit.broadcastMessage(Messages.prefix(ChatColor.GREEN + ""
						+ k.getName() + "has reached the Warrior Rank!"));
				this.manager.getData().set(k.getUniqueId() + ".Rank", "Warrior");
				this.manager.saveData();
			}

			// Gladiator 15
			if (killCounter == 350) {
				Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(),
						"pex user " + k.getName() + " suffix &f[&1Gladiator&f]");

				Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(),
						"pex user " + k.getName() + " add kits.gladiator");

				Bukkit.broadcastMessage(Messages.prefix(ChatColor.GREEN + ""
						+ k.getName() + "has reached the Gladiator Rank!"));
				this.manager.getData().set(k.getUniqueId() + ".Rank", "Gladiator");
				this.manager.saveData();
			}
			// Guardian 30
			if (killCounter == 750) {
				Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(),
						"pex user " + k.getName() + " suffix &f[&6Guardian&f]");

				Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(),
						"pex user " + k.getName() + " add kits.guardian");
				Bukkit.broadcastMessage(Messages.prefix(ChatColor.GREEN + ""
						+ k.getName() + "has reached the Guardian Rank!"));
				this.manager.getData().set(k.getUniqueId() + ".Rank", "Guardian");
				this.manager.saveData();
			}
			// Berserk 60
			if (this.manager.getData().getInt(k.getUniqueId() + ".Kills") == 1249) {
				Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(),
						"pex user " + k.getName() + " suffix &f[&aBerserk&f]");

				Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(),
						"pex user " + k.getName() + " add kits.berserk");

				Bukkit.broadcastMessage(Messages.prefix(ChatColor.GREEN + ""
						+ k.getName() + "has reached the Berserk Rank!"));
				this.manager.getData().set(k.getUniqueId() + ".Rank", "Berserk");
				this.manager.saveData();
			}

			// Legend 100
			if (this.manager.getData().getInt(k.getUniqueId() + ".Kills") == 1749) {
				Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(),
						"pex user " + k.getName() + " suffix &f[&3Legend&f]");

				Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(),
						"pex user " + k.getName() + " add kits.legend");
				Bukkit.broadcastMessage(Messages.prefix(ChatColor.GREEN + ""
						+ k.getName() + "has reached the Legend Rank!"));
				this.manager.getData().set(k.getUniqueId() + ".Rank", "Legend");
				this.manager.saveData();
			}
			// DEMI GOD 250
			if (this.manager.getData().getInt(k.getUniqueId() + ".Kills") == 2249) {
				Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(),
						"pex user " + k.getName() + " suffix &f[&cDemi-God&f]");

				Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(),
						"pex user " + k.getName() + " add kits.demigod");
				Bukkit.broadcastMessage(Messages.prefix(ChatColor.GREEN+""+k.getName()+"has reached the Demi God Rank!"));
				this.manager.getData().set(k.getUniqueId() + ".Rank", "DemiGod");
				this.manager.saveData();
			}

			// God 500
			if (this.manager.getData().getInt(k.getUniqueId() + ".Kills") == 3499) {
				Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(),
						"pex user " + k.getName() + " suffix &f[&4God&f]");

				Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(),
						"pex user " + k.getName() + " add kits.god");
				Bukkit.broadcastMessage(Messages.prefix(ChatColor.GREEN+""+k.getName()+"has reached the God Rank!"));
				this.manager.getData().set(k.getUniqueId() + ".Rank", "God");
				this.manager.saveData();
				
				this.manager.getData().set(k.getUniqueId() + ".Quests.Justice", true);
				p.getKiller().sendMessage(Messages.prefix(Methods
						.format("&aQUESTS: &dYou completed the &5Justice &dQuest!")));
				this.manager.saveData();
				TokenManager.addBalance(p.getKiller(), 2500);
				
			}
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		if (this.manager.getData().getBoolean(p.getName() + ".Kits.Speedy") == true) {

			return;
		} else {

			this.manager.getData().set(p.getName() + ".Kits.Speedy", false);
			this.manager.saveData();

		}

		this.manager.getData().set(p.getName() + ".Kits.Speedy", false);

		e.setJoinMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+"
				+ ChatColor.GRAY + "]" + ChatColor.GREEN + " " + p.getName());
	}

	@EventHandler
	public void onQUIT(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage(ChatColor.GRAY + "[" + ChatColor.RED + "-"
				+ ChatColor.GRAY + "]" + ChatColor.RED + " " + p.getName());
	}

}
