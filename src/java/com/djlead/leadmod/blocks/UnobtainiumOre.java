package com.djlead.leadmod.blocks;

import com.djlead.leadmod.sys.MyItems;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * Created by Lead on 27-9-2015.
 */
public class UnobtainiumOre extends BlockL {

    public UnobtainiumOre() {
        super();
        this.setBlockName("unobtainiumore");
        this.setHardness(4.0F);
        this.setResistance(10.0F);
        //      this.setStepSound(soundTypePiston);
        this.setLightLevel(0.0F);

    }

    @Override
    public boolean isOpaqueCube(){
        return false;
        // does block let light shine through
    }

    @Override
    public Item getItemDropped(int metadata, Random random, int fortune){
        return MyItems.unobtainiumShard;
        // what item to drop
    }

    @Override
    public int quantityDropped(Random random) {
        return random.nextInt(4);
        // give (1 to 4) items when mined
    }


}
