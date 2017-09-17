package com.sesamepvp.utilites;

import org.bukkit.ChatColor;

public class Methods {
	public static String format(String format) {
		return ChatColor.translateAlternateColorCodes('&', format);
	}

	public static String config(String format) {
		return format.replace("§", "&");
	}
}
