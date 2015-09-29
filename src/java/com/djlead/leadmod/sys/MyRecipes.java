package com.djlead.leadmod.sys;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by Lead on 27-9-2015.
 */
public class MyRecipes {
    public static void init() {

        GameRegistry.addRecipe(new ItemStack(MyItems.unobtainiumFragment), " s ", " s ", " s ", 's', new ItemStack(MyItems.unobtainiumShard));
        GameRegistry.addRecipe(new ItemStack(MyItems.unobtainiumPart), " f ", " f ", " f ", 'f', new ItemStack(MyItems.unobtainiumFragment));
        GameRegistry.addRecipe(new ItemStack(MyItems.unobtainium), " p ", " p ", " p ", 'p', new ItemStack(MyItems.unobtainiumPart));
        GameRegistry.addRecipe(new ItemStack(MyItems.hardtofindium), " u ", " u ", " u ", 'u', new ItemStack(MyItems.unobtainium));
        GameRegistry.addSmelting(new ItemStack(MyItems.hardtofindium), new ItemStack(MyItems.impossibrium), 0.5F);
        GameRegistry.addRecipe(new ItemStack(MyItems.djPickaxe), "www", " s ", " s ", 'w', new ItemStack(MyItems.wishAlloy), 's', new ItemStack(Items.stick));
        GameRegistry.addRecipe(new ItemStack(MyItems.djSword), "w", "w", "s", 'w', new ItemStack(MyItems.wishAlloy), 's', new ItemStack(Items.stick));

        GameRegistry.addShapelessRecipe(new ItemStack(MyBlocks.rocklight), new ItemStack(MyItems.impossibrium), new ItemStack(MyItems.impossibrium));


    }
}
