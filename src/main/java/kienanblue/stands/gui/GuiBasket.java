package kienanblue.stands.gui;

import kienanblue.stands.Stands;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Kienan on 20/08/2017.
 */
public class GuiBasket extends GuiContainer
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Stands.MODID, "textures/gui/basket.png");
    
    private IInventory basketInventory;
    private InventoryPlayer playerInventory;
    
    public GuiBasket(InventoryPlayer playerInv, IInventory tile)
    {
        super(new ContainerBasket(playerInv, tile));
        this.basketInventory = tile;
        this.playerInventory = playerInv;
        this.xSize = 176;
        this.ySize = 166;
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(TEXTURE);
        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s = I18n.format("gui."+Stands.MODID+".basket");
        this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
    }
    
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }
}
