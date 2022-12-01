package com.academia.placementhistory;

import com.academia.placementhistory.Util.CORSFilter;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class HelloApplication extends ResourceConfig {
    HelloApplication() {
        register(CORSFilter.class);
        packages("com.academia.placementhistory");
    }
}