package me.yake.Houses2.Listeners;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;
import me.yake.Houses2.Houses;
import me.yake.Houses2.Cuboid.CuboidSelection;


public class HousesPlayerListener extends PlayerListener {

	public static Houses plugin;
	public final static HashMap<Player, Location> loc1 = new HashMap<Player, Location>();
	public final static HashMap<Player, Location> loc2 = new HashMap<Player, Location>();
	
	public final static HashMap<Player, Integer> sizeOfZone = new HashMap<Player, Integer>();
	public final static HashMap<Player, Boolean> confirmHashMap = new HashMap<Player, Boolean>();
	Block blockLeft;
	Block blockRight;
	public HousesPlayerListener(Houses instance) {
		
		plugin = instance;
		
	}
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action action = event.getAction();

			if(action == Action.LEFT_CLICK_BLOCK) {
				
			 	if(event.getPlayer().getItemInHand().getTypeId() == Houses.selectionItem) {
			 		
			 		blockLeft = event.getClickedBlock();
			 		player.sendMessage("You selected the first point of the zone.");
	 			
			 	}
			} else if(action == Action.RIGHT_CLICK_BLOCK){
				
			 	if(event.getPlayer().getItemInHand().getTypeId() == Houses.selectionItem) {

		 			blockRight = event.getClickedBlock();
					player.sendMessage("You selected the second point of the zone.");
					
	 				Location blockRightLoc = blockRight.getLocation();
	 		 		Location blockLeftLoc = blockLeft.getLocation();
	 		 		
					CuboidSelection.CuboidArea(blockLeftLoc, blockRightLoc, player);
					
					sizeOfZone.put(player, (int) CuboidSelection.getSize());
					loc1.put(player, blockLeftLoc);
					loc2.put(player, blockRightLoc);
					
					player.sendMessage(ChatColor.DARK_AQUA + "Selection size: " + CuboidSelection.getSize());
					
			}
	 	}
	}
	
/*	public void onPlayerMove(PlayerMoveEvent event){
		
		File fileDir = new File("plugins/Houses/Terrains");
		File[] files = fileDir.listFiles();
		Configuration conf;
		
		Location checkLoc1 = null;
		Location checkLoc2 = null;
		
		int i = 0;
		
		while(fileDir.exists()){
			
			File fileToRead2 = new File(files[i].toString());
		//	checkCuboid.checkIfCuboid(event.getPlayer().getLocation(), checkCuboid.getNewLocation1(checkLoc1, fileToRead2), checkCuboid.getNewLocation2(checkLoc2, fileToRead2), event.getPlayer());
			i++;
			
		}
		
	} */
	
/*	public void onPlayerChat(PlayerChatEvent event) {
		Player player = event.getPlayer();
		String message = event.getMessage();
		System.out.println(message);
		if(Commands.confirmTransaction.containsKey(player)){
			
			if(message == "yes"){
				
				confirmHashMap.put(player, true);
				Commands.confirmTransaction.remove(player);
				player.sendMessage(ChatColor.GREEN + "You confirmed !");
				event.setCancelled(true);
				
			} else if (message == "no"){
				
				confirmHashMap.put(player, true);
				player.sendMessage(ChatColor.RED + "You refused !");
				event.setCancelled(true);
				
			} else {
				
				player.sendMessage(ChatColor.RED + "You must type 'yes' or 'no' !");
				event.setCancelled(true);
			}
		}
	} */
}