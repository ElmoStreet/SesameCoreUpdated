package com.sesamepvp.kitpvp.upgrades;

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

public class UpgradeManager {
	static Inventory kitsGUI = Bukkit.createInventory(null, 36, "Kit Upgrades");

	public static void upgradeGUI(Player p) {
		
		KitpvpFile manager = KitpvpFile.getInstance();
		boolean KitDefaultUpgraded = manager.getData().getBoolean(
				p.getUniqueId() + ".Kits.Default.Upgraded");
		boolean TankKitUpgraded = manager.getData().getBoolean(
				p.getUniqueId()+ ".Kits.Tank.Upgraded");
		boolean ArcherKitUpgraded = manager.getData().getBoolean(
				p.getUniqueId() + ".Kits.Archer.Upgraded");
		boolean PyroKitUpgraded = manager.getData().getBoolean(
				p.getUniqueId() + ".Kits.Pyro.Upgraded");
		boolean GoldenKitUpgraded = manager.getData().getBoolean(
				p.getUniqueId() + ".Kits.Golden.Upgraded");
		boolean AlchemistKitUpgraded = manager.getData().getBoolean(
				p.getUniqueId() + ".Kits.Alchemist.Upgraded");
		boolean FishermanKitUpgraded = manager.getData().getBoolean(
				p.getUniqueId()+ ".Kits.Fisherman.Upgraded");
		
		if (KitDefaultUpgraded == true) {
			ItemStack defaultkitupgrade = new ItemStack(
					Material.STAINED_GLASS_PANE, 1, (short) 5);
			ItemMeta defaultkitupgradem = defaultkitupgrade.getItemMeta();
			defaultkitupgradem.setDisplayName(ChatColor.RED
					+ "Default Kit Upgrade");
			List<String> defaultkitlore = new ArrayList<String>();
			defaultkitlore.add(ChatColor.DARK_GRAY + ""
					+ ChatColor.STRIKETHROUGH + "--------------");
			defaultkitlore.add(ChatColor.GREEN + "Purchased!");
			defaultkitlore.add(ChatColor.DARK_GRAY + ""
					+ ChatColor.STRIKETHROUGH + "--------------");
			defaultkitupgradem.setLore(defaultkitlore);
			defaultkitupgrade.setItemMeta(defaultkitupgradem);
			kitsGUI.setItem(19, defaultkitupgrade);
		} else {
			ItemStack defaultkitupgrade = new ItemStack(
					Material.STAINED_GLASS_PANE, 1, (short) 14);
			ItemMeta defaultkitupgradem = defaultkitupgrade.getItemMeta();
			defaultkitupgradem.setDisplayName(ChatColor.RED + "Default Kit");
			List<String> defaultkitlore = new ArrayList<String>();
			defaultkitlore.add(ChatColor.DARK_GRAY + ""
					+ ChatColor.STRIKETHROUGH + "--------------");
			defaultkitlore.add(ChatColor.RED + "Purchase for $250!");
			defaultkitlore.add(ChatColor.DARK_GRAY + ""
					+ ChatColor.STRIKETHROUGH + "--------------");
			defaultkitupgradem.setLore(defaultkitlore);
			defaultkitupgrade.setItemMeta(defaultkitupgradem);
			kitsGUI.setItem(19, defaultkitupgrade);
		}
		if (TankKitUpgraded == true) {
			ItemStack tankkitupgrade = new ItemStack(
					Material.STAINED_GLASS_PANE, 1, (short) 5);
			ItemMeta tankkitupgradem = tankkitupgrade.getItemMeta();
			tankkitupgradem.setDisplayName(ChatColor.RED + "Tank Kit");
			List<String> tankkitlore = new ArrayList<String>();
			tankkitlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			tankkitlore.add(ChatColor.GREEN + "Purchased!");
			tankkitlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			tankkitupgradem.setLore(tankkitlore);
			tankkitupgrade.setItemMeta(tankkitupgradem);
			kitsGUI.setItem(20, tankkitupgrade);
		} else {
			ItemStack tankkitupgrade = new ItemStack(
					Material.STAINED_GLASS_PANE, 1, (short) 14);
			ItemMeta tankkitupgradem = tankkitupgrade.getItemMeta();
			tankkitupgradem.setDisplayName(ChatColor.RED + "Tank Kit");
			List<String> tankkitlore = new ArrayList<String>();
			tankkitlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			tankkitlore.add(ChatColor.RED + "Purchase for $250!");
			tankkitlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			tankkitupgradem.setLore(tankkitlore);
			tankkitupgrade.setItemMeta(tankkitupgradem);
			kitsGUI.setItem(20, tankkitupgrade);
		}
		
		if (ArcherKitUpgraded == true) {
			ItemStack archerkitupgrade = new ItemStack(
					Material.STAINED_GLASS_PANE, 1, (short) 5);
			ItemMeta archerkitupgradem = archerkitupgrade.getItemMeta();
			archerkitupgradem.setDisplayName(ChatColor.RED + "Archer Kit");
			List<String> archerkitlore = new ArrayList<String>();
			archerkitlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			archerkitlore.add(ChatColor.GREEN + "Purchased!");
			archerkitlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			archerkitupgradem.setLore(archerkitlore);
			archerkitupgrade.setItemMeta(archerkitupgradem);
			kitsGUI.setItem(21, archerkitupgrade);
		} else {
			ItemStack archerkitupgrade = new ItemStack(
					Material.STAINED_GLASS_PANE, 1, (short) 14);
			ItemMeta archerkitupgradem = archerkitupgrade.getItemMeta();
			archerkitupgradem.setDisplayName(ChatColor.RED + "Archer Kit");
			List<String> archerkitlore = new ArrayList<String>();
			archerkitlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			archerkitlore.add(ChatColor.RED + "Purchase for $250!");
			archerkitlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			archerkitupgradem.setLore(archerkitlore);
			archerkitupgrade.setItemMeta(archerkitupgradem);
			kitsGUI.setItem(21, archerkitupgrade);
		}
		if (PyroKitUpgraded == true) {
			ItemStack pyrokitupgrade = new ItemStack(
					Material.STAINED_GLASS_PANE, 1, (short) 5);
			ItemMeta pyrokitupgradem = pyrokitupgrade.getItemMeta();
			pyrokitupgradem.setDisplayName(ChatColor.RED + "Pyro Kit");
			List<String> pyrokitlore = new ArrayList<String>();
			pyrokitlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			pyrokitlore.add(ChatColor.GREEN + "Purchased!");
			pyrokitlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			pyrokitupgradem.setLore(pyrokitlore);
			pyrokitupgrade.setItemMeta(pyrokitupgradem);
			kitsGUI.setItem(22, pyrokitupgrade);
		} else {
			ItemStack pyrokitupgrade = new ItemStack(
					Material.STAINED_GLASS_PANE, 1, (short) 14);
			ItemMeta pyrokitupgradem = pyrokitupgrade.getItemMeta();
			pyrokitupgradem.setDisplayName(ChatColor.RED + "Pyro Kit");
			List<String> pyrokitlore = new ArrayList<String>();
			pyrokitlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			pyrokitlore.add(ChatColor.RED + "Purchase for $250!");
			pyrokitlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			pyrokitupgradem.setLore(pyrokitlore);
			pyrokitupgrade.setItemMeta(pyrokitupgradem);
			kitsGUI.setItem(22, pyrokitupgrade);
		}
		
		if (GoldenKitUpgraded == true) {
			ItemStack goldenkitupgrade = new ItemStack(
					Material.STAINED_GLASS_PANE, 1, (short) 5);
			ItemMeta goldenkitupgradem = goldenkitupgrade.getItemMeta();
			goldenkitupgradem.setDisplayName(ChatColor.RED + "Golden Kit");
			List<String> goldenkitlore = new ArrayList<String>();
			goldenkitlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			goldenkitlore.add(ChatColor.GREEN + "Purchased!");
			goldenkitlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			goldenkitupgradem.setLore(goldenkitlore);
			goldenkitupgrade.setItemMeta(goldenkitupgradem);
			kitsGUI.setItem(23, goldenkitupgrade);
		} else {
			ItemStack goldenkitupgrade = new ItemStack(
					Material.STAINED_GLASS_PANE, 1, (short) 14);
			ItemMeta goldenkitupgradem = goldenkitupgrade.getItemMeta();
			goldenkitupgradem.setDisplayName(ChatColor.RED + "Golden Kit");
			List<String> goldenkitlore = new ArrayList<String>();
			goldenkitlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			goldenkitlore.add(ChatColor.RED + "Purchase for $250!");
			goldenkitlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			goldenkitupgradem.setLore(goldenkitlore);
			goldenkitupgrade.setItemMeta(goldenkitupgradem);
			kitsGUI.setItem(23, goldenkitupgrade);
		}
		

		if (AlchemistKitUpgraded == true) {
			ItemStack potkitupgrade = new ItemStack(
					Material.STAINED_GLASS_PANE, 1, (short) 5);
			ItemMeta potkitupgradem = potkitupgrade.getItemMeta();
			potkitupgradem.setDisplayName(ChatColor.RED + "Alchemist Kit");
			List<String> potkitlore = new ArrayList<String>();
			potkitlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			potkitlore.add(ChatColor.GREEN + "Purchased!");
			potkitlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			potkitupgradem.setLore(potkitlore);
			potkitupgrade.setItemMeta(potkitupgradem);
			kitsGUI.setItem(24, potkitupgrade);
		} else {
			ItemStack potkitupgrade = new ItemStack(
					Material.STAINED_GLASS_PANE, 1, (short) 14);
			ItemMeta potkitupgradem = potkitupgrade.getItemMeta();
			potkitupgradem.setDisplayName(ChatColor.RED + "Alchemist Kit");
			List<String> potkitlore = new ArrayList<String>();
			potkitlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			potkitlore.add(ChatColor.RED + "Purchase for $250!");
			potkitlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			potkitupgradem.setLore(potkitlore);
			potkitupgrade.setItemMeta(potkitupgradem);
			kitsGUI.setItem(24, potkitupgrade);
		}
		
		if (FishermanKitUpgraded == true) {
			ItemStack fishkitupgrade = new ItemStack(
					Material.STAINED_GLASS_PANE, 1, (short) 5);
			ItemMeta fishkitupgradem = fishkitupgrade.getItemMeta();
			fishkitupgradem.setDisplayName(ChatColor.RED + "Fisherman Kit");
			List<String> fishkitlore = new ArrayList<String>();
			fishkitlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			fishkitlore.add(ChatColor.GREEN + "Purchased!");
			fishkitlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			fishkitupgradem.setLore(fishkitlore);
			fishkitupgrade.setItemMeta(fishkitupgradem);
			kitsGUI.setItem(25, fishkitupgrade);
		} else {
			ItemStack fishkitupgrade = new ItemStack(
					Material.STAINED_GLASS_PANE, 1, (short) 14);
			ItemMeta fishkitupgradem = fishkitupgrade.getItemMeta();
			fishkitupgradem.setDisplayName(ChatColor.RED + "Fisherman Kit");
			List<String> fishkitlore = new ArrayList<String>();
			fishkitlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			fishkitlore.add(ChatColor.RED + "Purchase for $250");
			fishkitlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			fishkitupgradem.setLore(fishkitlore);
			fishkitupgrade.setItemMeta(fishkitupgradem);
			kitsGUI.setItem(25, fishkitupgrade);
		}
		
		ItemStack defaultKit = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		ItemMeta defaultkitm = defaultKit.getItemMeta();
		defaultkitm.setDisplayName(ChatColor.RED + "Upgraded Default Kit");
		defaultKit.setItemMeta(defaultkitm);
		ItemStack tankKit = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
		ItemMeta kit2 = tankKit.getItemMeta();
		kit2.setDisplayName(ChatColor.RED + "Upgraded Tank Kit");
		tankKit.setItemMeta(kit2);

		ItemStack archerKit = new ItemStack(Material.BOW, 1);
		ItemMeta kit3 = archerKit.getItemMeta();
		kit3.setDisplayName(ChatColor.RED + "Upgraded Archer Kit");
		archerKit.setItemMeta(kit3);

		ItemStack pyroKit = new ItemStack(Material.FIREBALL, 1);
		ItemMeta kit4 = pyroKit.getItemMeta();
		kit4.setDisplayName(ChatColor.RED + "Upgraded Pyro Kit");
		pyroKit.setItemMeta(kit4);

		ItemStack goldenKit = new ItemStack(Material.GOLDEN_APPLE, 1);
		ItemMeta kit5 = goldenKit.getItemMeta();
		kit5.setDisplayName(ChatColor.RED + "Upgraded Golden Kit");
		goldenKit.setItemMeta(kit5);

		ItemStack potKit = new ItemStack(Material.GLASS_BOTTLE, 1);
		ItemMeta kit6 = potKit.getItemMeta();
		kit6.setDisplayName(ChatColor.RED + "Upgraded Alchemist Kit");
		potKit.setItemMeta(kit6);

		ItemStack fishKit = new ItemStack(Material.FISHING_ROD, 1);
		ItemMeta kit7 = fishKit.getItemMeta();
		kit7.setDisplayName(ChatColor.RED + "Upgraded Fisherman Kit");
		fishKit.setItemMeta(kit7);

		ItemStack panel = new ItemStack(Material.STAINED_GLASS_PANE, 1,
				(short) 7);
		ItemMeta panelim = panel.getItemMeta();
		panelim.setDisplayName(ChatColor.RED + "");
		panel.setItemMeta(panelim);
		
		ItemStack back = new ItemStack(Material.WOOL, 1,
				(short) 13);
		ItemMeta backm = back.getItemMeta();
		backm.setDisplayName(ChatColor.GREEN+"To Kit Shop");
		back.setItemMeta(backm);		
		
		ItemStack close = new ItemStack(Material.WOOL, 1,
				(short) 14);
		ItemMeta closem = close.getItemMeta();
		closem.setDisplayName(ChatColor.RED+"Close");
		close.setItemMeta(closem);		

		ItemStack kitshop = new ItemStack(Material.WOOL, 1,
				(short) 5);
		ItemMeta kitshopm = kitshop.getItemMeta();
		kitshopm.setDisplayName(ChatColor.GREEN+"To Kits");
		kitshop.setItemMeta(kitshopm);		
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
		kitsGUI.setItem(28, panel);
		kitsGUI.setItem(29, panel);
		kitsGUI.setItem(30, panel);
		kitsGUI.setItem(31, panel);
		kitsGUI.setItem(32, panel);
		kitsGUI.setItem(33, panel);
		kitsGUI.setItem(34,kitshop);
		kitsGUI.setItem(17, panel);
		kitsGUI.setItem(26, panel);
		kitsGUI.setItem(35, back);
		

		kitsGUI.setItem(10, defaultKit);
		kitsGUI.setItem(11, tankKit);
		kitsGUI.setItem(12, archerKit);
		kitsGUI.setItem(13, pyroKit);
		kitsGUI.setItem(14, goldenKit);
		kitsGUI.setItem(15, potKit);
		kitsGUI.setItem(16, fishKit);
		
		p.openInventory(kitsGUI);
	}
}
