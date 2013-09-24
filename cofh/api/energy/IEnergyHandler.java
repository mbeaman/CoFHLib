package cofh.api.energy;

import net.minecraftforge.common.ForgeDirection;

/**
 * Implement this interface on TileEntities which should handle energy, generally storing it in one or more internal {@link IEnergyStorage} objects.
 * 
 * A reference implementation is provided {@link TileEnergyHandler}.
 * 
 * @author King Lemming
 * 
 */
public interface IEnergyHandler {

	/**
	 * Add energy to an IEnergyHandler, internal distribution is left entirely to the IEnergyHandler.
	 * 
	 * @param from
	 *            Orientation the energy is received from.
	 * @param maxReceive
	 *            Maximum amount of energy to received.
	 * @param doReceive
	 *            If false, the charge will only be simulated.
	 * @return Amount of energy that was (or would have been, if simulated) received.
	 */
	int receiveEnergy(ForgeDirection from, int maxReceive, boolean doReceive);

	/**
	 * Remove energy from an IEnergyHandler, internal distribution is left entirely to the IEnergyHandler.
	 * 
	 * @param from
	 *            Orientation the energy is extracted to.
	 * @param maxExtract
	 *            Maximum amount of energy to extract.
	 * @param doExtract
	 *            If false, the discharge will only be simulated.
	 * @return Amount of energy that was (or would have been, if simulated) extracted.
	 */
	int extractEnergy(ForgeDirection from, int maxExtract, boolean doExtract);

	/**
	 * Returns true if energy can be received from the given direction.
	 * 
	 * More formally, this should return true if energy is able to enter from the given direction.
	 */
	boolean canReceiveEnergy(ForgeDirection from);

	/**
	 * Returns true if energy can be extracted from the given direction.
	 * 
	 * More formally, this should return true if energy is able to leave from the given direction.
	 */
	boolean canExtractEnergy(ForgeDirection from);

	/**
	 * Returns the amount of energy currently stored.
	 */
	int getEnergyStored(ForgeDirection from);

	/**
	 * Returns the maximum amount of energy that can be stored.
	 */
	int getMaxEnergyStored(ForgeDirection from);

}
