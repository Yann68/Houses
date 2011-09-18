package me.yake.Houses2.Commands;


import me.yake.Houses2.Houses;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.iCo6.iConomy;
import com.nijiko.permissions.PermissionHandler;



public class CommandsCore implements CommandExecutor{


	public static PermissionHandler permissionHandler;
	public static Houses plugin;
	public static iConomy iConomy = null;


	
	final DefaultCommand defaultcom = new DefaultCommand();
	final InfoCommand info = new InfoCommand();
	final HelpCommand help = new HelpCommand();
	final ConfirmCommand confirm = new ConfirmCommand();
	final SellZoneCommand szcom = new SellZoneCommand();
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
			if (label.equalsIgnoreCase("house")) {
				if(args.length == 0)
				{
					DefaultCommand.defaultCommand(sender);
				}
				else
				{
					
					if(args[0].equalsIgnoreCase("info"))
					{
						
					    if (Houses.permissionHandler.has((Player) sender, "houses.houses")) {
						InfoCommand.infoCommand(sender, Houses.version);
					    } else {
					    	sender.sendMessage(ChatColor.RED + "You don't have permission for that!");
					    }
						
					} else if (args[0].equalsIgnoreCase("help")) {
						
						if (Houses.permissionHandler.has((Player) sender, "houses.houses")) {
						HelpCommand.helpCommand(sender);
						} else {
							sender.sendMessage(ChatColor.RED + "You don't have permission for that!");
						}
						
					} else if (args[0].equalsIgnoreCase("confirm")){
						
						if (Houses.permissionHandler.has((Player) sender, "houses.houses")) {
						ConfirmCommand.confirmCommand(sender);
						} else {
							sender.sendMessage(ChatColor.RED + "You don't have permission for that!");
						}
					} else if (args[0].equalsIgnoreCase("sellzone") && iConomy.isEnabled()){
						
						if (Houses.permissionHandler.has((Player) sender, "houses.sell")) {
							SellZoneCommand.sellZoneCommand(sender, args, Houses.pricepercube, Houses.money);
						
						} else {
							sender.sendMessage(ChatColor.RED + "You don't have permission for that!");
						}
						
			}
		}
	}
		return false;
}
}