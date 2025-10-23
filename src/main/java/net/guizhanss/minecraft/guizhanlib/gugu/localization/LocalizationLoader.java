package net.guizhanss.minecraft.guizhanlib.gugu.localization;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.papermc.lib.PaperLib;
import net.guizhanss.minecraft.guizhanlib.GuizhanLib;
import net.guizhanss.minecraft.guizhanlib.utils.MinecraftVersionUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Localization file loader
 *
 * @author ybw0014
 */
public final class LocalizationLoader {

    private static final Gson GSON = new Gson();
    private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder()
        .connectTimeout(Duration.ofSeconds(5))
        .build();

    private final Map<String, String> lang = new HashMap<>();
    private final Logger logger;
    private final String fullVersion;
    private final File localeFile;

    public LocalizationLoader() {
        logger = GuizhanLib.getInstance().getLogger();
        fullVersion = MinecraftVersionUtils.getFullVersion();

        // create minecraft-lang folder if not exists
        File langFolder = new File(GuizhanLib.getInstance().getDataFolder(), "minecraft-lang");
        if (!langFolder.exists()) {
            langFolder.mkdirs();
        }

        localeFile = new File(GuizhanLib.getInstance().getDataFolder(), "minecraft-lang/" + fullVersion + ".json");

        prepareFile();
        loadFile();
    }

    public Map<String, String> getResult() {
        return Collections.unmodifiableMap(lang);
    }

    private void prepareFile() {
        logger.log(Level.INFO, "Starting to load Minecraft localization file");
        logger.log(Level.INFO, "Current version: " + fullVersion);

        try {
            if (!localeFile.exists()) {
                logger.log(Level.INFO, "Localization file for current version does not exist, attempting to download");

                String remoteUrl = "https://cdn.jsdelivr.net/gh/InventivetalentDev/minecraft-assets@" + fullVersion + "/assets/minecraft/lang/en_US.json";

                HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(remoteUrl))
                    .GET()
                    .timeout(Duration.ofSeconds(10))
                    .build();

                HttpResponse<InputStream> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofInputStream());
                InputStream inputStream = response.body();
                saveToFile(inputStream);

                logger.log(Level.INFO, "Downloaded localization file for current version");
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while loading Minecraft localization resources, trying backup plan", e);
            prepareBackupFile();
        }
    }

    private void prepareBackupFile() {
        logger.log(Level.INFO, "Starting to load local backup Minecraft localization file (may not be the latest for current version)");
        try {
            int mcVersion = PaperLib.getMinecraftVersion();
            InputStream input;
            while (mcVersion >= 18) {
                logger.log(Level.INFO, "Trying to find 1." + mcVersion);
                final String filename = "/minecraft-lang/1." + mcVersion + "/en_US.json";
                input = GuizhanLib.getInstance().getClass().getResourceAsStream(filename);
                if (input != null) {
                    logger.log(Level.INFO, "Loading 1." + mcVersion);

                    saveToFile(input);

                    logger.log(Level.INFO, "Loaded 1." + mcVersion);
                    break;
                } else {
                    logger.log(Level.INFO, "Localization file for 1." + mcVersion + " is missing, trying to load previous version");
                    mcVersion--;
                }
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to load local backup Minecraft localization resources", e);
        }
    }

    private void saveToFile(InputStream inputStream) throws Exception {
        FileOutputStream output = new FileOutputStream(localeFile);
        byte[] data = new byte[1024];
        int read;

        while ((read = inputStream.read(data, 0, 1024)) != -1) {
            output.write(data, 0, read);
        }

        inputStream.close();
        output.close();
    }

    private void loadFile() {
        try {
            FileInputStream stream = new FileInputStream(localeFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                stream, StandardCharsets.UTF_8
            ));
            // @formatter:off
            Type type = new TypeToken<Map<String, String>>() {}.getType();
            // @formatter:on
            lang.putAll(GSON.fromJson(reader, type));

            logger.log(Level.INFO, "Loading successful");
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error occurred while loading Minecraft localization file", ex);
        }
    }
}
