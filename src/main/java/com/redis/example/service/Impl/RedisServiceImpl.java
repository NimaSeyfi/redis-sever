package com.redis.example.service.Impl;

import com.redis.example.cache.CacheConfig;
import com.redis.example.cache.CacheData;
import com.redis.example.cache.LRUCache;
import com.redis.example.dto.request.*;
import com.redis.example.dto.response.GeneralResponse;
import com.redis.example.exception.ApiError;
import com.redis.example.exception.ErrorObject;
import com.redis.example.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisServiceImpl implements RedisService {

    CacheConfig cacheConfig = CacheConfig.getInstance();

    @Override
    public GeneralResponse del(List<String> keys) {
        Integer selected_db = cacheConfig.getSelectedDb();
        LRUCache cache = LRUCache.getCaches().get(selected_db);
        Integer count = 0;
        for (String key:
                keys) {
            if(cache.get(key) != null) {
                count++;
            }
        }
        GeneralResponse response = new GeneralResponse(false, count, 10200000);
        return response;
    }

    @Override
    public GeneralResponse exists(List<String> keys) {
        Integer selected_db = cacheConfig.getSelectedDb();
        LRUCache cache = LRUCache.getCaches().get(selected_db);
        Integer count = 0;
        for (String key:
             keys) {
            if(cache.get(key) != null)
                count++;
        }
        GeneralResponse response = new GeneralResponse(false, count, 10200000);
        return response;
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
    public GeneralResponse get(String key) {
        Integer selected_db = cacheConfig.getSelectedDb();
        LRUCache cache = LRUCache.getCaches().get(selected_db);
        String value = "(nil)";
        CacheData data = (CacheData) cache.get(key);
        if(data==null){
            throw new ApiError(ErrorObject.RESOURCE_NOT_FOUND);
        }
        value = data.getValue();
        GeneralResponse response = new GeneralResponse(false, value, 10200000);
        return response;
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
        Integer selected_db = cacheConfig.getSelectedDb();
        if(request.getDb() != selected_db){
            CacheConfig.changeSelectedDb(request.getDb());
        }
        GeneralResponse response = new GeneralResponse(false, "ok", 10200000);
        return response;

    }

    @Override
    public GeneralResponse set(SetRequest request) {
        Integer selected_db = cacheConfig.getSelectedDb();
        LRUCache cache = LRUCache.getCaches().get(selected_db);
        CacheData data = new CacheData(request.getValue(), null);
        cache.put(request.getKey(), data);
        GeneralResponse response = new GeneralResponse(false, "ok", 10200000);
        return response;
    }

    @Override
    public GeneralResponse ttl(TtlRequest request) {
        return null;
    }

}
