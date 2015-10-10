package com.djlead.leadmod.biome;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

/**
 * Created by Lead on 29-9-2015.
 */
public class BiomeWhish extends BiomeGenBase{

    public BiomeWhish(int id){
        super(id);
        // environmental
        this.rootHeight = 0.125F;
        this.heightVariation = 1.0F;
        this.setTemperatureRainfall(1.2F, 0.9F);
        this.setDisableRain();
        this.topBlock = Blocks.grass;
        this.fillerBlock = Blocks.sandstone;
     //   this.setColor(15560713);

        // generation                                                        .. , min group, max group
        this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 8, 20));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityOcelot.class, 20, 8, 20));
        this.theBiomeDecorator.treesPerChunk = 3;
        this.theBiomeDecorator.grassPerChunk = 1;
        this.theBiomeDecorator.reedsPerChunk = 10;
    }

//    @Override
//    public int getBiomeGrassColor(int posX, int posY, int posZ) {
//        return 966757;
//    }                         // sets grass color

//    @Override
//    public int getBiomeFoliageColor(int posX, int posY, int posZ) {
//        return 7397529;
//    }                         // sets foliage color (trees)

    @Override
    public int getSkyColorByTemp(float par1) {
        return 1690879;
    }                           // set the sky color

}

