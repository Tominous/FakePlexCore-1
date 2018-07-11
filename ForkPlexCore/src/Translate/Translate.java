package Translate;

import org.bukkit.ChatColor;

public class Translate {

	public static String chat (String s){
		return ChatColor.translateAlternateColorCodes('&', s);
	}
}