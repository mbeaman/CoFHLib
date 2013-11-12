package cofh.gui.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Slot which copies an ItemStack when clicked on, does not decrement the ItemStack on the cursor.
 * 
 * @author King Lemming
 * 
 */
public class SlotFalseCopy extends Slot {

	public int slotIndex = 0;

	public SlotFalseCopy(IInventory inventory, int slot, int x, int z) {

		super(inventory, slot, x, z);
		slotIndex = slot;
	}

	@Override
	public boolean canTakeStack(EntityPlayer player) {

		return true;
	}

	@Override
	public boolean isItemValid(ItemStack stack) {

		return true;
	}

	@Override
	public void putStack(ItemStack par1ItemStack) {

		if (par1ItemStack != null) {
			par1ItemStack.stackSize = 1;
		}
		this.inventory.setInventorySlotContents(this.slotIndex, par1ItemStack);
		this.onSlotChanged();
	}

}
