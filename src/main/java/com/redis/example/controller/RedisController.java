package com.redis.example.controller;

import com.redis.example.dto.request.*;
import com.redis.example.dto.response.GeneralResponse;
import com.redis.example.service.RedisService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;


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

    @PostMapping("/get")
    public ResponseEntity<GeneralResponse> get(@Valid @RequestBody GetRequest request)
            throws Exception {
        logger.info("Request for get : "+request.toString());
        GeneralResponse generalResponse = redisService.get(request);
        logger.info("Response : "+ generalResponse.toString());
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }

    @PostMapping("/del")
    public ResponseEntity<GeneralResponse> del(@Valid @RequestBody DelRequest request)
            throws Exception {
        logger.info("Request for del : "+request.toString());
        GeneralResponse generalResponse = redisService.del(request);
        logger.info("Response : "+ generalResponse.toString());
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }

    @PostMapping("/exists")
    public ResponseEntity<GeneralResponse> exists(@Valid @RequestBody ExistsRequest request)
            throws Exception {
        logger.info("Request for exists : "+request.toString());
        GeneralResponse generalResponse = redisService.exists(request);
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
