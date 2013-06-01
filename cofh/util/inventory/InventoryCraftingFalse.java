
package cofh.util.inventory;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;

/**
 * This class is used to get recipes (IRecipe requires it...) with a container!
 * 
 * @author Zeldo Kavira
 * 
 */
public final class InventoryCraftingFalse extends InventoryCrafting {

    public InventoryCraftingFalse(int width, int height) {

        super(null, width, height);
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {

        if (this.stackList[slot] != null) {
            ItemStack stack;

            if (this.stackList[slot].stackSize <= amount) {
                stack = this.stackList[slot];
                this.stackList[slot] = null;
                return stack;
            } else {
                stack = this.stackList[slot].splitStack(amount);

                if (this.stackList[slot].stackSize == 0) {
                    this.stackList[slot] = null;
                }
                return stack;
            }
        } else {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {

        this.stackList[slot] = stack;
    }

}
