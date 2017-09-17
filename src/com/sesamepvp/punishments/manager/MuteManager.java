package com.sesamepvp.punishments.manager;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.sesamepvp.files.PunishmentsFile;
import com.sesamepvp.punishments.Tempban;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class MuteManager implements Listener {
	static PunishmentsFile pf = PunishmentsFile.getInstance();
	public static boolean ismuted = false;

	public static boolean isMuted(Player p) {
		if (pf.getData().getBoolean("Mutes." + p.getUniqueId() + ".muted") == true) {
			ismuted = true;
		} else {
			ismuted = false;
		}
		return ismuted;
	}

	public static void mutePlayer(CommandSender sender, Player target) {
		if (isMuted(target) == true) {
			sender.sendMessage(Messages.prefix(Methods.format("&cThat player is already muted.")));
		} else {
			pf.getData().set("Mutes." + target.getUniqueId() + ".muted", true);
			pf.getData().set("Mutes." + target.getUniqueId() + ".muter", sender.getName());
			target.sendMessage(Messages.prefix(Methods.format("&aYou have been muted by &2" + sender.getName())));
			sender.sendMessage(Messages.prefix(Methods.format("&cYou muted &a" + target.getName() + "&c.")));
			pf.saveData();
		}
	}

	public static void unmutePlayer(CommandSender p, Player target) {
		if (isMuted(target) == true) {
			pf.getData().set("Mutes." + target.getUniqueId() + ".muted", false);
			pf.getData().set("Mutes." + target.getUniqueId() + ".time", null);
			pf.getData().getConfigurationSection("Mutes." + target.getUniqueId()).set("Mutes." + target.getUniqueId(),
					null);
			;
			target.sendMessage(Messages.prefix(Methods.format("&aYou have been unmuted by &2" + p.getName())));
			p.sendMessage(Messages.prefix(Methods.format("&cYou unmuted &a" + target.getName() + "&c.")));
			pf.saveData();
		} else {
			p.sendMessage(Messages.prefix(Methods.format("&cThat player is not muted.")));
		}
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		int seconds = pf.getData().getInt("Mutes." + p.getUniqueId() + ".time");
		if (isMuted(p) == true && pf.getData().get("Mutes." + p.getUniqueId() + ".time") != null) {

			e.setCancelled(true);
			p.sendMessage(
					Messages.prefix(Methods.format("&cYou are currently muted for &4" + Tempban.formatTime(seconds))));
		} else {
			if (isMuted(p) == true) {
				e.setCancelled(true);
				p.sendMessage(Messages.prefix(Methods.format("&cYou are currently muted!")));
			}
		}
	}
}
