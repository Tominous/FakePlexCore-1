package Events;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import com.connorlinfoot.titleapi.TitleAPI;

import ForkPlexCore.ForkPlexCore.ForkPlexCore.Main;
import Translate.Translate;
import Utils.API;

public class OnJoinTitle implements Listener{
	
	private static Plugin plugin = Main.plugin;
	API api = new API();
	
	public OnJoinTitle(ForkPlexCore.ForkPlexCore.ForkPlexCore.Main plugin) {
	this.plugin = plugin;
	
	Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	FileConfiguration config = Main.plugin.getConfig();
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		TitleAPI.sendTitle(e.getPlayer(), 10, 5 * 20, 10, Translate.chat(config.getString("Title")), Translate.chat(config.getString("TitleSubtittle")));
		//TabList UNDER
		TitleAPI.sendTabTitle(e.getPlayer(), Translate.chat(config.getString("TablistTOP")), Translate.chat(config.getString("TablistBOTTOM")));
	}
}
