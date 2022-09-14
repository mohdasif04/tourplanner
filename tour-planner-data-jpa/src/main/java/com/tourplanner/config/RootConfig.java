package com.tourplanner.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ PersistanceConfig.class, ServiceConfig.class })
public class RootConfig {

}
