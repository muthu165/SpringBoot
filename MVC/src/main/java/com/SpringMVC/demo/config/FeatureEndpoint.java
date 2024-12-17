package com.SpringMVC.demo.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
//stereotype annotation
@Component
@Endpoint(id = "features")
public class FeatureEndpoint {
    private final Map<String,Feature> featureMap = new ConcurrentHashMap<>();

    public FeatureEndpoint() {
        featureMap.put("Department",new Feature(true));
        featureMap.put("User",new Feature(false));
        featureMap.put("Auth",new Feature(false));
    }
//    when we call feature return this featuremap
    @ReadOperation
    public Map<String, Feature> getAllfeature() {
        return featureMap;
    }
    @ReadOperation
    public Feature getfeature(@Selector String featureName) {
        return featureMap.get(featureName);
    }
//    @Selector to fetch and send {} similar to @pathvariable

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Feature {
        private boolean isEnabled;
    }
}
