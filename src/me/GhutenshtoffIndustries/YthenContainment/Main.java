package me.GhutenshtoffIndustries.YthenContainment;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	@Override public void onEnable() {
		this.getCommand("yfreeze").setExecutor(new Freeze());
		this.getCommand("ypossess").setExecutor(new Possess());
		this.getCommand("ydeath").setExecutor(new Death());
		this.getCommand("ylightning").setExecutor(new Lightning());
		this.getCommand("ylag").setExecutor(new Lag());
		this.getCommand("yspin").setExecutor(new Spin());
		this.getCommand("yice").setExecutor(new Ice());
		this.getCommand("ydiorite").setExecutor(new Diorite());
	}
	
	@Override public void onDisable() {
		
	}

}
