package Events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import ForkPlexCore.ForkPlexCore.ForkPlexCore.Main;

public class DoubleJump implements Listener{
	
	private static Plugin plugin = Main.plugin;
	
	public DoubleJump(ForkPlexCore.ForkPlexCore.ForkPlexCore.Main plugin) {
		this.plugin = plugin;
	
	Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.setGameMode(GameMode.ADVENTURE);
        player.setAllowFlight(true);
    }
 
    @EventHandler
    public void onPlayerToggleFlight(PlayerToggleFlightEvent event) {
        Player player = event.getPlayer();
        if (player.getGameMode() == GameMode.ADVENTURE) {
            player.setFlying(false);
            Location loc = player.getLocation().clone();
            loc.setPitch(0.0F);
            Vector vel = player.getVelocity().clone();
       
            int strength = 10;
       
            Vector jump = vel.multiply(0.1D).setY(0.17D * strength);
            Vector look = loc.getDirection().normalize().multiply(1.5D);
       
            player.setVelocity(jump.add(look));
       
            player.setAllowFlight(false);
            
            player.playSound(player.getLocation(), Sound.ENTITY_GHAST_SHOOT, 10.0f, 1.0f);
       
            event.setCancelled(true);
        }
    }
 
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (player.getGameMode() == GameMode.ADVENTURE) {
            if (!player.getAllowFlight()) {
                Location loc = player.getLocation();
                Block block = loc.getBlock().getRelative(BlockFace.DOWN);
                if (block.getType() != Material.AIR) {
                    player.setAllowFlight(true);
                }
            }
        }
    }
}