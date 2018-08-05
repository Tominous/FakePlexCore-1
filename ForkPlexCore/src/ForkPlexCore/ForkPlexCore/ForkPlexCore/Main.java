package ForkPlexCore.ForkPlexCore.ForkPlexCore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import Commands.bungee;
import Commands.defaultmineplex;
import Commands.fly;
import Commands.gm;
import Commands.setspawn;
import Commands.spawn;
import Events.DoubleJump;
import Events.IfFallInVoid;
import Events.LoadingStats;
import Events.OnFallDamage;
import Events.OnFoodChange;
import Events.OnHealthChange;
import Events.OnJoinTitle;
import Events.OnWeatherChange;
import Translate.Translate;
import Utils.CustomYmlManger;
import Utils.Metrics;

public class Main extends JavaPlugin implements Listener {

    public static Main instance;
    public static Main plugin;
    private CustomYmlManger customyml;
    
	@Override
	public void onEnable() {
		plugin = this;
		YmlConfigGen();
		FileConfigGen();
		eventsEnable();
		commandsEnable();
		bstats();
		getLogger().info("[FakePlexCore] is now loaded!");
	}
	public void onDisable() {
		getLogger().info("[FakePlexCore] is now disabled.");
	}
	public void commandsEnable() {
		new bungee(this);
		new fly(this);	
		new gm(this);
		new defaultmineplex(this);
		new spawn(customyml, this);
		new setspawn(customyml, this);
	}
	public void eventsEnable() {
		new LoadingStats(this);
		new OnFoodChange(this);
		new OnFallDamage(this);
		new DoubleJump(this);
		new OnWeatherChange(this);
		new OnHealthChange(this);
		new OnJoinTitle(this);
		new IfFallInVoid(customyml, plugin);
	}
	public void FileConfigGen() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	public void YmlConfigGen() {
		customyml = new CustomYmlManger();
		//YML GOES BELOW ME
		customyml.setupshit();
		customyml.saveshit();
		customyml.reloadshit();
	}
	public void bstats() {
		Metrics metrics = new Metrics(this);
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		  {
			  Player p = (Player) sender;
		       
		        if (cmd.getName().equalsIgnoreCase("server")) {
		            if (args.length == 0) {
		                p.sendMessage(Translate.chat("&9Portal>&7 You are currently on server: &6Lobby-1"));
		                return true;
		            }
		        }
		  }
		return false;
	}
}