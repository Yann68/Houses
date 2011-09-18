package me.yake.Houses2.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ConfirmCommand {
	public static void confirmCommand(CommandSender sender){		
		sender.sendMessage(ChatColor.GREEN + "You confirmed !");
}
}
