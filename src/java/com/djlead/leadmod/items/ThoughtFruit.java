package com.djlead.leadmod.items;

import com.djlead.leadmod.Reference;
import com.djlead.leadmod.sys.MyTab;
import net.minecraft.item.ItemFood;

/** Thought Apple - Good Food
 * Created by Lead on 28-9-2015.
 */
public class ThoughtFruit extends ItemFood {
    public ThoughtFruit() {

        super(6, 1.0F, false);
        //  healing , saturation , wolve food
        //  ---------------------------------
        //  Apple 	                4 	0.3f
        //  Raw Porkchop or Beef 	3 	0.3f
        //  Bread 	                5 	0.6f
        //  Cooked Porkchop or Beef 8 	0.8f
        //  Golden Apple 	        4 	1.2f

        this.setUnlocalizedName("thoughtfruit");
        this.setTextureName(Reference.MODID + ":" + "thoughtfruit");
        this.setCreativeTab(MyTab.CreaTab);
        this.setAlwaysEdible();
    }
}

