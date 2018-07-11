package Events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class OnHealthChange implements Listener{
	
	private ForkPlexCore.ForkPlexCore.ForkPlexCore.Main plugin;
	
	public OnHealthChange(ForkPlexCore.ForkPlexCore.ForkPlexCore.Main plugin) {
	this.plugin = plugin;
	
	Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDamage (EntityDamageEvent event) {
		Player p = (Player) event.getEntity();
		
		event.setCancelled(true);
	}
}