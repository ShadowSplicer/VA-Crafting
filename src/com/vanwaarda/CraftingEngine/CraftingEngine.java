package com.vanwaarda.CraftingEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class CraftingEngine extends JavaPlugin implements Listener {
	public final Logger logger = Logger.getLogger("Minecraft");
	
	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		Bukkit.getConsoleSender().sendMessage(pdfFile.getName() + " has been disabled");
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + pdfFile.getName() + " version " + pdfFile.getVersion() + " has been enabled");
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		
		ItemStack blockChiseledStone = new ItemStack(Material.SMOOTH_BRICK, 1, (short) 3);
		ShapedRecipe blockChiseledStoneRecipe = new ShapedRecipe(blockChiseledStone);
		blockChiseledStoneRecipe.shape("s", "s");
		blockChiseledStoneRecipe.setIngredient('s', Material.STEP, 5);
		Bukkit.getServer().addRecipe(blockChiseledStoneRecipe);
		
		ItemStack dogFood = new ItemStack(Material.ROTTEN_FLESH, 1, (short) 100); // Dog Food
		ItemMeta dogFoodMeta = dogFood.getItemMeta();
		dogFoodMeta.setDisplayName(ChatColor.WHITE + "Dog Food");
		List<String> dogFoodLore = new ArrayList<String>();
		dogFoodLore.add("Restores pets to full health.");
		dogFoodLore.add("Restores 4 food, damages 4 health to players.");
		dogFoodMeta.setLore(dogFoodLore);
		dogFood.setItemMeta(dogFoodMeta);
		ShapedRecipe zombieDogFood = new ShapedRecipe(dogFood);
		zombieDogFood.shape("f", "f", "f");
		zombieDogFood.setIngredient('f', Material.ROTTEN_FLESH);
		Bukkit.getServer().addRecipe(zombieDogFood);
		
		ItemStack cookedFlesh = new ItemStack(Material.ROTTEN_FLESH, 1, (short) 101); // Zombie Jerky
		ItemMeta CookedFleshMeta = cookedFlesh.getItemMeta();
		CookedFleshMeta.setDisplayName(ChatColor.WHITE + "Zombie Jerky");
		List<String> cookedFleshLore = new ArrayList<String>();
		cookedFleshLore.add("Restores 4 food, does no poison damage.");
		CookedFleshMeta.setLore(cookedFleshLore);
		cookedFlesh.setItemMeta(CookedFleshMeta);
		cookedFlesh.getItemMeta().setDisplayName("Zombie Jerky");
		FurnaceRecipe cookedZombie = new FurnaceRecipe(cookedFlesh, Material.ROTTEN_FLESH, 0);
		Bukkit.getServer().addRecipe(cookedZombie);
		
		ItemStack applePie = new ItemStack(Material.PUMPKIN_PIE, 1, (short) 100); // Apple Pie
		ItemMeta applePieMeta = applePie.getItemMeta();
		applePieMeta.setDisplayName(ChatColor.WHITE + "Apple Pie");
		List<String> applePieLore = new ArrayList<String>();
		applePieLore.add("Restores 4 food, heals 3 health instantly.");
		applePieMeta.setLore(applePieLore);
		applePie.setItemMeta(applePieMeta);
		ShapedRecipe warmApplePie = new ShapedRecipe(applePie);
		warmApplePie.shape("as", " e");
		warmApplePie.setIngredient('a', Material.APPLE);
		warmApplePie.setIngredient('s', Material.SUGAR);
		warmApplePie.setIngredient('e', Material.EGG);
		Bukkit.getServer().addRecipe(warmApplePie);
		
		// TODO: For some reason, this recipe isn't working. FIGURE IT OUT.
		/*ItemStack meatStew = new ItemStack(Material.MUSHROOM_SOUP, 1, (short) 100); // Meat Stew
		ItemMeta meatStewMeta = meatStew.getItemMeta();
		meatStewMeta.setDisplayName(ChatColor.WHITE + "Meat Stew");
		List<String> meatStewLore = new ArrayList<String>();
		meatStewLore.add("Restores 4 food, heals 2 health instantly.");
		meatStewMeta.setLore(meatStewLore);
		meatStew.setItemMeta(meatStewMeta);
		ShapedRecipe tastyMeatStew = new ShapedRecipe(meatStew);
		tastyMeatStew.shape("scp", " b");
		tastyMeatStew.setIngredient('s', Material.COOKED_BEEF);
		tastyMeatStew.setIngredient('c', Material.CARROT);
		tastyMeatStew.setIngredient('p', Material.BAKED_POTATO);
		tastyMeatStew.setIngredient('b', Material.BOWL);
		Bukkit.getServer().addRecipe(tastyMeatStew);*/
		
		ItemStack Fries = new ItemStack(Material.BAKED_POTATO, 3, (short) 100); // Fries
		ItemMeta FriesMeta = Fries.getItemMeta();
		FriesMeta.setDisplayName(ChatColor.WHITE + "Fries");
		List<String> FriesLore = new ArrayList<String>();
		FriesLore.add("Restores 2 food, heals 2 health instantly.");
		FriesMeta.setLore(FriesLore);
		Fries.setItemMeta(FriesMeta);
		ShapedRecipe frenchFries = new ShapedRecipe(Fries);
		frenchFries.shape("p");
		frenchFries.setIngredient('p', Material.BAKED_POTATO);
		Bukkit.getServer().addRecipe(frenchFries);
		
		ItemStack Burger = new ItemStack(Material.BREAD, 1, (short) 100); // Hamburger
		ItemMeta BurgerMeta = Burger.getItemMeta();
		BurgerMeta.setDisplayName(ChatColor.WHITE + "Hamburger");
		List<String> BurgerLore = new ArrayList<String>();
		BurgerLore.add("Restores 4 food, heals 3 health instantly.");
		BurgerMeta.setLore(BurgerLore);
		Burger.setItemMeta(BurgerMeta);
		ShapedRecipe hamburger = new ShapedRecipe(Burger);
		hamburger.shape("b", "m", "b");
		hamburger.setIngredient('b', Material.BREAD);
		hamburger.setIngredient('m', Material.COOKED_BEEF);
		Bukkit.getServer().addRecipe(hamburger);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String[] args) {
		if(cmd.getName().equalsIgnoreCase("crafting")) {
			if (args.length == 0) {
				sender.sendMessage(ChatColor.YELLOW + "There are currently 6 custom recipies available on the server!");
				return true;
			}
		}
		return false;
	}
// END   
}
