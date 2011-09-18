package me.yake.Houses2.Listeners;

import me.yake.Houses2.Houses;

import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityListener;

public class HousesEntityListener extends EntityListener {
	
	public static Houses plugin;
	
	public HousesEntityListener(Houses instance) {
		
		plugin = instance;
		
	}
	
	public void onEntityExplode(EntityExplodeEvent event){
		
		if(event.getEntity().getEntityId() != 0){
		}
		
	}

}
