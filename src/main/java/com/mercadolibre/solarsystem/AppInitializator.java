package com.mercadolibre.solarsystem;

@org.springframework.stereotype.Component
class AppInitializator {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AppInitializator.class);

    @org.springframework.beans.factory.annotation.Autowired
    private com.mercadolibre.solarsystem.services.DayService dayService;

    @javax.annotation.PostConstruct
    private void init() {
        dayService.mockDays();
    }

}