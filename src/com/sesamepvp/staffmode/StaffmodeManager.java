package com.sesamepvp.staffmode;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;

import com.sesamepvp.files.KitpvpFile;
import com.sesamepvp.files.StaffmodeFile;
import com.sesamepvp.utilites.Messages;

public class StaffmodeManager {
	public static ArrayList<Player> vanish = new ArrayList<Player>();
	public static ArrayList<Player> fly = new ArrayList<Player>();

	static KitpvpFile manager = KitpvpFile.getInstance();
	static StaffmodeFile smf = StaffmodeFile.getInstance();

	public static void clearArmor(Player p) {
		PlayerInventory pi = p.getInventory();
		pi.setBoots(new ItemStack(Material.AIR));
		pi.setChestplate(new ItemStack(Material.AIR));
		pi.setHelmet(new ItemStack(Material.AIR));
		pi.setLeggings(new ItemStack(Material.AIR));
		return;
	}

	public static void Vanish(Player p) {
		if (vanish.contains(p)) {
			for (Player online : Bukkit.getOnlinePlayers()) {
				if (online.hasPermission("core.bypassvanish")) {
					online.showPlayer(p);
				} else {
					online.hidePlayer(p);
				}
			}
		} else {
			
			for (Player online : Bukkit.getOnlinePlayers()) {
				online.showPlayer(p);
			}

		}
	}

	public static void Fly(Player p) {
		if (!fly.contains(p)) { // if contains
			p.setAllowFlight(false); // disable
		} else if (fly.contains(p)) { // if doesnt contain
			p.setAllowFlight(true); // enable
		}
	}

	public static void giveItems(Player p) {
		p.getInventory().clear();
		clearArmor(p);

		// Freeze Block
		ItemStack reportsgui = new ItemStack(Material.getMaterial(smf.getData().getString("Reports.material")), 1,
				(short) smf.getData().getInt("Reports.data"));
		ItemMeta reportsguiim = reportsgui.getItemMeta();
		ArrayList<String> reportlore = new ArrayList<String>();
		for(String output : smf.getData().getStringList("Reports.lore")){
			reportlore.add(format(output));
		}
		reportsguiim.setLore(reportlore);
		reportsguiim.setDisplayName(format(smf.getData().getString("Reports.displayname")));
		reportsgui.setItemMeta(reportsguiim);

		// Inspection

		ItemStack inspect = new ItemStack(Material.getMaterial(smf.getData().getString("Inspect.material")), 1,
				(short) smf.getData().getInt("Inspect.data"));
		ItemMeta inspectim = inspect.getItemMeta();
		ArrayList<String> inspectlore = new ArrayList<String>();
		for(String output : smf.getData().getStringList("Inspect.lore")){
			inspectlore.add(format(output));
		}
		inspectim.setLore(inspectlore);
		inspectim.setDisplayName(format(smf.getData().getString("Inspect.displayname")));
		inspect.setItemMeta(inspectim);

		// Mover
		ItemStack compass = new ItemStack(Material.getMaterial(smf.getData().getString("Compass.material")), 1,
				(short) smf.getData().getInt("Compass.data"));
		ItemMeta compassim = compass.getItemMeta();
		ArrayList<String> compasslore = new ArrayList<String>();
		for(String output : smf.getData().getStringList("Compass.lore")){
			compasslore.add(format(output));
		}
		compassim.setLore(compasslore);
		compassim.setDisplayName(format(smf.getData().getString("Compass.displayname")));
		compass.setItemMeta(compassim);

		// Random Teleport
		ItemStack rtp = new ItemStack(Material.getMaterial(smf.getData().getString("RandomTP.material")), 1,
				(short) smf.getData().getInt("RandomTP.data"));
		ItemMeta rtpim = rtp.getItemMeta();
		ArrayList<String> rtplore = new ArrayList<String>();
		for(String output : smf.getData().getStringList("RandomTP.lore")){
			rtplore.add(format(output));
		}
		rtpim.setLore(rtplore);
		rtpim.setDisplayName(format(smf.getData().getString("RandomTP.displayname")));
		rtp.setItemMeta(rtpim);

		// Vanish
		ItemStack vanish = new ItemStack(Material.getMaterial(smf.getData().getString("Vanish.material")), 1,
				(short) smf.getData().getInt("Vanish.data"));
		ItemMeta vanishim = vanish.getItemMeta();
		ArrayList<String> vanishlore = new ArrayList<String>();
		for(String output : smf.getData().getStringList("Vanish.lore")){
			vanishlore.add(format(output));
		}
		vanishim.setLore(vanishlore);
		vanishim.setDisplayName(format(smf.getData().getString("Vanish.displayname")));
		vanish.setItemMeta(vanishim);

		// flight
		ItemStack flight = new ItemStack(Material.getMaterial(smf.getData().getString("Flight.material")), 1,
				(short) smf.getData().getInt("Flight.data"));
		ItemMeta flightim = flight.getItemMeta();
		ArrayList<String> flightlore = new ArrayList<String>();
		for(String output : smf.getData().getStringList("Flight.lore")){
			flightlore.add(format(output));
		}
		flightim.setLore(flightlore);
		flightim.setDisplayName(format(smf.getData().getString("Flight.displayname")));
		flight.setItemMeta(flightim);

		// flight
		ItemStack worldedit = new ItemStack(Material.getMaterial(smf.getData().getString("WorldEdit.material")), 1,
				(short) smf.getData().getInt("WorldEdit.data"));
		ItemMeta worldeditim = flight.getItemMeta();
		ArrayList<String> worldeditlore = new ArrayList<String>();
		for(String output : smf.getData().getStringList("WorldEdit.lore")){
			worldeditlore.add(format(output));
		}
		worldeditim.setLore(worldeditlore);
		worldeditim.setDisplayName(format(smf.getData().getString("WorldEdit.displayname")));
		worldedit.setItemMeta(worldeditim);
		
		ItemStack MinerGUI = new ItemStack(Material.getMaterial(smf.getData().getString("MinerGUI.material")), 1,
				(short) smf.getData().getInt("MinerGUI.data"));
		ItemMeta MinerGUIim = flight.getItemMeta();
		ArrayList<String> MinerGUIlore = new ArrayList<String>();
		for(String output : smf.getData().getStringList("MinerGUI.lore")){
			MinerGUIlore.add(format(output));
		}
		MinerGUIim.setLore(MinerGUIlore);
		MinerGUIim.setDisplayName(format(smf.getData().getString("MinerGUI.displayname")));
		MinerGUI.setItemMeta(MinerGUIim);

		p.getInventory().setItem(smf.getData().getInt("Compass.slot"), compass);
		p.getInventory().setItem(smf.getData().getInt("WorldEdit.slot"), worldedit);
		p.getInventory().setItem(smf.getData().getInt("Inspect.slot"), inspect);
		p.getInventory().setItem(smf.getData().getInt("Reports.slot"), reportsgui);
		p.getInventory().setItem(smf.getData().getInt("RandomTP.slot"), rtp);
		p.getInventory().setItem(smf.getData().getInt("Flight.slot"), flight);
		p.getInventory().setItem(smf.getData().getInt("Vanish.slot"), vanish);
		p.getInventory().setItem(smf.getData().getInt("MinerGUI.slot"), MinerGUI);
	}

	public static ArrayList<Player> pvp = new ArrayList<Player>();
	public static ArrayList<Player> archer = new ArrayList<Player>();
	public static ArrayList<Player> tank = new ArrayList<Player>();
	public static ArrayList<Player> golden = new ArrayList<Player>();
	public static ArrayList<Player> alchemist = new ArrayList<Player>();
	public static ArrayList<Player> fisherman = new ArrayList<Player>();
	public static ArrayList<Player> pyro = new ArrayList<Player>();
	public static ArrayList<Player> warrior = new ArrayList<Player>();
	public static ArrayList<Player> gladiator = new ArrayList<Player>();
	public static ArrayList<Player> guardian = new ArrayList<Player>();
	public static ArrayList<Player> berserk = new ArrayList<Player>();
	public static ArrayList<Player> legend = new ArrayList<Player>();
	public static ArrayList<Player> demigod = new ArrayList<Player>();
	public static ArrayList<Player> god = new ArrayList<Player>();
	public static ArrayList<Player> viper = new ArrayList<Player>();
	public static ArrayList<Player> slug = new ArrayList<Player>();
	public static ArrayList<Player> vampire = new ArrayList<Player>();
	public static ArrayList<Player> thor = new ArrayList<Player>();
	public static ArrayList<Player> burner = new ArrayList<Player>();
	public static ArrayList<Player> speedy = new ArrayList<Player>();
	public static ArrayList<Player> assassin = new ArrayList<Player>();
	public static ArrayList<Player> godarcher = new ArrayList<Player>();
	public static ArrayList<Player> insane = new ArrayList<Player>();

	public static void removeArrayLists(Player p) {
		StaffmodeManager.alchemist.remove(p);
		StaffmodeManager.pvp.remove(p);
		StaffmodeManager.archer.remove(p);
		StaffmodeManager.tank.remove(p);
		StaffmodeManager.pyro.remove(p);
		StaffmodeManager.fisherman.remove(p);
		StaffmodeManager.golden.remove(p);
		StaffmodeManager.viper.remove(p);
		StaffmodeManager.slug.remove(p);
		StaffmodeManager.thor.remove(p);
		StaffmodeManager.vampire.remove(p);
		StaffmodeManager.insane.remove(p);
		StaffmodeManager.speedy.remove(p);
		StaffmodeManager.assassin.remove(p);
		StaffmodeManager.burner.remove(p);
		StaffmodeManager.godarcher.remove(p);
		StaffmodeManager.warrior.remove(p);
		StaffmodeManager.gladiator.remove(p);
		StaffmodeManager.guardian.remove(p);
		StaffmodeManager.berserk.remove(p);
		StaffmodeManager.legend.remove(p);
		StaffmodeManager.demigod.remove(p);
		StaffmodeManager.god.remove(p);
	}

	public static String format(String format) {
		return ChatColor.translateAlternateColorCodes('&', format);
	}

	public static String config(String format) {
		return format.replace("§", "&");
	}

	public static boolean cmd(String format) {
		return Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), format);
	}
	
	static Score score;

	public static Score testkits(int slot, Player player, Objective objective) {
		if (StaffmodeManager.pvp.contains(player)) {
			Score score = objective.getScore(" §c" + "Default");
			score.setScore(slot);
			return score;
		} else if (StaffmodeManager.archer.contains(player)) {
			Score score = objective.getScore(" §c" + "Archer");
			score.setScore(slot);
			return score;
		} else if (StaffmodeManager.tank.contains(player)) {
			Score score = objective.getScore(" §c" + "Tank");
			score.setScore(slot);
			return score;
		} else if (StaffmodeManager.pyro.contains(player)) {
			Score score = objective.getScore(" §c" + "Pyro");
			score.setScore(slot);
			return score;
		} else if (StaffmodeManager.golden.contains(player)) {
			Score score = objective.getScore(" §c" + "Golden");
			score.setScore(slot);
			return score;
		} else if (StaffmodeManager.alchemist.contains(player)) {
			Score score = objective.getScore(" §c" + "Alchemist");
			score.setScore(slot);
			return score;
		} else if (StaffmodeManager.fisherman.contains(player)) {
			Score score = objective.getScore(" §c" + "Fisherman");
			score.setScore(slot);
			return score;
		} else if (StaffmodeManager.warrior.contains(player)) {
			Score score = objective.getScore(" §c" + "Warrior");
			score.setScore(slot);
			return score;
		} else if (StaffmodeManager.gladiator.contains(player)) {
			Score score = objective.getScore(" §c" + "Gladiator");
			score.setScore(slot);
			return score;
		} else if (StaffmodeManager.guardian.contains(player)) {
			Score score = objective.getScore(" §c" + "Guardian");
			score.setScore(slot);
			return score;
		} else if (StaffmodeManager.berserk.contains(player)) {
			Score score = objective.getScore(" §c" + "Berserk");
			score.setScore(slot);
			return score;
		} else if (StaffmodeManager.legend.contains(player)) {
			Score score = objective.getScore(" §c" + "Legend");
			score.setScore(slot);
			return score;
		} else if (StaffmodeManager.demigod.contains(player)) {
			Score score = objective.getScore(" §c" + "Demi God");
			score.setScore(slot);
			return score;
		} else if (StaffmodeManager.god.contains(player)) {
			Score score = objective.getScore(" §c" + "God");
			score.setScore(slot);
			return score;
		} else if (StaffmodeManager.burner.contains(player)) {
			Score score = objective.getScore(" §c" + "Burner");
			score.setScore(slot);
			return score;
		} else if (StaffmodeManager.speedy.contains(player)) {
			Score score = objective.getScore(" §c" + "Speedy");
			score.setScore(slot);
			return score;
		} else if (StaffmodeManager.godarcher.contains(player)) {
			Score score = objective.getScore(" §c" + "God Archer");
			score.setScore(slot);
			return score;
		} else if (StaffmodeManager.assassin.contains(player)) {
			Score score = objective.getScore(" §c" + "Assassin");
			score.setScore(slot);
			return score;
		} else if (StaffmodeManager.insane.contains(player)) {
			Score score = objective.getScore(" §c" + "Insane");
			score.setScore(slot);
			return score;
		} else if (StaffmodeManager.slug.contains(player)) {
			Score score = objective.getScore(" §c" + "Slug");
			score.setScore(slot);
			return score;
		} else if (StaffmodeManager.thor.contains(player)) {
			Score score = objective.getScore(" §c" + "Thor");
			score.setScore(slot);
			return score;
		} else if (StaffmodeManager.viper.contains(player)) {
			Score score = objective.getScore(" §c" + "Viper");
			score.setScore(slot);
			return score;
		} else if (StaffmodeManager.vampire.contains(player)) {
			Score score = objective.getScore(" §c" + "Vampire");
			score.setScore(slot);
			return score;
		}
		return score;
	}

	public static void testKits(Player p) {
		if (manager.getData().getBoolean(p.getName() + ".Kits.Assasin") == true
				&& manager.getData().getBoolean(p.getName() + ".Kits.Burner") == true
				&& manager.getData().getBoolean(p.getName() + ".Kits.Godarcher") == true
				&& manager.getData().getBoolean(p.getName() + ".Kits.Speedy") == true
				&& manager.getData().getBoolean(p.getName() + ".Kits.Insane") == true

				&& manager.getData().getString(p.getName() + ".Kits.Warrior").equalsIgnoreCase("")) {
			p.sendMessage(Messages.prefix(format("&aQUESTS: &aYou completed the &2Professional &aQuest!")));
		} else {
			return;
		}
	}

}
