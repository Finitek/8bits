package space.eightbits.ranks.bit;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import space.eightbits.ranks.Ranks;
import net.md_5.bungee.api.ChatColor;

public class Bit implements Listener{
	Ranks main;

	@EventHandler
	public void OnChat(AsyncPlayerChatEvent event){
		if(main.CheckRank(event.getPlayer().getUniqueId()+"")=="bit"){
			event.setFormat(ChatColor.DARK_PURPLE+"BIT"+ChatColor.BLACK+"-"+ChatColor.GRAY+"%s"+ChatColor.RESET+": %s");
		}
	}
}
