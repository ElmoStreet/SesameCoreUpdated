package com.sesamepvp.punishments.GUI;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.sesamepvp.files.PunishmentsFile;
import com.sesamepvp.utilites.Methods;

public class PunishGUI implements Listener {
	PunishmentsFile pf = PunishmentsFile.getInstance();
	public static Inventory punish = Bukkit.createInventory(null, 54, "Punish");

	public static void openGUI(Player p, Player target) {
		ItemStack panel = new ItemStack(Material.STAINED_GLASS_PANE, 1,
				(short) 7);
		ItemMeta panelim = panel.getItemMeta();
		panelim.setDisplayName(ChatColor.RED + "");
		panel.setItemMeta(panelim);

		ItemStack close = new ItemStack(Material.WOOL, 1, (short) 14);
		ItemMeta closem = close.getItemMeta();
		closem.setDisplayName(ChatColor.RED + "Close");
		close.setItemMeta(closem);

		ItemStack tempban1day = new ItemStack(Material.BOOK);
		ItemMeta tempban1daym = tempban1day.getItemMeta();
		tempban1daym.setDisplayName(Methods.format("&a&lGeneral Ban"));
		List<String> tempban1daylore = new ArrayList<String>();
		tempban1daylore.add(Methods.format("&fBan Duration: &e1 Day."));
		tempban1daylore.add("");
		tempban1daylore.add(Methods.format("&7Examples:"));
		tempban1daylore
				.add(Methods
						.format(" &fStaff disrespect, consistent and toxic chat messages."));
		tempban1daym.setLore(tempban1daylore);
		tempban1day.setItemMeta(tempban1daym);

		ItemStack tempban1week = new ItemStack(Material.WOOL, 1, (short) 4);
		ItemMeta tempban1weekm = tempban1week.getItemMeta();
		tempban1weekm.setDisplayName(Methods.format("&a&lSeverity 1"));
		List<String> weeklore = new ArrayList<String>();
		weeklore.add(Methods.format("&fBan Duration: &e7 Days."));
		weeklore.add("");

		weeklore.add(Methods.format("&7Examples:"));
		weeklore.add(Methods.format(" &fAdmitting to Autoclicker, or Macros."));
		tempban1weekm.setLore(weeklore);
		tempban1week.setItemMeta(tempban1weekm);

		ItemStack tempban3week = new ItemStack(Material.WOOL, 1, (short) 1);
		ItemMeta tempban3weekm = tempban3week.getItemMeta();
		tempban3weekm.setDisplayName(Methods.format("&a&lSeverity 2"));
		List<String> week3lore = new ArrayList<String>();
		week3lore.add(Methods.format("&fBan Duration: &e14 Days."));
		week3lore.add("");

		week3lore.add(Methods.format("&7Examples:"));
		week3lore.add(Methods
				.format(" &fAdmitting to the use of Hacked Clients."));
		week3lore
				.add(Methods
						.format(" &fUsing modifications that give the player an advantage"));
		tempban3weekm.setLore(week3lore);
		tempban3week.setItemMeta(tempban3weekm);

		ItemStack tempban8week = new ItemStack(Material.WOOL, 1, (short) 14);
		ItemMeta tempban8weekm = tempban8week.getItemMeta();
		tempban8weekm.setDisplayName(Methods.format("&a&lSeverity 3"));
		List<String> week8lore = new ArrayList<String>();
		week8lore.add(Methods.format("&fBan Duration: &e2 Months."));
		week8lore.add("");

		week8lore.add(Methods.format("&7Examples:"));
		week8lore.add(Methods.format(" &fRefusal to screenshare."));
		week8lore.add(Methods.format(" &fCaught cheating with out admitting."));
		tempban8weekm.setLore(week8lore);
		tempban8week.setItemMeta(tempban8weekm);

		ItemStack h4mute = new ItemStack(Material.HOPPER, 1);
		ItemMeta h4mutem = h4mute.getItemMeta();
		h4mutem.setDisplayName(Methods.format("&a&lGeneral Chat Offense"));
		List<String> h4mutelore = new ArrayList<String>();
		h4mutelore.add(Methods.format("&fMute Duration: &e4 hours."));
		h4mutelore.add("");

		h4mutelore.add(Methods.format("&7Examples:"));
		h4mutelore.add(Methods.format(" &fAbusing commands, spamming."));
		h4mutelore.add(Methods.format(" &fConsistent hackusating."));
		h4mutem.setLore(h4mutelore);
		h4mute.setItemMeta(h4mutem);

		ItemStack week7mute = new ItemStack(Material.WOOL, 1, (short) 5);
		ItemMeta week7mutem = week7mute.getItemMeta();
		week7mutem.setDisplayName(Methods.format("&a&lSeverity 1"));
		List<String> week7mlore = new ArrayList<String>();
		week7mlore.add(Methods.format("&fMute Duration: &e1 week."));
		week7mlore.add("");

		week7mlore.add(Methods.format("&7Examples:"));
		week7mlore.add(Methods.format(" &fSpamming, after being warned."));
		week7mlore.add(Methods.format(" &fNot listening to staff members."));
		week7mutem.setLore(week7mlore);
		week7mute.setItemMeta(week7mutem);

		ItemStack warn = new ItemStack(Material.PAPER);
		ItemMeta warnm = warn.getItemMeta();
		warnm.setDisplayName(Methods.format("&a&lWarns"));
		List<String> warnlore = new ArrayList<String>();
		warnlore.add(Methods.format("&fWarn:"));
		warnlore.add("");

		warnlore.add(Methods.format("&7Examples:"));
		warnlore.add(Methods.format(" &fLight spamming."));
		warnlore.add(Methods.format(" &fToxicity"));
		warnlore.add(Methods.format(" &fAbusing Glitches"));
		warnlore.add(Methods.format(" &fAlting."));
		warnm.setLore(warnlore);
		warn.setItemMeta(warnm);

		ItemStack permmute = new ItemStack(Material.BOOK_AND_QUILL);
		ItemMeta permmutem = permmute.getItemMeta();
		permmutem.setDisplayName(Methods.format("&a&lMute"));
		List<String> permmutelore = new ArrayList<String>();
		permmutelore.add(Methods.format("&fMute Duration: &ePermanent"));
		permmutelore.add("");

		permmutelore.add(Methods.format("&7Examples:"));
		permmutelore.add(Methods.format(" &fLight spamming."));
		permmutelore.add(Methods.format(" &fToxicity"));
		permmutelore.add(Methods.format(" &fAbusing Glitches"));
		permmutelore.add(Methods.format(" &fAlting."));
		permmutem.setLore(permmutelore);
		permmute.setItemMeta(permmutem);

		ItemStack permban = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta permbanm = permban.getItemMeta();
		permbanm.setDisplayName(Methods.format("&a&lBan"));
		List<String> permbanlore = new ArrayList<String>();
		permbanlore.add(Methods.format("&fBan Duration: &ePermanent"));
		permbanlore.add("");

		permbanlore.add(Methods.format("&7Examples:"));
		permbanlore.add(Methods.format(" &fHacking multiple times."));
		permbanlore.add(Methods.format(" &fBan Evading."));
		permbanlore.add(Methods.format(" &fAccount hacking."));
		permbanlore.add(Methods.format(" &fStealing information"));
		permbanlore.add(Methods
				.format(" &fUsing bugs to your advantage, with warnings."));
		permbanm.setLore(permbanlore);
		permban.setItemMeta(permbanm);

		punish.setItem(14, warn);
		punish.setItem(23, permmute);
		punish.setItem(32, permban);

		punish.setItem(12, h4mute);
		punish.setItem(21, week7mute);

		punish.setItem(10, tempban1day);
		punish.setItem(19, tempban1week);
		punish.setItem(28, tempban3week);
		punish.setItem(37, tempban8week);

		p.openInventory(punish);
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if (e.getCurrentItem() == null) {
			return;
		}
		if (e.getInventory().getName().equalsIgnoreCase("Punish")) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.BOOK) {
				Player t = Bukkit.getPlayer(e.getInventory().getItem(4)
						.getItemMeta().getDisplayName());
				if (t == null) {
					return;
				}
				String sb = e.getInventory().getItem(4).getItemMeta().getLore()
						.get(1);
				Bukkit.dispatchCommand(
						e.getWhoClicked(),
						"tempban " + t.getName() + " 86400 "
								+ ChatColor.stripColor(sb));
				e.getWhoClicked().closeInventory();
				pf.getData().set("Punishments." + t.getName() + ".punished",
						true);
				pf.getData().set("Punishments." + t.getName() + ".punishment",
						"Tempban: 1 days");
				pf.saveData();
				// if (PunishManager.getPunishment(t) == true) {
				// PunishManager.setNewPunishment(sb, t, punish);
				// }
			}
			if (e.getCurrentItem().getType() == Material.WOOL
					&& e.getCurrentItem().getDurability() == 4) {
				Player t = Bukkit.getPlayer(e.getInventory().getItem(4)
						.getItemMeta().getDisplayName());
				if (t == null) {
					return;
				}
				String sb = e.getInventory().getItem(4).getItemMeta().getLore()
						.get(1);
				Bukkit.dispatchCommand(
						e.getWhoClicked(),
						"tempban " + t.getName() + " 604800 "
								+ ChatColor.stripColor(sb));
				e.getWhoClicked().closeInventory();
				pf.getData().set("Punishments." + t.getName() + ".punished",
						true);
				pf.getData().set("Punishments." + t.getName() + ".punishment",
						"Tempban: 7 days");
				pf.saveData();
				// if (PunishManager.getPunishment(t) == true) {
				// PunishManager.setNewPunishment( sb, t, punish);
				// }
			}

			if (e.getCurrentItem().getType() == Material.WOOL
					&& e.getCurrentItem().getDurability() == 1) {
				Player t = Bukkit.getPlayer(e.getInventory().getItem(4)
						.getItemMeta().getDisplayName());
				if (t == null) {
					return;
				}
				String sb = e.getInventory().getItem(4).getItemMeta().getLore()
						.get(1);
				Bukkit.dispatchCommand(
						e.getWhoClicked(),
						"tempban " + t.getName() + " 1209600 "
								+ ChatColor.stripColor(sb));
				e.getWhoClicked().closeInventory();
				pf.getData().set("Punishments." + t.getName() + ".punished",
						true);
				pf.getData().set("Punishments." + t.getName() + ".punishment",
						"Tempban: 14 days");
				pf.saveData();
				// if (PunishManager.getPunishment(t) == true) {
				// PunishManager.setNewPunishment( sb, t, punish);
				// }
			}
			if (e.getCurrentItem().getType() == Material.WOOL
					&& e.getCurrentItem().getDurability() == 14) {
				Player t = Bukkit.getPlayer(e.getInventory().getItem(4)
						.getItemMeta().getDisplayName());
				if (t == null) {
					return;
				}
				String sb = e.getInventory().getItem(4).getItemMeta().getLore()
						.get(1);
				Bukkit.dispatchCommand(
						e.getWhoClicked(),
						"tempban " + t.getName() + " 5259492 "
								+ ChatColor.stripColor(sb));
				e.getWhoClicked().closeInventory();
				pf.getData().set("Punishments." + t.getName() + ".punished",
						true);
				pf.getData().set("Punishments." + t.getName() + ".punishment",
						"Tempban: 2 months");
				pf.saveData();
				// if (PunishManager.getPunishment(t) == true) {
				// PunishManager.setNewPunishment( sb, t, punish);
				// }
			}
			if (e.getCurrentItem().getType() == Material.REDSTONE_BLOCK) {
				Player t = Bukkit.getPlayer(e.getInventory().getItem(4)
						.getItemMeta().getDisplayName());
				String sb = e.getInventory().getItem(4).getItemMeta().getLore()
						.get(1);
				Bukkit.dispatchCommand(e.getWhoClicked(), "ban " + t.getName()
						+ " " + sb.toString());
				e.getWhoClicked().closeInventory();
				pf.getData().set("Punishments." + t.getName() + ".punished",
						true);
				pf.getData().set("Punishments." + t.getName() + ".punishment",
						"Ban: Permanent");
				pf.saveData();
				// if (PunishManager.getPunishment(t) == true) {
				// PunishManager.setNewPunishment( sb, t, punish);
				// }
			}

			if (e.getCurrentItem().getType() == Material.HOPPER) {
				Player t = Bukkit.getPlayer(e.getInventory().getItem(4)
						.getItemMeta().getDisplayName());
				String sb = e.getInventory().getItem(4).getItemMeta().getLore()
						.get(1);
				Bukkit.dispatchCommand(e.getWhoClicked(),
						"tempmute " + t.getName() + " 14400 " + sb.toString());
				e.getWhoClicked().closeInventory();
				pf.getData().set("Punishments." + t.getName() + ".punished",
						true);
				pf.getData().set("Punishments." + t.getName() + ".punishment",
						"Mute: 4 hours");
				pf.saveData();
				// if (PunishManager.getPunishment(t) == true) {
				// PunishManager.setNewPunishment( sb, t, punish);
				// }
			}

			if (e.getCurrentItem().getType() == Material.WOOL
					&& e.getCurrentItem().getDurability() == 5) {
				Player t = Bukkit.getPlayer(e.getInventory().getItem(4)
						.getItemMeta().getDisplayName());
				String sb = e.getInventory().getItem(4).getItemMeta().getLore()
						.get(1);
				Bukkit.dispatchCommand(e.getWhoClicked(),
						"tempmute " + t.getName() + " 604800 " + sb.toString());
				e.getWhoClicked().closeInventory();
				pf.getData().set("Punishments." + t.getName() + ".punished",
						true);
				pf.getData().set("Punishments." + t.getName() + ".punishment",
						"Mute: 1 week");
				pf.saveData();
				// if (PunishManager.getPunishment(t) == true) {
				// PunishManager.setNewPunishment( sb, t, punish);
				// }
			}

			if (e.getCurrentItem().getType() == Material.BOOK_AND_QUILL) {
				Player t = Bukkit.getPlayer(e.getInventory().getItem(4)
						.getItemMeta().getDisplayName());
				Bukkit.dispatchCommand(e.getWhoClicked(), "mute " + t.getName());
				e.getWhoClicked().closeInventory();
				pf.getData().set("Punishments." + t.getName() + ".punished",
						true);
				pf.getData().set("Punishments." + t.getName() + ".punishment",
						"Mute: Permanent");
				pf.saveData();
				// if (PunishManager.getPunishment(t) == true) {
				// PunishManager.setNewPunishment( sb, t, punish);
				// }
			}

			if (e.getCurrentItem().getType() == Material.PAPER) {
				Player t = Bukkit.getPlayer(e.getInventory().getItem(4)
						.getItemMeta().getDisplayName());
				String reason = e.getInventory().getItem(4).getItemMeta()
						.getLore().get(1);
				Bukkit.dispatchCommand(e.getWhoClicked(), "warn " + t.getName()
						+ " " + reason);
				e.getWhoClicked().closeInventory();

			}
		}
	}
}
