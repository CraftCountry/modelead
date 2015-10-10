package com.djlead.leadmod.biome;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

/**
 * Created by Lead on 29-9-2015.
 */
public class MyBiome {

    public static BiomeGenBase biomeWhish;
    public static void initBiome() {
        biomeWhish = new BiomeWhish(137).setBiomeName("Whish County");
    }

    public static void  registerBiome(){
        BiomeDictionary.registerBiomeType(biomeWhish, BiomeDictionary.Type.HILLS);
        BiomeManager.addSpawnBiome(biomeWhish);
    }
}
