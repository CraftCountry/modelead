package com.djlead.leadmod.blocks;

import com.djlead.leadmod.Reference;
import com.djlead.leadmod.sys.MyTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

/** BaseBlock All generated blocks
 * Created by Lead on 21-9-2015.
 */
public class BaseBlock extends Block {

    public BaseBlock(Material material){
        super(material);
        this.setCreativeTab(MyTab.CreaTab);
    }

    public BaseBlock(){
        this(Material.rock);
        this.setCreativeTab(MyTab.CreaTab);
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("tile.%s%s", Reference.MODID.toLowerCase() + ":", getUnWrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnWrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    protected String getUnWrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}

//        .setHardness 	      recommended sets how long it takes to break the block 	[default:depends on material; stone:1.5F; obsidian:50.0F]
//        .setResistance 	  recommended sets the block's resistance against explosions 	default:depends on material; stone:10.0F; obsidian:2000.0F
//        .setLightLevel 	  optional 	  sets how much light is emitted from the block 	default: 0.0F (nothing); maximum: 15.0F (like full sunlight)

//        .setCreativeTab 	  optional 	  sets the creative tab to display the block in 	[default: tabBlock]
//        .setStepSound 	  recommended sets the step sound of a block 	default:depends on material
//        .setLightOpacity 	  optional 	  sets how much light is subtracted when going through this block
//                                        This is only used if isOpaqueCube() returns false 	default: 16 (completely opaque); maximum: 0 (100% translucent)
//        .setHarvestLevel 	  recommended sets the tool and the tool level to break a block. If you don't use this, the break level is defined by the material
//                              tool: "pickaxe", "axe", "shovel"
//                              level: 0=wood; 1=stone; 2=iron; 3=diamond tool
//        .setBlockUnbreakable 	optional  makes the block unbreakable in survival only bedrock and barriers are unbreakable
//        .setTickRandomly 	  optional 	  if true the block receives random update ticks. Used for example for the decaying of leaves.    [default: false]
