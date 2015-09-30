package com.djlead.leadmod.items;

import com.djlead.leadmod.Reference;
import com.djlead.leadmod.sys.MyBlocks;
import com.djlead.leadmod.sys.MyTab;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;

/**
 * Created by Lead on 30-9-2015.
 */
public class DealSeed extends ItemSeeds {
    public DealSeed() {
        super(MyBlocks.dealCrop, Blocks.farmland);
        this.setUnlocalizedName("dealseed");
        this.setTextureName(Reference.MODID + ":" + "dealseed");
        this.setCreativeTab(MyTab.CreaTab);
    }
}


