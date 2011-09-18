package me.yake.Houses2.Commands;

import me.yake.Houses2.Houses;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DefaultCommand {
	public static void defaultCommand(CommandSender sender){
		if(Houses.permissionHandler != null)
		{
	    if (Houses.permissionHandler.has((Player) sender, "houses.houses")) {

			sender.sendMessage(ChatColor.RED + "Error. Please try /house info for more informations.");
		} else {
			sender.sendMessage(ChatColor.RED + "You don't have permission for that");
		}
		} else {
			sender.sendMessage(ChatColor.RED + "Error. Please try /house info for more informations.");
		}
	}
}
