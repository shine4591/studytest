package com.andy.myredis.subscribe;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class SubscribeTest {

    public static void main(String[] args) throws Exception {
        //把 服务器上的端口映射到本地，免去配置服务器上的防火墙
        //ssh -CNfL 16379:127.0.0.1:6379 xxx@xxx.xx.xx.xx -p xx -o ServerAliveInterval=60
        final JedisPubSub mysub = new JedisPubSub() {

            public void onMessage(String channel, String message) {
                System.out.println("channel from " + channel + ", message is " + message);
            }

            public void onSubscribe(String channel, int subscribedChannels) {
                System.out.println("onSubscribe channel from " + channel + ",subscribedChannels is " + subscribedChannels);
            }

            public void onUnsubscribe(String channel, int subscribedChannels) {
                System.out.println("onUnsubscribe channel from " + channel + ",subscribedChannels is " + subscribedChannels);
            }
        };
        new Thread() {
            @Override
            public void run() {
                Jedis jedis = null;
                try {
                    jedis = new Jedis("127.0.0.1", 16379);

                    jedis.subscribe(mysub, "hellochannel");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (jedis != null) jedis.close();
                }

            }
        }.start();


        new Thread() {
            @Override
            public void run() {
                try {
                    Jedis jedis = null;
                    try {
                        jedis = new Jedis("127.0.0.1", 16379);
                        Thread.sleep(1000);
                        jedis.publish("hellochannel", "firstMessage");
                        System.out.println("publish firstMessage");
                        Thread.sleep(1000);
                        jedis.publish("hellochannel", "secondMessage");
                        System.out.println("publish secondMessage");
                        Thread.sleep(1000);
                        jedis.publish("hellochannel", "thirdMessage");
                        System.out.println("publish thirdMessage");
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (jedis != null) jedis.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    try {
                        Thread.sleep(2500);
                        mysub.unsubscribe();
                        System.out.println("unsubscribe...");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }


}
