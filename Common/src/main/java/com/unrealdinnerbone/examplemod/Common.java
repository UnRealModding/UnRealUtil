package com.unrealdinnerbone.examplemod;

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

public class Common {

    private static final Logger LOGGER = LogUtils.getLogger();
    public static void init() {
        LOGGER.info("Starting Common Code!");
    }
}