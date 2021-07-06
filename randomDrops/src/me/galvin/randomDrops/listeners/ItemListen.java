package me.galvin.randomDrops.listeners;

import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.inventory.ItemStack;

import me.galvin.randomDrops.Main;

public class ItemListen implements Listener {
	
	private Main plugin;
	public Material[] mats = Material.values();
	public Random rand = new Random();
	
	public ItemListen(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void DropEvent(BlockDropItemEvent e) {
		
		Location loc = e.getBlock().getLocation();
		
		Material mat = mats[rand.nextInt(mats.length)];
		
		while(mat.name().contains("COMMAND") || mat.name().contains("DEAD") || mat.isAir() || !mat.isItem()) {			
			mat = mats[rand.nextInt(mats.length)];
		}
		
		e.getPlayer().getWorld().dropItem(loc, new ItemStack(mat,64));
		e.setCancelled(true);
		
	}
}