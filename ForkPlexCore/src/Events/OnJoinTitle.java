package Events;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.connorlinfoot.titleapi.TitleAPI;

import ForkPlexCore.ForkPlexCore.ForkPlexCore.Main;
import Translate.Translate;

public class OnJoinTitle implements Listener{
	
	private ForkPlexCore.ForkPlexCore.ForkPlexCore.Main plugin;
	
	public OnJoinTitle(ForkPlexCore.ForkPlexCore.ForkPlexCore.Main plugin) {
	this.plugin = plugin;
	
	Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	FileConfiguration config = Main.plugin.getConfig();
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		TitleAPI.sendTitle(e.getPlayer(), 10, 5 * 20, 10, Translate.chat(config.getString("titlename")), Translate.chat(config.getString("titlesubtitle")));
		//TabList UNDER
		TitleAPI.sendTabTitle(e.getPlayer(), Translate.chat(config.getString("tablisttop")), Translate.chat(config.getString("tablistbottom")));
	}
}
