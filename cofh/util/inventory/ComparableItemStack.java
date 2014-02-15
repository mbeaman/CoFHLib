package cofh.util.inventory;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cofh.util.ItemHelper;

/**
 * This class allows for OreDictionary-compatible ItemStack comparisons.
 * 
 * The intended purpose of this is for things such as Recipe Handlers or HashMaps of ItemStacks.
 * 
 * @author King Lemming
 * 
 */
public class ComparableItemStack {

	public Item item = null;
	public int metadata = -1;
	public int stackSize = -1;
	public int oreID = -1;

	public ComparableItemStack(ItemStack stack) {

		if (stack != null) {
			item = stack.getItem();
			metadata = stack.getItemDamage();
			stackSize = stack.stackSize;
			oreID = OreDictionary.getOreID(stack);
		}
	}

	public ComparableItemStack(Item item, int damage, int stackSize) {

		this.item = item;
		this.metadata = damage;
		this.stackSize = stackSize;
		this.oreID = OreDictionary.getOreID(this.toItemStack());
	}

	public ComparableItemStack(ComparableItemStack stack) {

		this.item = stack.item;
		this.metadata = stack.metadata;
		this.stackSize = stack.stackSize;
		this.oreID = stack.oreID;
	}

	public ComparableItemStack(String oreName) {

		if (ItemHelper.oreNameExists(oreName)) {
			ItemStack ore = OreDictionary.getOres(oreName).get(0);
			item = ore.getItem();
			metadata = ore.getItemDamage();
			stackSize = 1;
			oreID = OreDictionary.getOreID(oreName);
		}
	}

	public ComparableItemStack set(ItemStack stack) {

		if (stack != null) {
			item = stack.getItem();
			metadata = stack.getItemDamage();
			stackSize = stack.stackSize;
			oreID = OreDictionary.getOreID(stack);
		} else {
			item = null;
			metadata = -1;
			stackSize = -1;
			oreID = -1;
		}
		return this;
	}

	public ComparableItemStack set(ComparableItemStack stack) {

		if (stack != null) {
			item = stack.item;
			metadata = stack.metadata;
			stackSize = stack.stackSize;
			oreID = stack.oreID;
		} else {
		    item = null;
			metadata = -1;
			stackSize = -1;
			oreID = -1;
		}
		return this;
	}

	public boolean isItemEqual(ComparableItemStack other) {

		return other != null && (oreID != -1 && oreID == other.oreID || item.equals(other.item) && metadata == other.metadata);
	}

	public boolean isStackEqual(ComparableItemStack other) {

		return isItemEqual(other) && stackSize == other.stackSize;
	}

	public boolean isStackValid() {

		return getItem() != null;
	}

	public Item getItem() {

		return item;
	}

	public ItemStack toItemStack() {
	    
		return new ItemStack(item, stackSize, metadata);
	}

	@Override
	public ComparableItemStack clone() {

		return new ComparableItemStack(this);
	}

	@Override
	public int hashCode() {

		return oreID != -1 ? oreID : metadata | Item.getIdFromItem(item) << 16;
	}

	@Override
	public boolean equals(Object o) {

		if (!(o instanceof ComparableItemStack)) {
			return false;
		}
		return isItemEqual((ComparableItemStack) o);
	}

}
