package me.GhutenshtoffIndustries.YthenContainment;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ice implements CommandExecutor, Runnable {
	
	public boolean isIced = false;
	
	private int taskId;
	
	Location location;
	Location location2;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("yice")) {
			if (sender.hasPermission("ycontainment.ice")) {
				if (Bukkit.getPlayer("Ythen") != null) {
					Player ythen = Bukkit.getPlayer("Ythen");
					location = ythen.getLocation();
					location2 = new Location(ythen.getWorld(), location.getX(), location.getY() + 1, location.getZ());
					if (!isIced) {
						run();
						taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("YthenContainment"), this, 0L, 0L);
						isIced = true;
						sender.sendMessage(ChatColor.GOLD + "On!");
						return true;
					} else {
						Bukkit.getScheduler().cancelTask(taskId);
						isIced = false;
						location.getBlock().setType(Material.AIR);
						location2.getBlock().setType(Material.AIR);
						sender.sendMessage(ChatColor.GOLD + "Off!");
						return true;
					}
				} else {
					sender.sendMessage(ChatColor.RED + "Ythen is not online");
					return true;
				}
			}
			sender.sendMessage(ChatColor.RED + "You do not have permission to use this command");
			return true;
		}
		return false;
	}
	
	public void run() {
		Player ythen = Bukkit.getPlayer("Ythen");
		ythen.teleport(location);
		location.getBlock().setType(Material.ICE);
		location2.getBlock().setType(Material.ICE);
	}

}
