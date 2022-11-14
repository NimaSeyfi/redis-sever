package com.redis.example.config;

import com.redis.example.cache.CacheConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.redis.example.utils.functions;

@Configuration
public class AppConfig {

    @Value("${db.max.count}")
    private Integer DB_MAX_COUNT;

    @Value("${db.max.size}")
    private Integer DB_MAX_SIZE;

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.ALL));
        messageConverters.add(converter);
        messageConverters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
        restTemplate.setMessageConverters(messageConverters);
        return restTemplate;
    }

    @Bean
    public void loadCache(){
        CacheConfig.getInstance();
        functions.load_dbs(DB_MAX_COUNT, DB_MAX_SIZE);
    }

}