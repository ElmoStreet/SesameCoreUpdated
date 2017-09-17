package com.sesamepvp.kitpvp.gui;

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

public class KitShopGUI {
	public static KitpvpFile manager = KitpvpFile.getInstance();

	public static void openKitshop(Player p) {
		final Inventory kitshop = Bukkit.createInventory(null, 36, "KitShop");
		boolean KitSpeedyOwned = manager.getData().getBoolean(
				p.getUniqueId() + ".Kits.Speedy");
		boolean KitBurnerOwned = manager.getData().getBoolean(
				p.getUniqueId() + ".Kits.Burner");
		boolean KitAssassinOwned = manager.getData().getBoolean(
				p.getUniqueId() + ".Kits.Assasin");
		boolean KitGodArcherOwned = manager.getData().getBoolean(
				p.getUniqueId() + ".Kits.GodArcher");
		boolean KitInsaneOwned = manager.getData().getBoolean(
				p.getUniqueId() + ".Kits.Insane");
		if (KitSpeedyOwned == true) {
			ItemStack name = new ItemStack(Material.STAINED_GLASS_PANE, 1,
					(short) 5);
			ItemMeta namem = name.getItemMeta();
			namem.setDisplayName(ChatColor.RED + "Speedy Kit");
			List<String> namel = new ArrayList<String>();
			namel.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			namel.add(ChatColor.GREEN + "Purchased!");
			namel.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			namem.setLore(namel);
			name.setItemMeta(namem);
			kitshop.setItem(19, name);
		} else {
			ItemStack name = new ItemStack(Material.STAINED_GLASS_PANE, 1,
					(short) 14);
			ItemMeta namem = name.getItemMeta();
			namem.setDisplayName(ChatColor.RED + "Speedy Kit");
			List<String> namel = new ArrayList<String>();
			namel.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			namel.add(ChatColor.RED + "Purchase for $500");
			namel.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			namem.setLore(namel);
			name.setItemMeta(namem);
			kitshop.setItem(19, name);
		}

		if (KitBurnerOwned == true) {
			ItemStack name = new ItemStack(Material.STAINED_GLASS_PANE, 1,
					(short) 5);
			ItemMeta namem = name.getItemMeta();
			namem.setDisplayName(ChatColor.RED + "Burner Kit");
			List<String> namel = new ArrayList<String>();
			namel.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			namel.add(ChatColor.GREEN + "Purchased!");
			namel.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			namem.setLore(namel);
			name.setItemMeta(namem);
			kitshop.setItem(21, name);
		} else {
			ItemStack name = new ItemStack(Material.STAINED_GLASS_PANE, 1,
					(short) 14);
			ItemMeta namem = name.getItemMeta();
			namem.setDisplayName(ChatColor.RED + "Burner Kit");
			List<String> namel = new ArrayList<String>();
			namel.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			namel.add(ChatColor.RED + "Purchase for $1000");
			namel.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			namem.setLore(namel);
			name.setItemMeta(namem);
			kitshop.setItem(21, name);
		}

		if (KitAssassinOwned == true) {
			ItemStack name = new ItemStack(Material.STAINED_GLASS_PANE, 1,
					(short) 5);
			ItemMeta namem = name.getItemMeta();
			namem.setDisplayName(ChatColor.RED + "Assassin Kit");
			List<String> namel = new ArrayList<String>();
			namel.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			namel.add(ChatColor.GREEN + "Purchased!");
			namel.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			namem.setLore(namel);
			name.setItemMeta(namem);
			kitshop.setItem(22, name);
		} else {
			ItemStack name = new ItemStack(Material.STAINED_GLASS_PANE, 1,
					(short) 14);
			ItemMeta namem = name.getItemMeta();
			namem.setDisplayName(ChatColor.RED + "Assassin Kit");
			List<String> namel = new ArrayList<String>();
			namel.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			namel.add(ChatColor.RED + "Purchase for $800");
			namel.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			namem.setLore(namel);
			name.setItemMeta(namem);
			kitshop.setItem(22, name);
		}

		if (KitInsaneOwned == true) {
			ItemStack name = new ItemStack(Material.STAINED_GLASS_PANE, 1,
					(short) 5);
			ItemMeta namem = name.getItemMeta();
			namem.setDisplayName(ChatColor.RED + "Insane Kit");
			List<String> namel = new ArrayList<String>();
			namel.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			namel.add(ChatColor.GREEN + "Purchased!");
			namel.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			namem.setLore(namel);
			name.setItemMeta(namem);
			kitshop.setItem(23, name);
		} else {
			ItemStack name = new ItemStack(Material.STAINED_GLASS_PANE, 1,
					(short) 14);
			ItemMeta namem = name.getItemMeta();
			namem.setDisplayName(ChatColor.RED + "Insane Kit");
			List<String> namel = new ArrayList<String>();
			namel.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			namel.add(ChatColor.RED + "Purchase for $1500");
			namel.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			namem.setLore(namel);
			name.setItemMeta(namem);
			kitshop.setItem(23, name);
		}
		if (KitGodArcherOwned == true) {
			ItemStack name = new ItemStack(Material.STAINED_GLASS_PANE, 1,
					(short) 5);
			ItemMeta namem = name.getItemMeta();
			namem.setDisplayName(ChatColor.RED + "God Archer Kit");
			List<String> namel = new ArrayList<String>();
			namel.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			namel.add(ChatColor.GREEN + "Purchased!");
			namel.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			namem.setLore(namel);
			name.setItemMeta(namem);
			kitshop.setItem(20, name);
		} else {
			ItemStack name = new ItemStack(Material.STAINED_GLASS_PANE, 1,
					(short) 14);
			ItemMeta namem = name.getItemMeta();
			namem.setDisplayName(ChatColor.RED + "God Archer Kit");
			List<String> namel = new ArrayList<String>();
			namel.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			namel.add(ChatColor.RED + "Purchase for $750");
			namel.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
					+ "--------------");
			namem.setLore(namel);
			name.setItemMeta(namem);
			kitshop.setItem(20, name);
		}

		ItemStack panel = new ItemStack(Material.STAINED_GLASS_PANE, 1,
				(short) 7);
		ItemMeta panelim = panel.getItemMeta();
		panelim.setDisplayName(ChatColor.RED + "");
		panel.setItemMeta(panelim);
		kitshop.setItem(0, panel);

		ItemStack speedy = new ItemStack(Material.FEATHER, 1);
		ItemMeta speed = speedy.getItemMeta();
		speed.setDisplayName(ChatColor.DARK_RED + "Speedy Kit");
		List<String> speedlore = new ArrayList<String>();
		speedlore.add(ChatColor.RED + "Price: " + ChatColor.GREEN + "$500");
		speedlore.add(ChatColor.GOLD + "Speedy kit with Speed 2!");
		speed.setLore(speedlore);
		speedy.setItemMeta(speed);

		ItemStack godarcher = new ItemStack(Material.ARROW, 1);
		ItemMeta ga = godarcher.getItemMeta();
		ga.setDisplayName(ChatColor.DARK_RED + "God Archer Kit");
		List<String> galore = new ArrayList<String>();
		galore.add(ChatColor.RED + "Price: " + ChatColor.GREEN + "$750");
		galore.add(ChatColor.GOLD + "Archer kit with a GOD Bow!");
		ga.setLore(galore);
		godarcher.setItemMeta(ga);

		ItemStack burner = new ItemStack(Material.FLINT_AND_STEEL, 1);
		ItemMeta b = burner.getItemMeta();
		b.setDisplayName(ChatColor.DARK_RED + "Burner Kit");
		List<String> blore = new ArrayList<String>();
		blore.add(ChatColor.RED + "Price: " + ChatColor.GREEN + "$1000");
		blore.add(ChatColor.GOLD + "Burner kit with better weaponary!");
		b.setLore(blore);
		burner.setItemMeta(b);

		ItemStack assassin = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
		ItemMeta assin = assassin.getItemMeta();
		assin.setDisplayName(ChatColor.DARK_RED + "Assassin Kit");
		List<String> assinl = new ArrayList<String>();
		assinl.add(ChatColor.RED + "Price: " + ChatColor.GREEN + "$800");
		assinl.add(ChatColor.GOLD + "Assassin Kit With Speed 4!");
		assin.setLore(assinl);
		assassin.setItemMeta(assin);

		ItemStack insane = new ItemStack(Material.LAVA_BUCKET, 1);
		ItemMeta insaneim = insane.getItemMeta();
		insaneim.setDisplayName(ChatColor.DARK_RED + "Insane Kit");
		List<String> insanel = new ArrayList<String>();
		insanel.add(ChatColor.RED + "Price: " + ChatColor.GREEN + "$1500");
		insanel.add(ChatColor.GOLD + "When you kill someone, you go INSANE!");
		insaneim.setLore(insanel);
		insane.setItemMeta(insaneim);

		ItemStack freezer = new ItemStack(Material.SNOW_BALL, 1);
		ItemMeta freezeim = freezer.getItemMeta();
		freezeim.setDisplayName(ChatColor.DARK_RED + "Freeze Kit");
		List<String> freezel = new ArrayList<String>();
		freezel.add(ChatColor.RED + "Price: " + ChatColor.GREEN + "$1300");
		freezel.add(ChatColor.GOLD + "Freeze Players BR....");
		freezeim.setLore(freezel);
		freezer.setItemMeta(freezeim);

		kitshop.setItem(10, speedy);
		kitshop.setItem(11, godarcher);
		kitshop.setItem(12, burner);
		kitshop.setItem(13, assassin);
		kitshop.setItem(14, insane);
		// kitshop.setItem(15, freezer);

		ItemStack back = new ItemStack(Material.WOOL, 1, (short) 13);
		ItemMeta backm = back.getItemMeta();
		backm.setDisplayName(ChatColor.GREEN + "To Upgrades");
		back.setItemMeta(backm);

		ItemStack close = new ItemStack(Material.WOOL, 1, (short) 14);
		ItemMeta closem = close.getItemMeta();
		closem.setDisplayName(ChatColor.RED + "Close");
		close.setItemMeta(closem);

		ItemStack tokits = new ItemStack(Material.WOOL, 1, (short) 5);
		ItemMeta tokitsm = tokits.getItemMeta();
		tokitsm.setDisplayName(ChatColor.GREEN + "To Kits");
		tokits.setItemMeta(tokitsm);

		kitshop.setItem(0, panel);
		kitshop.setItem(1, panel);
		kitshop.setItem(2, panel);
		kitshop.setItem(3, panel);
		kitshop.setItem(4, panel);
		kitshop.setItem(5, panel);
		kitshop.setItem(6, panel);
		kitshop.setItem(7, panel);
		kitshop.setItem(8, close);
		kitshop.setItem(9, panel);
		kitshop.setItem(18, panel);
		kitshop.setItem(27, panel);
		kitshop.setItem(28, panel);
		kitshop.setItem(29, panel);
		kitshop.setItem(30, panel);
		kitshop.setItem(31, panel);
		kitshop.setItem(32, panel);
		kitshop.setItem(33, panel);
		kitshop.setItem(34, tokits);
		kitshop.setItem(17, panel);
		kitshop.setItem(26, panel);
		kitshop.setItem(35, back);
		p.openInventory(kitshop);
	}

}
