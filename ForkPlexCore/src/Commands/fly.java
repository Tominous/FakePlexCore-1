package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ForkPlexCore.ForkPlexCore.ForkPlexCore.Main;
import Translate.Translate;

public class fly implements CommandExecutor {
	
	private Main plugin;
	
	public fly(ForkPlexCore.ForkPlexCore.ForkPlexCore.Main main){
		this.plugin = plugin;
		main.getCommand("fly").setExecutor(this);
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
            } else {
                  p.setAllowFlight(true);
                  p.setAllowFlight(false);
                  p.sendMessage(Translate.chat("Flying Disabled."));
                return true;
                } 
			return true;
		} else {
			p.sendMessage(Translate.chat("You don't have permission to use this command."));
		}
		return false;
	}

}
