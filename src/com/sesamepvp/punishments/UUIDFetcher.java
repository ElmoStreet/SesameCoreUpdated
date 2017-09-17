package com.sesamepvp.punishments;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class UUIDFetcher {
	public static OfflinePlayer getPlayer(String uuid) {
		return Bukkit.getOfflinePlayer(UUID.fromString(uuid));
	}

	public static UUID getOfflineUUID(String player) {
		return UUID.nameUUIDFromBytes(player.getBytes());
	}

	public static UUID getOnlineUUID(String player) {
		UUID uuid = null;
		for (OfflinePlayer offlineplayer : Bukkit.getOfflinePlayers()) {
			if (offlineplayer.getName() == player) {
				uuid = offlineplayer.getUniqueId();
			}
		}
		for (Player onlineplayer : Bukkit.getOnlinePlayers()) {
			if (onlineplayer.getName() == player) {
				uuid = onlineplayer.getUniqueId();
			}
		}
		return uuid;
	}
}