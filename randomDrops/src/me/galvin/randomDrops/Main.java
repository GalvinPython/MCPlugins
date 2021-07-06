package me.galvin.randomDrops;

import org.bukkit.plugin.java.JavaPlugin;

import me.galvin.randomDrops.listeners.ItemListen;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		new ItemListen(this);
	}

}
