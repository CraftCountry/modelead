package com.djlead.leadmod.items;

import com.djlead.leadmod.Reference;
import com.djlead.leadmod.sys.MyItems;
import com.djlead.leadmod.sys.MyTab;
import net.minecraft.item.ItemSword;

/**
 * Created by Lead on 27-9-2015.
 */
public class WhishSword extends ItemSword {

    public WhishSword() {
        super(MyItems.whishAlloy);
        this.setUnlocalizedName("djsword");
        this.setTextureName(Reference.MODID + ":" + "djsword");
        this.setCreativeTab(MyTab.CreaTab);
    }
}
