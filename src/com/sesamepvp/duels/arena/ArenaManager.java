package com.sesamepvp.duels.arena;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.sesamepvp.files.ArenaFile;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class ArenaManager {
	static ArenaFile af = ArenaFile.getInstance();
	public static boolean inDuel = false;
	public static HashMap<Player, Player> duel = new HashMap<Player, Player>();
	public static HashMap<Player, Player> request = new HashMap<Player, Player>();
	public static HashMap<Player, Location> prevloc = new HashMap<Player, Location>();
	public static HashMap<Player, ItemStack[]> inventory = new HashMap<Player, ItemStack[]>();
	public static HashMap<Player, ItemStack[]> armor = new HashMap<Player, ItemStack[]>();
	public static HashMap<String, Boolean> available = new HashMap<String, Boolean>();
	public static HashMap<Player, String> inarenawhat = new HashMap<Player, String>();

	public static boolean inArena(Player p) {
		if (duel.containsKey(p)) {
			inDuel = true;
		} else {
			inDuel = false;
		}
		return inDuel;
	}

	public static boolean isArena(String arenaname) {
		if (af.getData().isSet(arenaname)) {
			return true;
		} else {
			return false;
		}
	}

	public static void newArena(String arenaname) {
		af.getData().set(arenaname + ".activated", true);
		available.put(arenaname, false);
		af.saveData();
		return;
	}

	public static Location getSpawnLoc1(String arenaname) {
		if (isArena(arenaname)) {
			Location loc = (Location) af.getData().get(
					arenaname + ".spawnlocation1");
			return loc;
		} else {
			return null;
		}
	}

	public static boolean ArenaEmpty(String arenaname) {
		if(available.get(arenaname) == null || available.get(arenaname) == false){
			return false;
		}else{
			return true;
		}
	}

	public static Location getSpawnLoc2(String arenaname) {
		if (isArena(arenaname)) {
			Location loc = (Location) af.getData().get(
					arenaname + ".spawnlocation2");
			return loc;
		} else {
			return null;
		}
	}

	public static void acceptRequest(Player accepter, Player dueler,
			String arenaname) {
		newDuel(dueler, accepter, arenaname);
		return;
	}

	public static void delArena(String arenaname) {
		if (isArena(arenaname)) {
			af.getData().set(arenaname, null);
			af.saveData();
		} else {
			return;
		}
	}

	public static void newRequest(Player p, Player t, String arenaname) {
		request.put(p, t);
		request.put(t, p);
		p.sendMessage(Messages.prefix(Methods.format("&aRequest sent to "
				+ t.getName())));
		t.sendMessage(Messages.prefix(Methods
				.format("&aYou have recieved a duel request for arena "
						+ arenaname + " from " + p.getName())));
		t.sendMessage(Messages.prefix(Methods
				.format("&eUse /duel accept &a" + arenaname +" &eto accept the duel!")));
		return;
	}

	public static String getArena(Player p) {
		if (inArena(p)) {
			return inarenawhat.get(p);
		} else {
			return null;
		}
	}

	public static void recover(Player p) {
		if (inventory.containsKey(p)) {
			p.getInventory().setContents(inventory.get(p));
		}
		if (armor.containsKey(p)) {
			p.getInventory().setArmorContents(armor.get(p));
		}
		if (prevloc.containsKey(p)) {
			p.teleport(prevloc.get(p));
		}
		return;
	}

	public static void endDuel(Player dueler, Player accepter, String arenaname) {
		if (ArenaEmpty(arenaname)) {
			if (isArena(arenaname)) {
				available.remove(arenaname);
				dueler.getInventory().clear();
				accepter.getInventory().clear();

				request.remove(accepter);
				request.remove(dueler);

				duel.remove(accepter);
				duel.remove(dueler);

				recover(accepter);
				recover(dueler);
				inarenawhat.remove(dueler);
				inarenawhat.remove(accepter);
			} else {
				return;
			}
		} else {
			return;
		}
	}

	public static void newDuel(Player dueler, Player accepter, String arenaname) {
		if (!ArenaEmpty(arenaname)) {
			Bukkit.broadcastMessage("4");
			if (isArena(arenaname)) {
				Bukkit.broadcastMessage("5");
				if (!inArena(accepter) || inArena(dueler)) {
					Bukkit.broadcastMessage("6");
					available.put(arenaname, true);
					inarenawhat.put(dueler, arenaname);
					inarenawhat.put(accepter, arenaname);
					inventory.put(dueler, dueler.getInventory().getContents());
					inventory.put(accepter, accepter.getInventory()
							.getContents());

					prevloc.put(dueler, dueler.getLocation());
					prevloc.put(accepter, accepter.getLocation());

					armor.put(dueler, dueler.getInventory().getArmorContents());
					armor.put(accepter, accepter.getInventory()
							.getArmorContents());

					duel.put(dueler, accepter);
					duel.put(accepter, dueler);
					Location loc1 = getSpawnLoc1(arenaname);
					Location loc2 = getSpawnLoc2(arenaname);

					dueler.teleport(loc1);
					accepter.teleport(loc2);
					// if (KitManager.kitDefined(arenaname)) {
					// KitManager.applyKit(accepter, arenaname);
					// KitManager.applyKit(dueler, arenaname);
					// }else{
					// return;
					// }

					accepter.getInventory().clear();
					dueler.getInventory().clear();

					accepter.getInventory().setBoots(
							new ItemStack(Material.IRON_BOOTS));
					;
					accepter.getInventory().setChestplate(
							new ItemStack(Material.IRON_CHESTPLATE));
					;
					accepter.getInventory().setLeggings(
							new ItemStack(Material.IRON_LEGGINGS));
					;
					accepter.getInventory().setHelmet(
							new ItemStack(Material.IRON_HELMET));
					;

					for (int i = 0; i <= 34; i++) {
						accepter.getInventory().addItem(
								new ItemStack(Material.MUSHROOM_SOUP));
						dueler.getInventory().addItem(
								new ItemStack(Material.MUSHROOM_SOUP));
					}
					accepter.getInventory().setItem(0,
							new ItemStack(Material.DIAMOND_SWORD));
					dueler.getInventory().setItem(0,
							new ItemStack(Material.DIAMOND_SWORD));

					dueler.getInventory().setBoots(
							new ItemStack(Material.IRON_BOOTS));
					;
					dueler.getInventory().setChestplate(
							new ItemStack(Material.IRON_CHESTPLATE));
					;
					dueler.getInventory().setLeggings(
							new ItemStack(Material.IRON_LEGGINGS));
					;
					dueler.getInventory().setHelmet(
							new ItemStack(Material.IRON_HELMET));
					;

					dueler.sendMessage(Messages.prefix(Methods
							.format("&aDuel has started with &e"
									+ accepter.getName() + "&a!")));
					accepter.sendMessage(Messages.prefix(Methods
							.format("&aDuel has started with &e"
									+ dueler.getName() + "&a!")));
				} else {

				}
			} else {
				return;
			}
		} else {
			return;
		}
	}
}
