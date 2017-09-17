package com.sesamepvp.files;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

public class PunishmentGUIFile {
	static PunishmentGUIFile instance = new PunishmentGUIFile();
	Plugin p;
	FileConfiguration config;
	File cfile;
	FileConfiguration data;
	public static File pfile;

	public static PunishmentGUIFile getInstance() {
		return instance;
	}

	// commit 2
	public void setup(Plugin p) {
		this.cfile = new File(p.getDataFolder(), "config.yml");
		this.config = p.getConfig();
		if (!p.getDataFolder().exists()) {
			p.getDataFolder().mkdir();
		}
			File path = new File(p.getDataFolder() + File.separator + "/GUI");
		    File pfile = new File(path, "punish.yml");
		if (!pfile.exists()) {
			try {
				path.mkdirs();
				pfile.createNewFile();
				
			} catch (IOException e) {
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create punishgui.yml!");
			}
		}
		this.data = YamlConfiguration.loadConfiguration(pfile);
	}

	public FileConfiguration getData() {
		return this.data;
	}

	public void saveData() {
		try {
			this.data.save(pfile);
		} catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save punishgui.yml!");
		}
	}

	public void reloadData() {
		this.data = YamlConfiguration.loadConfiguration(pfile);
	}

	public FileConfiguration getConfig() {
		return this.config;
	}

	public void saveConfig() {
		try {
			this.config.save(this.cfile);
		} catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save config.yml!");
		}
	}

	public void reloadConfig() {
		this.config = YamlConfiguration.loadConfiguration(this.cfile);
	}

	public PluginDescriptionFile getDesc() {
		return this.p.getDescription();
	}
}
