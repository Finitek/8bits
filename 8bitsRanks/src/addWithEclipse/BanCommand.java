package space.eightbits.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import space.eightbits.ranks.Ranks;
public class BanCommand implements CommandExecutor{
    Ranks plugin;
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //if player is op, player can ban that player and length of args equals 3{
            //ban
            if(!plugin.getConfig().contains("id."+(Player)sender.getUniquId()+".actions")){
                plugin.getConfig().addDefault("id."+(Player)sender.getUniquId()+"actions");
                plugin.getConfig().copyDefaults(true);
                plugin.saveConfig();
            }
            //make varibale for actions element
            //get avalaible id of action and add maek it variable (id)
            String path = "id."+(Player)sender.getUniquId()+".actions."/*+id*/;
            plugin.getConfig().addDefault(path+".type","ban");
            plugin.getConfig().addDefault(path+".player",args[0]);
            plugin.getConfig().addDefault(path+".period",args[1]);
            plugin.getConfig().addDefault(path+".reason",args[2]);
            plugin.getConfig().copyDefaults(true);
            plugin.saveConfig();
        //}
    }
}