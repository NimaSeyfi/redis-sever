package com.redis.example.utils;

import com.redis.example.cache.LRUCache;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

public class functions {

    private static final Logger logger = LogManager.getLogger(functions.class);

    public static Object read_object_from_file(String filepath) {

        try {

            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            objectIn.close();
            return obj;

        } catch (Exception ex) {
            logger.debug("error when reading file from : "+filepath);
            logger.error(ex);
            return null;
        }
    }

    public static void save_object_on_path(String filepath,Object serObj) {

        try {
            File file = new File(filepath);
            file.createNewFile();
            FileOutputStream fileOut = new FileOutputStream(file, false);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            logger.info("object saved : "+filepath);

        } catch (Exception ex) {
            logger.debug("saving object to a file failed : "+filepath);
            logger.error(ex);
        }
    }

    public static void load_dbs(Integer count, Integer max_size){

        for (int i = 0; i <= count; i++){
            LRUCache cache = (LRUCache) functions.read_object_from_file("db"+i);
            if (cache == null)
                cache = new LRUCache(max_size);
            LRUCache.getCaches().put(i, cache);
        }


    }

}
