package com.unrealdinnerbone.examplemod.platform;

import com.unrealdinnerbone.examplemod.platform.registry.RegistrationProvider;
import com.unrealdinnerbone.examplemod.platform.services.IPlatformHelper;
import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

import java.util.ServiceLoader;

public class Services {

    private static final Logger LOGGER = LogUtils.getLogger();

    private static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);

    private static final RegistrationProvider.Factory FACTORY = load(RegistrationProvider.Factory.class);

    public static <T> T load(Class<T> clazz) {
        final T loadedService = ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        LOGGER.debug("Using {} for service {}", clazz.getName(), clazz.getName());
        return loadedService;
    }

    public static IPlatformHelper getPlatform() {
        return PLATFORM;
    }

    public static RegistrationProvider.Factory getFactory() {
        return FACTORY;
    }
}
