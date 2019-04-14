package space.eightbits.ranks;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.md_5.bungee.api.ChatColor;



public class Events implements Listener{
	
	Ranks plugin;
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		//if(!plugin.getConfig().contains(""+player.getUniqueId())) {
			plugin.getConfig().addDefault("id."+player.getUniqueId(),ChatColor.RED+ "Yeah!!!!!");
			System.out.println("plugin.getConfig().addDefault(\"id.\"+player.getUniqueId(),ChatColor.RED+ \"Yeah!!!!!\");");
			plugin.getConfig().addDefault("id."+player.getUniqueId()+".name", player.getName());
			System.out.println("plugin.getConfig().addDefault(\"id.\"+player.getUniqueId()+\".name\", player.getName());");
		    plugin.getConfig().options().copyDefaults(true);
		    System.out.println("plugin.getConfig().options().copyDefaults(true);");
		    plugin.saveConfig();
		    System.out.println("plugin.saveConfig();");
		    
		//}
	}

}
