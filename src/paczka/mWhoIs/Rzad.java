package paczka.mWhoIs;

import org.bukkit.plugin.java.JavaPlugin;

import paczka.mWhoIs.dzialanie.pInfo;

public class Rzad extends JavaPlugin{
	
	public static Rzad rzad;
	
	public void onEnable(){
		System.out.println("mWhoIs | Wlaczanie pluginu...");
		System.out.println("mWhoIs | Wersja: v1.0");
		new pInfo(this);
	}
	
	public void onDisable(){
		System.out.println("mWhoIs | Wylaczanie pluginu...");
		System.out.println("mWhoIs | Wersja: v1.0");
	}

}
