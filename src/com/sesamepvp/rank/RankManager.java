package com.sesamepvp.rank;

import java.util.List;

import org.bukkit.entity.Player;

import com.sesamepvp.files.Rankfile;
import com.sesamepvp.utilites.Methods;

public class RankManager {
	public static Rankfile rf = Rankfile.getInstance();
	public String rank;
	public boolean staff;
	public int rankvalue;
	
	//Ranks:
	 //builder:
		 //prefix: 'hi'
     //jerry:
    	//prefix: 'jerry'
	public static void newRank(String rankname){
		rf.getData().set("Ranks." + rankname, "");
		rf.saveData();
	}
	
	public static boolean rankExists(String rankname){
		if(rf.getData().contains("Ranks." + rankname)){
			return true;
		}else{
			return false;
		}
	}
	
	public static void removeRank(String rankname){
		rf.getData().set("Ranks." + rankname, null);
		rf.saveData();
		return;
	}
	
	public static void setPrefix(String rankname, String prefix){
		if(rankExists(rankname)){
			 rf.getData().set("Ranks." + rankname +".prefix", Methods.format(prefix));
			 rf.saveData();
		}else{
			return;
		}
	}
	
	public static String getPrefix(String rankname){
		return (String) rf.getData().get("Ranks." + rankname+".prefix");
	}
	
	public static List<String> getPermissions(String rankname){
		List<String> permissionlist = rf.getData().getStringList("Ranks." + rankname + ".permissions");
		return permissionlist;
	}
	
	public static void setRank(Player p, String rankname){
		rf.getData().set("Users."+p.getUniqueId()+".rank",rankname);
		rf.saveData();
		return;
	}
	
	public static String getRank(Player p){
		
		return (String) rf.getData().get("Users."+p.getUniqueId()+".rank");
	}
}
