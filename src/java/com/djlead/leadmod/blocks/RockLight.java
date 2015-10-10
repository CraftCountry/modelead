package com.djlead.leadmod.blocks;

import com.djlead.leadmod.sys.MyItems;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * Created by Lead on 26-9-2015.
 */
public class RockLight extends BaseBlock {

    public RockLight() {
        super();
        this.setBlockName("rocklight");
        this.setHardness(3.0F);
        this.setResistance(10.0F);
  //      this.setStepSound(soundTypePiston);
        this.setLightLevel(1.0F);

    }

    @Override
    public boolean isOpaqueCube(){
        return false;
    }

    @Override
    public Item getItemDropped(int metadata, Random random, int fortune){
        return MyItems.impossibrium;
    }

    @Override
    public int quantityDropped(Random random) {
        return 2;
        // give 2 items when mined
    }
}
