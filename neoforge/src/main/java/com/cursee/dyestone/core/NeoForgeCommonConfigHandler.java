package com.cursee.dyestone.core;

import com.cursee.dyestone.Constants;
import com.cursee.dyestone.platform.Services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class NeoForgeCommonConfigHandler {

    public static void onLoad() {
        new File(Services.PLATFORM.getGameDirectory() + File.separator + "config").mkdirs();
        File CONFIG_FILE = new File(Services.PLATFORM.getGameDirectory() + File.separator + "config" + File.separator + Constants.MOD_ID + "-common.toml");
        handleConfig(CONFIG_FILE);
    }

    private static final String[] DEFAULT_CONFIG = new String[] {
            "all_dyestone_connects = true"
    };

    public static void handleConfig(File file) {
        if (!file.isFile()) {
            try (PrintWriter writer = new PrintWriter(file, StandardCharsets.UTF_8)) {
                for (String s : DEFAULT_CONFIG) {
                    writer.println(s);
                }
            }
            catch (Exception ignored) {}

            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
            String line = reader.readLine().replace("all_dyestone_connects = ", "");
            CommonConfigValues.all_dyestone_connects = Boolean.parseBoolean(line);

        }
        catch (Exception ignored) {}

//        try {
//            Toml toml = new Toml().read(file);
//            CommonConfigValues.automatic_disenchanting = toml.getBoolean("automatic_disenchanting");
//            CommonConfigValues.resets_repair_cost = toml.getBoolean("resets_repair_cost");
//            CommonConfigValues.requires_experience = toml.getBoolean("requires_experience");
//            CommonConfigValues.uses_points = toml.getBoolean("uses_points");
//            CommonConfigValues.experience_cost = Math.toIntExact(toml.getLong("experience_cost"));
//        }
//        catch (Exception ignored) {}
    }
}
