/*
package com.sjp.ddshop.jedis;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Set;

public class JedisTest {
    
    @Test
    public void testJedis1(){
        Jedis jedis = new Jedis("10.31.161.73",6379);
        jedis.set("bbq","qwerdf");
        System.out.println(jedis.get("bbq"));
        jedis.close();
    }
    @Test
    public void testJedis2(){
        //获取jedis池
        JedisPool jedisPool = new JedisPool("10.31.161.73",6379);
        //获取Jedis对象
        Jedis jedis = jedisPool.getResource();
        jedis.set("key1","value1");
        System.out.println(jedis.get("key1"));
        //关闭连接
        jedis.close();
        jedisPool.close();
    }
    @Test
    public void testJedis3(){
        //创建集群节点集合
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        //将6个节点加入到集合中
        nodes.add(new HostAndPort("10.31.161.73",9001));
        nodes.add(new HostAndPort("10.31.161.73",9002));
        nodes.add(new HostAndPort("10.31.161.73",9003));
        nodes.add(new HostAndPort("10.31.161.73",9004));
        nodes.add(new HostAndPort("10.31.161.73",9005));
        nodes.add(new HostAndPort("10.31.161.73",9006));
        //创建集群对象
        JedisCluster jedisCluster = new JedisCluster(nodes);
        //存入数据
        jedisCluster.set("key2","value2");
        System.out.println(jedisCluster.get("key2"));
        //关闭连接
        jedisCluster.close();
    }
    
}
*/
