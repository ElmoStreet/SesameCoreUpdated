package com.sesamepvp.kitpvp.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.sesamepvp.files.KitpvpFile;
import com.sesamepvp.kitpvp.gui.KitShopGUI;
import com.sesamepvp.kitpvp.gui.KitsGUI;
import com.sesamepvp.kitpvp.managers.KitListener;
import com.sesamepvp.utilites.Messages;

public class GiveRespawnItems implements Listener {

	KitpvpFile manager = KitpvpFile.getInstance();

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage(Messages.joinMessage(p));
		p.getInventory().clear();
		p.getActivePotionEffects().clear();

		ItemStack cs = new ItemStack(Material.DIAMOND);
		ItemMeta csm = cs.getItemMeta();
		csm.setDisplayName(ChatColor.RED + "Kit Shop");
		cs.setItemMeta(csm);

		ItemStack ns = new ItemStack(Material.NETHER_STAR);
		ItemMeta nsm = ns.getItemMeta();
		nsm.setDisplayName(ChatColor.RED + "Kit Selector");
		ns.setItemMeta(nsm);
		p.getInventory().setItem(4, ns);
		p.getInventory().setItem(8, cs);
		if (KitListener.kitselected.contains(p)) {
			KitListener.kitselected.remove(p);
		}
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		Player k = e.getEntity().getKiller();
		if(k instanceof Player){
			
		
		e.setDeathMessage(Messages.deathMessage(p, k));
		e.getDrops().clear();
		}else{
			return;
		}
		if (p instanceof Player) {
			p.getActivePotionEffects().clear();

			ItemStack cs = new ItemStack(Material.DIAMOND);
			ItemMeta csm = cs.getItemMeta();
			csm.setDisplayName(ChatColor.RED + "Kit Shop");
			cs.setItemMeta(csm);

			ItemStack ns = new ItemStack(Material.NETHER_STAR);
			ItemMeta nsm = ns.getItemMeta();
			nsm.setDisplayName(ChatColor.RED + "Kit Selector");
			ns.setItemMeta(nsm);
			p.getInventory().setItem(4, ns);
			p.getInventory().setItem(8, cs);
		}else{
			return;
		}
		if (KitListener.kitselected.contains(p)) {
			KitListener.kitselected.remove(p);

		}
	}

	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_AIR
				|| e.getAction() == Action.RIGHT_CLICK_BLOCK
				|| e.getAction() == Action.LEFT_CLICK_AIR
				|| e.getAction() == Action.LEFT_CLICK_BLOCK) {
			if (p.getItemInHand().getType() == Material.NETHER_STAR) {
				KitsGUI.gui(p);
			}
		}
	}

	
	@EventHandler
	public void onInteraction(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_AIR
				|| e.getAction() == Action.RIGHT_CLICK_BLOCK
				|| e.getAction() == Action.LEFT_CLICK_AIR
				|| e.getAction() == Action.LEFT_CLICK_BLOCK) {
			if (p.getItemInHand().getType() == Material.DIAMOND) {
				KitShopGUI.openKitshop(p);
			}
		}
	}
}
