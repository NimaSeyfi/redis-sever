package com.redis.example.service;

import com.redis.example.dto.request.*;
import com.redis.example.dto.response.GeneralResponse;

public interface RedisService {

    GeneralResponse del(DelRequest request);
    GeneralResponse exists(ExistsRequest request);
    GeneralResponse expire(ExpireRequest request);
    GeneralResponse getdel(GetdelRequest request);
    GeneralResponse getex(GetexRequest request);
    GeneralResponse get(GetRequest request);
    GeneralResponse incrby(IncrByRequest request);
    GeneralResponse incr(IncrRequest request);
    GeneralResponse keys(KeysRequest request);
    GeneralResponse select(SelectRequest request);
    GeneralResponse set(SetRequest request);
    GeneralResponse ttl(TtlRequest request);

}
