package com.sesamepvp.punishments.GUI;

public class PunishManager {
//	static PunishmentsFile pf = PunishmentsFile.getInstance();
//	public static boolean isPunished = false;
//	
//	public static boolean getPunishment(Player p){
//		if(pf.getData().getBoolean("Punishments." + p.getName() + ".punished") == true){
//			isPunished = true;
//		}else{
//			isPunished = false;
//		}
//		return isPunished;
//	}
//	public static int slot = 8;
//	
//	public static void setNewPunishment(String reason,Player p, Inventory inv){
//		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE,1,(short) 14);
//		ItemMeta im = item.getItemMeta();
//		String punishmenttype = pf.getData().getString("Punishments." + p.getName() + ".punishment");
//		im.setDisplayName(Methods.format("&a&l "+ punishmenttype));
//		List<String> lore = new ArrayList<String>();
//		lore.add(Methods.format(""));
//		if(punishmenttype.equalsIgnoreCase("Tempban: 1 days")){
//			lore.add(Methods.format("&fBan Duration: &f1 day."));
//			lore.add(Methods.format(""));
//			lore.add(Methods.format("&a&lType:"));
//			lore.add(Methods.format(" &7General Ban"));
//			lore.add(Methods.format(""));
//			lore.add(Methods.format("&a&lReason:"));
//			lore.add(Methods.format(" &7" + reason));
//			lore.add(Methods.format(""));
//			lore.add(Methods.format("&cClick to clear all history!"));
//			im.setLore(lore);
//			item.setItemMeta(im);
//		}else{
//			if(punishmenttype.equalsIgnoreCase("Tempban: 7 days")){
//				lore.add(Methods.format("&fBan Duration: &f7 day."));
//				lore.add(Methods.format(""));
//				lore.add(Methods.format("&a&lType:"));
//				lore.add(Methods.format(" &7Severity 1"));
//				lore.add(Methods.format(""));
//				lore.add(Methods.format("&a&lReason:"));
//				lore.add(Methods.format(" &7" + reason));
//				lore.add(Methods.format(""));
//				lore.add(Methods.format("&cClick to clear all history!"));
//				im.setLore(lore);
//				item.setItemMeta(im);
//			}
//		}
//		im.setLore(lore);
//		item.setItemMeta(im);
//		inv.setItem(slot, item);
//		slot = slot + 9;
//	}
//	
//	public static void removePunishment(int slot, Inventory inv){
//		ItemStack air = new ItemStack(Material.AIR);
//		inv.setItem(slot, air);
//	}
}
