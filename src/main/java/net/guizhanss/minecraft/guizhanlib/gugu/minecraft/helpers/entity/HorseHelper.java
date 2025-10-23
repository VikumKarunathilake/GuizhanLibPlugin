package net.guizhanss.minecraft.guizhanlib.gugu.minecraft.helpers.entity;

import com.google.common.base.Preconditions;
import lombok.experimental.UtilityClass;
import net.guizhanss.guizhanlib.common.utils.StringUtil;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Horse.Color;
import org.bukkit.entity.Horse.Style;

import javax.annotation.Nonnull;
import java.util.Map;

/**
 * {@link Horse} related utilities
 */
@UtilityClass
@SuppressWarnings({"ConstantConditions", "unused"})
public final class HorseHelper {

    private static final Map<Color, String> COLOR_MAP = Map.of(
        Color.BLACK, "Black",
        Color.BROWN, "Brown",
        Color.CHESTNUT, "Chestnut",
        Color.CREAMY, "Creamy",
        Color.DARK_BROWN, "Dark Brown",
        Color.GRAY, "Gray",
        Color.WHITE, "White"
    );

    private static final Map<Style, String> STYLE_MAP = Map.of(
        Style.BLACK_DOTS, "Black Dots",
        Style.NONE, "None",
        Style.WHITE, "White",
        Style.WHITE_DOTS, "White Dots",
        Style.WHITEFIELD, "White Field"
    );

    @Nonnull
    public static String getColorName(@Nonnull Color color) {
        Preconditions.checkNotNull(color);
        return COLOR_MAP.getOrDefault(color, "Unknown");
    }

    @Nonnull
    public static String getColorName(@Nonnull String variant) {
        Preconditions.checkNotNull(variant);
        try {
            Color inst = Color.valueOf(StringUtil.dehumanize(variant));
            return getColorName(inst);
        } catch (Exception ex) {
            return StringUtil.humanize(variant);
        }
    }

    @Nonnull
    public static String getStyleName(@Nonnull Style style) {
        Preconditions.checkNotNull(style);
        return STYLE_MAP.getOrDefault(style, "Unknown");
    }

    @Nonnull
    public static String getStyleName(@Nonnull String variant) {
        Preconditions.checkNotNull(variant);
        try {
            Style inst = Style.valueOf(StringUtil.dehumanize(variant));
            return getStyleName(inst);
        } catch (Exception ex) {
            return StringUtil.humanize(variant);
        }
    }
}
