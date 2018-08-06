package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import ForkPlexCore.ForkPlexCore.ForkPlexCore.Main;
import Translate.Translate;
import Utils.API;

public class defaultmineplex implements CommandExecutor {
	
	private static Plugin plugin = Main.plugin;
	API api = new API();
	
	public defaultmineplex(ForkPlexCore.ForkPlexCore.ForkPlexCore.Main plugin){
		this.plugin = plugin;
		plugin.getCommand("defaultmineplex").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)){
			sender.sendMessage("Only Players Can Use This Command.");
			return true;
		}
		
		Player p = (Player) sender;
		FileConfiguration file = Main.plugin.getConfig();
		
		if (p.hasPermission("fakeplex.defaultmineplex.command")){
			p.sendMessage(Translate.chat("&aThis plugin is setting the default mineplex shit."));
			file.set("TitleTOP", "&6&lFORKPLEX");
			file.set("TittleBOTTOM", "&9Made by andrew121410");
			file.set("TablistTOP", "&f&lMineplex Network&r     &aLobby-1");
			file.set("TablistBOTTOM", "Visit &awww.mineplex.com&r for News, Forums and Shop");
			Main.plugin.saveConfig();
			Main.plugin.reloadConfig();
			return true;
		} else {
			api.PermissionErrorMessage(p);
		}
		return true;
	}
}