package com.svennieke.MundaneRedstone.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
	
	public static void Init() {
		GameRegistry.addSmelting(new ItemStack(ModBlocks.Mundane_Redstone_Ore), new ItemStack(Items.REDSTONE), 0.7F);
	}
}
