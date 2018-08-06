package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import ForkPlexCore.ForkPlexCore.ForkPlexCore.Main;
import Translate.Translate;
import Utils.API;

public class bungee implements CommandExecutor {
	
	private static Plugin plugin = Main.plugin;
	API api = new API();
	
	public bungee(ForkPlexCore.ForkPlexCore.ForkPlexCore.Main plugin){
		this.plugin = plugin;
		
		plugin.getCommand("bungee").setExecutor(this);
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
			api.PermissionErrorMessage(p);
		}
		return true;
	}
}