package Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ForkPlexCore.ForkPlexCore.ForkPlexCore.Main;
import Translate.Translate;
import Utils.API;
import Utils.CustomYmlManger;

public class spawn implements CommandExecutor {
	
	private Main plugin;
	API api = new API();
	
	private CustomYmlManger configinstance = null;
	public spawn(CustomYmlManger getConfigInstance, ForkPlexCore.ForkPlexCore.ForkPlexCore.Main plugin) {
        this.configinstance = getConfigInstance;
   this.plugin = plugin;
        plugin.getCommand("spawn").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)){
			sender.sendMessage("Only Players Can Use This Command.");
			return true;
		}
		
		Player p = (Player) sender;
		
	      double x = configinstance.getshit().getInt("Spawn.Data.X");
	      double y = configinstance.getshit().getInt("Spawn.Data.Y");
	      double z = configinstance.getshit().getInt("Spawn.Data.Z");
	      float yaw = (float)configinstance.getshit().getInt("Spawn.Data.Yaw");
	      float pitch = (float)configinstance.getshit().getInt("Spawn.Data.Pitch");
	      World world = Bukkit.getWorld(configinstance.getshit().getString("Spawn.Data.World"));
	      
	      Location spawn = new Location(world, x, y, z, yaw, pitch);
		//World world = Bukkit.getServer().getWorld("world");
		//FileConfiguration file = Main.plugin.getConfig();
		
		if (p.hasPermission("fakeplex.spawn.command")){
		      p.teleport(spawn);
			p.sendMessage(Translate.chat("&6Teleporting..."));
			return true;
		} else {
			api.PermissionErrorMessage(p);
		}
		return true;
	}

}