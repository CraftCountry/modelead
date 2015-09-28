package com.djlead.leadmod.sys;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by Lead on 27-9-2015.
 */
public class MyRecipes {
    public static void init() {

        GameRegistry.addRecipe(new ItemStack(MyItems.unobtainiumFragment), " s ", "ded", " s ", 's', new ItemStack(MyItems.unobtainiumShard), 'e', new ItemStack(Items.emerald), 'd', new ItemStack(Items.diamond));
        GameRegistry.addRecipe(new ItemStack(MyItems.unobtainiumPart), " s ", "dfd", " s ", 'f', new ItemStack(MyItems.unobtainiumFragment), 'e', new ItemStack(Items.emerald), 'd', new ItemStack(Items.diamond));

        GameRegistry.addShapelessRecipe(new ItemStack(MyBlocks.rocklight), new ItemStack(MyItems.impossibrium), new ItemStack(MyItems.impossibrium));

        GameRegistry.addSmelting(new ItemStack(MyItems.hardtofindium), new ItemStack(MyItems.impossibrium), 0.5F);
    }
}
