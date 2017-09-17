package com.sesamepvp.main;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.sesamepvp.adminfun.AdminFun;
import com.sesamepvp.chatmanagement.commands.ChatMute;
import com.sesamepvp.chatmanagement.commands.ClearChat;
import com.sesamepvp.chatmanagement.events.ChatMuteListener;
import com.sesamepvp.duels.Duel;
import com.sesamepvp.duels.arena.Arena;
import com.sesamepvp.essentials.commands.Broadcast;
import com.sesamepvp.essentials.commands.ClearInventory;
import com.sesamepvp.essentials.commands.Feed;
import com.sesamepvp.essentials.commands.FindUUID;
import com.sesamepvp.essentials.commands.Fly;
import com.sesamepvp.essentials.commands.Gamemode;
import com.sesamepvp.essentials.commands.Heal;
import com.sesamepvp.essentials.commands.Invsee;
import com.sesamepvp.essentials.commands.List;
import com.sesamepvp.essentials.commands.Vanish;
import com.sesamepvp.essentials.commands.Website;
import com.sesamepvp.essentials.commands.Workbench;
import com.sesamepvp.essentials.commands.Locations.spawn.Setspawn;
import com.sesamepvp.essentials.commands.Locations.spawn.Spawn;
import com.sesamepvp.essentials.commands.teleport.Teleport;
import com.sesamepvp.essentials.events.ListListener;
import com.sesamepvp.essentials.msg.Message;
import com.sesamepvp.essentials.msg.Reply;
import com.sesamepvp.files.ArenaFile;
import com.sesamepvp.files.FriendFile;
import com.sesamepvp.files.KitpvpFile;
import com.sesamepvp.files.MessageFile;
import com.sesamepvp.files.PunishmentGUIFile;
import com.sesamepvp.files.PunishmentsFile;
import com.sesamepvp.files.Rankfile;
import com.sesamepvp.files.ReportsFile;
import com.sesamepvp.files.StaffmodeFile;
import com.sesamepvp.friend.Friend;
import com.sesamepvp.kitpvp.abilities.InsaneAbility;
import com.sesamepvp.kitpvp.abilities.SlugAbility;
import com.sesamepvp.kitpvp.abilities.VampireAbility;
import com.sesamepvp.kitpvp.commands.KitShop;
import com.sesamepvp.kitpvp.commands.Kits;
import com.sesamepvp.kitpvp.commands.PathSeter;
import com.sesamepvp.kitpvp.commands.Sesame;
import com.sesamepvp.kitpvp.commands.Stats;
import com.sesamepvp.kitpvp.events.General;
import com.sesamepvp.kitpvp.events.GiveRespawnItems;
import com.sesamepvp.kitpvp.kits.defaultkits.Alchemist;
import com.sesamepvp.kitpvp.kits.defaultkits.Archer;
import com.sesamepvp.kitpvp.kits.defaultkits.Default;
import com.sesamepvp.kitpvp.kits.defaultkits.Fisherman;
import com.sesamepvp.kitpvp.kits.defaultkits.Golden;
import com.sesamepvp.kitpvp.kits.defaultkits.Pyro;
import com.sesamepvp.kitpvp.kits.defaultkits.Tank;
import com.sesamepvp.kitpvp.kits.donatorkits.Slug;
import com.sesamepvp.kitpvp.kits.donatorkits.Thor;
import com.sesamepvp.kitpvp.kits.donatorkits.Vampire;
import com.sesamepvp.kitpvp.kits.donatorkits.Viper;
import com.sesamepvp.kitpvp.kits.purchasedkits.Assassin;
import com.sesamepvp.kitpvp.kits.purchasedkits.Burner;
import com.sesamepvp.kitpvp.kits.purchasedkits.GodArcher;
import com.sesamepvp.kitpvp.kits.purchasedkits.Insane;
import com.sesamepvp.kitpvp.kits.purchasedkits.Speed;
import com.sesamepvp.kitpvp.managers.KitListener;
import com.sesamepvp.kitpvp.managers.KitShopManager;
import com.sesamepvp.kitpvp.managers.RankupSystem;
import com.sesamepvp.kitpvp.managers.StatsManager;
import com.sesamepvp.kitpvp.quests.Quest;
import com.sesamepvp.kitpvp.quests.events.InventoryClickEvents;
import com.sesamepvp.kitpvp.quests.managers.QuestManager;
import com.sesamepvp.kitpvp.quests.quests.Hunter;
import com.sesamepvp.kitpvp.signs.SignsManager;
import com.sesamepvp.kitpvp.upgrades.UpgradeClickEvent;
import com.sesamepvp.kitpvp.upgrades.kits.AlchemistUpgraded;
import com.sesamepvp.kitpvp.upgrades.kits.ArcherUpgraded;
import com.sesamepvp.kitpvp.upgrades.kits.DefaultUpgraded;
import com.sesamepvp.kitpvp.upgrades.kits.FishermanUpgraded;
import com.sesamepvp.kitpvp.upgrades.kits.GoldenUpgraded;
import com.sesamepvp.kitpvp.upgrades.kits.PyroUpgraded;
import com.sesamepvp.kitpvp.upgrades.kits.TankUpgraded;
import com.sesamepvp.punishments.Ban;
import com.sesamepvp.punishments.Kick;
import com.sesamepvp.punishments.Mute;
import com.sesamepvp.punishments.Punish;
import com.sesamepvp.punishments.Tempban;
import com.sesamepvp.punishments.Tempmute;
import com.sesamepvp.punishments.Unban;
import com.sesamepvp.punishments.Unmute;
import com.sesamepvp.punishments.Warn;
import com.sesamepvp.punishments.GUI.PunishGUI;
import com.sesamepvp.punishments.events.ClickEventHandler;
import com.sesamepvp.punishments.manager.BanManager;
import com.sesamepvp.punishments.manager.MuteManager;
import com.sesamepvp.rank.Events;
import com.sesamepvp.rank.RankCommand;
import com.sesamepvp.staffmode.StaffmodeManager;
import com.sesamepvp.staffmode.commands.Freeze;
import com.sesamepvp.staffmode.commands.StaffMode;
import com.sesamepvp.staffmode.commands.report.Report;
import com.sesamepvp.staffmode.commands.report.manager.ClickEventManager;
import com.sesamepvp.staffmode.commands.report.manager.ReportManager;
import com.sesamepvp.staffmode.events.BlockPlace;
import com.sesamepvp.staffmode.events.DamageCancel;
import com.sesamepvp.staffmode.events.FlightEvent;
import com.sesamepvp.staffmode.events.FreezeListener;
import com.sesamepvp.staffmode.events.InteractionEvent;
import com.sesamepvp.staffmode.events.InvClickEvent;
import com.sesamepvp.staffmode.events.ItemDrop;
import com.sesamepvp.staffmode.events.LoggedWhilstFrozen;
import com.sesamepvp.staffmode.events.RandomTeleport;
import com.sesamepvp.staffmode.events.VanishEvent;
import com.sesamepvp.staffmode.gui.miner.EventManager;
import com.sesamepvp.tokens.Token;
import com.sesamepvp.tokens.Tokens;

public class SesameCore extends JavaPlugin implements Listener {
	FriendFile ff = FriendFile.getInstance();
	ArenaFile af = ArenaFile.getInstance();
	KitpvpFile manager = KitpvpFile.getInstance();
	Rankfile rf = Rankfile.getInstance();
	MessageFile messageconfig = MessageFile.getInstance();
	StaffmodeFile staffmodeconfig = StaffmodeFile.getInstance();
	ReportsFile reportsfile = ReportsFile.getInstance();
	PunishmentsFile punishmentsfile = PunishmentsFile.getInstance();
	PunishmentGUIFile pfg = PunishmentGUIFile.getInstance();
	private PluginManager pm;


	public void onEnable() {
		registerConfig();
		@SuppressWarnings("unused")
		QuestManager Quests = new Hunter();
		pm = Bukkit.getServer().getPluginManager();

		registerEvents();
		registerCommands();
		reportsfile.setup(this);
		manager.setup(this);
		messageconfig.setup(this);
		staffmodeconfig.setup(this);
		punishmentsfile.setup(this);
		pfg.setup(this);
		rf.setup(this);
		af.setup(this);
		ff.setup(this);
		setupMessages();
		ReportManager.clearAllReports();
	}

	public void registerConfig() {
		getConfig().options().copyDefaults(true);
		reloadConfig();
		saveConfig();

	}

	
	private void registerCommands() {
		getCommand("clearchat").setExecutor(new ClearChat());
		getCommand("cc").setExecutor(new ClearChat());
		getCommand("mutechat").setExecutor(new ChatMute());
		getCommand("friend").setExecutor(new Friend());
		getCommand("mc").setExecutor(new ChatMute());
		getCommand("mod").setExecutor(new StaffMode());
		getCommand("freeze").setExecutor(new Freeze());
		getCommand("report").setExecutor(new Report(this));
		getCommand("reports").setExecutor(new Report(this));
		getCommand("stats").setExecutor(new Stats());
		getCommand("list").setExecutor(new List());
		getCommand("kits").setExecutor(new Kits());
		getCommand("kitshop").setExecutor(new KitShop());
		getCommand("sesame").setExecutor(new Sesame());
		getCommand("fly").setExecutor(new Fly());
		getCommand("vanish").setExecutor(new Vanish());
		getCommand("v").setExecutor(new Vanish());
		getCommand("gm").setExecutor(new Gamemode());
		getCommand("gamemode").setExecutor(new Gamemode());
		getCommand("setspawn").setExecutor(new Setspawn());
		getCommand("spawn").setExecutor(new Spawn());
		getCommand("feed").setExecutor(new Feed());
		getCommand("heal").setExecutor(new Heal());
		getCommand("ci").setExecutor(new ClearInventory());
		getCommand("clearinventory").setExecutor(new ClearInventory());
		getCommand("clear").setExecutor(new ClearInventory());
		getCommand("bc").setExecutor(new Broadcast(this));
		getCommand("broadcast").setExecutor(new Broadcast(this));
		getCommand("msg").setExecutor(new Message());
		getCommand("m").setExecutor(new Message());
		getCommand("message").setExecutor(new Message());
		getCommand("invsee").setExecutor(new Invsee());
		getCommand("inspect").setExecutor(new Invsee());
		getCommand("teleport").setExecutor(new Teleport());
		getCommand("tp").setExecutor(new Teleport());
		getCommand("setpath").setExecutor(new PathSeter());
		getCommand("uuid").setExecutor(new FindUUID());
		getCommand("website").setExecutor(new Website());
		getCommand("craft").setExecutor(new Workbench());
		getCommand("quests").setExecutor(new Quest());

		getCommand("arena").setExecutor(new Arena());
		getCommand("duel").setExecutor(new Duel());
		
		getCommand("mute").setExecutor(new Mute());
		getCommand("tempmute").setExecutor(new Tempmute(this));
		getCommand("unmute").setExecutor(new Unmute());

		getCommand("ban").setExecutor(new Ban());
		getCommand("banofflineplayer").setExecutor(new Ban());
		getCommand("unban").setExecutor(new Unban());
		getCommand("tempban").setExecutor(new Tempban(this));

		getCommand("kick").setExecutor(new Kick());
		getCommand("punish").setExecutor(new Punish());
		
		getCommand("warn").setExecutor(new Warn());
		
		getCommand("token").setExecutor(new Token(this));
		getCommand("tokens").setExecutor(new Tokens(this));
		
		getCommand("rm").setExecutor(new RankCommand(this));
		getCommand("adminfun").setExecutor(new AdminFun(this));
		
		getCommand("r").setExecutor(new Reply());
		getCommand("reply").setExecutor(new Reply());
	}

	private void registerEvents() {
		pm.registerEvents(new EventManager(), this);
		pm.registerEvents(new PunishGUI(), this);
		pm.registerEvents(new Tempmute(this), this);
		pm.registerEvents(new ClickEventManager(), this);
		pm.registerEvents(this, this);
		pm.registerEvents(new StatsManager(), this);
		pm.registerEvents(new ListListener(), this);
		pm.registerEvents(new InsaneAbility(), this);
		pm.registerEvents(new SlugAbility(), this);
		pm.registerEvents(new VampireAbility(), this);
		pm.registerEvents(new UpgradeClickEvent(), this);
		pm.registerEvents(new ChatMuteListener(), this);
		pm.registerEvents(new FreezeListener(), this);
		pm.registerEvents(new FlightEvent(), this);
		pm.registerEvents(new VanishEvent(), this);
		pm.registerEvents(new RandomTeleport(), this);
		pm.registerEvents(new com.sesamepvp.duels.events.EventManager(), this);
		pm.registerEvents(new LoggedWhilstFrozen(), this);
		pm.registerEvents(new DamageCancel(), this);
		pm.registerEvents(new ItemDrop(), this);
		pm.registerEvents(new BlockPlace(), this);
		pm.registerEvents(new InteractionEvent(), this);
		pm.registerEvents(new InvClickEvent(), this);
		pm.registerEvents(new GiveRespawnItems(), this);
		pm.registerEvents(new KitListener(), this);
		pm.registerEvents(new KitShopManager(), this);
		pm.registerEvents(new General(), this);
		pm.registerEvents(new RankupSystem(), this);
		pm.registerEvents(new com.sesamepvp.scoreboard.SB(this), this);
		pm.registerEvents(new Events(this), this);
		// Kits
		pm.registerEvents(new Alchemist(), this);
		pm.registerEvents(new Archer(), this);
		pm.registerEvents(new Default(), this);
		pm.registerEvents(new Fisherman(), this);
		pm.registerEvents(new Golden(), this);
		pm.registerEvents(new Pyro(), this);
		pm.registerEvents(new Tank(), this);

		pm.registerEvents(new InventoryClickEvents(), this);

		pm.registerEvents(new MuteManager(), this);
		pm.registerEvents(new BanManager(), this);

		pm.registerEvents(new Tempban(this), this);
		pm.registerEvents(new ClickEventHandler(), this);

		pm.registerEvents(new AlchemistUpgraded(), this);
		pm.registerEvents(new ArcherUpgraded(), this);
		pm.registerEvents(new DefaultUpgraded(), this);
		pm.registerEvents(new FishermanUpgraded(), this);
		pm.registerEvents(new GoldenUpgraded(), this);
		pm.registerEvents(new PyroUpgraded(), this);
		pm.registerEvents(new TankUpgraded(), this);

		pm.registerEvents(new Slug(), this);
		pm.registerEvents(new Thor(), this);
		pm.registerEvents(new Vampire(), this);
		pm.registerEvents(new Viper(), this);

		pm.registerEvents(new Assassin(), this);
		pm.registerEvents(new Burner(), this);
		pm.registerEvents(new GodArcher(), this);
		pm.registerEvents(new Insane(), this);
		pm.registerEvents(new Speed(), this);
		pm.registerEvents(new Kits(), this);
		pm.registerEvents(new SignsManager(), this);
		pm.registerEvents(new KitShop(), this);
	}

	public void onDisable() {
	}

	public void setupMessages() {
		if (messageconfig.getData().getString("prefix") == null || messageconfig.getData().getString("prefix") == "") {
			messageconfig.getData().set("prefix", StaffmodeManager.config("§c§lSesame§f§lPvP §8>> "));
			messageconfig.getData().set("nopermission",
					StaffmodeManager.config("§cNo permission to execcute this command!"));
			messageconfig.getData().set("notplayer",
					StaffmodeManager.config("§cYou must be a player to execute this command!"));
			messageconfig.getData().set("staffmode.disabled", StaffmodeManager.config("§cYou have §4left §cmod mode."));
			messageconfig.getData().set("staffmode.enabled",
					StaffmodeManager.config("§aYou have §2entered §amod mode."));
			messageconfig.getData().set("staffmode.mustleavemod",
					StaffmodeManager.config("§cYou must leave §4Staff §cmode to do this."));
			messageconfig.getData().set("staffmode.noitemdrop",
					StaffmodeManager.config("§cYou must leave §4Staff §cmode drop items."));
			messageconfig.getData().set("staffmode.noblockplace",
					StaffmodeManager.config("§cYou must leave §4Staff §cmode to place blocks."));
			messageconfig.getData().set("staffmode.nodamage",
					StaffmodeManager.config("§cYou must leave &4Staff &cmode to attack players."));
			messageconfig.getData().set("playernull",
					StaffmodeManager.config("&cThat player does not exist, or is not online."));
			messageconfig.getData().set("staffmode.frozen",
					StaffmodeManager.config("&cYou have been &4frozen, please coordinate with a staff member."));
			messageconfig.getData().set("chat.talkdenied",
					StaffmodeManager.config("&cYou can't talk, chat is currently muted!"));
			messageconfig.getData().set("chat.muted", StaffmodeManager.config("&cChat has been &4muted!"));
			messageconfig.getData().set("chat.unmuted", StaffmodeManager.config("&aChat has been &2unmuted!"));
			messageconfig.getData().set("chat.clear", StaffmodeManager.config("§aThe chat has been &2cleared."));
			messageconfig.getData().set("staffmode.notenoughplayers",
					StaffmodeManager.config("&cThere are not enough players online!"));
			messageconfig.getData().set("staffmode.flight.enabled",
					StaffmodeManager.config("&aFlight has been &2Enabled."));
			messageconfig.getData().set("staffmode.flight.disabled",
					StaffmodeManager.config("&cFlight has been &4Disabled."));
			messageconfig.getData().set("staffmode.vanish.enabled",
					StaffmodeManager.config("&aVanish has been &2Enabled"));
			messageconfig.getData().set("staffmode.vanish.disabled",
					StaffmodeManager.config("&cVanish has been &4Disabled."));

			messageconfig.getData().set("kitpvp.purchasedkit.speedy",
					StaffmodeManager.config("&aYou have purchased the &2Speedy&a kit."));
			messageconfig.getData().set("kitpvp.purchasedkit.insane",
					StaffmodeManager.config("&aYou have purchased the &2Insane&a kit."));
			messageconfig.getData().set("kitpvp.purchasedkit.assassin",
					StaffmodeManager.config("&aYou have purchased the &2Assassin&a kit."));
			messageconfig.getData().set("kitpvp.purchasedkit.godarcher",
					StaffmodeManager.config("&aYou have purchased the &2Godarcher&a kit."));
			messageconfig.getData().set("kitpvp.purchasedkit.burner",
					StaffmodeManager.config("&aYou have purchased the &2Burner&a kit."));
			messageconfig.getData().set("kitpvp.kits.alreadyowned",
					StaffmodeManager.config("&cYou already own that kit."));
			messageconfig.getData().set("kitpvp.kits.upgraded",
					StaffmodeManager.config("&aYou have successfully upgraded a kit."));
			messageconfig.getData().set("kitpvp.kits.alreadyselected",
					StaffmodeManager.config("&cYou already have a kit selected."));
			messageconfig.getData().set("kitpvp.kits.notowned", StaffmodeManager.config("&cYou do not own this kit."));
			messageconfig.getData().set("kitpvp.gui.openingkitshop",
					StaffmodeManager.config("&aOpening the Kit shop."));
			messageconfig.getData().set("kitpvp.gui.closedinventory", StaffmodeManager.config("&cClosed inventory."));
			messageconfig.getData().set("eco.insufficientfunds",
					StaffmodeManager.config("&cYou have insufficient funds."));
			messageconfig.getData().set("kitpvp.ranks.rank", StaffmodeManager.config("&aRanks:"));
			messageconfig.getData().set("kitpvp.ranks.warrior", StaffmodeManager.config("&aWarrior: 150 kills."));
			messageconfig.getData().set("kitpvp.ranks.gladiator", StaffmodeManager.config("&aGladiator: 350 kills."));
			messageconfig.getData().set("kitpvp.ranks.guardian", StaffmodeManager.config("&aGuardian: 750 kills."));
			messageconfig.getData().set("kitpvp.ranks.berserk", StaffmodeManager.config("&aBerserk: 1250 kills."));
			messageconfig.getData().set("kitpvp.ranks.legend", StaffmodeManager.config("&aLegend: 1750 kills."));
			messageconfig.getData().set("kitpvp.ranks.demigod", StaffmodeManager.config("&aDemi God: 2250 kills."));
			messageconfig.getData().set("kitpvp.ranks.god", StaffmodeManager.config("&aGod: 3500 kills."));

			messageconfig.getData().set("spawn.set", StaffmodeManager.config("&aSpawn has been set."));
			messageconfig.getData().set("spawn.teleportedto",
					StaffmodeManager.config("&aYou have been teleported to spawn."));

			messageconfig.getData().set("gamemode.creative",
					StaffmodeManager.config("&aGamemode has been set to &2Creative"));
			messageconfig.getData().set("gamemode.survival",
					StaffmodeManager.config("&aGamemode has been set to &2Survival"));
			messageconfig.getData().set("gamemode.adventure",
					StaffmodeManager.config("&aGamemode has been set to &2Adventure"));
			messageconfig.getData().set("gamemode.spectator",
					StaffmodeManager.config("&aGamemode has been set to &2Spectator"));

			messageconfig.getData().set("health.feed", StaffmodeManager.config("&aYou have been fed."));
			messageconfig.getData().set("health.healed", StaffmodeManager.config("&aYou have been healed."));

			messageconfig.getData().set("inventory.clear",
					StaffmodeManager.config("&aYou have cleared you're inventory."));

			messageconfig.saveData();
		} else {
			return;
		}
	}

}
