package com.redis.example.cache;

import com.redis.example.utils.AsyncFunctions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.redis.example.utils.functions;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Configuration
@Component
@ComponentScan({"com.redis.example", "com.redis.example.cache"})
public class CacheConfig implements Serializable {

    private static final Logger logger = LogManager.getLogger(CacheConfig.class);

    public static CacheConfig instance;

    public Integer getSelectedDb() {
        return selectedDb;
    }

    private Integer selectedDb;

    //TODO: read from env
    private static String configPath = "CacheConfig.conf";

    public CacheConfig(){

        instance = load_config_from_file();

    }

    private CacheConfig(Integer selectedDb){

        this.selectedDb = selectedDb;

    }

    public static void changeSelectedDb(Integer db){
        instance.selectedDb = db;
        AsyncFunctions asyncFunctions = new AsyncFunctions();
        try {
            asyncFunctions.save_object_on_path_async(configPath, instance);
        } catch (Exception e){
            logger.error(e);
            logger.debug("error when writing cache config file to this path : "+configPath);
        }
    }

    public static CacheConfig getInstance() {
        if (instance == null)
            instance = new CacheConfig();
        return instance;
    }


    private CacheConfig load_config_from_file(){
        CacheConfig cacheConfig = (CacheConfig) functions.read_object_from_file(configPath);
        if (cacheConfig == null){
            cacheConfig = new CacheConfig(0);
            try {
                functions.save_object_on_path(configPath, cacheConfig);
            } catch (Exception e){
                logger.error(e);
                logger.debug("error when writing cache config file to this path : "+configPath);
            }
        }
        return cacheConfig;
    }
}
