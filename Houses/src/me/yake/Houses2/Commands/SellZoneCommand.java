package me.yake.Houses2.Commands;

import java.io.File;
import java.util.HashMap;

import me.yake.Houses2.Houses;
import me.yake.Houses2.Cuboid.CuboidSelection;
import me.yake.Houses2.Listeners.HousesPlayerListener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.config.Configuration;

import com.LRFLEW.register.payment.Method;
import com.iConomy.iConomy;
import com.iConomy.system.Account;
import com.iConomy.system.Holdings;

public class SellZoneCommand {
	
	protected static Configuration config;
	protected static Configuration terrainConfig;
	static int priceOfZone = 1;
	static Location location1;
	static Location location2;
	public final static HashMap<Player, Boolean> confirmTransaction = new HashMap<Player, Boolean>();
	public static HashMap<Player, Boolean> requests = new HashMap<Player, Boolean>();
	public static iConomy iConomy = null;
	
	public static void sellZoneCommand(CommandSender sender, String[] args, int ppc2, String money){
		
		if(HousesPlayerListener.sizeOfZone.containsKey(sender)){
		if(args[0] != ""){
			
			if(args[1] != ""){
		
		if(Method.hasAccount(args[1])){
			
			Method.MethodAccount buyer = Method.MethodAccount.getAccount(args[1]);
			Method.MethodAccount buyeraccount = Method.MethodAccount.getAccount(args[1]);
			String sellername = sender.toString();
			 seller = com.iConomy.iConomy.getAccount(sellername).getHoldings();
			    
			if(buyeraccount != null )	{
				

				Integer getZoneSize = HousesPlayerListener.sizeOfZone.get(sender);

				//getZoneSize * ppc2; Integer.parseInt(Houses.getEquation());
				location1 = HousesPlayerListener.loc1.get(sender).getBlock().getLocation();
				location2 = HousesPlayerListener.loc2.get(sender).getBlock().getLocation();
				CuboidSelection.CuboidArea(location1, location2, Bukkit.getServer().getPlayer(sellername));
				if(Houses.equation.contains("%y")){
					
					if(location1.getBlockY() > location2.getBlockY()){
						
					priceOfZone *= CuboidSelection.getYSize();
					
					} else {
						
						priceOfZone *= CuboidSelection.getYSize();
						
					}
				}
				
				if(Houses.equation.contains("%x")){
					
					priceOfZone *= CuboidSelection.getXSize();
					
				}
				if(Houses.equation.contains("%z")){
					
					priceOfZone *= CuboidSelection.getZSize();
					
				}
				if(Houses.equation.contains("%ppc")){
					
					priceOfZone *= ppc2;
					
				}

					
				if(buyer.hasUnder(priceOfZone)){
					
					sender.sendMessage(ChatColor.RED + "" + args[1] + " has not enought money, needing " + priceOfZone + " " + money);
					priceOfZone = 0;
					HousesPlayerListener.loc1.remove(sender);
					HousesPlayerListener.loc2.remove(sender);
				}
				else
				{
						
					sender.sendMessage(ChatColor.GOLD + "The price of the terrain (size: " + getZoneSize + ") is: " + ChatColor.GREEN + priceOfZone + " " + money);
					sender.sendMessage(ChatColor.GREEN + args[1] + "'s holdings : " + ChatColor.WHITE + buyer);
					
					buyer.subtract(priceOfZone);
					seller.add(priceOfZone);
					priceOfZone = 0;
					Player buyerPlayer = Bukkit.getServer().getPlayer(args[1]);
					requests.put(buyerPlayer, false);					
					sender.sendMessage(ChatColor.GREEN + args[1] + "'s holdings after transaction : " + ChatColor.WHITE + buyer);
					File fterrain = new File("plugins/Houses/Terrains/" + args[1] + ".yml");
					File pterrain = new File("plugins/Houses/Terrains");
				        if(!fterrain.exists()) {
				            // creating it

				            System.out.println("[Houses] Creating file : " + args[1] +".yml.");
				            pterrain.mkdirs();
		    				String senderName = sender.toString();
		    				String finalSenderName = senderName.replace("CraftPlayer{name=", "").replace("}", "");
		    				
				    	    terrainConfig = new Configuration(new File("plugins/Houses/Terrains/" + args[1] + ".yml"));
				    	    
				    		terrainConfig.setProperty("infos.owner", args[1]);
				    		terrainConfig.setProperty("infos.creator", finalSenderName);
				    		terrainConfig.setProperty("infos.protection-enabled", false);
				    		
				    		terrainConfig.setProperty("location.point1.X", HousesPlayerListener.loc1.get(sender).getBlockX());
				    		terrainConfig.setProperty("location.point1.Y", HousesPlayerListener.loc1.get(sender).getBlockY());
				    		terrainConfig.setProperty("location.point1.Z", HousesPlayerListener.loc1.get(sender).getBlockZ());
				    		
				    		terrainConfig.setProperty("location.point2.X", HousesPlayerListener.loc2.get(sender).getBlockX());
				    		terrainConfig.setProperty("location.point2.Y", HousesPlayerListener.loc2.get(sender).getBlockY());
				    		terrainConfig.setProperty("location.point2.Z", HousesPlayerListener.loc2.get(sender).getBlockZ());
				    		
				    		terrainConfig.setProperty("protection.flags.tnt", false);
				    		terrainConfig.setProperty("protection.flags.others-can-build-in-zone", false);
				    		terrainConfig.setProperty("protection.flags.creeper-explosion", false);
				    		terrainConfig.setProperty("protection.flags.pvp", false);

				    		terrainConfig.save();


				    			
							
							HousesPlayerListener.loc1.remove(sender);
							HousesPlayerListener.loc2.remove(sender);
							
							
							System.out.println("[Houses] File created!");
				}
				}
			} else {
				
				sender.sendMessage(ChatColor.RED + args[1] + "'s account doesn't exist!");
				
			}
			
			} else {
				sender.sendMessage(ChatColor.RED + args[1] + "'s account doesn't exist!");
							
			}
			} else {
				sender.sendMessage(ChatColor.RED + "Error. Please type /house sellzone <buyername>.");
			}
	} else {
		sender.sendMessage(ChatColor.RED + "Error. Please type /house sellzone <buyername>.");
	}
		} else {
			sender.sendMessage(ChatColor.RED + "Please, first select a zone !");
		}
}
}
