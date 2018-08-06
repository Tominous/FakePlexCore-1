package Events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import ForkPlexCore.ForkPlexCore.ForkPlexCore.Main;
import Translate.Translate;
import Utils.API;
import Utils.CustomYmlManger;
import net.minecraft.server.v1_12_R1.EntityPlayer;

public class IfFallInVoid implements Listener{
	
	private Main plugin;
	API api = new API();
	
	private CustomYmlManger configinstance = null;
    public IfFallInVoid(CustomYmlManger getConfigInstance, ForkPlexCore.ForkPlexCore.ForkPlexCore.Main plugin) {
        this.configinstance = getConfigInstance;
        this.plugin = plugin;
   
    Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	//FileConfiguration config = Main.plugin.getConfig();
	
	@EventHandler
	public void onPlayerMove (PlayerMoveEvent  e) {
		if(!(e.getPlayer() instanceof Player)) {
			return;
		}
		Player p = (Player) e.getPlayer();
	      double x = configinstance.getshit().getInt("Spawn.Data.X");
	      double y = configinstance.getshit().getInt("Spawn.Data.Y");
	      double z = configinstance.getshit().getInt("Spawn.Data.Z");
	      float yaw = (float)configinstance.getshit().getInt("Spawn.Data.Yaw");
	      float pitch = (float)configinstance.getshit().getInt("Spawn.Data.Pitch");
	      World world = Bukkit.getWorld(configinstance.getshit().getString("Spawn.Data.World"));
	      Location loc = p.getLocation();
	      
	      Location spawn = new Location(world, x, y, z, yaw, pitch);
	      
		if (loc.getBlockY() <=0) {
			p.teleport(spawn);
			p.sendMessage(Translate.chat("&4I got you fam"));
		}
	}
}