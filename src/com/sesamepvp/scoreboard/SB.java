package com.sesamepvp.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.sesamepvp.files.KitpvpFile;
import com.sesamepvp.files.MessageFile;
import com.sesamepvp.files.ReportsFile;
import com.sesamepvp.files.StaffmodeFile;
import com.sesamepvp.kitpvp.managers.KitListener;
import com.sesamepvp.main.SesameCore;
import com.sesamepvp.staffmode.StaffmodeManager;
import com.sesamepvp.staffmode.commands.StaffMode;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class SB implements Listener {
	KitpvpFile manager = KitpvpFile.getInstance();
	MessageFile messageconfig = MessageFile.getInstance();
	StaffmodeFile staffmodeconfig = StaffmodeFile.getInstance();
	ReportsFile reportsfile = ReportsFile.getInstance();
	
	
	
	SesameCore plugin;

	public SB(SesameCore instance) {
		plugin = instance;
	}
	
	

	public void updateScoreboard(Player player) {
		if (KitListener.kitselected.contains(player)) {
			KitpvpFile manager1 = KitpvpFile.getInstance();
			ScoreboardManager manager = Bukkit.getScoreboardManager();
			final Scoreboard board = manager.getNewScoreboard();
			final Objective objective = board.registerNewObjective("test", "dummy");

			objective.setDisplaySlot(DisplaySlot.SIDEBAR);
			objective.setDisplayName(Methods.format(Messages.prefix("")));

			Score score = objective.getScore(StaffmodeManager.format("&8&l&m-----------------"));
			score.setScore(10);

			Score score9 = objective.getScore(StaffmodeManager.format("&4&lKit:"));
			score9.setScore(9);

			StaffmodeManager.testkits(8,player, objective);

			Score score7 = objective.getScore(" ");
			score7.setScore(7);

			Score score6 = objective.getScore(StaffmodeManager.format("&4&lRank:"));
			score6.setScore(6);
			if (manager1.getData().getString(player.getUniqueId() + ".Rank") == null) {
				Score score5 = objective.getScore(StaffmodeManager.format(" &cNone"));
				score5.setScore(5);
			} else {
				Score score5 = objective
						.getScore(StaffmodeManager.format(" &c" + manager1.getData().getString(player.getUniqueId() + ".Rank")));
				score5.setScore(5);
			}
			Score score4 = objective.getScore("");
			score4.setScore(4);

			Score score3 = objective.getScore(StaffmodeManager.format("&4&lStats:"));
			score3.setScore(3);

			Score score2 = objective.getScore(
					StaffmodeManager.format(" &cKills:&r&4 " + manager1.getData().getInt(player.getUniqueId() + ".Kills")));
			score2.setScore(2);

			Score score1 = objective.getScore(
					StaffmodeManager.format(" &cDeaths: &r&4" + manager1.getData().getInt(player.getUniqueId() + ".Deaths")));
			score1.setScore(1);

			Score score0 = objective.getScore(StaffmodeManager.format("&8&l&m--------I--------"));
			score0.setScore(0);

			player.setScoreboard(board);
		} else if (StaffMode.staffmode.contains(player)) {
			@SuppressWarnings("unused")
			KitpvpFile manager1 = KitpvpFile.getInstance();
			ScoreboardManager manager = Bukkit.getScoreboardManager();
			final Scoreboard board = manager.getNewScoreboard();
			final Objective objective = board.registerNewObjective("test", "dummy");

			objective.setDisplaySlot(DisplaySlot.SIDEBAR);
			objective.setDisplayName(Messages.prefix(""));

			Score score = objective.getScore(StaffmodeManager.format("&8&l&m------------------"));
			score.setScore(7);
			Score score6 = objective.getScore(StaffmodeManager.format("&4&lStaff Mode: "));
			score6.setScore(6);

			if (StaffmodeManager.vanish.contains(player)) {
				Score score4 = objective.getScore(StaffmodeManager.format(" &cVanish: &aEnabled"));
				score4.setScore(5);
			} else {
				Score score4 = objective.getScore(StaffmodeManager.format(" &cVanish: &cDisabled"));
				score4.setScore(5);
			}

			if (StaffmodeManager.fly.contains(player)) {
				Score score3 = objective.getScore(StaffmodeManager.format(" &cFlight: &aEnabled"));
				score3.setScore(4);
			} else {
				Score score3 = objective.getScore(StaffmodeManager.format(" &cFlight: &cDisabled"));
				score3.setScore(4);
			}
			Score score2 = objective.getScore(StaffmodeManager.format(" &cGamemode: &a" + player.getGameMode()));
			score2.setScore(3);

			Score score0 = objective.getScore(StaffmodeManager.format("&8&l&m--------I--------"));
			score0.setScore(0);

			player.setScoreboard(board);
		} else {
			KitpvpFile manager1 = KitpvpFile.getInstance();
			ScoreboardManager manager = Bukkit.getScoreboardManager();
			final Scoreboard board = manager.getNewScoreboard();
			final Objective objective = board.registerNewObjective("test", "dummy");

			objective.setDisplaySlot(DisplaySlot.SIDEBAR);
			objective.setDisplayName(Messages.prefix(""));

			Score score = objective.getScore(StaffmodeManager.format("&8&l&m------------------"));
			score.setScore(10);

			Score score7 = objective.getScore("");
			score7.setScore(7);

			Score score6 = objective.getScore(StaffmodeManager.format("&4&lRank:"));
			score6.setScore(6);
			if (manager1.getData().getString(player.getName() + ".Rank") == null) {
				Score score5 = objective.getScore(StaffmodeManager.format(" &cNone"));
				score5.setScore(5);
			} else {
				Score score5 = objective
						.getScore(StaffmodeManager.format(" &c" + manager1.getData().getString(player.getUniqueId() + ".Rank")));
				score5.setScore(5);
			}
			Score score4 = objective.getScore("");
			score4.setScore(4);

			Score score3 = objective.getScore(StaffmodeManager.format("&4&lStats:"));
			score3.setScore(3);

			Score score2 = objective.getScore(
					StaffmodeManager.format(" &cKills:&r&4 " + manager1.getData().getInt(player.getUniqueId() + ".Kills")));
			score2.setScore(2);

			Score score1 = objective.getScore(
					StaffmodeManager.format(" &cDeaths: &r&4" + manager1.getData().getInt(player.getUniqueId() + ".Deaths")));
			score1.setScore(1);

			Score score0 = objective.getScore(StaffmodeManager.format("&8&l&m--------I--------"));
			score0.setScore(0);

			player.setScoreboard(board);
		}
	}

	public void add(final Player player) {
		BukkitScheduler Scheduler = Bukkit.getServer().getScheduler();
		Scheduler.scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				updateScoreboard(player);
				
				manager.reloadData();
				manager.saveData();
				
				messageconfig.reloadData();
				messageconfig.saveData();
			
				reportsfile.reloadData();
				reportsfile.saveData();
				
				staffmodeconfig.reloadData();
				staffmodeconfig.saveData();
			}
		}, 0, 5);
	}

	@EventHandler
	public void PlayerJoinEvent(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		this.add(p);
	}

}
