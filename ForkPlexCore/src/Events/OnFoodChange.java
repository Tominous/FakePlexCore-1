package Events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class OnFoodChange implements Listener{
	
	private ForkPlexCore.ForkPlexCore.ForkPlexCore.Main plugin;
	
	public OnFoodChange(ForkPlexCore.ForkPlexCore.ForkPlexCore.Main plugin) {
	this.plugin = plugin;
	
	Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
    @EventHandler(priority = EventPriority.HIGHEST)
    public boolean Foodlevel(FoodLevelChangeEvent event){
    	Player p = (Player) event.getEntity();
    	
    	event.setCancelled(true);
    	
    	if(p.getFoodLevel() == 19){
    		p.setFoodLevel(20);
    	}
		return false;
    }
    	
    }