package space.eightbits.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import space.eightbits.ranks.Ranks;

public class KickCommand implements CommandExecutor{
    Ranks plugin;
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //if player is op, player can kick that player and length of args equals 2{
            //ban
            if(!plugin.getConfig().contains("id."+(Player)sender.getUniquId()+".actions")){
                plugin.getConfig().addDefault("id."+(Player)sender.getUniquId()+"actions");
                plugin.getConfig().copyDefaults(true);
                plugin.saveConfig();
            }
            //make varibale for actions element
            //get avalaible id of action and add maek it variable (id)
            String path = "id."+(Player)sender.getUniquId()+".actions."/*+id*/;
            plugin.getConfig().addDefault(path+".type","kick");
            plugin.getConfig().addDefault(path+".player",args[0]);
            plugin.getConfig().addDefault(path+".reason",args[1]);
            plugin.getConfig().copyDefaults(true);
            plugin.saveConfig();
            
        //}
    }
}