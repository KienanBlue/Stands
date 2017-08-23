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
    private static final ResourceLocation texture = new ResourceLocation(Stands.MODID, "textures/gui/basket.png");
    
    private static TileEntityBasket tileStatic;
    private TileEntityBasket tile = tileStatic;
    
    public GuiBasket(Container container, TileEntityBasket tile)
    {
        super(container);
        tileStatic = tile;
        this.xSize = 176;
        this.ySize = 166;
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
            fontRenderer.drawString(tile.getName(), this.xSize / 2, 6, 4210752);
        }
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
        this.renderHoveredToolTip(mouseX - guiLeft, mouseY - guiTop);
    }
}
