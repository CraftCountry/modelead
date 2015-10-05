package com.djlead.leadmod.items;

import com.djlead.leadmod.Reference;

/**
 * Created by Lead on 4-10-2015.
 */
public class Rambutan extends BaseItem {
    public Rambutan (){
        super();
        this.maxStackSize = 18;
        this.setUnlocalizedName("rambutan");
        this.setTextureName(Reference.MODID + ":" + "rambutan");
    }
}
