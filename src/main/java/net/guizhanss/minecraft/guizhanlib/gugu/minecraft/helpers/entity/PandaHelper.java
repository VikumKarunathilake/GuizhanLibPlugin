package net.guizhanss.minecraft.guizhanlib.gugu.minecraft.helpers.entity;

import com.google.common.base.Preconditions;
import lombok.experimental.UtilityClass;
import net.guizhanss.guizhanlib.common.utils.StringUtil;
import org.bukkit.entity.Panda;
import org.bukkit.entity.Panda.Gene;

import javax.annotation.Nonnull;
import java.util.Map;

/**
 * {@link Panda} related utilities
 */
@UtilityClass
@SuppressWarnings({"ConstantConditions", "unused"})
public final class PandaHelper {

    private static final Map<Gene, String> VARIANT_MAP = Map.of(
        Gene.AGGRESSIVE, "Aggressive",
        Gene.BROWN, "Brown",
        Gene.LAZY, "Lazy",
        Gene.NORMAL, "Normal",
        Gene.PLAYFUL, "Playful",
        Gene.WEAK, "Weak",
        Gene.WORRIED, "Worried"
    );

    @Nonnull
    public static String getGeneName(@Nonnull Gene variant) {
        Preconditions.checkNotNull(variant);
        return VARIANT_MAP.getOrDefault(variant, "Unknown");
    }

    @Nonnull
    public static String getGeneName(@Nonnull String variant) {
        Preconditions.checkNotNull(variant);
        try {
            Gene inst = Gene.valueOf(StringUtil.dehumanize(variant));
            return getGeneName(inst);
        } catch (Exception ex) {
            return StringUtil.humanize(variant);
        }
    }
}
