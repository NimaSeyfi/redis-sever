package com.redis.example.controller;

import com.redis.example.dto.request.*;
import com.redis.example.dto.response.GeneralResponse;
import com.redis.example.service.RedisService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;


@RestController
public class RedisController {

    private static final Logger logger = LogManager.getLogger(RestController.class);

    @Autowired
    private RedisService redisService;

    @PostMapping("/select")
    public ResponseEntity<GeneralResponse> select(@Valid @RequestBody SelectRequest request)
            throws Exception {
        logger.info("Request for selecting a db : "+request.toString());
        GeneralResponse generalResponse = redisService.select(request);
        logger.info("Response : "+ generalResponse.toString());
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }

    @PostMapping("/set")
    public ResponseEntity<GeneralResponse> set(@Valid @RequestBody SetRequest request)
            throws Exception {
        logger.info("Request for set : "+request.toString());
        GeneralResponse generalResponse = redisService.set(request);
        logger.info("Response : "+ generalResponse.toString());
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }

    @PostMapping("/expire")
    public ResponseEntity<GeneralResponse> expire(@Valid @RequestBody ExpireRequest request)
            throws Exception {
        logger.info("Request for expire : "+request.toString());
        GeneralResponse generalResponse = redisService.expire(request);
        logger.info("Response : "+ generalResponse.toString());
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<GeneralResponse> get(@Size(min = 1, max = 500, message = "key content size should fit in 1 to 500 characters")
                                                   @NotNull(message = "key can't be null")
                                                   @NotBlank(message = "key can't be blank")
                                                   @NotEmpty(message = "key can't be empty")
                                                   @RequestParam String key)
            throws Exception {
        logger.info("Request for get : "+key);
        GeneralResponse generalResponse = redisService.get(key);
        logger.info("Response : "+ generalResponse.toString());
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }

    @PostMapping("/del")
    public ResponseEntity<GeneralResponse> del(@Valid @RequestParam("key")List<String> keys)
            throws Exception {
        logger.info("Request for del : "+keys.toString());
        GeneralResponse generalResponse = redisService.del(keys);
        logger.info("Response : "+ generalResponse.toString());
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }

    @GetMapping("/exists")
    public ResponseEntity<GeneralResponse> exists(@Valid @RequestParam("key")List<String> keys)
            throws Exception {
        logger.info("Request for exists : "+keys.toString());
        GeneralResponse generalResponse = redisService.exists(keys);
        logger.info("Response : "+ generalResponse.toString());
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }

    @PostMapping("/ttl")
    public ResponseEntity<GeneralResponse> ttl(@Valid @RequestBody TtlRequest request)
            throws Exception {
        logger.info("Request for ttl : "+request.toString());
        GeneralResponse generalResponse = redisService.ttl(request);
        logger.info("Response : "+ generalResponse.toString());
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }

    @PostMapping("/incr")
    public ResponseEntity<GeneralResponse> ttl(@Valid @RequestBody IncrRequest request)
            throws Exception {
        logger.info("Request for incr : "+request.toString());
        GeneralResponse generalResponse = redisService.incr(request);
        logger.info("Response : "+ generalResponse.toString());
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }

    @PostMapping("/incrby")
    public ResponseEntity<GeneralResponse> incrby(@Valid @RequestBody IncrByRequest request)
            throws Exception {
        logger.info("Request for incrby : "+request.toString());
        GeneralResponse generalResponse = redisService.incrby(request);
        logger.info("Response : "+ generalResponse.toString());
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }

    @PostMapping("/getex")
    public ResponseEntity<GeneralResponse> getex(@Valid @RequestBody GetexRequest request)
            throws Exception {
        logger.info("Request for getex : "+request.toString());
        GeneralResponse generalResponse = redisService.getex(request);
        logger.info("Response : "+ generalResponse.toString());
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }

    @PostMapping("/getdel")
    public ResponseEntity<GeneralResponse> getdel(@Valid @RequestBody GetdelRequest request)
            throws Exception {
        logger.info("Request for getdel : "+request.toString());
        GeneralResponse generalResponse = redisService.getdel(request);
        logger.info("Response : "+ generalResponse.toString());
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }

    @PostMapping("/keys")
    public ResponseEntity<GeneralResponse> keys(@Valid @RequestBody KeysRequest request)
            throws Exception {
        logger.info("Request for keys : "+request.toString());
        GeneralResponse generalResponse = redisService.keys(request);
        logger.info("Response : "+ generalResponse.toString());
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }
}
