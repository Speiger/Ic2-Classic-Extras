package trinsdar.ic2c_extras.container;

import ic2.core.inventory.container.ContainerTileComponent;
import ic2.core.inventory.filters.ArrayFilter;
import ic2.core.inventory.filters.BasicItemFilter;
import ic2.core.inventory.gui.components.base.FluidTankComp;
import ic2.core.inventory.gui.components.base.MachineChargeComp;
import ic2.core.inventory.gui.components.base.MachineProgressComp;
import ic2.core.inventory.slots.SlotCustom;
import ic2.core.inventory.slots.SlotDischarge;
import ic2.core.inventory.slots.SlotOutput;
import ic2.core.inventory.slots.SlotUpgrade;
import ic2.core.platform.registry.Ic2GuiComp;
import ic2.core.platform.registry.Ic2Items;
import ic2.core.util.math.Box2D;
import ic2.core.util.math.Vec2i;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.ResourceLocation;
import trinsdar.ic2c_extras.tileentity.TileEntityOreWashingPlant;

public class ContainerOreWashingPlant extends ContainerTileComponent<TileEntityOreWashingPlant>
{
    public ContainerOreWashingPlant(InventoryPlayer player, TileEntityOreWashingPlant tile)
    {
        super(tile);

        this.addSlotToContainer(new SlotCustom(tile, 0, 56, 17, null));
        this.addSlotToContainer(new SlotDischarge(tile, 2147483647, 1, 56, 53));
        this.addSlotToContainer(new SlotOutput(player.player, tile, 2, 111, 17));
        this.addSlotToContainer(new SlotOutput(player.player, tile, 3, 111, 35));
        this.addSlotToContainer(new SlotOutput(player.player, tile, 4, 111, 53));
        this.addSlotToContainer(new SlotCustom(tile, 5, 8, 12, new ArrayFilter(new BasicItemFilter(Items.WATER_BUCKET), new BasicItemFilter(Ic2Items.waterCell))));
        this.addSlotToContainer(new SlotCustom(tile, 6, 8, 57, null));

        for(int i = 0; i < 4; ++i)
        {
            this.addSlotToContainer(new SlotUpgrade(tile, 7 + i, 152, 8 + i * 18));
        }

        this.addPlayerInventory(player);
        this.addComponent(new MachineChargeComp(tile, Ic2GuiComp.machineChargeBox, Ic2GuiComp.machineChargePos));
        this.addComponent(new MachineProgressComp(tile, Ic2GuiComp.machineProgressBox, Ic2GuiComp.machineProgressPos));
        this.addComponent(new FluidTankComp(new Box2D(13, 32, 16, 58), tile.waterTank, new Vec2i(176, 133), new Box2D(32, 13, 16, 58)));
    }

    @Override
    public ResourceLocation getTexture()
    {
        return this.getGuiHolder().getGuiTexture();
    }

    @Override
    public int guiInventorySize()
    {
        return this.getGuiHolder().slotCount;
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer)
    {
        return this.getGuiHolder().canInteractWith(entityPlayer);
    }
}
