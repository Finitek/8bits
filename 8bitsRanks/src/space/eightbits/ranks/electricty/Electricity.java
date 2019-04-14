package space.eightbits.ranks.electricty;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import space.eightbits.ranks.Ranks;
import net.md_5.bungee.api.ChatColor;

public class Electricity implements Listener{
	Ranks main;

	@EventHandler
	public void WhenChats(AsyncPlayerChatEvent event){
		if(main.CheckRank(event.getPlayer().getUniqueId()+"")=="electricity"){
		event.setFormat(ChatColor.BLUE+"ELECTRICTY"+ChatColor.BLACK+"-"+ChatColor.GRAY+"%s"+ChatColor.RESET+": %s");
		}
	}
}
