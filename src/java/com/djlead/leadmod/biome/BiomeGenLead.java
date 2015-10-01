package com.djlead.leadmod.biome;

import com.djlead.leadmod.sys.MyBlocks;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

/**
 * Created by Lead on 29-9-2015.
 */
public class BiomeGenLead extends BiomeGenBase{

    public BiomeGenLead(int id){
        super(id);

        this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 8, 20));
        this.theBiomeDecorator.treesPerChunk = 2;
        this.theBiomeDecorator.grassPerChunk = 3;
        this.theBiomeDecorator.deadBushPerChunk = 10;
        this.theBiomeDecorator.bigMushroomsPerChunk = 3;
        this.setDisableRain();

        this.topBlock = Blocks.grass;
        this.fillerBlock = Blocks.sandstone;

    }
}
