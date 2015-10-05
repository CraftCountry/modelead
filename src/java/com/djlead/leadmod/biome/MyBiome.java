package com.djlead.leadmod.biome;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

/**
 * Created by Lead on 29-9-2015.
 */
public class MyBiome {

//    public static void biomeRegister() {
//        initBiome();
//        registerBiome();
//    }

    public static BiomeGenBase biomeLead;
    public static void initBiome() {

        biomeLead = new BiomeGenLead(137).setBiomeName("Whish County");

    }

    public static void  registerBiome(){
        BiomeDictionary.registerBiomeType(biomeLead, BiomeDictionary.Type.HILLS);
        BiomeManager.addSpawnBiome(biomeLead);
    }


}
