package me.GhutenshtoffIndustries.YthenContainment;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Lightning implements CommandExecutor, Runnable {
	
	public boolean isLightninged = false;
	
	private int taskId;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("ylightning")) {
			if (sender.hasPermission("ycontainment.lightning")) {
				if (Bukkit.getPlayer("Ythen") != null) {
					if (!isLightninged) {
						run();
						taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("YthenContainment"), this, 0L, 0L);
						isLightninged = true;
						sender.sendMessage(ChatColor.GOLD + "On!");
						return true;
					} else {
						Bukkit.getScheduler().cancelTask(taskId);
						isLightninged = false;
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
		ythen.getWorld().spawnEntity(location, EntityType.LIGHTNING);
	}

}
