package org.example.util;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.args.ListPosition;

import java.util.List;
import java.util.Map;

/*
 用于redis 客户端调用工具包
 */
@Service
public class RedisCommonUtil {

    private Jedis jedis;

    //如果redis在配置文件里面设置了密码，这里java调用也是需要密码的
    public RedisCommonUtil(){
         jedis = new Jedis("127.0.0.1", 6379);
        jedis.auth("foobared");
    }
    public String ping(){
       return jedis.ping();
    }

    //设置String类型
    public void  setString(String key, String value){
        jedis.set(key,value);
    }
    //获取String类型
    public String  getStringKey(String key){
       return jedis.get(key);
    }

    //设置hash类型  hash名字+  hash内部key+value
    //对某一个hash进行插入数据
    public void  setHash(String name, Map<String, String> hash) {
        jedis.hmset(name, hash);
    }
    public List<String> getHash(String name) {
        return  jedis.hmget(name);
    }
    //设置list类型  key+ string .... name
    public List<String> getList(String name) {
        return  jedis.lrange(name,0,jedis.llen(name));
    }

    //从redis 队头部插入   新数据  +老数据  新数据里类似队列，先进的值row在后面，后进的值row是1
    public void  setListLeft(String key,String ...values) {
        jedis.lpush(key,values);
    }

    //从redis 队尾部插入  老数据+新数据   新数据是按照list（插入顺序对应，比如位置是第一位，那么插入的也是第一位 row也是1）
    public void  setListRight(String key,String ...values) {
        jedis.rpush(key,values);
    }
  // 在给指定数据后面插入数据
    public void  setListLast(String key,String position,String value) {
    jedis.linsert(key, ListPosition.AFTER, position,value);
    }

    // 在给定数据前面插入数据
    public void  setListBefore(String key,String position,String value) {
        jedis.linsert(key, ListPosition.BEFORE, position,value);
    }


    //list右边删除数据
   // Atomically return and remove the first (LPOP) or last (RPOP) element of the list.
    // For example if the list contains the elements "a","b","c" LPOP will return "a" and the list will
    // become "b","c".
    public void removeListLeftKey(String key) {
        jedis.lpop(key);
    }

    public void removeListRightKey(String key) {
        jedis.rpop(key);
    }

    //Zset插入  排行榜  如果没有key的，会重新新建一个
    public long setZSet(String key, Map<String, Double> scoreMembers) {
       return jedis.zadd(key,scoreMembers);
    }

    public long getZsetLen(String key){
       return jedis.zcard(key);
    }
    public List<String> getZSet(String key) {
        return   jedis.lrange(key,0,jedis.llen(key));
    }

    //set  add
    public void sadd(String key,String... value) {
           jedis.sadd(key,value);
    }

    public void getSet(String key,String... value) {
           jedis.lrange(key,0,jedis.llen(key));
    }

}
