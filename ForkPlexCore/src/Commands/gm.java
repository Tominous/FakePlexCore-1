package Commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import ForkPlexCore.ForkPlexCore.ForkPlexCore.Main;
import Translate.Translate;
import Utils.API;

public class gm implements CommandExecutor {
	
	private static Plugin plugin = Main.plugin;
	API api = new API();
	
	public gm(ForkPlexCore.ForkPlexCore.ForkPlexCore.Main plugin){
		this.plugin = plugin;
		plugin.getCommand("gm").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)){
			sender.sendMessage("Only Players Can Use This Command.");
			return true;
		}
		
		Player p = (Player) sender;
		
		if (p.hasPermission("fakeplex.gm.command")){
			if(p.getGameMode() == GameMode.ADVENTURE){
				p.setGameMode(GameMode.CREATIVE);
				p.sendMessage(Translate.chat("&9Game Mode>&7 Creative Mode: &aTrue"));
			}
				else if (p.getGameMode() == GameMode.CREATIVE){
					p.setGameMode(GameMode.ADVENTURE);
					p.sendMessage(Translate.chat("&9Game Mode>&7 Creative Mode: &cFalse"));
				}
		} else {
			p.sendMessage(Translate.chat("You don't have permission to use this command."));
		}
		return true;
	}

}
