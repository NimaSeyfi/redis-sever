package com.redis.example.service.Impl;

import com.redis.example.dto.request.*;
import com.redis.example.dto.response.GeneralResponse;
import com.redis.example.service.RedisService;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

    @Override
    public GeneralResponse del(DelRequest request) {
        return null;
    }

    @Override
    public GeneralResponse exists(ExistsRequest request) {
        return null;
    }

    @Override
    public GeneralResponse expire(ExpireRequest request) {
        return null;
    }

    @Override
    public GeneralResponse getdel(GetdelRequest request) {
        return null;
    }

    @Override
    public GeneralResponse getex(GetexRequest request) {
        return null;
    }

    @Override
    public GeneralResponse get(GetRequest request) {
        return null;
    }

    @Override
    public GeneralResponse incrby(IncrByRequest request) {
        return null;
    }

    @Override
    public GeneralResponse incr(IncrRequest request) {
        return null;
    }

    @Override
    public GeneralResponse keys(KeysRequest request) {
        return null;
    }

    @Override
    public GeneralResponse select(SelectRequest request) {
        return null;
    }

    @Override
    public GeneralResponse set(SetRequest request) {
        return null;
    }

    @Override
    public GeneralResponse ttl(TtlRequest request) {
        return null;
    }

}
