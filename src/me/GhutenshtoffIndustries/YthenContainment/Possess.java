package me.GhutenshtoffIndustries.YthenContainment;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Possess implements CommandExecutor, Runnable {
	
	public boolean isPossessed = false;
	
	private int taskId;
	
	Player player;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("ypossess")) {
			if (sender.hasPermission("ycontainment.possess")) {
				if (sender instanceof Player) {
					player = (Player) sender;
					if (Bukkit.getPlayer("Ythen") != null) {
						if (player != Bukkit.getPlayer("Ythen")) {
							if (!isPossessed) {
								run();
								taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("YthenContainment"), this, 0L, 0L);
								isPossessed = true;
								sender.sendMessage(ChatColor.GOLD + "On!");
								return true;
							} else {
								Bukkit.getScheduler().cancelTask(taskId);
								isPossessed = false;
								sender.sendMessage(ChatColor.GOLD + "Off!");
								return true;
							}
						} else {
							sender.sendMessage(ChatColor.RED + "Ythen... you can't possess yourself!");
							return true;
						}
					} else {
						sender.sendMessage(ChatColor.RED + "Ythen is not online");
						return true;
					}
				} else {
					sender.sendMessage(ChatColor.RED + "Console cannot run this command");
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
		Location location = player.getLocation();
		ythen.teleport(location);
		
	}

}
