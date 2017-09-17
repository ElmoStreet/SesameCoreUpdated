package com.sesamepvp.friend.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.entity.Player;

import com.sesamepvp.files.FriendFile;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class FriendManager {
	static FriendFile ff = FriendFile.getInstance();

	public static HashMap<Player, Player> friendrequest = new HashMap<Player,Player>();
	
	public static List<String> getFriends(Player p) {
		if (haveFriends(p)) {
			return ff.getData().getStringList(p.getUniqueId() + ".friends");
		}else{
			return null;
		}
	}

	public static boolean haveFriends(Player p) {
		if (getFriends(p) == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean getRequest(Player p){
		if(friendrequest.containsKey(p)){
			return true;
		}else{
			return false;
		}
	}
	
	public static void newRequest(Player p, Player t){
		friendrequest.put(p, t);
		friendrequest.put(t, p);
		p.sendMessage(Messages.prefix(Methods.format("&aFriend Request Sent!")));
		t.sendMessage(Messages.prefix(Methods.format("&aYou have recieved a friend request from &2" + t.getName())));
		t.sendMessage(Messages.prefix(Methods.format("&eType /friend accept <player> to accept the friend request")));
	  return;
	}
	
	public static boolean isFriendsWith(Player p, Player t){
		//If player p is friends with player t.
		if(getFriends(p).contains(t.getName())){
			return true;
		}else{
			return false;
		}
	}
		
	public static void addFriend(Player p, Player t){
		List<String> friends = new ArrayList<String>();
		friends.add(t.getName());
		p.sendMessage(Messages.prefix(Methods.format("&aYou have a new friend! &e" + t.getName())));
		t.sendMessage(Messages.prefix(Methods.format("&aYou have a new friend! &e" + p.getName())));
		ff.getData().set(p.getName(), friends);
		ff.saveData();
	}
}
