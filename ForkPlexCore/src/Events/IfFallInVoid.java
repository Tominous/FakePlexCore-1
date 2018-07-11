package Events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import ForkPlexCore.ForkPlexCore.ForkPlexCore.Main;
import Translate.Translate;

public class IfFallInVoid implements Listener{
	
	private ForkPlexCore.ForkPlexCore.ForkPlexCore.Main plugin;
	
	public IfFallInVoid(ForkPlexCore.ForkPlexCore.ForkPlexCore.Main plugin) {
	this.plugin = plugin;
	
	Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	FileConfiguration config = Main.plugin.getConfig();
	
	@EventHandler
	public void onPlayerMove (PlayerMoveEvent event) {
		Player p = event.getPlayer();
		Location loc = p.getLocation();
		World world = Bukkit.getServer().getWorld("world");
		
		if (loc.getBlockY() <=0) {
			p.teleport(new Location(world, config.getInt("xfallinvoid"), config.getInt("yfallinvoid"), config.getInt("zfallinvoid")));
			p.sendMessage(Translate.chat("&4I got you fam"));
		}
	}

}
