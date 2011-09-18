package me.yake.Houses2.Commands;

import me.yake.Houses2.Houses;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class InfoCommand {
	public static void infoCommand(CommandSender sender, String version){	
		Houses.config.load();
		sender.sendMessage(ChatColor.GREEN + "[Houses]" + ChatColor.GOLD + " Version " + version + " by Yake (yannkaiser16)");	
		sender.sendMessage(ChatColor.GOLD + "---------- [Houses config] -----------");
		sender.sendMessage(ChatColor.GREEN + "money: " + ChatColor.WHITE + Houses.config.getString("config.money"));
		sender.sendMessage(ChatColor.GREEN + "price-per-block: " + ChatColor.WHITE + Houses.config.getInt("config.price-per-block", 100));
		sender.sendMessage(ChatColor.GREEN + "selection-item: " + ChatColor.WHITE + Houses.config.getInt("config.selection-item", 286));
		sender.sendMessage(ChatColor.GREEN + "specified-equation" + ChatColor.WHITE + Houses.config.getString("config.specified-equation"));
		
	}
}
