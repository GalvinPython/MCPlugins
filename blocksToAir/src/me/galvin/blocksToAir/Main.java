package me.galvin.blocksToAir;

import org.bukkit.plugin.java.JavaPlugin;

import me.galvin.blocksToAir.listeners.ChangeBlock;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		new ChangeBlock(this);
	}
	
}
