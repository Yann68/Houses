package me.yake.Houses2.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class HelpCommand {
	public static void helpCommand(CommandSender sender){
		sender.sendMessage(ChatColor.GOLD + "---------- [Houses commands] ----------");
		sender.sendMessage(ChatColor.GREEN + "/house info " + ChatColor.WHITE + "- gives you more infos about the plugin");
		sender.sendMessage(ChatColor.GREEN + "/house sellzone <buyername>" + ChatColor.WHITE + " - makes you sell a terrain of <sizeterrain>'s size to <buyername>");

	}
}
