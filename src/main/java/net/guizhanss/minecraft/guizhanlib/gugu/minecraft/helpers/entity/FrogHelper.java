package net.guizhanss.minecraft.guizhanlib.gugu.minecraft.helpers.entity;

import com.google.common.base.Preconditions;
import lombok.experimental.UtilityClass;
import net.guizhanss.guizhanlib.common.utils.StringUtil;
import org.bukkit.entity.Frog;
import org.bukkit.entity.Frog.Variant;

import javax.annotation.Nonnull;
import java.util.Map;

/**
 * {@link Frog} related utilities
 */
@UtilityClass
@SuppressWarnings({"ConstantConditions", "unused"})
public final class FrogHelper {

    private static final Map<Variant, String> VARIANT_MAP = Map.of(
        Variant.TEMPERATE, "Orange",
        Variant.COLD, "Green",
        Variant.WARM, "White"
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
