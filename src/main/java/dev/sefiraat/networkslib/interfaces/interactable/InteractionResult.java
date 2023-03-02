package dev.sefiraat.networkslib.interfaces.interactable;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Arrays;
import java.util.List;

/**
 * This class represents the result of an interaction request sent from Networks.
 */
public class InteractionResult {

    private final boolean interactionSuccessful;
    @Nonnull
    private final List<ItemStack> fetchedStacks;
    @Nonnull
    private final Location affectLocation;

    /**
     * Creates a new InteractionResult
     *
     * @param interactionSuccessful Whether the interaction was successful or not
     * @param affectLocation        The location of the interaction.
     *                              This is used for when Networks wants to reject a given item onto the ground.
     * @param fetchedStacks         The {@link ItemStack}(s) that Networks will attempt to process.
     *                              Any items that cannot go into the Network will be dropped at the affectLocation.
     */
    @ParametersAreNonnullByDefault
    public InteractionResult(boolean interactionSuccessful, Location affectLocation, ItemStack... fetchedStacks) {
        this.interactionSuccessful = interactionSuccessful;
        this.affectLocation = affectLocation;
        this.fetchedStacks = Arrays.asList(fetchedStacks);
    }

    /**
     * Returns whether the interaction was successful or not.
     *
     * @return boolean denoting success.
     */
    public boolean isInteractionSuccessful() {
        return interactionSuccessful;
    }

    /**
     * Returns the {@link ItemStack}(s) produced as a result of this interaction.
     * Networks will attempt to process them and, if it fails, will drop into the world at
     * the {@link InteractionResult#getAffectLocation()}
     *
     * @return A list of {@link ItemStack}(s) to process.
     */
    @Nonnull
    public List<ItemStack> getFetchedStacks() {
        return fetchedStacks;
    }

    /**
     * Returns the location of the affected block and/or the location to drop unprocessed items.
     *
     * @return the location of the affected block and/or the location to drop unprocessed items.
     */
    @Nonnull
    public Location getAffectLocation() {
        return affectLocation;
    }
}
