package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ForkPlexCore.ForkPlexCore.ForkPlexCore.Main;
import Translate.Translate;

public class bungee implements CommandExecutor {
	
	private Main plugin;
	
	public bungee(ForkPlexCore.ForkPlexCore.ForkPlexCore.Main main){
		this.plugin = plugin;
		main.getCommand("bungee").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)){
			sender.sendMessage("Only Players Can Use This Command.");
			return true;
		}
		
		Player p = (Player) sender;
		
		if (p.hasPermission("fakeplex.bungee.command")){
			p.sendMessage(Translate.chat("&9This server is running BungeeCord version"));
			p.sendMessage(Translate.chat("&9Umm i really don't even know."));
			return true;
		} else {
			p.sendMessage(Translate.chat("You don't have permission to use this command."));
		}
		return false;
	}

}
