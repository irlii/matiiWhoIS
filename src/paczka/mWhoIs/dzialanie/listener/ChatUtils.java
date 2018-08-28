package paczka.mWhoIs.dzialanie.listener;

import org.bukkit.ChatColor;

public final class ChatUtils {
	
	public static String Color(String m){
		if(m == null){
			return "";
		}
		return ChatColor.translateAlternateColorCodes('&', m);
	}
} 
