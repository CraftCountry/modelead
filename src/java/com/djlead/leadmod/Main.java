package com.djlead.leadmod;


//import com.djlead.leadmod.worldgen.WorldGeneratorOre;

import com.djlead.leadmod.items.DjSword;
import com.djlead.leadmod.proxy.CommonProxy;
import com.djlead.leadmod.sys.*;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.common.util.EnumHelper;

/** Main Class
 *  Created by Lead on 11-9-2015.
 */

@Mod(modid = Reference.MODID, name = Reference.MODNAME , version = Reference.MODVERSION, dependencies = "required-after:FML")

public class Main {

    @Mod.Instance(value=Reference.MODID)
    public static Main instance;

    @SidedProxy(modId=Reference.MODID, clientSide=Reference.CLIENT_PROXY, serverSide=Reference.SERVER_PROXY)
    public static CommonProxy proxy;

    ///////////////////////////////////////////

  //  public static Item djSword;
//    public static Item djPickaxe;
//    public static Item djAxe;

    public static Item whishApple;

    public static final Item.ToolMaterial djToolMaterial = EnumHelper.addToolMaterial("djToolMaterial", 4, 2000, 15.0F, 3.0F, 30 );

            // material, harvastlevel, max uses, efficiency, damage, enchantability
    // harvastlevel : diamond = 3, iron = 2
    // maxUses : diamond = 1560
    // efficiency : diamond = 8.0F, stone 4.0F, iton = 6.0F
    // damage : diamond = 3.0F, iron 2.0f, stone 1.0F
    // enchantability : diamond =10
    //////////////////////////////////////////////////////

    // initialization
    @Mod.EventHandler
    //PreInits Handler used for creating blocks, init, plugin APIs and to register item/blocks with GameRegistry
    public void preInit(FMLPreInitializationEvent event) {

        // Initialize and register Custom Items & blocks
        MyItems.init();
        MyBlocks.init();

        GameRegistry.registerWorldGenerator(new OreGen(), 0);

        whishApple = new ItemFood(8, 0.5F, false).setUnlocalizedName("WhishApple").setTextureName("leadmod:whishapple");
        GameRegistry.registerItem(whishApple, whishApple.getUnlocalizedName().substring(5));

      //  djSword = new DjSword(djToolMaterial);

        LogOut.info("Pre Init Complete");

    }

    @Mod.EventHandler    // Init build ui data structures, crafting recipes and register new handler and API useage
    public void init(FMLInitializationEvent event) {

        // Add custom recipes
        MyRecipes.init();

        LogOut.info("Init Complete");




    }

    @Mod.EventHandler    //Postinit deals with communication with other mods
    public void postInit(FMLPostInitializationEvent event) {

        LogOut.info("Post Init Complete");
    }
}
