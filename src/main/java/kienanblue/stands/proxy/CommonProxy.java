package kienanblue.stands.proxy;

import kienanblue.stands.blocks.ModBlocks;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Kienan on 11/08/2017.
 */
public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent e)
    {
        ModBlocks.register();
    }
    
    public void init(FMLInitializationEvent e)
    {
    
    }
    
    public void postInit(FMLPostInitializationEvent e)
    {
    
    }
}
