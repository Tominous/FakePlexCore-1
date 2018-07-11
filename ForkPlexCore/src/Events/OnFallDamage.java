package Events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class OnFallDamage implements Listener{
	
	private ForkPlexCore.ForkPlexCore.ForkPlexCore.Main plugin;
	
	public OnFallDamage(ForkPlexCore.ForkPlexCore.ForkPlexCore.Main plugin) {
	this.plugin = plugin;
	
	Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
    @EventHandler
    public void onPlayerFall(EntityDamageEvent e) {
        Player player = (Player) e.getEntity();
        if (e.getCause() == DamageCause.FALL){
        	e.setCancelled(true);
                player.setFallDistance(0);
                return;
        }
    }
}