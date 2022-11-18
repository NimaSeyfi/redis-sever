package com.redis.example.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class AsyncFunctions {

    private static final Logger logger = LogManager.getLogger(functions.class);

    @Async
    public void save_object_on_path_async(String filepath, Object serObj) {

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

}
