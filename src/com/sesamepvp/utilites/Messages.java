package com.sesamepvp.utilites;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import com.sesamepvp.files.MessageFile;
import com.sesamepvp.staffmode.StaffmodeManager;

public class Messages {
	static MessageFile msgconfig = MessageFile.getInstance();
	public static String prefix(String txt) {
		String prefix = StaffmodeManager.format(msgconfig.getData().getString("prefix"));
		return prefix + "" + txt;
	}

	public static String noPermission() {
		//String noPermission = "§cYou do not have permission for this.";
		String noPermission = StaffmodeManager.format(msgconfig.getData().getString("nopermission"));
		return prefix(noPermission);
	}
	
	public static String notPlayer() {
		//String notPlayer = "§cYou must be a player to execute this command.";
		String notPlayer = StaffmodeManager.format(msgconfig.getData().getString("notPlayer"));
		return prefix(notPlayer);
	}

	public static String modDisabled() {
		//String modDisabled = "§cYou have left §4Staff §cmode.";
		String modDisabled = StaffmodeManager.format(msgconfig.getData().getString("staffmode.disabled"));
		return prefix(modDisabled);
	}

	public static String modEnabled() {
		String modEnabled = StaffmodeManager.format(msgconfig.getData().getString("staffmode.enabled"));
		return prefix(modEnabled);
	}

	public static String mustleaveMod() {
		String mustleaveMod = StaffmodeManager.format(msgconfig.getData().getString("staffmode.mustleavemod"));
		return prefix(mustleaveMod);
	}

	public static String noitemDrop() {
		String noitemDrop = StaffmodeManager.format(msgconfig.getData().getString("staffmode.noitemdrop"));
		return prefix(noitemDrop);
	}

	public static String noBlockPlace() {
		String noBlockPlace = StaffmodeManager.format(msgconfig.getData().getString("staffmode.noblockplace"));
		return prefix(noBlockPlace);
	}

	public static String noDamage() {
		String noDamage = StaffmodeManager.format(msgconfig.getData().getString("staffmode.nodamage"));
		return prefix(noDamage);
	}

	public static String freezeArgs() {
		String freezeArgs = "§cUsage: /freeze <player>";
		return prefix(freezeArgs);
	}

	public static String playerNull() {
		String playerNull = StaffmodeManager.format(msgconfig.getData().getString("playernull"));
		return prefix(playerNull);
	}

	public static String frozePlayer(Player p) {
		String frozePlayer = "§cYou have froze §4" + p.getName() + "§c.";
		return prefix(frozePlayer);
	}

	public static String unfrozePlayer(Player p) {
		String unfrozePlayer = "§aYou have unfroze §2" + p.getName() + "§a.";
		return prefix(unfrozePlayer);
	}

	public static String frozen(Player freezer) {
		String frozen = "§cYou have been frozen by §4" + freezer.getName()
				+ " §cPlease join coordinate with the staff member.";
		return prefix(frozen);
	}

	public static String unFrozen(Player unfreezer) {
		String unFrozen = "§aYou have been unfrozen by §2"
				+ unfreezer.getName() + "§a.";
		return prefix(unFrozen);
	}

	public static String playerFrozen() {
		String playerFrozen = StaffmodeManager.format(msgconfig.getData().getString("staffmode.frozen"));
		return prefix(playerFrozen);
	}

	public static String talkDenied() {
		String talkDenied = StaffmodeManager.format(msgconfig.getData().getString("chat.talkdenied"));
		return prefix(talkDenied);
	}

	public static String chatMuted() {
		String chatMuted = StaffmodeManager.format(msgconfig.getData().getString("chat.muted"));
		return prefix(chatMuted);
	}

	public static String chatUnmuted() {
		String chatunMuted = StaffmodeManager.format(msgconfig.getData().getString("chat.unmuted"));
		return prefix(chatunMuted);
	}

	public static String chatClear() {
		String chatClear = StaffmodeManager.format(msgconfig.getData().getString("chat.clear"));
		return prefix(chatClear);
	}

	public static String notenoughPlayers() {
		String notenoughPlayers = StaffmodeManager.format(msgconfig.getData().getString("staffmode.notenoughplayers"));
		return prefix(notenoughPlayers);
	}

	public static String randomteleportedTo(Player p) {
		String randomteleportedTo = "§aYou have been teleported to §2"
				+ p.getName() + "§a.";
		return prefix(randomteleportedTo);
	}

	public static String flightEnabled() {
		String flightEnabled = StaffmodeManager.format(msgconfig.getData().getString("staffmode.flight.enabled"));
		return prefix(flightEnabled);
	}

	public static String flightDisabled() {
		String flightDisabled = StaffmodeManager.format(msgconfig.getData().getString("staffmode.flight.disabled"));
		return prefix(flightDisabled);
	}

	public static String vanishEnabled() {
		String vanishEnabled = StaffmodeManager.format(msgconfig.getData().getString("staffmode.vanish.enabled"));
		return prefix(vanishEnabled);
	}

	public static String vanishDisabled() {
		String vanishDisabled = StaffmodeManager.format(msgconfig.getData().getString("staffmode.flight.disabled"));
		return prefix(vanishDisabled);
	}

	public static String reportUsage() {
		String reportUsage = "§cUsage: /report <player> <reason>";
		return prefix(reportUsage);
	}

	public static String reported(Player target, String reason) {
		String reported = "§aYou have reported §2" + target.getName()
				+ "§a for §2" + reason + ".";
		return prefix(reported);
	}

	public static String purchasedSpeedyKit() {
		String purchasedSpeedyKit = StaffmodeManager.format(msgconfig.getData().getString("kitpvp.purchasedkit.speedy"));
		return prefix(purchasedSpeedyKit);
	}

	public static String purchasedInsaneKit() {
		String purchasedInsaneKit = StaffmodeManager.format(msgconfig.getData().getString("kitpvp.purchasedkit.insane"));
		return prefix(purchasedInsaneKit);
	}

	public static String purchasedAssassinKit() {
		String purchasedAssassinKit = StaffmodeManager.format(msgconfig.getData().getString("kitpvp.purchasedkit.assassin"));
		return prefix(purchasedAssassinKit);
	}

	public static String purchasedGodArcherKit() {
		String purchasedGodArcherKit = StaffmodeManager.format(msgconfig.getData().getString("kitpvp.purchasedkit.godarcher"));
		return prefix(purchasedGodArcherKit);
	}

	public static String purchasedBurnerKit() {
		String purchasedBurnerKit = StaffmodeManager.format(msgconfig.getData().getString("kitpvp.purchasedkit.burner"));
		return prefix(purchasedBurnerKit);
	}

	public static String kitalreadyOwned() {
		String kitalreadyOwned = StaffmodeManager.format(msgconfig.getData().getString("kitpvp.kits.alreadyowned"));
		return prefix(kitalreadyOwned);
	}

	public static String insufficientFunds() {
		String insufficientFunds = StaffmodeManager.format(msgconfig.getData().getString("eco.insufficientfunds"));
		return prefix(insufficientFunds);
	}

	public static String rankNone() {
		String rankNone = "§aRank: §eNone.";
		return prefix(rankNone);
	}

	public static String rank(String rank) {
		String ranks = "§aRank: §e" + rank;
		return prefix(ranks);
	}

	public static String kills(int pkills) {
		String kills = "§aKills: §e" + pkills;
		return prefix(kills);
	}

	public static String deaths(int pdeaths) {
		String deaths = "§aDeaths: §e" + pdeaths;
		return prefix(deaths);
	}

	public static String targetStats(Player t) {
		String targetStats = "§2" + t.getName() + "'s §a stats :";
		return prefix(targetStats);
	}

	public static String openKitShop() {
		String openKitShop = StaffmodeManager.format(msgconfig.getData().getString("kitpvp.gui.openingkitshop"));
		return prefix(openKitShop);
	}

	public static String ranks() {
		String ranks = StaffmodeManager.format(msgconfig.getData().getString("kitpvp.ranks.rank"));
		return prefix(ranks);
	}

	public static String Warrior() {
		String warrior = StaffmodeManager.format(msgconfig.getData().getString("kitpvp.ranks.warrior"));
		return prefix(warrior);
	}

	public static String Gladiator() {
		String Gladiator = StaffmodeManager.format(msgconfig.getData().getString("kitpvp.ranks.gladiator"));
		return prefix(Gladiator);
	}

	public static String Guardian() {
		String Guardian = StaffmodeManager.format(msgconfig.getData().getString("kitpvp.ranks.guardian"));
		return prefix(Guardian);
	}

	public static String Berserk() {
		String Berserk = StaffmodeManager.format(msgconfig.getData().getString("kitpvp.ranks.berserk"));
		return prefix(Berserk);
	}

	public static String Legend() {
		String Legend = StaffmodeManager.format(msgconfig.getData().getString("kitpvp.ranks.legend"));
		return prefix(Legend);
	}

	public static String DemiGod() {
		String DemiGod = StaffmodeManager.format(msgconfig.getData().getString("kitpvp.ranks.demigod"));
		return prefix(DemiGod);
	}

	public static String God() {
		String God = StaffmodeManager.format(msgconfig.getData().getString("kitpvp.ranks.god"));
		return prefix(God);
	}

	public static String dataReloaded() {
		String datareloaded = "§aCore has been reloaded";
		return prefix(datareloaded);
	}

	public static String spawnSet() {
		String spawnset = StaffmodeManager.format(msgconfig.getData().getString("spawn.set"));
		return prefix(spawnset);
	}

	public static String deathMessage(Entity p, Entity k) {
		String deathmessage = "§c" + p.getName() + " §ehas been killed by §c"
				+ k.getName();
		return prefix(deathmessage);
	}

	public static String reachedwarriorRank(Player k) {
		String reachedwarriorrank = "§c" + k.getName()
				+ " &ahas reached the §bWarrior §arank!";
		return prefix(reachedwarriorrank);
	}

	public static String reachedgladiatorrank(Player k) {
		String reachedgladiatorrank = "§c" + k.getName()
				+ " &ahas reached the §1Gladiator §arank!";
		return prefix(reachedgladiatorrank);
	}

	public static String reachedguardianrank(Player k) {
		String reachedguardianrank = "§c" + k.getName()
				+ " &ahas reached the §6Guardian §arank!";
		return prefix(reachedguardianrank);
	}

	public static String reachedberserkrank(Player k) {
		String reachedberserkrank = "§c" + k.getName()
				+ " &ahas reached the §aBerserk §arank!";
		return prefix(reachedberserkrank);
	}

	public static String reachedlegendrank(Player k) {
		String reachedlegendrank = "§c" + k.getName()
				+ " &ahas reached the §3Legend §arank!";
		return prefix(reachedlegendrank);
	}

	public static String reachedemigodrank(Player k) {
		String reachedemigodrank = "§c" + k.getName()
				+ " &ahas reached the §cDemiGod §arank!";
		return prefix(reachedemigodrank);
	}

	public static String reachedgodrank(Player k) {
		String reachedgodrank = "§c" + k.getName()
				+ " &ahas reached the §4God §arank!";
		return prefix(reachedgodrank);
	}

	public static String chatFormat(String message, Player player) {
		String chatformat = player.getDisplayName() + "§8 : §f§r" + message;
		return chatformat;
	}

	public static String joinMessage(Player p) {
		String joinMessage = "§8[§a+§8] §2" + p.getName()
				+ "§a has joined the server.";
		return prefix(joinMessage);
	}

	public static String kitSelected() {
		String kitselected = StaffmodeManager.format(msgconfig.getData().getString("kitpvp.kits.alreadyselected"));
		return prefix(kitselected);
	}

	public static String kitnotOwned() {
		String kitnotowned = StaffmodeManager.format(msgconfig.getData().getString("kitpvp.kits.notowned"));
		return prefix(kitnotowned);
	}

	public static String quitMessage(Player p) {
		String quitmessage = "§8[§c-§8] §2" + p.getName()
				+ "§c has left the server.";
		return prefix(quitmessage);
	}

	public static String targetFlightEnabled(Player target) {
		String targetFlightEnabled = "§aYou have enabled §2 " + target.getName() + "'s §aflight.";
		return prefix(targetFlightEnabled);
	}
	
	public static String targetFlightDisabled(Player target) {
		String targetFlightDisabled = "§cYou have disabled §4 " + target.getName() + "'s §cflight.";
		return prefix(targetFlightDisabled);
	}
	
	public static String targetVanishDisabled(Player target) {
		String targetVanishDisabled = "§cYou have disabled §4 " + target.getName() + "'s §cvanish.";
		return prefix(targetVanishDisabled);
	}
	
	public static String targetVanishEnabled(Player target) {
		String targetVanishEnabled = "§aYou have enabled §2 " + target.getName() + "'s §avanish.";
		return prefix(targetVanishEnabled);
	}

	public static String gamemodeCreative() {
		String gamemodeCreative = StaffmodeManager.format(msgconfig.getData().getString("gamemode.creative"));
		return prefix(gamemodeCreative);
	}
	
	public static String gamemodeSurvival() {
		String gamemodeSurvival = StaffmodeManager.format(msgconfig.getData().getString("gamemode.survival"));
		return prefix(gamemodeSurvival);
	}
	
	public static String gamemodeAdventure() {
		String gamemodeAdventure = StaffmodeManager.format(msgconfig.getData().getString("gamemode.adventure"));
		return prefix(gamemodeAdventure);
	}
	
	public static String gamemodeSpectator() {
		String gamemodeSpectator = StaffmodeManager.format(msgconfig.getData().getString("gamemode.spectator"));
		return prefix(gamemodeSpectator);
	}

	public static String gamemodeUsage() {
		String gamemodeUsage = "§cUsage: /gamemode [type] [player] or /gamemode <type>";
		return prefix(gamemodeUsage);
	}

	public static String teleportedtoSpawn() {
		String teleportedtospawn = StaffmodeManager.format(msgconfig.getData().getString("spawn.teleportedto"));
		return prefix(teleportedtospawn);
	}

	public static String spawnUsage() {
		String spawnUage = "§cUsage: /spawn or /spawn <player>";
		return prefix(spawnUage);
	}

	public static String teleportedtargettoSpawn(Player t) {
		String st = "§aYou have teleported §2" + t.getName() + "§a to spawn.";
		return prefix(st);
	}

	public static String feed() {
		String s = StaffmodeManager.format(msgconfig.getData().getString("health.feed"));
		return prefix(s);
	}
	
	public static String feedUsage(){
		String s = "§cUsage: /feed  or /feed <player>";
		return prefix(s);
	}
	
	public static String healUsage(){
		String s = "§cUsage: /heal  or /heal <player>";
		return prefix(s);
	}
	
	public static String healed() {
		String s = StaffmodeManager.format(msgconfig.getData().getString("health.healed"));
		return prefix(s);
	}

	public static String playerFeed(Player t) {
		String s = "§aYou have fed §2" + t.getName() + "§a.";
		return prefix(s);
	}
	
	public static String playerHealed(Player t) {
		String s = "§aYou have healed §2" + t.getName() + "§a.";
		return prefix(s);
	}

	public static String clearedInventory() {
		String s = StaffmodeManager.format(msgconfig.getData().getString("inventory.clear"));
		return prefix(s);
	}

	public static String playerClearedInventory(Player t) {
		String s = "§aYou have cleared §2" + t.getName() +"'s §ainventory.";
		return prefix(s);
	}

	public static String clearinventoryUsage() {
		String s = "§cUsage: /ci  or /ci <player>";
		return prefix(s);
	}

	public static String broadcastUsage() {
		String s = "§cUsage: /broadcast <message>";
		return prefix(s);
	}

	public static String messageUsage() {
		String s = "§cUsage: /message <player> <message>";
		return prefix(s);
	}

	public static String invseeUsage() {
		String s = "§cUsage: /invsee <player>";
		return prefix(s);
	}

	public static String teleportedtoPlayer(Player target) {
		String s = "§aYou have been teleported to §2" + target.getName();
		return prefix(s);
	}

	public static String teleportUsage() {
		String s = "§cUsage: /teleport <player>";
		return prefix(s);
	}

	public static String closedInventory() {
		String s = StaffmodeManager.format(msgconfig.getData().getString("kitpvp.gui.closedinventory"));
		return prefix(s);
	}

	public static String upgraded() {
		String s = StaffmodeManager.format(msgconfig.getData().getString("kitpvp.kits.upgraded"));
		return prefix(s);
	}

	public static String resetPlayerStats(Player t) {
		String s = "§aYou have reset §2" + t.getName()+"'s §astats.";
		return prefix(s);
	}
	public static String nullItem() {
		String s = "§cThere is nothing in your hand!";
		return s;
	}
}
