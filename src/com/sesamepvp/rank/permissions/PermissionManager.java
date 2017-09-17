package com.sesamepvp.rank.permissions;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.Plugin;

import com.sesamepvp.main.SesameCore;

public class PermissionManager {
	SesameCore instance;
	public PermissionManager(SesameCore instance){
		this.instance = instance;
	}
	public static HashMap<UUID, PermissionAttachment> perms = new HashMap<UUID, PermissionAttachment>();

	public static void addPermission(Player p, Plugin plugin,
			String permissionnode) {
		PermissionAttachment attachment = p.addAttachment(plugin);
		perms.put(p.getUniqueId(), attachment);

		PermissionAttachment pperms = perms.get(p.getUniqueId());
		pperms.setPermission(permissionnode, true);
	}

	//public static void removePermission(Player p) {
		//perms.get(p.getUniqueId()).unsetPermission(permissionnode);
	//	if(perms.get(p.getUniqueId().(perms.get(p.getUniqueId()))){
	//	p.removeAttachment(perms.get(p.getUniqueId()));
	//	}
	//	}

	public static void removePermission(Player p, List<String> permissionnode) {
		for (int i = 0; i < permissionnode.size(); i++) {
			perms.get(p.getUniqueId()).unsetPermission(permissionnode.get(i));
		}
	}
    
    public static void removeAllPermissions(Player player){
    	perms.remove(player.getUniqueId());
    	return;
    }
}
