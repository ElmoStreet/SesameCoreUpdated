package com.sesamepvp.staffmode.events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.sesamepvp.files.StaffmodeFile;
import com.sesamepvp.staffmode.StaffmodeManager;
import com.sesamepvp.staffmode.commands.StaffMode;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class VanishEvent implements Listener {
	StaffmodeFile sfm = StaffmodeFile.getInstance();

	@EventHandler
	public void onVanish(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((p.getItemInHand().getType() == Material.getMaterial(sfm.getData().getString("Vanish.material")))
				&& (StaffMode.staffmode.contains(p))
				&& ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))) {
			if (StaffmodeManager.vanish.contains(p)) {

				p.getInventory().remove(Material.getMaterial(sfm.getData().getString("Vanish.material")));
				ItemStack grayinksack = new ItemStack(
						Material.getMaterial(sfm.getData().getString("Vanish.toggled.material")), 1,
						(short) sfm.getData().getInt("Vanish.toggled.data"));
				ItemMeta grayinksackim = grayinksack.getItemMeta();
				List<String> lore = new ArrayList<String>();
				for(String output : sfm.getData().getStringList("Vanish.lore")){
					lore.add(Methods.format(output));
				}
				grayinksackim.setLore(lore);
				grayinksackim.setDisplayName(Methods.format(sfm.getData().getString("Vanish.toggled.displayname")));
				grayinksack.setItemMeta(grayinksackim);
				p.getInventory().setItem(sfm.getData().getInt("Vanish.slot"), grayinksack);
				p.sendMessage(Messages.vanishDisabled());
				for (Player online : Bukkit.getOnlinePlayers()) {

					online.showPlayer(p);

				}

				StaffmodeManager.vanish.remove(p);
			} else if (!StaffmodeManager.vanish.contains(p)) {

				p.getInventory().remove(Material.getMaterial(sfm.getData().getString("Vanish.toggled.material")));
				ItemStack greeninksack = new ItemStack(Material.getMaterial(sfm.getData().getString("Vanish.material")),
						1, (short) sfm.getData().getInt("Vanish.data"));
				ItemMeta greeninksackim = greeninksack.getItemMeta();
				greeninksackim.setDisplayName(Methods.format(sfm.getData().getString("Vanish.displayname")));
				greeninksack.setItemMeta(greeninksackim);
				p.getInventory().setItem(sfm.getData().getInt("Vanish.slot"), greeninksack);
				p.sendMessage(Messages.vanishEnabled());

				for (Player online : Bukkit.getOnlinePlayers()) {
					if (online.hasPermission("sesame.bypassvanish")) {
						online.showPlayer(p);
					} else {
						online.hidePlayer(p);
					}
				}

				StaffmodeManager.vanish.add(p);

			}
		}
	}
}
