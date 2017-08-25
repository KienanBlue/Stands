package kienanblue.stands.gui;

import kienanblue.stands.blocks.TileEntityBasket;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;

/**
 * Created by Kienan on 23/08/2017.
 */
public class SlotBasket extends Slot
{
    public SlotBasket(IInventory inventory, int index, int x, int y)
    {
        super(inventory, index, x, y);
    }
    
    @Override
    public boolean isItemValid(ItemStack stack)
    {
        ArrayList<Item> invalidFoods = new ArrayList<>();
        for(int i = 0; i < invalidFoods.size(); i++)
        {
            if(stack.getItem() instanceof ItemFood && stack.getItem() != invalidFoods.get(i)) return true;
        }
        return false;
    }
    
    
}
