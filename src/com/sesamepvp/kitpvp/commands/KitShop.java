package com.sesamepvp.kitpvp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.sesamepvp.kitpvp.gui.KitShopGUI;
import com.sesamepvp.utilites.Messages;

public class KitShop implements CommandExecutor, Listener {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("kitshop")) {
			Player p = (Player) sender;

			sender.sendMessage(Messages.openKitShop());
			KitShopGUI.openKitshop(p);

		}

		return true;

	}

}
