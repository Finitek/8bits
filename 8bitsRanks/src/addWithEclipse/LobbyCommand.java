package space.eightbits.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import space.eightbits.ranks.Ranks;

public class LobbyCommand implements CommandExecutor{
    Ranks plugin;
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    //if player isn't on spawn{
        //teleport to spawn
        if(args.length != 0){
            (Player)sender.sendMessage("Arguments are not required for this command!")
        }    
    //}
    }
}