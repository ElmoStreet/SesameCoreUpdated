package com.sesamepvp.kitpvp.abilities;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.sesamepvp.staffmode.StaffmodeManager;

public class SlugAbility implements Listener {
	
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
		Player t = (Player) e.getEntity();
		if (e.getDamager().getType() == EntityType.ARROW) {
			@SuppressWarnings("unused")
			Entity p = e.getDamager();
			return;
		} else {
			if (e.getDamager().getType() == EntityType.PLAYER) {
				Player p = (Player) e.getDamager();
				if (p.getItemInHand().getType() == Material.DIAMOND_SWORD) {
					if (StaffmodeManager.slug.contains(p)) {

						PotionEffect potionEffect = new PotionEffect(
								PotionEffectType.SLOW, 30, 3);
						potionEffect.apply(t);

						PotionEffect potionEffect2 = new PotionEffect(
								PotionEffectType.SPEED, 30, 0);
						potionEffect2.apply(p);

					}
				}
			}
		}
	}
}
