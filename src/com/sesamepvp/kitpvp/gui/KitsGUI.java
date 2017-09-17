package com.sesamepvp.kitpvp.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitsGUI {
	public static Inventory kitsGUI = Bukkit.createInventory(null, 54, "Kits");
	public static void gui(Player p){
		ItemStack defaultKit = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		ItemMeta kit1 = defaultKit.getItemMeta();
		kit1.setDisplayName(ChatColor.RED + "Default PvP Kit");
		defaultKit.setItemMeta(kit1);

		ItemStack panel = new ItemStack(Material.STAINED_GLASS_PANE, 1,
				(short) 7);
		ItemMeta panelim = panel.getItemMeta();
		panelim.setDisplayName(ChatColor.RED + "");
		panel.setItemMeta(panelim);

		ItemStack tankKit = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
		ItemMeta kit2 = tankKit.getItemMeta();
		kit2.setDisplayName(ChatColor.RED + "Tank Kit");
		tankKit.setItemMeta(kit2);

		ItemStack archerKit = new ItemStack(Material.BOW, 1);
		ItemMeta kit3 = archerKit.getItemMeta();
		kit3.setDisplayName(ChatColor.RED + "Archer Kit");
		archerKit.setItemMeta(kit3);

		ItemStack pyroKit = new ItemStack(Material.FIREBALL, 1);
		ItemMeta kit4 = pyroKit.getItemMeta();
		kit4.setDisplayName(ChatColor.RED + "Pyro Kit");
		pyroKit.setItemMeta(kit4);

		ItemStack goldenKit = new ItemStack(Material.GOLDEN_APPLE, 1);
		ItemMeta kit5 = goldenKit.getItemMeta();
		kit5.setDisplayName(ChatColor.RED + "Golden Kit");
		goldenKit.setItemMeta(kit5);

		ItemStack potKit = new ItemStack(Material.GLASS_BOTTLE, 1);
		ItemMeta kit6 = potKit.getItemMeta();
		kit6.setDisplayName(ChatColor.RED + "Alchemist Kit");
		potKit.setItemMeta(kit6);

		ItemStack fishKit = new ItemStack(Material.FISHING_ROD, 1);
		ItemMeta kit7 = fishKit.getItemMeta();
		kit7.setDisplayName(ChatColor.RED + "Fisherman Kit");
		fishKit.setItemMeta(kit7);

		ItemStack warriorKit = new ItemStack(Material.IRON_SWORD, 1);
		ItemMeta kit8 = warriorKit.getItemMeta();
		kit8.setDisplayName(ChatColor.DARK_RED + "Warrior Kit");

		ArrayList<String> warriorlore = new ArrayList<String>();
		warriorlore.add(ChatColor.GOLD + "Get 150 Kills to unlock this!");
		kit8.setLore(warriorlore);
		warriorKit.setItemMeta(kit8);

		ItemStack gladiatorKit = new ItemStack(Material.GOLD_SWORD, 1);
		ItemMeta kit9 = gladiatorKit.getItemMeta();
		kit9.setDisplayName(ChatColor.DARK_RED + "Gladiator Kit");

		ArrayList<String> gladiatorlore = new ArrayList<String>();
		gladiatorlore.add(ChatColor.GOLD + "Get 350 Kills to unlock this!");
		kit9.setLore(gladiatorlore);
		gladiatorKit.setItemMeta(kit9);

		ItemStack guardianKit = new ItemStack(Material.DIAMOND_SWORD, 1);
		ItemMeta kit10 = guardianKit.getItemMeta();
		kit10.setDisplayName(ChatColor.DARK_RED + "Guardian Kit");

		ArrayList<String> guardianlore = new ArrayList<String>();
		guardianlore.add(ChatColor.GOLD + "Get 750 Kills to unlock this!");
		kit10.setLore(guardianlore);
		guardianKit.setItemMeta(kit10);

		ItemStack berserkKit = new ItemStack(Material.REDSTONE, 1);
		ItemMeta kit11 = berserkKit.getItemMeta();
		kit11.setDisplayName(ChatColor.DARK_RED + "Berserk Kit");

		ArrayList<String> berserklore = new ArrayList<String>();
		berserklore.add(ChatColor.GOLD + "Get 1250 Kills to unlock this!");
		kit11.setLore(berserklore);
		berserkKit.setItemMeta(kit11);

		ItemStack legendKit = new ItemStack(Material.IRON_INGOT, 1);
		ItemMeta kit12 = legendKit.getItemMeta();
		kit12.setDisplayName(ChatColor.DARK_RED + "Legend Kit");

		ArrayList<String> legendlore = new ArrayList<String>();
		legendlore.add(ChatColor.GOLD + "Get 1750 Kills to unlock this!");
		kit12.setLore(legendlore);
		legendKit.setItemMeta(kit12);

		ItemStack demigod = new ItemStack(Material.GOLD_INGOT, 1);
		ItemMeta kit13 = demigod.getItemMeta();
		kit13.setDisplayName(ChatColor.DARK_RED + "Demi God Kit");

		ArrayList<String> demigodlore = new ArrayList<String>();
		demigodlore.add(ChatColor.GOLD + "Get 2250 Kills to unlock this!");
		kit13.setLore(demigodlore);
		demigod.setItemMeta(kit13);

		ItemStack god = new ItemStack(Material.DIAMOND, 1);
		ItemMeta kit14 = god.getItemMeta();
		kit14.setDisplayName(ChatColor.DARK_RED + "GOD Kit");

		List<String> godlore = new ArrayList<String>();
		godlore.add(ChatColor.GOLD + "Get 3500 Kills to unlock this!");
		kit14.setLore(godlore);
		god.setItemMeta(kit14);

		ItemStack speedy = new ItemStack(Material.FEATHER, 1);
		ItemMeta speed = speedy.getItemMeta();
		speed.setDisplayName(ChatColor.DARK_RED + "Speedy Kit");

		List<String> speedlore = new ArrayList<String>();
		speedlore.add(ChatColor.GOLD + "Purchase with /kitshop");
		speed.setLore(speedlore);
		speedy.setItemMeta(speed);

		ItemStack godarcher = new ItemStack(Material.ARROW, 1);
		ItemMeta ga = godarcher.getItemMeta();
		ga.setDisplayName(ChatColor.DARK_RED + "God Archer Kit");
		List<String> galore = new ArrayList<String>();

		galore.add(ChatColor.GOLD + "Purchase with /kitshop");
		ga.setLore(galore);
		godarcher.setItemMeta(ga);

		ItemStack burner = new ItemStack(Material.FLINT_AND_STEEL, 1);
		ItemMeta b = burner.getItemMeta();
		b.setDisplayName(ChatColor.DARK_RED + "Burner Kit");
		List<String> blore = new ArrayList<String>();
		blore.add(ChatColor.GOLD + "Purchase with /kitshop");
		b.setLore(blore);
		burner.setItemMeta(b);

		ItemStack assassin = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
		ItemMeta assin = assassin.getItemMeta();
		assin.setDisplayName(ChatColor.DARK_RED + "Assasin Kit");
		List<String> assinl = new ArrayList<String>();

		assinl.add(ChatColor.GOLD + "Purchase with /kitshop");
		assin.setLore(assinl);
		assassin.setItemMeta(assin);

		ItemStack insane = new ItemStack(Material.LAVA_BUCKET, 1);
		ItemMeta insaneim = insane.getItemMeta();
		insaneim.setDisplayName(ChatColor.DARK_RED + "Insane Kit");
		List<String> insanel = new ArrayList<String>();

		insanel.add(ChatColor.GOLD + "Purchase with /kitshop");
		insaneim.setLore(insanel);
		insane.setItemMeta(insaneim);

		ItemStack freeze = new ItemStack(Material.SNOW_BALL, 1);
		ItemMeta freezeim = freeze.getItemMeta();
		freezeim.setDisplayName(ChatColor.DARK_RED + "Freezer Kit");
		List<String> freezel = new ArrayList<String>();

		freezel.add(ChatColor.GOLD + "Purchase with /kitshop");
		freezeim.setLore(freezel);
		freeze.setItemMeta(freezeim);

		ItemStack toshop = new ItemStack(Material.REDSTONE_BLOCK, 1);
		ItemMeta toshopm = toshop.getItemMeta();
		toshopm.setDisplayName(ChatColor.DARK_RED + "Page 2");
		List<String> toshopl = new ArrayList<String>();

		toshopl.add(ChatColor.GOLD + "Redirect to Page 2!");
		toshopm.setLore(toshopl);
		toshop.setItemMeta(toshopm);

		ItemStack thor = new ItemStack(Material.IRON_AXE, 1);
		ItemMeta thorm = thor.getItemMeta();
		thorm.setDisplayName(ChatColor.RED + "Thor");
		List<String> thorl = new ArrayList<String>();

		thorl.add(ChatColor.GOLD + "Buy with /buy");
		thorm.setLore(thorl);
		thor.setItemMeta(thorm);

		ItemStack viper = new ItemStack(Material.SPIDER_EYE, 1);
		ItemMeta viperm = viper.getItemMeta();
		viperm.setDisplayName(ChatColor.RED + "Viper");
		List<String> viperl = new ArrayList<String>();

		viperl.add(ChatColor.GOLD + "Buy with /buy");
		viperm.setLore(thorl);
		viper.setItemMeta(viperm);

		ItemStack slug = new ItemStack(Material.FERMENTED_SPIDER_EYE);
		ItemMeta slugm = slug.getItemMeta();
		slugm.setDisplayName(ChatColor.RED + "Slug");
		List<String> slugl = new ArrayList<String>();

		slugl.add(ChatColor.GOLD + "Buy with /buy");
		slugm.setLore(slugl);
		slug.setItemMeta(slugm);

		ItemStack vampire = new ItemStack(Material.GHAST_TEAR);
		ItemMeta vampirem = vampire.getItemMeta();
		vampirem.setDisplayName(ChatColor.RED + "Vampire");
		List<String> vampirel = new ArrayList<String>();		
		vampirel.add(ChatColor.GOLD + "Buy with /buy");
		vampirem.setLore(vampirel);
		vampire.setItemMeta(vampirem);
		
		ItemStack greenwool = new ItemStack(Material.WOOL, 1,
				(short) 13);
		ItemMeta greenwoolm = greenwool.getItemMeta();
		greenwoolm.setDisplayName(ChatColor.GREEN+"Upgrades");
		greenwool.setItemMeta(greenwoolm);	
		
		ItemStack close = new ItemStack(Material.WOOL, 1,
				(short) 14);
		ItemMeta closem = close.getItemMeta();
		closem.setDisplayName(ChatColor.RED+"Close");
		close.setItemMeta(closem);		
		
		ItemStack lightgreenwool = new ItemStack(Material.WOOL, 1,
				(short) 5);
		ItemMeta lightgreenwoolm = lightgreenwool.getItemMeta();
		lightgreenwoolm.setDisplayName(ChatColor.GREEN+"Kit Shop");
		lightgreenwool.setItemMeta(lightgreenwoolm);		
		// DEFAULT
		kitsGUI.setItem(10, defaultKit);
		kitsGUI.setItem(11, tankKit);
		kitsGUI.setItem(12, archerKit);
		kitsGUI.setItem(13, pyroKit);
		kitsGUI.setItem(14, goldenKit);
		kitsGUI.setItem(15, potKit);
		kitsGUI.setItem(16, fishKit);

		// KILLS KITS
		kitsGUI.setItem(19, warriorKit);
		kitsGUI.setItem(20, gladiatorKit);
		kitsGUI.setItem(21, guardianKit);
		kitsGUI.setItem(22, berserkKit);
		kitsGUI.setItem(23, legendKit);
		kitsGUI.setItem(24, demigod);
		kitsGUI.setItem(25, god);

		// BUYABLE KITS
		kitsGUI.setItem(28, speedy);
		kitsGUI.setItem(29, burner);
		kitsGUI.setItem(30, godarcher);
		kitsGUI.setItem(31, assassin);
		kitsGUI.setItem(32, insane);
		kitsGUI.setItem(33, freeze);
		// DONATOR KITS
		kitsGUI.setItem(43, thor);
		kitsGUI.setItem(42, viper);
		kitsGUI.setItem(41, slug);
		kitsGUI.setItem(40, vampire);
		// Panels
		kitsGUI.setItem(0, panel);
		kitsGUI.setItem(1, panel);
		kitsGUI.setItem(2, panel);
		kitsGUI.setItem(3, panel);
		kitsGUI.setItem(4, panel);
		kitsGUI.setItem(5, panel);
		kitsGUI.setItem(6, panel);
		kitsGUI.setItem(7, panel);
		kitsGUI.setItem(8, close);
		kitsGUI.setItem(9, panel);
		kitsGUI.setItem(18, panel);
		kitsGUI.setItem(27, panel);
		kitsGUI.setItem(44, panel);

		kitsGUI.setItem(36, panel);
		kitsGUI.setItem(53, greenwool);
		kitsGUI.setItem(52, lightgreenwool);
		kitsGUI.setItem(51, panel);
		kitsGUI.setItem(50, panel);
		kitsGUI.setItem(49, panel);
		kitsGUI.setItem(48, panel);
		kitsGUI.setItem(47, panel);
		kitsGUI.setItem(46, panel);
		kitsGUI.setItem(45, panel);
		kitsGUI.setItem(17, panel);
		kitsGUI.setItem(26, panel);
		kitsGUI.setItem(35, panel);
		
		p.playSound(p.getLocation(), Sound.NOTE_PLING, 2F, 1F);
		p.openInventory(kitsGUI);
	}
}
