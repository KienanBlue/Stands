package kienanblue.stands.gui;

import kienanblue.stands.blocks.TileEntityBasket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

/**
 * Created by Kienan on 20/08/2017.
 */
public class GuiHandler implements IGuiHandler
{
    public static final int BASKET = 0;
    
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        BlockPos pos = new BlockPos(x, y, z);
        switch(ID)
        {
            case BASKET:
                return new ContainerBasket(player.inventory, (TileEntityBasket) world.getTileEntity(pos));
            default:
                return null;
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        BlockPos pos = new BlockPos(x, y, z);
        switch(ID)
        {
            case BASKET:
                return new GuiBasket(player.inventory, (TileEntityBasket) world.getTileEntity(pos));
            default:
                return null;
        }
    }
}
