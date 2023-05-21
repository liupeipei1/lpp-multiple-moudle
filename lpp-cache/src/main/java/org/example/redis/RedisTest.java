package org.example.redis;

import org.example.util.GetBeanUtil;
import org.example.util.RedisCommonUtil;

import java.util.HashMap;
import java.util.Map;

public class RedisTest {
    public static void main(String[] args) {

        GetBeanUtil getBeanUtil =new GetBeanUtil();
        RedisCommonUtil redisCommonUtil= (RedisCommonUtil) getBeanUtil.getBeanByAnnotation("redisCommonUtil");
        System.out.printf("connect:"+ redisCommonUtil.ping());
        System.out.printf("\r"+redisCommonUtil.getStringKey("String-name"));
        //设置redis string 类型
        redisCommonUtil.setString("name","wangquan1");
        //hash类型
        Map<String, String> map=new HashMap<>();
        map.put("柳智宇","29");
        redisCommonUtil.setHash("Hash-roster",map);
        //list 允许重复的数据产生
      //  redisCommonUtil.setListLeft("list-course","history","chemistry","physical");
        redisCommonUtil.removeListLeftKey("list-course");
        System.out.printf("List:"+ redisCommonUtil.getList("list-course"));
        System.out.println("***********向redis中添加zset数据***********");
        //向redis中添加zset数据
        Map<String, Double> scoreMembers =new HashMap<>();
        scoreMembers.put("柳智宇",50d);
        Long zAdd1 = redisCommonUtil.setZSet("Zset-排行榜", scoreMembers);
        System.out.println("添加zset数据：" + redisCommonUtil.getZSet("Set-student"));


    }
}
