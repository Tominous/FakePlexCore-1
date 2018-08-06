package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import ForkPlexCore.ForkPlexCore.ForkPlexCore.Main;
import Translate.Translate;
import Utils.API;

public class fly implements CommandExecutor {
	
	private static Plugin plugin = Main.plugin;
	API api = new API();

	
	public fly(ForkPlexCore.ForkPlexCore.ForkPlexCore.Main plugin){
		this.plugin = plugin;
		plugin.getCommand("fly").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)){
			sender.sendMessage("Only Players Can Use This Command.");
			return true;
		}
		
		Player p = (Player) sender;
		
		if (p.hasPermission("fakeplex.fly.command")){
            if (p.getAllowFlight() == (false)){
                p.setAllowFlight(true);
                p.sendMessage(Translate.chat("Flying Enabled."));
            }else if (p.getAllowFlight() == (true)){
            	p.setAllowFlight(false);
                  p.sendMessage(Translate.chat("Flying Disabled."));
                return true;
		} else {
			api.PermissionErrorMessage(p);
		}
		}
		return true;
	}
}