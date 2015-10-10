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
        // Enchanted Items

        // Crafting Recipes
        GameRegistry.addRecipe(new ItemStack(MyItems.unobtainiumFragment), " s ", " s ", " s ", 's', new ItemStack(MyItems.unobtainiumShard));
        GameRegistry.addRecipe(new ItemStack(MyItems.unobtainiumPart), " f ", " f ", " f ", 'f', new ItemStack(MyItems.unobtainiumFragment));
        GameRegistry.addRecipe(new ItemStack(MyItems.unobtainium), " p ", " p ", " p ", 'p', new ItemStack(MyItems.unobtainiumPart));
        GameRegistry.addRecipe(new ItemStack(MyItems.hardtofindium), " u ", " u ", " u ", 'u', new ItemStack(MyItems.unobtainium));
        GameRegistry.addSmelting(new ItemStack(MyItems.hardtofindium), new ItemStack(MyItems.impossibrium), 0.5F);

        ItemStack enchantedPickaxe = new ItemStack(MyItems.djPickaxe);
        enchantedPickaxe.addEnchantment(Enchantment.sharpness, 7);
        enchantedPickaxe.addEnchantment(Enchantment.fortune, 7);
        enchantedPickaxe.addEnchantment(Enchantment.unbreaking, 7);
        GameRegistry.addRecipe((enchantedPickaxe), "www", " s ", " s ", 'w', new ItemStack(MyItems.whishalloy), 's', new ItemStack(Items.stick));

        ItemStack enchantedSword = new ItemStack(MyItems.djSword);
        enchantedSword.addEnchantment(Enchantment.sharpness, 7);
        enchantedSword.addEnchantment(Enchantment.looting, 7);
        GameRegistry.addRecipe((enchantedSword), "w", "w", "s", 'w', new ItemStack(MyItems.whishalloy), 's', new ItemStack(Items.stick));

        ItemStack enchantedHelmet = new ItemStack(MyItems.whishHelmet);
        enchantedHelmet.addEnchantment(Enchantment.aquaAffinity, 3);
        enchantedHelmet.addEnchantment(Enchantment.respiration, 7);
        enchantedHelmet.addEnchantment(Enchantment.unbreaking, 7);
        GameRegistry.addRecipe((enchantedHelmet), "www", "w w", 'w', new ItemStack(MyItems.whishalloy));

        ItemStack enchantedBoots = new ItemStack(MyItems.whishBoots);
        enchantedBoots.addEnchantment(Enchantment.aquaAffinity, 3);
        enchantedBoots.addEnchantment(Enchantment.respiration, 7);
        enchantedBoots.addEnchantment(Enchantment.unbreaking, 7);
        GameRegistry.addRecipe((enchantedBoots), "w w", "w w", 'w', new ItemStack(MyItems.whishalloy));

        GameRegistry.addRecipe(new ItemStack(MyItems.whishLeggings), "www", "w w", "w w", 'w', new ItemStack(MyItems.whishalloy));
        GameRegistry.addRecipe(new ItemStack(MyItems.whishChestplate), "w w", "www", "www", 'w', new ItemStack(MyItems.whishalloy));

        GameRegistry.addRecipe(new ItemStack(MyBlocks.blockWhish), "www", "www", "www", 'w', new ItemStack(MyItems.whishalloy));
        GameRegistry.addRecipe(new ItemStack(MyBlocks.thoughtSoil, 2), "sss", "sws", "sss", 's', new ItemStack(MyItems.rambutanShell), 'w', new ItemStack(Items.water_bucket));
        GameRegistry.addRecipe(new ItemStack(MyBlocks.whishSoil, 2), "ttt", "twt", "ttt", 't', new ItemStack(MyBlocks.thoughtSoil), 'w', new ItemStack(MyItems.whishalloy));

        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 4), new ItemStack(MyBlocks.logBT));

        GameRegistry.addShapelessRecipe(new ItemStack(MyItems.whishalloy,9), new ItemStack(MyBlocks.blockWhish));
        GameRegistry.addShapelessRecipe(new ItemStack(MyBlocks.rocklight), new ItemStack(MyItems.impossibrium), new ItemStack(MyItems.impossibrium));


    }
}
