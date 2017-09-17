package com.sesamepvp.staffmode.gui.miner;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.sesamepvp.staffmode.gui.Miner;
import com.sesamepvp.utilites.Methods;

public class MinerManager {
	static int slotmax = 0;
	public static ArrayList<String> mining = new ArrayList<String>();

	public static float getPlayerY(Player p) {
		float y = p.getLocation().getBlockY();
		return y;
	}

	public static boolean yUnderRequirements(Player p) {
		if (getPlayerY(p) <= 20) {
			if (mining.contains(p.getName())) {
				return false;
			} else {
				newMiner(p, Miner.minerGUI, slotmax-1);
				mining.add(p.getName());
				return true;
			}
		} else {
			if (mining.contains(p.getName())) {
				mining.remove(p.getName());
				removeMiner(Miner.minerGUI, slotmax-1);
			}
			return false;
		}
	}

	public static void newMiner(Player p, Inventory i, int slot) {
		ItemStack item = new ItemStack(Material.IRON_PICKAXE, 1);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(Methods.format(""+ p.getName()));
		List<String> lore = new ArrayList<String>();
		lore.add("§8-------------------------");
		lore.add(" §7 Location:");
		lore.add(" §7  X: §8" + p.getLocation().getBlockX());
		lore.add(" §7  Y: §8" + p.getLocation().getBlockY());
		lore.add(" §7  Z: §8" + p.getLocation().getBlockZ());
		lore.add("§8-------------------------");
		lore.add(" §7Click to teleport!");
		lore.add("§8-------------------------");

		itemmeta.setLore(lore);
		item.setItemMeta(itemmeta);
		if(slotmax > slot){
			i.setItem(slotmax, item);
		}else{
			i.setItem(slot, item);
		}
		slotmax++;
	}

	public static void removeMiner(Inventory i, int slot) {
		ItemStack item = new ItemStack(Material.AIR, 1);
		i.setItem(slot, item);
		slotmax--;
	}
}
