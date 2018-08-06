package Events;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.plugin.Plugin;

import ForkPlexCore.ForkPlexCore.ForkPlexCore.Main;

public class NewDoubleJump implements Listener {
	
	private static Plugin plugin = Main.plugin;
	
	public NewDoubleJump(ForkPlexCore.ForkPlexCore.ForkPlexCore.Main plugin) {
		this.plugin = plugin;
	
	Bukkit.getPluginManager().registerEvents(this, plugin);
	}
  @EventHandler
  public void onMove(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    {
      if (p.getGameMode() == GameMode.CREATIVE) {
        return;
      }
      if (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.AIR) {
        return;
      }
      if (p.isFlying()) {
        return;
      }
      p.setAllowFlight(true);
    }
  }
  @SuppressWarnings("deprecation")
@EventHandler
  public void ToggleFlighEvent(PlayerToggleFlightEvent event) {
    Player player = event.getPlayer();
  {
      if (player.getGameMode() == GameMode.CREATIVE) {
        return;
      }
      event.setCancelled(true);
      player.setAllowFlight(false);
      player.setFlying(false);
      player.setVelocity(player.getLocation().getDirection().multiply(1.4D).setY(1));
      player.playEffect(player.getLocation(), Effect.BLAZE_SHOOT, 0);
  }
  }
}