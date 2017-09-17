package com.sesamepvp.staffmode.commands.report.manager;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.sesamepvp.files.ReportsFile;
import com.sesamepvp.utilites.Methods;

public class ReportManager implements Listener{
	static ReportsFile rf = ReportsFile.getInstance();
	
	public static int slotnumberMAX = 0;
	
	public static boolean reported;

	public static boolean getReport(Player p) {
		if (rf.getData().getString("Reports." + p.getUniqueId()) == null) {
			reported = false;
		} else {
			reported = true;
		}
		return reported;
	}

	public static String getReporters(Player p) {
		List<String> reports = rf.getData().getStringList("Reports." + p.getUniqueId() + ".reporters");
		return reports.toString();
	}

	public static void clearReports(Player p) {
		if (getReport(p) == false) {
			return;
		} else {
			rf.getData().set("Reports." + p.getUniqueId(), null);
			rf.saveData();
		}
	}

	public static void clearAllReports() {
		ReportsFile.rfile.delete();
		rf.reloadData();
		rf.saveData();
	}

	public static void addReport(Player p, Inventory inv, int slot) {
		if (getReport(p) == false) {
			return;
		} else {
			ItemStack newreport = new ItemStack(Material.PAPER);
			ItemMeta newreportm = newreport.getItemMeta();
			List<String> newreportlore = new ArrayList<String>();
			newreportm.setDisplayName(Methods.format(p.getName()));
			newreportlore.add(Methods.format("&8&l&m-------------"));
			newreportlore.add(Methods.format("&aReasons:"));
			for (String reasons : rf.getData().getStringList("Reports." + p.getUniqueId() + ".reasons")){
				newreportlore.add(Methods.format("&2" + reasons));
			}
			newreportlore.add(Methods.format("&8&l&m-------------"));
			newreportlore.add(Methods.format("&aReporters:"));
			for (String reporters : rf.getData().getStringList("Reports." + p.getUniqueId() + ".reporters")){
				newreportlore.add(Methods.format("&2" + reporters));
			}
			newreportlore.add(Methods.format("&8&l&m-------------"));
			newreportlore.add(Methods.format("&cClick to clear this report!"));
			newreportlore.add(Methods.format("&8&l&m-------------"));
			newreportm.setLore(newreportlore);
			newreport.setItemMeta(newreportm);
			if(slotnumberMAX > slot){
				inv.setItem(slot++, newreport);
			}else{
				inv.setItem(slot, newreport);
			}
			
			slotnumberMAX++;
		}
	}

	public static void removeReport(Player clickedreport, Inventory reportGUI, int slotnumberMAX2) {
		ItemStack air = new ItemStack(Material.AIR);
		reportGUI.setItem(slotnumberMAX2, air);
		clearReports(clickedreport);
		slotnumberMAX = slotnumberMAX2;
	}
	
	public static void removeAllReports(Inventory inv){
		int data = 0;
		ItemStack air = new ItemStack(Material.AIR);
		while(data < 53){
			if(data == 45){
				return;
			}else{
			inv.setItem(data, air);
			data++;
			}
		}
	}

}
