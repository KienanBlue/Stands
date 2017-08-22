package kienanblue.stands.gui;

import kienanblue.stands.Stands;
import kienanblue.stands.blocks.TileEntityBasket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Kienan on 20/08/2017.
 */
public class GuiBasket extends GuiContainer
{
    private static final ResourceLocation texture = new ResourceLocation(Stands.MODID, "textures/gui/basket");
    
    private static TileEntityBasket tileStatic;
    private TileEntityBasket tile = tileStatic;
    
    public GuiBasket(Container container, TileEntityBasket tile)
    {
        super(container);
        tileStatic = tile;
        this.xSize = 128;
        this.ySize = 128;
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        this.drawDefaultBackground();
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
        if(tile != null)
        {
            if(tile.getStackInSlot(0).isEmpty())
            {
                drawTexturedModalRect(guiLeft+100, guiTop+50, 128, 0, 16, 16);
            }
            String name = tile.getName();
            int l = (xSize-fontRenderer.getStringWidth(name))/2;
            fontRenderer.drawString(name, this.guiLeft+l, this.guiTop+15, 3216909);
        }
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
        this.renderHoveredToolTip(mouseX - guiLeft, mouseY - guiTop);
    }
    /*
    private static String basketType()
    {
        if(tileStatic.getBlockType().getRegistryName() == ModBlocks.spruce_basket.getRegistryName()) return "spruce";
        if(tileStatic.getBlockType().getRegistryName() == ModBlocks.birch_basket.getRegistryName()) return "birch";
        if(tileStatic.getBlockType().getRegistryName() == ModBlocks.jungle_basket.getRegistryName()) return "jungle";
        if(tileStatic.getBlockType().getRegistryName() == ModBlocks.acacia_basket.getRegistryName()) return "acacia";
        if(tileStatic.getBlockType().getRegistryName() == ModBlocks.dark_oak_basket.getRegistryName()) return "dark_oak";
        if(tileStatic.getBlockType().getRegistryName() == ModBlocks.metal_basket.getRegistryName()) return "metal";
        return "oak";
    }*/
}
