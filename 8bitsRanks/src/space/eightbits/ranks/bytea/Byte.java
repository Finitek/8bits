package space.eightbits.ranks.bytea;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import space.eightbits.ranks.Ranks;
import net.md_5.bungee.api.ChatColor;

public class Byte implements Listener{
	Ranks main;

	@EventHandler
	public void WhenChats(AsyncPlayerChatEvent event){
		if(main.CheckRank(event.getPlayer().getUniqueId()+"")=="byte"){
		event.setFormat(ChatColor.AQUA+"BIT"+ChatColor.BLACK+"-"+ChatColor.GRAY+"%s"+ChatColor.RESET+": %s");
		}
	}
}