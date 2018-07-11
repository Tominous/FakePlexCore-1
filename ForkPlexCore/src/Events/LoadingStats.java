package Events;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import Translate.Translate;

public class LoadingStats implements Listener{
	
	private ForkPlexCore.ForkPlexCore.ForkPlexCore.Main plugin;
	
	public LoadingStats(ForkPlexCore.ForkPlexCore.ForkPlexCore.Main plugin) {
	this.plugin = plugin;
	
	Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		Player p = event.getPlayer();
		
        if (p.getDisplayName().equals("andrew121410")) {
            p.sendMessage(Translate.chat("&4Hello, Owner."));
        }
            event.setJoinMessage("");
            
            Bukkit.broadcastMessage(Translate.chat("&9Server>&9 Welcome Back! " + p.getDisplayName()));
            p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10.0f, 1.0f);
            p.sendMessage(Translate.chat("&9Stats Manger>&7 Loading your stats..."));
            p.sendMessage(Translate.chat("&9Stats Manger>&7 Your stats have been loaded!"));
	}
}