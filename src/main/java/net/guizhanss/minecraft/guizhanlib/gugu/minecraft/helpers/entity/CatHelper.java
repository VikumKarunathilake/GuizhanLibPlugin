package net.guizhanss.minecraft.guizhanlib.gugu.minecraft.helpers.entity;

import com.google.common.base.Preconditions;
import lombok.experimental.UtilityClass;
import net.guizhanss.guizhanlib.common.utils.StringUtil;
import org.bukkit.entity.Cat;
import org.bukkit.entity.Cat.Type;

import javax.annotation.Nonnull;
import java.util.Map;

/**
 * {@link Cat} related utilities
 */
@UtilityClass
@SuppressWarnings({"ConstantConditions", "unused"})
public final class CatHelper {

    private static final Map<Type, String> TYPE_MAP = Map.ofEntries(
        Map.entry(Type.ALL_BLACK, "All Black"),
        Map.entry(Type.BLACK, "Tuxedo"),
        Map.entry(Type.BRITISH_SHORTHAIR, "British Shorthair"),
        Map.entry(Type.CALICO, "Calico"),
        Map.entry(Type.JELLIE, "Jellie"),
        Map.entry(Type.PERSIAN, "Persian"),
        Map.entry(Type.RAGDOLL, "Ragdoll"),
        Map.entry(Type.RED, "Red Tabby"),
        Map.entry(Type.SIAMESE, "Siamese"),
        Map.entry(Type.TABBY, "Tabby"),
        Map.entry(Type.WHITE, "White")
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
