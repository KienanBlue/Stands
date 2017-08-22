package kienanblue.stands.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

/**
 * Created by Kienan on 19/08/2017.
 */
public class BlockBasketWood extends BlockBasket
{
    public BlockBasketWood(String id)
    {
        super(id, Material.WOOD);
        setHarvestLevel("axe", 0);
        setSoundType(SoundType.WOOD);
    }
}
