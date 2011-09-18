package me.yake.Houses2.Listeners;

import me.yake.Houses2.Houses;

import org.bukkit.Bukkit;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.event.server.ServerListener;
import org.bukkit.plugin.PluginManager;

import com.LRFLEW.register.payment.Method;
import com.LRFLEW.register.payment.Methods;

public class HousesServerListener extends ServerListener {
    private Houses plugin;
    private Method economy;

    public HousesServerListener(Houses plugin) {
        this.plugin = plugin;
        this.economy = Methods.getMethod();
    }

    @Override
    public void onPluginDisable(PluginDisableEvent event) {
        if (plugin.economy != null) {
                plugin.economy = null;
                System.out.println("[Houses] un-hooked from " + economy.getName() + ".");
            }
        }

    @Override
    public void onPluginEnable(PluginEnableEvent event) {
        PluginManager pm = Bukkit.getServer().getPluginManager();


        if (economy !=null && !Methods.hasMethod()) {
        	
            if (Methods.setMethod((PluginManager) pm.getPlugin("iConomy"))) {
            	
                plugin.economy = Methods.getMethod();
                
            }
            
            else if (Methods.setMethod((PluginManager) pm.getPlugin("BOSEconomy"))) {
            	
                plugin.economy = Methods.getMethod();
                
            }
            
            else if (Methods.setMethod((PluginManager) pm.getPlugin("EssentialsEco"))) {
            	
                plugin.economy = Methods.getMethod();
                
            }
        }
    }
}