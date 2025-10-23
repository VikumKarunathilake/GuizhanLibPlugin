package net.guizhanss.minecraft.guizhanlib.gugu.minecraft.helpers.entity;

import lombok.experimental.UtilityClass;
import org.bukkit.entity.Panda;

import javax.annotation.Nonnull;

/**
 * {@link org.bukkit.entity.PufferFish} related utilities
 */
@UtilityClass
@SuppressWarnings({"unused"})
public final class PufferFishHelper {

    @Nonnull
    public static String getPuffState(int level) {
        return switch (level) {
            case 0 -> "Not Puffed";
            case 1 -> "Half Puffed";
            case 2 -> "Fully Puffed";
            default -> "Unknown";
        };
    }
}
