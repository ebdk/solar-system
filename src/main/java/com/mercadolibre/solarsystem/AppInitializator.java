package com.mercadolibre.solarsystem;

@org.springframework.stereotype.Component
class AppInitializator {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AppInitializator.class);

    @javax.annotation.PostConstruct
    private void init() {
        log.info("AppInitializator initialization logic TEEEEEEEEEEEEEST ...");
        // ...
    }

}