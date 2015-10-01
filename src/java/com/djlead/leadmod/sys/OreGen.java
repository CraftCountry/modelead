package com.djlead.leadmod.sys;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

/**
 * Created by Lead on 27-9-2015.
 */
public class OreGen implements IWorldGenerator{

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {

            case -1:
                generateNether(world,random,chunkX,chunkZ);
                break;

            case 0:
                generateOverworld(world,random,chunkX,chunkZ);
                break;

            case 1:
                generateEnd(world,random,chunkX,chunkZ);
                break;

        }
    }

    public void generateNether(World world, Random random, int x, int z){
        generateOre(MyBlocks.unobtainiumore, world, random, x, z, 2, 10, 5, 3, 100, Blocks.lava);
    }

    public void generateOverworld(World world, Random random, int x, int z){
        generateOre(MyBlocks.unobtainiumore, world, random, x, z, 1, 2, 50, 11, 27, Blocks.stone);
//        generateOre(MyBlocks.unobtainiumore, world, random, x, z, 2, 10, 25, 3, 100, Blocks.grass);
    }

    public void generateEnd(World world, Random random, int x, int z){
        generateOre(MyBlocks.unobtainiumore, world, random, x, z, 2, 10, 5, 20, 60, Blocks.end_stone);
    }

    public void generateOre(Block block, World world, Random random, int chunkX, int chunkZ, int minVeinSize, int maxVeinSize, int chance, int minY, int maxY, Block generateIn) {
        int veinSize = minVeinSize + random.nextInt(maxVeinSize - minVeinSize);
        int heightRange = maxY - minY;
        WorldGenMinable gen = new WorldGenMinable(block, veinSize, generateIn);
        for (int i=0; i< chance; i++) {
            int randX = chunkX * 16 + random.nextInt(16);
            int randY = random.nextInt(heightRange)+minY;
            int randZ = chunkZ * 16 + random.nextInt(16);
            gen.generate(world, random, randX, randY, randZ);
        }
    }
}
