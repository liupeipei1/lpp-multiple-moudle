package org.example.jvm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
  测试cacheable注解的缓存是否有用
 */

@Slf4j
@RestController
@RequestMapping("/jvm")
public class CommonCacheManageController {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private Environment environment;


    //测试缓存insert
    @Cacheable(value = "cacheSomething", key = "#inPara")
    @GetMapping(value = "/cacheSomething")
    public ResponseEntity<?> cacheSomething(String inPara){
        try {

            System.out.printf("111----server:"+ environment.getProperty("spring.application.name")+"--method:cacheSomething");
            ResponseEntity<?> cacheValue= (ResponseEntity<?>) cacheManager.getCache("cacheSomething").get(inPara);
            ifExistInCaChe(cacheValue);
            ResponseEntity<?> responseEntity=new ResponseEntity<>(cacheValue,HttpStatus.OK);
            return  responseEntity;
        } catch (Exception e) {
            //log.error("cache has some errors  e:"+ e);
            return new ResponseEntity<>(inPara,HttpStatus.GONE);

        }
    }

    //测试缓存失效

    @CacheEvict(value = "cacheSomething", key = "#inPara")
    @GetMapping(value = "/evictCacheSomething")
    public ResponseEntity<?> cacheEvictSomething(String inPara){
        try {
            System.out.printf("222----"+environment.getProperty("spring.application.name")+"--method:cacheEvictSomething");
            ResponseEntity<?> cacheValue= (ResponseEntity<?>) cacheManager.getCache("cacheSomething").get(inPara);
            ifExistInCaChe(cacheValue);
            ResponseEntity<?> responseEntity=new ResponseEntity<>(cacheValue,HttpStatus.OK);
            return  responseEntity;
        } catch (Exception e) {
            //log.error("cache has some errors  e:"+ e);
            return new ResponseEntity<>(inPara,HttpStatus.GONE);

        }
    }

    private void ifExistInCaChe(ResponseEntity<?> cacheValue) {
        if(null== cacheValue || cacheValue.equals("")|| cacheValue.equals("null")){
            System.out.printf("\r cache:"+ cacheValue +" has been removed already.");
        }else{
            System.out.printf("\n cache:"+ cacheValue +" existed.");
        }
    }


}
