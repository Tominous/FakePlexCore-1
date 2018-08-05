package Utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import Translate.Translate;
import ForkPlexCore.ForkPlexCore.ForkPlexCore.Main;

public class CustomYmlManger {

	private Main plugin = Main.getPlugin(Main.class);
	
	//Files & File Configs Here.
	public FileConfiguration shitcfg;
	public File shitfile;
	// --------------------------------------------------------------------------------------------------------
	public void setupshit(){
		if (!plugin.getDataFolder().exists()) {
		plugin.getDataFolder().mkdir();
	}
	shitfile = new File(plugin.getDataFolder(), "shit.yml");
	
	if (!shitfile.exists()) {
		try {
			shitfile.createNewFile();
			Bukkit.getServer().getConsoleSender().sendMessage(Translate.chat("The shit.yml has been created."));
		} catch (IOException e) {
			Bukkit.getServer().getConsoleSender().sendMessage(Translate.chat("The shit.yml could not make for some reason."));
		}
	}
	
	shitcfg = YamlConfiguration.loadConfiguration(shitfile);
	}
	public FileConfiguration getshit() {
		return shitcfg;
	}
	public void saveshit() {
		try {
			shitcfg.save(shitfile);
			Bukkit.getServer().getConsoleSender().sendMessage(Translate.chat("&aThe shit.yml has been saved."));
		} catch (IOException e) {
			Bukkit.getServer().getConsoleSender().sendMessage(Translate.chat("&cThe shit.yml has been NOT SAVED.."));
		}
	}
	public void reloadshit() {
		shitcfg = YamlConfiguration.loadConfiguration(shitfile);
		Bukkit.getServer().getConsoleSender().sendMessage(Translate.chat("&6The shit.yml has been reloaded."));
		//END OF SHIT YML ****************************************************************************************************
	}
}