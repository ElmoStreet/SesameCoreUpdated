package com.sesamepvp.duels.kits;


public class KitManager {
//	static ArenaFile af = ArenaFile.getInstance();
//
//	public static boolean kitDefined = false;
//
//	public static boolean kitDefined(String arenaname) {
//		if (af.getData().contains(arenaname + ".kit")) {
//			return true;
//		} else {
//			return false;
//		}
//	}
//
//	public static ItemStack[] getInventory(String arenaname) {
//		if (kitDefined(arenaname)) {
//			return (ItemStack[]) af.getData().get(arenaname + ".kit.contents");
//		} else {
//			return null;
//		}
//	}
//
//	@SuppressWarnings("unchecked")
//	public static ItemStack[] getArmor(String arenaname) {
//		if (kitDefined(arenaname)) {
//			ItemStack[] content = ((List<ItemStack>) af.getData().get(
//					arenaname + ".kit.armor")).toArray(new ItemStack[0]);
//			return content;
//		} else {
//			return null;
//		}
//	}
//
//	public static void applyKit(Player p, String arenaname) {
//		if (ArenaManager.isArena(arenaname)) {
//			p.getInventory().setContents(Other.fromBase64(af.getData().getString(arenaname+".kit.contents")));
//		} else {
//			return;
//		}
//	}
//
//	@SuppressWarnings("unused")
//	public static void saveKit(Player p, String arenaname) {
//		String invstring = Other.toBase64(p.getInventory());
//		af.getData().set(arenaname+".kit.contents", invstring);
//		af.saveData();
//		return;
//	}

}
