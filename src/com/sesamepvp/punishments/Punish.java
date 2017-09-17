package com.sesamepvp.punishments;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import com.sesamepvp.files.PunishmentGUIFile;
import com.sesamepvp.punishments.GUI.PunishGUI;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class Punish implements CommandExecutor {
	PunishmentGUIFile pfg = PunishmentGUIFile.getInstance();

	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("punish")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (p.hasPermission("core.punish")) {
					if (args.length == 0) {
						p.sendMessage(Messages.prefix(Methods.format("&aUsage: /punish <player> <reason>")));
					} else {
						if (args.length == 1) {
							p.sendMessage(Messages.prefix(Methods.format("&aUsage: /punish <player> <reason>")));
						} else {

							StringBuilder sb = new StringBuilder();

							for (int i = 1; i < args.length; i++) {
								sb.append(args[i] + " ");
							}
							Player t = Bukkit.getPlayer(args[0]);
							if (t == null) {
								p.sendMessage(Messages.playerNull());
							} else {
								ItemStack playerhead = new ItemStack(Material.SKULL_ITEM, 1,
										(short) SkullType.PLAYER.ordinal());
								SkullMeta playerheadm = (SkullMeta) playerhead.getItemMeta();
								playerheadm.setOwner(t.getName());
								playerheadm.setDisplayName(Methods.format(t.getName()));
								List<String> playerheadlore = new ArrayList<String>();
								playerheadlore.add(Methods.format("&aReason:"));
								playerheadlore.add(Methods.format("&r&f" + sb.toString()));
								playerheadm.setLore(playerheadlore);
								playerhead.setItemMeta(playerheadm);

								PunishGUI.punish.setItem(4, playerhead);
								PunishGUI.openGUI(p, t);

							}
						}
					}
				} else {
					p.sendMessage(Messages.noPermission());
				}
			} else {
				sender.sendMessage(Messages.notPlayer());
			}
		}
		return true;
	}
}
