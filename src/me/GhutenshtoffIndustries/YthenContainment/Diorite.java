package me.GhutenshtoffIndustries.YthenContainment;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Diorite implements CommandExecutor, Runnable {
	
	public boolean isDiorite = false;
	
	private int taskId;
	
	ItemStack diorite = new ItemStack(Material.DIORITE);
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("ydiorite")) {
			if (sender.hasPermission("ycontainment.diorite")) {
				if (Bukkit.getPlayer("Ythen") != null) {
					if (!isDiorite) {
						run();
						taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("YthenContainment"), this, 0L, 19L);
						isDiorite = true;
						sender.sendMessage(ChatColor.GOLD + "On!");
						return true;
					} else {
						Bukkit.getScheduler().cancelTask(taskId);
						isDiorite = false;
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
		int random = (int)(Math.random()*10d);
		if (random == 7) {
			ythen.getInventory().addItem(diorite);
		}
	}

}
