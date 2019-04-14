package space.eightbits.ranks;

import java.awt.List;

import com.sun.prism.Material;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;
import space.eightbits.ranks.bit.Bit;
import space.eightbits.ranks.bytea.Byte;
import space.eightbits.ranks.electricty.Electricity;
import space.eightbits.ranks.image.Image;
import space.eightbits.commands.OpCommand;
import space.eightbits.commands.BanCommand;
import space.eightbits.commands.KickCommand;
import space.eightbits.commands.LobbyCommand;
public class Ranks extends JavaPlugin implements Listener, CommandExecutor{
	public String CheckRank(String uuid) {
		if(this.getConfig().getString("id."+uuid+".rank.type")=="electricity"){
			return "electricity";
		}
		if(this.getConfig().getString("id."+uuid+".rank.type")=="bit"){
			return "bit";
		}
		
		
		if(this.getConfig().getString("id."+uuid+".rank.type")=="image"){
			return "image";
		}
		if(this.getConfig().getString("id."+uuid+".rank.type")=="antivirus"){
			return "antivirus";
		}
		if(this.getConfig().getString("id."+uuid+".rank.type")=="program"){
			return "program";
		}
		if(this.getConfig().getString("id."+uuid+".rank.type")=="os"){
			return "os";
		}
		return "default";
		switch(this.getConfig().getString("id."+uuid+".rank.type")){
			case "electricity"://1
				return "electricity";
			case "bit"://2
				return "bit";
			case "byte"://3
				return "byte";
			case "image"://4
				return "image";
			case "antivirus"://5
				return "antivirus";
			case "program"://6
				return "program";
			case "os"://7
				return "os";
			default:
				return:"default";

		}
		
			
		
	}
	@Override
	public void onEnable(){
		getServer().getPluginManager().registerEvents(new Electricity(), this);
		getServer().getPluginManager().registerEvents(new Bit(), this);
		getServer().getPluginManager().registerEvents(new Byte(), this);
		getServer().getPluginManager().registerEvents(new Image(), this);
		getServer().getPluginManager().registerEvents(this, this);
		this.getConfig().options().copyDefaults(true);
	    this.saveConfig();
		this.getCommand("setrank").setExecutor(this);
		this.getCommand("op").setExecutor(new OpCommand());
		this.getCommand("ban").setExecutor(new BanCommand());
		this.getCommand("kick").setExecutor(new KickCommand());
		this.getCommand("lobby").setExecutor(new LobbyCommand());
		
	    
	}
	@Override
	public void onDisable(){
		
	}
	@EventHandler
	public void noDying(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) { e.setCancelled(true); }
	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		String uuid=player.getUniqueId+"";
		System.out.println("Player joined.");
		// teleport to spawn
		//if world is on spawn{
			ItemStack menu=new ItemStack(Material.COMPASS);
			ItemMeta menuMeta= new ItemMeta();
			menuMeta.setDisplayName(ChatColor.RED+"Menu");
			List<String> menuLore;
			menuLore.add("Coins: "+this.getConfig().getString("id."+uuid+".coins"+"EBC"));
			Int worldCount = this.getConfig().getInt("id."+uuid+".worlds.count.bought")+this.getConfig().getInt("id."+uuid+".worlds.count.rank")
			menuLore.add("Worlds: "+worldCount));
			menuLore.add("Player online: " +getServer().getOnlinePlayers().length);
			menuMeta.setLore(menuLore);
		//}
		if(!player.hasPlayedBefore()){//if(this.getConfig().contains("id."+player.getUniqueId())) {
			this.getConfig().addDefault("id."+uuid,ChatColor.RED+ "Yeah!!!!!");
			this.getConfig().addDefault("id."+uuid+".name", player.getName());
			this.getConfig().addDefault("id."+uuid+".rank.type", "default");
			this.getConfig().addDefault("id."+uuid+".worlds.count.bought", 0);
			this.getConfig().addDefault("id."+uuid+".worlds.count.rank", 0);
			this.getConfig().addDefault("id."+uuid+".coins", 0);
			this.getConfig().options().copyDefaults(true);
		    this.saveConfig();
		    System.out.println("Created config for them!");
		    
		}else {
			System.out.println("But they have their own config!");
		}
		//teleports to spawn

	}
	@EventHandler
	
	@EventHandler
	public void onDropAtSpawn(PlayerDropItemEvent e){
		// if player is at spawn {
			e.setCancelled(true);
		//}
	}
	@EventHandler 
	public void onClickAtSpawn(PlayerInteractEvent e){
		//if right clicks on menu item open menu(inventory)
		Player player e.getPlayer();
		ItemStack menu = new ItemStack(Material.COMPASS);
		Inventory menuInventory = Bukkit.createInventory(null,x*9,ChatColor.RESET+"Menu");
		menuInventory.setItem(slot, stack);
		if(player.getItemInHand()== menu){
			player
		}
		
	}
	public void setPlayerConfig(String uuid, String name) {
		this.getConfig().addDefault("id."+uuid,ChatColor.RED+ "Yeah!!!!!");
		this.getConfig().addDefault("id."+uuid+".name", name);
		this.getConfig().addDefault("id."+uuid+".rank.type", "default");
		this.getConfig().addDefault("id."+uuid+".worlds.count.bought", 0);
		this.getConfig().options().copyDefaults(true);
	    this.saveConfig();
	}
	public void setElectricity(String uuid){
		this.getConfig().set("id."+uuid+".rank.type","electricity");
		this.getConfig().addDefault("id."+args[1]+".worlds.count.rank", 1);
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		//set rank to electricity
	}
	public void setBit(String uuid){
		this.getConfig().set("id."+uuid+".rank.type","bit");
		this.getConfig().addDefault("id."+args[1]+".worlds.count.rank", 2);
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		//sets rank to bit
	}
	public void setByte(String uuid){
		this.getConfig().set("id."+uuid+".rank.type","byte");
		this.getConfig().addDefault("id."+args[1]+".worlds.count.rank", 5);
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		//sets rank to byte
	}
	public void setImage(String uuid){
		this.getConfig().set("id."+uuid+".rank.type","image");
		this.getConfig().addDefault("id."+args[1]+".worlds.count.rank", 10);
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		//sets rank to image
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player) && args.length==3) {
			if(!this.getConfig().contains("id."+args[1])) {
				setPlayerConfig(args[1],args[2]);
			}
			if(args[0]=="electricity") {
				setElectricity(args[1]);
				return true;
			}
			if(args[0]=="bit") {
				setBit(args[1]);
				return true;
			}
			if(args[0]=="byte") {
				setByte(args[1]);
				return true;
			}
			if(args[0]=="image") {
				
				setImage(args[1]);
				return true;
			}
			return true;
		}
		sender.sendMessage("Hahaha, just kiddin'!");
        return true;
    }
	
}
