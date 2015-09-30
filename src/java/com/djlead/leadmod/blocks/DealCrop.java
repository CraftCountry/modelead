package com.djlead.leadmod.blocks;

import com.djlead.leadmod.Reference;
import com.djlead.leadmod.sys.MyItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

/**
 * Created by Lead on 30-9-2015.
 */
public class DealCrop extends BlockCrops {

    public DealCrop() {
        super();
        this.setBlockName("dealcrop");
        this.setBlockTextureName(Reference.MODID + ":" + "dealcrop");
    }

    @Override
    protected Item func_149866_i ()    {
        return MyItems.dealSeed;
    }
    @Override
    protected Item func_149865_P ()    {
        return MyItems.unobtainiumShard;
    }
}
