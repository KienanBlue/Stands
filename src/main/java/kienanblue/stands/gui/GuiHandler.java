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
    public enum ID
    {
        BASKET
    }
    
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
    {
        BlockPos pos = new BlockPos(x, y, z);
        switch(ID.values()[id])
        {
            case BASKET:
                return new ContainerBasket(player.inventory, (TileEntityBasket) world.getTileEntity(pos));
            default:
                return null;
        }
    }
    
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
    {
        BlockPos pos = new BlockPos(x, y, z);
        switch(ID.values()[id])
        {
            case BASKET:
                return new GuiBasket((Container) getServerGuiElement(id, player, world, x, y, z), (TileEntityBasket) world.getTileEntity(pos));
            default:
                return null;
        }
    }
}
