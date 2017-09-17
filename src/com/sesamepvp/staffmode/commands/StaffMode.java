package com.sesamepvp.staffmode.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.sesamepvp.kitpvp.managers.KitListener;
import com.sesamepvp.staffmode.StaffmodeManager;
import com.sesamepvp.utilites.Messages;

public class StaffMode implements CommandExecutor {

	public static Map<Player, ItemStack[]> pArmor = new HashMap<Player, ItemStack[]>();
	public static Map<Player, ItemStack[]> pItems = new HashMap<Player, ItemStack[]>();
	public static ArrayList<Player> staffmode = new ArrayList<Player>();

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("mod")) {
			Player p = (Player) sender;
			if (sender instanceof Player) {
				if (p.hasPermission("core.staffmode")) {
					if (staffmode.contains(p)) {
						if (KitListener.kitselected.contains(p)) {
							KitListener.kitselected.remove(p);
						}
						p.getInventory().clear();
						staffmode.remove(p);
						StaffmodeManager.fly.remove(p);
						StaffmodeManager.Fly(p);
						StaffmodeManager.vanish.remove(p);
						StaffmodeManager.Vanish(p);
						if (pItems.containsKey(p)) {
							p.getInventory().setContents((ItemStack[]) pItems.get(p));
						}
						if (pArmor.containsKey(p)) {
							p.getInventory().setArmorContents((ItemStack[]) pArmor.get(p));
						}
						p.sendMessage(Messages.modDisabled());
					} else {
						staffmode.add(p);

						pArmor.put(p, p.getInventory().getArmorContents());
						pItems.put(p, p.getInventory().getContents());
						StaffmodeManager.fly.add(p);
						StaffmodeManager.Fly(p);
						StaffmodeManager.vanish.add(p);
						StaffmodeManager.Vanish(p);

						p.sendMessage(Messages.modEnabled());

						StaffmodeManager.giveItems(p);
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
