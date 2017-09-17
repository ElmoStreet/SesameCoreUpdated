package com.sesamepvp.kitpvp.quests.GUI;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.sesamepvp.files.KitpvpFile;
import com.sesamepvp.kitpvp.quests.quests.Bloodthirsty;
import com.sesamepvp.kitpvp.quests.quests.Hunter;
import com.sesamepvp.kitpvp.quests.quests.Justice;
import com.sesamepvp.kitpvp.quests.quests.Professional;
import com.sesamepvp.kitpvp.quests.quests.Scavenger;

public class QuestGUI {
	static KitpvpFile manager = KitpvpFile.getInstance();
	static Hunter Hunter = new Hunter();
	static Bloodthirsty Bloodthirsty = new Bloodthirsty();
	static Scavenger Scavenger = new Scavenger();
	static Justice Justice = new Justice();
	static Professional Professional = new Professional();
	public static Inventory quests = Bukkit.createInventory(null, 36, "Quests");

	public static void openQuestGUI(Player p) {
		boolean HunterQuest = manager.getData().getBoolean(
				p.getName() + ".Quests.Hunter");
		boolean BloodthirstyQuest = manager.getData().getBoolean(
				p.getName() + ".Quests.Bloodthirsty");
		boolean ProfessionalQuest = manager.getData().getBoolean(
				p.getName() + ".Quests.Professional");
		boolean JusticeQuest = manager.getData().getBoolean(
				p.getName() + ".Quests.Justice");
		boolean ScavengerQuest = manager.getData().getBoolean(
				p.getName() + ".Quests.Scavenger");

		if (HunterQuest == true) {
			ItemStack hunterquest = new ItemStack(Material.STAINED_GLASS_PANE,
					1, (short) 5);
			ItemMeta hunterquestm = hunterquest.getItemMeta();
			hunterquestm.setDisplayName(ChatColor.RED + "Hunter Quest");
			List<String> hunterquestlore = new ArrayList<String>();
			hunterquestlore.add(ChatColor.DARK_GRAY + ""
					+ ChatColor.STRIKETHROUGH + "--------------");
			hunterquestlore.add(ChatColor.GREEN + "Complete!");
			hunterquestlore.add(ChatColor.DARK_GRAY + ""
					+ ChatColor.STRIKETHROUGH + "--------------");
			hunterquestm.setLore(hunterquestlore);
			hunterquest.setItemMeta(hunterquestm);
			quests.setItem(19, hunterquest);
		} else {

			ItemStack hunterquest = new ItemStack(Material.STAINED_GLASS_PANE,
					1, (short) 14);
			ItemMeta hunterquestm = hunterquest.getItemMeta();
			hunterquestm.setDisplayName(ChatColor.RED + "Hunter Quest");
			List<String> hunterquestlore = new ArrayList<String>();
			hunterquestlore.add(ChatColor.DARK_GRAY + ""
					+ ChatColor.STRIKETHROUGH + "--------------");
			hunterquestlore.add(ChatColor.RED + "Incomplete!");
			hunterquestlore.add(ChatColor.DARK_GRAY + ""
					+ ChatColor.STRIKETHROUGH + "--------------");
			hunterquestm.setLore(hunterquestlore);
			hunterquest.setItemMeta(hunterquestm);
			quests.setItem(19, hunterquest);
		}

		if (BloodthirstyQuest == true) {
			ItemStack btq = new ItemStack(Material.STAINED_GLASS_PANE, 1,
					(short) 5);
			ItemMeta btqm = btq.getItemMeta();
			btqm.setDisplayName(ChatColor.RED + "Bloodthirsty Quest");
			List<String> btqlore = new ArrayList<String>();
			btqlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			btqlore.add(ChatColor.GREEN + "Complete!");
			btqlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			btqm.setLore(btqlore);
			btq.setItemMeta(btqm);
			quests.setItem(20, btq);
		} else {

			ItemStack btq = new ItemStack(Material.STAINED_GLASS_PANE, 1,
					(short) 14);
			ItemMeta btqm = btq.getItemMeta();
			btqm.setDisplayName(ChatColor.RED + "Bloodthirsty Quest");
			List<String> btqlore = new ArrayList<String>();
			btqlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			btqlore.add(ChatColor.RED + "Incomplete!");
			btqlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			btqm.setLore(btqlore);
			btq.setItemMeta(btqm);
			quests.setItem(20, btq);
		}

		if (ProfessionalQuest == true) {
			ItemStack pro = new ItemStack(Material.STAINED_GLASS_PANE, 1,
					(short) 5);
			ItemMeta prom = pro.getItemMeta();
			prom.setDisplayName(ChatColor.RED + "Professional Quest");
			List<String> prolore = new ArrayList<String>();
			prolore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			prolore.add(ChatColor.GREEN + "Complete!");
			prolore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			prom.setLore(prolore);
			pro.setItemMeta(prom);
			quests.setItem(21, pro);
		} else {

			ItemStack pro = new ItemStack(Material.STAINED_GLASS_PANE, 1,
					(short) 14);
			ItemMeta prom = pro.getItemMeta();
			prom.setDisplayName(ChatColor.RED + "Professional Quest");
			List<String> prolore = new ArrayList<String>();
			prolore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			prolore.add(ChatColor.RED + "Incomplete!");
			prolore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			prom.setLore(prolore);
			pro.setItemMeta(prom);
			quests.setItem(21, pro);
		}

		
		if (ScavengerQuest == true) {

			ItemStack s = new ItemStack(Material.STAINED_GLASS_PANE, 1,
					(short) 5);
			ItemMeta sm = s.getItemMeta();
			sm.setDisplayName(ChatColor.RED + "Scavenger Quest");
			List<String> slore = new ArrayList<String>();
			slore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			slore.add(ChatColor.GREEN + "Complete!");
			slore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			sm.setLore(slore);
			s.setItemMeta(sm);
			quests.setItem(21, s);
		} else {
			ItemStack s = new ItemStack(Material.STAINED_GLASS_PANE, 1,
					(short) 14);
			ItemMeta sm = s.getItemMeta();
			sm.setDisplayName(ChatColor.RED + "Scavenger Quest");
			List<String> slore = new ArrayList<String>();
			slore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			slore.add(ChatColor.RED + "Incomplete!");
			slore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			sm.setLore(slore);
			s.setItemMeta(sm);
			quests.setItem(21, s);
		}
		
		if (JusticeQuest == true) {
			ItemStack j = new ItemStack(Material.STAINED_GLASS_PANE, 1,
					(short) 5);
			ItemMeta jm = j.getItemMeta();
			jm.setDisplayName(ChatColor.RED + "Justice Quest");
			List<String> jlore = new ArrayList<String>();
			jlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			jlore.add(ChatColor.GREEN + "Complete!");
			jlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			jm.setLore(jlore);
			j.setItemMeta(jm);
			quests.setItem(22, j);
		} else {
			ItemStack j = new ItemStack(Material.STAINED_GLASS_PANE, 1,
					(short) 14);
			ItemMeta jm = j.getItemMeta();
			jm.setDisplayName(ChatColor.RED + "Justice Quest");
			List<String> jlore = new ArrayList<String>();
			jlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			jlore.add(ChatColor.RED + "Incomplete!");
			jlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			jm.setLore(jlore);
			j.setItemMeta(jm);
			quests.setItem(22, j);
		}

		ItemStack panel = new ItemStack(Material.STAINED_GLASS_PANE, 1,
				(short) 7);
		ItemMeta panelim = panel.getItemMeta();
		panelim.setDisplayName(ChatColor.RED + "");
		panel.setItemMeta(panelim);

		ItemStack close = new ItemStack(Material.WOOL, 1, (short) 14);
		ItemMeta closem = close.getItemMeta();
		closem.setDisplayName(ChatColor.RED + "Close");
		close.setItemMeta(closem);

		Hunter.applyQuest(quests, 10);
		Bloodthirsty.applyQuest(quests, 11);
		Scavenger.applyQuest(quests, 12);
		Justice.applyQuest(quests, 13);
		Professional.applyQuest(quests, 14);
		quests.setItem(0, panel);
		quests.setItem(1, panel);
		quests.setItem(2, panel);
		quests.setItem(3, panel);
		quests.setItem(4, panel);
		quests.setItem(5, panel);
		quests.setItem(6, panel);
		quests.setItem(7, panel);
		quests.setItem(8, close);
		quests.setItem(9, panel);
		quests.setItem(18, panel);
		quests.setItem(27, panel);
		quests.setItem(28, panel);
		quests.setItem(29, panel);
		quests.setItem(30, panel);
		quests.setItem(31, panel);
		quests.setItem(32, panel);
		quests.setItem(33, panel);
		quests.setItem(34, panel);
		quests.setItem(17, panel);
		quests.setItem(26, panel);
		quests.setItem(35, panel);

		p.openInventory(quests);
	}
}
