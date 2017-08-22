package kienanblue.stands.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

/**
 * Created by Kienan on 14/08/2017.
 */
public class BlockBasketMetal extends BlockBasket
{
    public BlockBasketMetal(String id)
    {
        super(id, Material.IRON);
        setHarvestLevel("pickaxe", 1);
        setSoundType(SoundType.METAL);
        setLightOpacity(0);
    }
}
