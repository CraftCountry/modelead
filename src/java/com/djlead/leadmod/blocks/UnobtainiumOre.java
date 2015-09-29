package com.djlead.leadmod.blocks;

import com.djlead.leadmod.sys.MyItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Lead on 27-9-2015.
 */
public class UnobtainiumOre extends BlockL {

    public UnobtainiumOre() {
        super();
        this.setBlockName("unobtainiumore");
        this.setHardness(5.0F);
        this.setResistance(20.0F);
        this.setHarvestLevel("pickaxe", 2);
        // this.setStepSound(soundTypePiston);
        // this.setLightLevel(0.0F);

    }

    @Override
    public boolean isOpaqueCube(){
        return false;
        // does block let light shine through
    }

//    @Override
//    public Item getItemDropped(int metadata, Random random, int fortune){
//        return MyItems.unobtainiumShard;
//        // what item to drop
//    }
//
//    @Override
//    public int quantityDropped(Random random) {
//        return random.nextInt(4);
//        // give (1 to 4) items when mined
//    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
        drops.add(new ItemStack(MyItems.unobtainiumShard, world.rand.nextInt(3) + 1));
        if (world.rand.nextFloat() < 0.3F)
            drops.add(new ItemStack(Items.diamond));
        return drops;
    }
}
