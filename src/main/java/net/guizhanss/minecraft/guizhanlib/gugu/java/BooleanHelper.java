package net.guizhanss.minecraft.guizhanlib.gugu.java;

import lombok.experimental.UtilityClass;

import javax.annotation.Nonnull;

/**
 * Boolean ({@link Boolean}) helper
 *
 * @author ybw0014
 */
@UtilityClass
public final class BooleanHelper {

    /**
     * Returns "Yes" or "No" based on the provided boolean value
     *
     * @param value a boolean value
     * @return {@link String} "Yes" or "No" based on the provided boolean value
     */
    @Nonnull
    public static String yesOrNo(boolean value) {
        return value ? "Yes" : "No";
    }

    /**
     * Returns "Enabled" or "Disabled" based on the provided boolean value
     *
     * @param value a boolean value
     * @return {@link String} "Enabled" or "Disabled" based on the provided boolean value
     */
    @Nonnull
    public static String enabledOrDisabled(boolean value) {
        return value ? "Enabled" : "Disabled";
    }
}
