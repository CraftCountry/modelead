package com.djlead.leadmod.blocks;

import com.djlead.leadmod.sys.MyItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Lead on 27-9-2015.
 */
public class UnobtainiumOre extends BaseBlock {

    public UnobtainiumOre() {
        super();
        this.setBlockName("unobtainiumore");
        this.setHardness(2.0F);
        this.setResistance(20.0F);
        this.setHarvestLevel("pickaxe", 2);
//        this.slipperiness = 1.25F;      // .98 = ice /  >1.25 is crazy
    }


    @Override
    public boolean isOpaqueCube(){
        return false;
        // does block let light shine through
    }

//    Drop a single item

//    @Override
//    public Item getItemDropped(int metadata, Random random, int fortune) {
//        return MyItems.unobtainiumShard;
//        // what item to drop
//    }
//
//    @Override
//    public int quantityDropped(Random random) {
//        return random.nextInt(4);
//        // give (1 to 4) items when mined
//    }

//    Drop multiple items
    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
        drops.add(new ItemStack(MyItems.unobtainiumShard, world.rand.nextInt(3)));
        if (world.rand.nextFloat() < 0.3F)
            drops.add(new ItemStack(Items.diamond));
        return drops;
    }

    // particles

    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int posX, int posY, int posZ, Random random){
        if (random.nextInt(6) == 0) {                                                      // set the chance to sparkle
            this.CreateParticle(world, posX, posY, posZ);
        }
    }

    private void CreateParticle(World world, int posX, int posY, int posZ) {
        Random random = world.rand;
        double d0 = 0.0625D;

        for (int l = 0; l < 6; ++l)        {
            double d1 = (double)((float)posX + random.nextFloat());
            double d2 = (double)((float)posY + random.nextFloat());
            double d3 = (double)((float)posZ + random.nextFloat());

            if (l == 0 && !world.getBlock(posX, posY + 1, posZ).isOpaqueCube()) {
                d2 = (double)(posY + 1) + d0;
            }

            if (l == 1 && !world.getBlock(posX, posY - 1, posZ).isOpaqueCube()) {
                d2 = (double)(posY + 0) - d0;
            }

            if (l == 2 && !world.getBlock(posX, posY, posZ + 1).isOpaqueCube()) {
                d3 = (double)(posZ + 1) + d0;
            }

            if (l == 3 && !world.getBlock(posX, posY, posZ - 1).isOpaqueCube()) {
                d3 = (double)(posZ + 0) - d0;
            }

            if (l == 4 && !world.getBlock(posX + 1, posY, posZ).isOpaqueCube()) {
                d1 = (double)(posX + 1) + d0;
            }

            if (l == 5 && !world.getBlock(posX - 1, posY, posZ).isOpaqueCube()) {
                d1 = (double)(posX + 0) - d0;
            }

            if (d1 < (double)posX || d1 > (double)(posX + 1) || d2 < 0.0D || d2 > (double)(posY + 1) || d3 < (double)posZ || d3 > (double)(posZ + 1))            {

//                world.spawnParticle("reddust", d1, d2, d3, 0.0D, 0.0D, 0.0D);         // soft red sparkles
//                world.spawnParticle("portal", d1, d2, d3, 0.0D, 0.0D, 0.0D);          // purple sucking in
//                world.spawnParticle("note", d1, d2, d3, 0.0D, 0.0D, 0.0D);            // music note green
//                world.spawnParticle("hugeexplosion", d1, d2, d3, 0.0D, 0.0D, 0.0D);
//                world.spawnParticle("fireworksSpark", d1, d2, d3, 0.0D, 0.0D, 0.0D);  // white snow dripping
//                world.spawnParticle("depthsuspend", d1, d2, d3, 0.0D, 0.0D, 0.0D);    // very tiny black bubbles come off
//                world.spawnParticle("crit", d1, d2, d3, 0.0D, 0.0D, 0.0D);            // stars drop
                world.spawnParticle("magicCrit", d1, d2, d3, 0.0D, 0.0D, 0.0D);       // cyan triangles fall off
//                world.spawnParticle("smoke", d1, d2, d3, 0.0D, 0.0D, 0.0D);           // smoke particles
//                world.spawnParticle("largesmoke", d1, d2, d3, 0.0D, 0.0D, 0.0D);      // big smoke particles
//                world.spawnParticle("mobSpell", d1, d2, d3, 0.0D, 0.0D, 0.0D);        // black twisters up
//                world.spawnParticle("mobSpellAmbient", d1, d2, d3, 0.0D, 0.0D, 0.0D); // black twisters up 50% opaque
//                world.spawnParticle("spell", d1, d2, d3, 0.0D, 0.0D, 0.0D);           // white twisters up fast
//                world.spawnParticle("instantSpell", d1, d2, d3, 0.0D, 0.0D, 0.0D);    // white stars up
//                world.spawnParticle("witchMagic", d1, d2, d3, 0.0D, 0.0D, 0.0D);      // purple stars up
//                world.spawnParticle("enchantmenttable", d1, d2, d3, 0.0D, 0.0D, 0.0D);// glyphs falling
//                world.spawnParticle("explode", d1, d2, d3, 0.0D, 0.0D, 0.0D);         // white smoke uop
//                world.spawnParticle("flame", d1, d2, d3, 0.0D, 0.0D, 0.0D);           //
//                world.spawnParticle("lava", d1, d2, d3, 0.0D, 0.0D, 0.0D);            // heavy burning sparks
//                world.spawnParticle("splash", d1, d2, d3, 0.0D, 0.0D, 0.0D);          // blue drops sparkling off
//                world.spawnParticle("cloud", d1, d2, d3, 0.0D, 0.0D, 0.0D);           // white puffs
//                world.spawnParticle("snowballpoof", d1, d2, d3, 0.0D, 0.0D, 0.0D);    // white balls sparkles off
//                world.spawnParticle("dripLava", d1, d2, d3, 0.0D, 0.0D, 0.0D);        // bubble and drip lava
//                world.spawnParticle("dripWater", d1, d2, d3, 0.0D, 0.0D, 0.0D);       // bubble and drip water
//                world.spawnParticle("snowshovel", d1, d2, d3, 0.0D, 0.0D, 0.0D);      // snow falls off fast
//                world.spawnParticle("slime", d1, d2, d3, 0.0D, 0.0D, 0.0D);           // green drops flying off
//                world.spawnParticle("heart", d1, d2, d3, 0.0D, 0.0D, 0.0D);           // animals breed
//                world.spawnParticle("angryVillager", d1, d2, d3, 0.0D, 0.0D, 0.0D);        // steam/flame rise up
//                world.spawnParticle("happyVillager", d1, d2, d3, 0.0D, 0.0D, 0.0D);        // green fonkles
            }
        }
    }
}
