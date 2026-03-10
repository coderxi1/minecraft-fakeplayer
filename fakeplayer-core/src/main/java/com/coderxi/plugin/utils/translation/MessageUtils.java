package com.coderxi.plugin.utils.translation;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class MessageUtils {
    private static Component PREFIX;
    public static void init(JavaPlugin plugin) {
        String prefix = plugin.getConfig().getString("i18n.message_prefix");
        if (prefix == null) {
            PREFIX = Component.text("");
        } else {
            PREFIX = LegacyComponentSerializer.legacyAmpersand().deserialize(prefix);
        }
    }

    public static Component translatableWithPrefix(final @NotNull String key) {
        return PREFIX.append(Component.translatable(key));
    }
    public static Component translatableWithPrefix(final @NotNull String key, @NotNull TextColor color) {
        return PREFIX.append(Component.translatable(key, color));
    }

    public static Component translatableWithPrefix(final @NotNull String key, final @NotNull ComponentLike @NotNull... args) {
        return PREFIX.append(Component.translatable(key, Style.empty(), args));
    }

}
