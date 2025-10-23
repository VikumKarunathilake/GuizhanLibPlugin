package net.guizhanss.minecraft.guizhanlib.gugu.minecraft.helpers.entity;

import com.google.common.base.Preconditions;
import lombok.experimental.UtilityClass;
import net.guizhanss.guizhanlib.common.utils.StringUtil;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Rabbit.Type;

import javax.annotation.Nonnull;
import java.util.Map;

/**
 * {@link Rabbit} related utilities
 */
@UtilityClass
@SuppressWarnings({"ConstantConditions", "unused"})
public final class RabbitHelper {

    private static final Map<Type, String> TYPE_MAP = Map.of(
        Type.BLACK, "Black",
        Type.BLACK_AND_WHITE, "Black and White",
        Type.BROWN, "Brown",
        Type.GOLD, "Gold",
        Type.SALT_AND_PEPPER, "Salt and Pepper",
        Type.THE_KILLER_BUNNY, "The Killer Bunny",
        Type.WHITE, "White"
    );

    @Nonnull
    public static String getTypeName(@Nonnull Type type) {
        Preconditions.checkNotNull(type);
        return TYPE_MAP.getOrDefault(type, "Unknown");
    }

    @Nonnull
    public static String getTypeName(@Nonnull String type) {
        Preconditions.checkNotNull(type);
        try {
            Type inst = Type.valueOf(StringUtil.dehumanize(type));
            return getTypeName(inst);
        } catch (Exception ex) {
            return StringUtil.humanize(type);
        }
    }
}
