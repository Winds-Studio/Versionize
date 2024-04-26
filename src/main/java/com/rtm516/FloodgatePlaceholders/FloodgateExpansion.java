package com.rtm516.FloodgatePlaceholders;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.geysermc.floodgate.api.FloodgateApi;
import org.geysermc.floodgate.api.player.FloodgatePlayer;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public class FloodgateExpansion extends PlaceholderExpansion {

    public static final String VERSION = "2.0.1";

    public FloodgateExpansion() {
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public boolean canRegister() {
        return Bukkit.getPluginManager().isPluginEnabled(getRequiredPlugin());
    }

    @Override
    public String getRequiredPlugin() {
        return "floodgate";
    }

    @Override
    public @NotNull String getAuthor() {
        return "rtm516";
    }

    @Override
    public @NotNull String getIdentifier() {
        return "Versionize";
    }

    @Override
    public @NotNull String getVersion() {
        return VERSION;
    }

    @Override
    public String onPlaceholderRequest(Player player, @NotNull String identifier) {
        if (player == null) return "";

        switch (identifier.toLowerCase()) {
            case "player_protocol_version":
                return getVersion(player);
            case "player_protocol_id":
                return String.valueOf(com.viaversion.viaversion.api.Via.getAPI().getPlayerVersion(player.getUniqueId()));
            case "isbedrock":
                return String.valueOf(isFloodgatePlayer(player));
            case "device":
                return getDeviceOs(player);
            case "locale":
                return getLocale(player);
            case "locale_upper":
                return getLocaleUpper(player);
            case "username":
                return getUsername(player);
            case "xuid":
                return getXuid(player);
        }
        return null;
    }

    private boolean isFloodgatePlayer(Player player) {
        return FloodgateApi.getInstance().isFloodgatePlayer(player.getUniqueId());
    }

    private String getXuid(Player player) {
        FloodgatePlayer floodgatePlayer = getFloodgatePlayer(player);
        return floodgatePlayer != null ? floodgatePlayer.getXuid() : "";
    }

    private String getDeviceOs(Player player) {
        FloodgatePlayer floodgatePlayer = getFloodgatePlayer(player);
        return floodgatePlayer != null ? floodgatePlayer.getDeviceOs().toString() : "JAVA";
    }

    private String getVersion(Player player) {
        FloodgatePlayer floodgatePlayer = getFloodgatePlayer(player);
        return floodgatePlayer != null ? floodgatePlayer.getVersion() : com.viaversion.viaversion.api.protocol.version.ProtocolVersion.getProtocol(com.viaversion.viaversion.api.Via.getAPI().getPlayerVersion(player.getUniqueId())).getName();
    }

    private String getLocale(Player player) {
        FloodgatePlayer floodgatePlayer = getFloodgatePlayer(player);
        return floodgatePlayer != null ? floodgatePlayer.getLanguageCode() : "";
    }

    private String getUsername(Player player) {
        FloodgatePlayer floodgatePlayer = getFloodgatePlayer(player);
        return floodgatePlayer != null ? floodgatePlayer.getUsername() : "";
    }

    private String getLocaleUpper(Player player) {
        return getLocale(player).toUpperCase(Locale.ROOT);
    }

    private FloodgatePlayer getFloodgatePlayer(Player player) {
        return FloodgateApi.getInstance().getPlayer(player.getUniqueId());
    }
}
