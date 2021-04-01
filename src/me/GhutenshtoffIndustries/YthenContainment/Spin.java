package me.GhutenshtoffIndustries.YthenContainment;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spin implements CommandExecutor, Runnable {
	
	public boolean isSpinning = false;
	
	private int taskId;
	
	int i = 0;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("yspin")) {
			if (sender.hasPermission("ycontainment.spin")) {
				if (Bukkit.getPlayer("Ythen") != null) {
					if (!isSpinning) {
						run();
						taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("YthenContainment"), this, 0L, 2L);
						isSpinning = true;
						sender.sendMessage(ChatColor.GOLD + "On!");
						return true;
					} else {
						Bukkit.getScheduler().cancelTask(taskId);
						isSpinning = false;
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
		Location location = ythen.getLocation();
		Location location1 = new Location(ythen.getWorld(), location.getX(), location.getY(), location.getZ(), 0, 0);
		Location location2 = new Location(ythen.getWorld(), location.getX(), location.getY(), location.getZ(), 90, 0);
		Location location3 = new Location(ythen.getWorld(), location.getX(), location.getY(), location.getZ(), 180, 0);
		Location location4 = new Location(ythen.getWorld(), location.getX(), location.getY(), location.getZ(), 260, 0);
		Location[] locations = {location1, location2, location3, location4};
		ythen.teleport(locations[i]);
		i++;
		if (i >= 3) {
			i = 0;
		}
	}

}
