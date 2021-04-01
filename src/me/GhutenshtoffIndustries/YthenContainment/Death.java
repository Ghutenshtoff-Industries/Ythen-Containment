package me.GhutenshtoffIndustries.YthenContainment;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Death implements CommandExecutor, Runnable {
	
	public boolean isDeath = false;
	
	private int taskId;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("ydeath")) {
			if (sender.hasPermission("ycontainment.death")) {
				if (Bukkit.getPlayer("Ythen") != null) {
					if (!isDeath) {
						run();
						taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("YthenContainment"), this, 0L, 0L);
						isDeath = true;
						sender.sendMessage(ChatColor.GOLD + "On!");
						return true;
					} else {
						Bukkit.getScheduler().cancelTask(taskId);
						isDeath = false;
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
		ythen.setHealth(0);
	}

}
