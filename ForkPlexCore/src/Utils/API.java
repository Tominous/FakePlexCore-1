package Utils;

import org.bukkit.entity.Player;

import Translate.Translate;

public class API {
	
	public void PermissionErrorMessage(Player p) {
		p.sendMessage(Translate.chat("[&9World1-6&r] &cYou Do Not Have Permission To Use This Command."));
	}
}