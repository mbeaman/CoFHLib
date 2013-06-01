
package cofh.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.oredict.OreDictionary;

public final class ItemHelper {

    private ItemHelper() {

    }

    public static ItemStack consumeItem(ItemStack stack) {

        if (stack.stackSize == 1) {
            if (stack.getItem().hasContainerItem()) {
                return stack.getItem().getContainerItemStack(stack);
            } else {
                return null;
            }
        }
        stack.splitStack(1);
        return stack;
    }

    public static int getHashCode(ItemStack stack) {

        return stack.getItemDamage() | stack.itemID << 16;
    }

    public static int getHashCode(int id, int metadata) {

        return metadata | id << 16;
    }

    public static int getIDFromHashCode(int hashCode) {

        return hashCode >> 16;
    }

    public static int getMetaFromHashCode(int hashCode) {

        return hashCode & 0xFF;
    }

    public static String getOreName(ItemStack stack) {

        return OreDictionary.getOreName(OreDictionary.getOreID(stack));
    }

    public static boolean isOreID(ItemStack stack, int oreID) {

        return OreDictionary.getOreID(stack) == oreID;
    }

    public static boolean isOreName(ItemStack stack, String oreName) {

        return OreDictionary.getOreName(OreDictionary.getOreID(stack)).equals(oreName);
    }

    public static boolean isPlayerHoldingFluidContainer(EntityPlayer player) {

        return FluidContainerRegistry.isContainer(player.getCurrentEquippedItem());
    }

    public static boolean isPlayerHoldingItem(Item item, EntityPlayer player) {

        Item equipped = player.getCurrentEquippedItem() != null ? player.getCurrentEquippedItem().getItem() : null;
        return item == null ? equipped == null : item.equals(equipped);
    }

    public static boolean isPlayerHoldingItemStack(ItemStack stack, EntityPlayer player) {

        ItemStack equipped = player.getCurrentEquippedItem() != null ? player.getCurrentEquippedItem() : null;
        return stack == null ? equipped == null : equipped != null && stack.isItemEqual(equipped) && ItemStack.areItemStackTagsEqual(stack, equipped);
    }

}
