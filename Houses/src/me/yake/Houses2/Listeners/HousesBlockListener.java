package me.yake.Houses2.Listeners;

import me.yake.Houses2.Houses;

import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;

public class HousesBlockListener extends BlockListener {
	
	public static Houses plugin;
	
	public HousesBlockListener(Houses instance) {
		
		plugin = instance;
		
	}
	
	public void onBlockPlace(BlockPlaceEvent event){
		
	}
}
