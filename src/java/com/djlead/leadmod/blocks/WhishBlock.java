package com.djlead.leadmod.blocks;

/** Storage block for Whish Alloy
 * Created by Lead on 4-10-2015.
 */
public class WhishBlock extends BaseBlock {

    public WhishBlock() {

        super();
        this.setBlockName("whishalloyblock");
        this.setHardness(15.0F);
        this.setResistance(100.0F);
        this.setHarvestLevel("pickaxe", 2);  // mine with at least iron pickaxe
        this.setStepSound(soundTypeMetal);
    }
}
