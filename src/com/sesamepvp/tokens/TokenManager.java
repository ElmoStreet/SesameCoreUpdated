package com.sesamepvp.tokens;

import org.bukkit.entity.Player;

import com.sesamepvp.files.KitpvpFile;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class TokenManager {
	public static KitpvpFile kpf = KitpvpFile.getInstance();
	
	public static int getBalance(Player p){
		int bal = kpf.getData().getInt(p.getUniqueId() + ".tokens");
		return bal;
	}
	
	public static boolean balanceNull(Player p){
		if(getBalance(p) == 0){
			return true;
		}else{
			return false;
		}
	}
	
	public static void sendBalance(Player p, Player target){
		p.sendMessage(Messages.prefix(Methods.format("&a" + target.getName() + " &aTokens: &e" + getBalance(target))));
		return;
	}
	
	public static void pay(Player p, Player target, int amount){
		if(getBalance(p) < amount){
			p.sendMessage(Messages.prefix(Methods.format("&cYou have insufficient funds for this")));
			return;
		}else{
		p.sendMessage(Messages.prefix(Methods.format("&aPayed &e" + target.getName() + " " + amount + " &aTokens.")));
		target.sendMessage(Messages.prefix(Methods.format("&aYou recieved &e " + amount + " &aTokens from&e " + p.getName())));
		kpf.getData().set(p.getUniqueId() + ".tokens", getBalance(p) - amount);
		kpf.getData().set(target.getUniqueId() + ".tokens", getBalance(target) + amount);
		kpf.saveData();
		}
	}
	
	public static void setBalance(Player p, int amount){
		kpf.getData().set(p.getUniqueId()+".tokens", amount);
		kpf.saveData();
		return;
	}
	
	public static void addBalance(Player p, int amount){
		kpf.getData().set(p.getUniqueId()+".tokens",getBalance(p)+amount);
		kpf.saveData();
		return;
	}
	
	public static void resetBalance(Player p){
		kpf.getData().set(p.getUniqueId()+".tokens", 0);
		kpf.saveData();
		return;
	}

	public static void takeBalance(Player target, int amount) {
		if(getBalance(target) < amount){
			return;
		}else{
			kpf.getData().set(target.getUniqueId()+".tokens", getBalance(target) - amount);
			kpf.saveData();
		}
	}

	public static boolean canBuy(Player p, int amount) {
		if(getBalance(p) >amount){
			return true;
		}else{
			return false;
		}
	}
}
