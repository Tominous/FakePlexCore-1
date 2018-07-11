package Events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class OnWeatherChange implements Listener{
	
	private ForkPlexCore.ForkPlexCore.ForkPlexCore.Main plugin;
	
	public OnWeatherChange(ForkPlexCore.ForkPlexCore.ForkPlexCore.Main plugin) {
	this.plugin = plugin;
	
	Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler(priority=EventPriority.HIGHEST)
    public void onWeatherChange(WeatherChangeEvent event) {
      
        boolean rain = event.toWeatherState();
        if(rain)
            event.setCancelled(true);
    }
  
    @EventHandler(priority=EventPriority.HIGHEST)
    public void onThunderChange(ThunderChangeEvent event) {
      
        boolean storm = event.toThunderState();
        if(storm)
            event.setCancelled(true);
    }
}