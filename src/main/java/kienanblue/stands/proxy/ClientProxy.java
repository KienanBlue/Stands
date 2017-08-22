package kienanblue.stands.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Kienan on 11/08/2017.
 */
public class ClientProxy extends CommonProxy
{
    @Override
    @SideOnly(Side.CLIENT)
    public void preInit(FMLPreInitializationEvent e)
    {
        super.preInit(e);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void init(FMLInitializationEvent e)
    {
        super.init(e);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void postInit(FMLPostInitializationEvent e)
    {
        super.postInit(e);
    }
}
