package cofh.api.world;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandom;

/**
 * This class essentially allows for ores to be generated in clusters, with Features randomly choosing one or more blocks from a weighted list.
 * 
 * @author King Lemming
 * 
 */
public final class WeightedRandomBlock extends WeightedRandom.Item {

	public final int blockId;
	public final int metadata;

	public WeightedRandomBlock(ItemStack ore) {

		super(100);
		this.blockId = Item.getIdFromItem(ore.getItem());
		this.metadata = ore.getItemDamage();
	}

	public WeightedRandomBlock(ItemStack ore, int weight) {

		super(weight);
		this.blockId = Item.getIdFromItem(ore.getItem());
		this.metadata = ore.getItemDamage();
	}
	
	public Block getBlock(){
	    return Block.getBlockById(blockId);
	}

}
