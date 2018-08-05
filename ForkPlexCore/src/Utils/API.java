package Utils;

import org.bukkit.entity.Player;

import Translate.Translate;

public class API {
	public void PermissionErrorMessage(Player p) {
		p.sendMessage(Translate.chat("&9Message>&c Err...something went wrong? do you have the correct permission?"));
	}
}