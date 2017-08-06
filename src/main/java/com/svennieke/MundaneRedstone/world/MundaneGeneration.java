package com.svennieke.MundaneRedstone.world;

import java.util.Random;

import com.svennieke.MundaneRedstone.config.MundaneConfigGen;
import com.svennieke.MundaneRedstone.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class MundaneGeneration implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		switch(world.provider.getDimension()){
        case 0: //Overworld
            generateOverworld(world, random, chunkX, chunkZ);
            break;
		}
	}
	
	private void generateOverworld(World world, Random rand, int x, int z)
	{
		if (MundaneConfigGen.generation.MundaneGenerate){
			generateOre(ModBlocks.Mundane_Redstone_Ore, world, rand, x, z, 
					MundaneConfigGen.mundanegen.MundaneMinVeinSize, MundaneConfigGen.mundanegen.MundaneMaxVeinSize, 
					MundaneConfigGen.mundanegen.MundaneChance, 0, MundaneConfigGen.mundanegen.MundaneMaxHeight, Blocks.STONE);
		}
	}

	public void generateOre(Block block, World world, Random random, int chunkX, int chunkZ, int minVeinSize, int maxVeinSize, int chance, int minY, int maxY, Block generateIn)
    {
        int veinSize = minVeinSize + random.nextInt(maxVeinSize - minVeinSize);
        int heightRange = maxY - minY;
        WorldGenMinable gen = new WorldGenMinable(block.getDefaultState(), veinSize, BlockMatcher.forBlock(generateIn));
        for (int i = 0; i < chance; i++){
            int xRand = chunkX * 16 + random.nextInt(16);
            int yRand = random.nextInt(heightRange) + minY;
            int zRand = chunkZ * 16 + random.nextInt(16);
            gen.generate(world, random, new BlockPos(xRand, yRand, zRand));
        }
    }
}