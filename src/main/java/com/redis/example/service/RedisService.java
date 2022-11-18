package com.redis.example.service;

import com.redis.example.dto.request.*;
import com.redis.example.dto.response.GeneralResponse;

import java.util.List;

public interface RedisService {

    GeneralResponse del(List<String> keys);
    GeneralResponse exists(List<String> keys);
    GeneralResponse expire(ExpireRequest request);
    GeneralResponse getdel(GetdelRequest request);
    GeneralResponse getex(GetexRequest request);
    GeneralResponse get(String key);
    GeneralResponse incrby(IncrByRequest request);
    GeneralResponse incr(IncrRequest request);
    GeneralResponse keys(KeysRequest request);
    GeneralResponse select(SelectRequest request);
    GeneralResponse set(SetRequest request);
    GeneralResponse ttl(TtlRequest request);

}
