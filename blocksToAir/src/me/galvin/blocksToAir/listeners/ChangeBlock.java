package me.galvin.blocksToAir.listeners;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.galvin.blocksToAir.Main;

public class ChangeBlock implements Listener {
	
	private Main plugin;
	public HashMap<String, Location> plb;
	private Material[] mats;
	
	public ChangeBlock(Main plugin) {
		this.plugin = plugin;
		this.plb = new HashMap<String, Location>();
		this.mats = Material.values();
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void moveEvent(PlayerMoveEvent e) {
		
		Player p = e.getPlayer();
		Block b = p.getTargetBlock(null, 100);
		Location blockLocation = b.getLocation();
		Material blockMaterial = b.getType();
		
		if(blockMaterial == Material.OBSIDIAN || blockMaterial == Material.END_PORTAL_FRAME || blockMaterial == Material.END_PORTAL || blockMaterial == Material.NETHER_PORTAL || blockMaterial == Material.AIR || blockMaterial == Material.CAVE_AIR || blockMaterial == Material.WATER) {
		}else {
			
			String name = p.getName();
			
			if(plb.containsKey(name)) {
				
				Location oldlocation = plb.get(name);
				if(oldlocation.getBlockX() != blockLocation.getBlockX() || oldlocation.getBlockY() != blockLocation.getBlockY() || oldlocation.getBlockZ() != blockLocation.getBlockZ()) {
					
					Random rnd = new Random();
					Material randomMaterial = mats[rnd.nextInt(mats.length)];
					if(randomMaterial != Material.AIR || randomMaterial != Material.CAVE_AIR) {
						randomMaterial = Material.AIR;
					}
					
					oldlocation.getBlock().setType(randomMaterial);
					
					plb.replace(name, blockLocation);
					
				}
				
			}else {
				plb.put(name, blockLocation);
			}			
		}		
	}	
}