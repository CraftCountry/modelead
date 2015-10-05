package com.djlead.leadmod.sys;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
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
        GameRegistry.addRecipe(new ItemStack(MyItems.djPickaxe), "www", " s ", " s ", 'w', new ItemStack(MyItems.whishalloy), 's', new ItemStack(Items.stick));

        ItemStack enchanted = new ItemStack(MyItems.djSword);
        enchanted.addEnchantment(Enchantment.sharpness, 2);
        GameRegistry.addRecipe(new ItemStack(MyItems.djSword), "w", "w", "s", 'w', new ItemStack(MyItems.whishalloy), 's', new ItemStack(Items.stick));


        GameRegistry.addRecipe(new ItemStack(MyBlocks.blockWhish), "www", "www", "www", 'w', new ItemStack(MyItems.whishalloy));
        GameRegistry.addRecipe(new ItemStack(MyBlocks.thoughtSoil, 2), "sss", "sws", "sss", 's', new ItemStack(MyItems.rambutanShell), 'w', new ItemStack(Items.water_bucket));
        GameRegistry.addRecipe(new ItemStack(MyBlocks.whishSoil, 2), "ttt", "twt", "ttt", 't', new ItemStack(MyBlocks.thoughtSoil), 'w', new ItemStack(MyItems.whishalloy));

        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 4), new ItemStack(MyBlocks.logBT));

        GameRegistry.addShapelessRecipe(new ItemStack(MyItems.whishalloy,9), new ItemStack(MyBlocks.blockWhish));
        GameRegistry.addShapelessRecipe(new ItemStack(MyBlocks.rocklight), new ItemStack(MyItems.impossibrium), new ItemStack(MyItems.impossibrium));


    }
}
