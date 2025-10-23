package net.guizhanss.minecraft.guizhanlib.gugu.minecraft;

import com.google.common.base.Preconditions;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.ChatColor;

import javax.annotation.Nonnull;
import java.util.EnumMap;
import java.util.Map;

/**
 * Chat colors {@link ChatColor}
 *
 * @author ybw0014
 * @see ChatColor
 */
@SuppressWarnings({"ConstantConditions", "deprecation"})
@Getter
@RequiredArgsConstructor
public enum ChatColors {
    /**
     * Aqua
     */
    AQUA(ChatColor.AQUA, "Aqua"),
    /**
     * Black
     */
    BLACK(ChatColor.BLACK, "Black"),
    /**
     * Blue
     */
    BLUE(ChatColor.BLUE, "Blue"),
    /**
     * Bold
     */
    BOLD(ChatColor.BOLD, "Bold"),
    /**
     * Dark Aqua
     */
    DARK_AQUA(ChatColor.DARK_AQUA, "Dark Aqua"),
    /**
     * Dark Blue
     */
    DARK_BLUE(ChatColor.DARK_BLUE, "Dark Blue"),
    /**
     * Dark Gray
     */
    DARK_GRAY(ChatColor.DARK_GRAY, "Dark Gray"),
    /**
     * Dark Green
     */
    DARK_GREEN(ChatColor.DARK_GREEN, "Dark Green"),
    /**
     * Dark Purple
     */
    DARK_PURPLE(ChatColor.DARK_PURPLE, "Dark Purple"),
    /**
     * Dark Red
     */
    DARK_RED(ChatColor.DARK_RED, "Dark Red"),
    /**
     * Gold
     */
    GOLD(ChatColor.GOLD, "Gold"),
    /**
     * Gray
     */
    GRAY(ChatColor.GRAY, "Gray"),
    /**
     * Green
     */
    GREEN(ChatColor.GREEN, "Green"),
    /**
     * Italic
     */
    ITALIC(ChatColor.ITALIC, "Italic"),
    /**
     * Light Purple
     */
    LIGHT_PURPLE(ChatColor.LIGHT_PURPLE, "Light Purple"),
    /**
     * Magic
     */
    MAGIC(ChatColor.MAGIC, "Magic"),
    /**
     * Red
     */
    RED(ChatColor.RED, "Red"),
    /**
     * Reset
     */
    RESET(ChatColor.RESET, "Reset"),
    /**
     * Strikethrough
     */
    STRIKETHROUGH(ChatColor.STRIKETHROUGH, "Strikethrough"),
    /**
     * Underline
     */
    UNDERLINE(ChatColor.UNDERLINE, "Underline"),
    /**
     * White
     */
    WHITE(ChatColor.WHITE, "White"),
    /**
     * Yellow
     */
    YELLOW(ChatColor.YELLOW, "Yellow");

    /**
     * Color code prefix
     */
    public static final char COLOR_CHAR = '§';

    private static final ChatColors[] valuesCache = values();
    private static final Map<ChatColor, ChatColors> colorLookup = new EnumMap<>(ChatColor.class);

    static {
        for (ChatColors color : valuesCache) {
            colorLookup.put(color.getColor(), color);
        }
    }

    private final ChatColor color;
    private final String name;

    /**
     * Returns the corresponding enum based on chat color
     *
     * @param chatColor {@link ChatColor} chat color
     * @return corresponding enum
     */
    @Nonnull
    public static ChatColors fromChatColor(@Nonnull ChatColor chatColor) {
        Preconditions.checkArgument(chatColor != null, "Chat color cannot be null");

        return colorLookup.get(chatColor);
    }

    /**
     * Get the name
     *
     * @return name
     */
    @Override
    public String toString() {
        return this.getName();
    }

    /**
     * Get the colored name with color code
     *
     * @return colored name with color code
     */
    public String toColoredString() {
        return this.getColor() + this.getName();
    }
}
