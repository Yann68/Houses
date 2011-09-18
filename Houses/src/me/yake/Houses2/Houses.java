package me.yake.Houses2;

import java.io.File;
import java.util.logging.Logger;

import me.yake.Houses2.Commands.CommandsCore;
import me.yake.Houses2.Cuboid.CuboidSelection;
import me.yake.Houses2.Listeners.HousesBlockListener;
import me.yake.Houses2.Listeners.HousesEntityListener;
import me.yake.Houses2.Listeners.HousesPlayerListener;
import me.yake.Houses2.Listeners.HousesServerListener;

import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.config.Configuration;

import com.LRFLEW.register.payment.Method;
import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;


public class Houses extends JavaPlugin{
	
	public static Houses plugin;
    public Method economy;
	private static CuboidSelection csel;
	//Gets the logger
	public final Logger log = Logger.getLogger("Minecraft");
	public static Configuration config;
	
	public static String money;	
	public static int pricepercube;
	public static String version = "2.0";
	public static int selectionItem;
	public static String equation;
	
	File f = new File("plugins/Houses/config.yml");
	public static PermissionHandler permissionHandler;
	

	
	
	
	@Override
	public void onDisable() {
		
		this.log.info("[Houses] is disabled!");
		config.save();
	}

	@Override
	public void onEnable() {

		PluginDescriptionFile pdfFile = this.getDescription();
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvent(Type.PLUGIN_ENABLE, new HousesServerListener(this), Priority.Monitor, this);
        pm.registerEvent(Type.PLUGIN_DISABLE, new HousesServerListener(this), Priority.Monitor, this);
        pm.registerEvent(Type.PLAYER_INTERACT, new HousesPlayerListener(this), Priority.Normal, this);
        pm.registerEvent(Type.PLAYER_MOVE, new HousesPlayerListener(this), Priority.Normal, this);
        pm.registerEvent(Type.BLOCK_BREAK, new HousesBlockListener(this), Priority.High, this);
        pm.registerEvent(Type.ENTITY_EXPLODE, new HousesEntityListener(this), Priority.High, this);
        pm.registerEvent(Type.BLOCK_PLACE, new HousesBlockListener(this), Priority.High, this);
        
		this.log.info("[" + pdfFile.getName() + "] version " + pdfFile.getVersion() + " is enabled!");
		try{
			
			if(f.exists()){
				
				loadConfig();
				this.log.info("[" + pdfFile.getName() + "] loaded config.yml!");
				
			} else {
				
				createConfig();
				this.log.info("[" + pdfFile.getName() + "] created config.yml!");
			}
        	
        	
        } catch (Exception e){
        	e.printStackTrace();
        	this.log.info("[" + pdfFile.getName() + "] config file cannot be used. ");
        	
        }
        setupPermissions();
        getCommand("houses").setExecutor(new CommandsCore());
        long maxRam = Runtime.getRuntime().maxMemory();
        String newRam = String.valueOf(maxRam);
        log.info(newRam);
	}
	

	
	private void setupPermissions() { if (permissionHandler != null) { return; }

	Plugin permissionsPlugin = this.getServer().getPluginManager().getPlugin("Permissions");

	if (permissionsPlugin == null) {
	    log.info("Permission system not detected, defaulting to OP");
	    return;
	}
	permissionHandler = ((Permissions) permissionsPlugin).getHandler();
	log.info("[Houses] Found and will use plugin "+((Permissions)permissionsPlugin).getDescription().getFullName());
	}
	
	
    public static CuboidSelection getCuboidArea() {
        return csel;
    }
    
    public void createConfig(){
    	
    	config = new Configuration(new File(getDataFolder().getPath() + "/config.yml"));
    	
		config.setProperty("config.money", "Dollars");
		config.setProperty("config.price-per-block", 100);
		config.setProperty("config.selection-item", 286);
		config.setProperty("config.specified-equation", "%y * %x * %z * %ppc");
		
		config.save();
    	
    }
    
    public void loadConfig(){
    	config = this.getConfiguration();
    	config.load();
    	
    	money = config.getString("config.money");
    	pricepercube = config.getInt("config.price-per-block", 100);
    	selectionItem = config.getInt("config.selection-item", 286);
    	equation = config.getString("config.specified-equation");
    }
    
    public void reloadConfig(){
    	
		config.setProperty("config.money", money);
		config.setProperty("config.price-per-block", pricepercube);
		config.setProperty("config.selection-item", selectionItem);
		config.setProperty("config.specified-equation", equation);
		
		config.save();
    	
    	config = new Configuration(new File(getDataFolder().getPath() + "/config.yml"));
    	config.load();
    	
    	money = config.getString("config.money");
    	pricepercube = config.getInt("config.price-per-block", 100);
    	selectionItem = config.getInt("config.selection-item", 286);
    	equation = config.getString("config.specified-equation");
    	
    }
    
}