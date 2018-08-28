package paczka.mWhoIs.dzialanie;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import paczka.mWhoIs.Rzad;

public class pInfo implements CommandExecutor{
	
	public pInfo(Rzad r){
		r.getCommand("whois").setExecutor(this);
	}

	@SuppressWarnings({ "deprecation" })
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lab,String[] args){
		if(cmd.getName().equalsIgnoreCase("whois")){
			if(!(sender instanceof Player)){
				sender.sendMessage("§7» §c§lERROR: §4Komende moze tylko uzywac uzytkownik!");
				return false;
			}
			if(!(sender.hasPermission("whois.allow"))){
				sender.sendMessage("§7» §c§lERROR: §4Brak uprawnien! §7(§4admin.minicore§7)");
				return false;
			}
			if(args.length==1){
				Player cel = Bukkit.getPlayerExact(args[0]);
				Player p = (Player) sender;
				if(cel!=null){
					//Podstawowe zmienne
					String nick = cel.getName();
					Double hp = cel.getHealth();
					int feed = cel.getFoodLevel();
					String ip = cel.getAddress().toString().replaceAll("/", "");
					String uuid = cel.getUniqueId().toString();
					GameMode gm = cel.getGameMode();
					Boolean fly = cel.isFlying();
					//Lokacja gracza
					int x = p.getLocation().getBlockX();
					int y = p.getLocation().getBlockY();
					int z = p.getLocation().getBlockZ();
					
					String.format("kordy: %d, %d, %d", x, y, z);
					
					p.sendMessage("§7» §cKarta informacyjna "+cel.getName());
					p.sendMessage(" ");
					p.sendMessage("§7» §cNick: §7"+nick);
					p.sendMessage("§7» §cKordy:§7 " + x + " " + y + " " + z);
					p.sendMessage("§7» §cIP: §7"+ip);
					p.sendMessage("§7» §cUUID: §7"+uuid);
					p.sendMessage("§7» §cGamemode: §7"+gm);
					p.sendMessage("§7» §cLatanie: §7"+fly);
					p.sendMessage("§7» §cIlosc zycia: §7"+hp+"/20");
					p.sendMessage("§7» §cIlosc glodu: §7"+feed+"/20");
				} else{
					sender.sendMessage("§7» §c§lERROR: §4Podany uzytkownik jest offline!");
					return false;
				}
			} else{
				sender.sendMessage("§7» §c§lERROR: §4Poprawne uzycie: /whois <uzytkownik>");
				return false;
			}
		}
		return false;
	}

}
