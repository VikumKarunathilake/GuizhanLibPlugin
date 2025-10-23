package net.guizhanss.minecraft.guizhanlib.gugu.minecraft.helpers.entity;

import com.google.common.base.Preconditions;
import lombok.experimental.UtilityClass;
import net.guizhanss.guizhanlib.common.utils.StringUtil;
import org.bukkit.entity.Axolotl;
import org.bukkit.entity.Axolotl.Variant;

import javax.annotation.Nonnull;
import java.util.Map;

/**
 * {@link Axolotl} related utilities
 */
@UtilityClass
@SuppressWarnings({"ConstantConditions", "unused"})
public final class AxolotlHelper {

    private static final Map<Variant, String> VARIANT_MAP = Map.of(
        Variant.LUCY, "Pink",
        Variant.WILD, "Brown",
        Variant.GOLD, "Gold",
        Variant.CYAN, "Cyan",
        Variant.BLUE, "Blue"
    );

    @Nonnull
    public static String getVariantName(@Nonnull Variant variant) {
        Preconditions.checkNotNull(variant);
        return VARIANT_MAP.getOrDefault(variant, "Unknown");
    }


    @Nonnull
    public static String getVariantName(@Nonnull String variant) {
        Preconditions.checkNotNull(variant);
        try {
            Variant inst = Variant.valueOf(StringUtil.dehumanize(variant));
            return getVariantName(inst);
        } catch (Exception ex) {
            return StringUtil.humanize(variant);
        }
    }
}
