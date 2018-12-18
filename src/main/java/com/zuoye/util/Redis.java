package com.zuoye.util;

import redis.clients.jedis.Jedis;

import java.util.Random;

public class Redis {
    public Jedis jedis = new Jedis("localhost");

    public void Record(String Phone, int Count) {
        // 存入redis
        jedis.set(Phone + "RE", String.valueOf(Count));
        jedis.expire(Phone + "RE", 120);
    }

    public boolean reRecord(String Phone) {
        String count = jedis.get(Phone + "RE");
        if (count == null || count.equals("")) {
            // 如果不存在就添加
            this.Record(Phone, 0);
            return true;
        }
        if (Integer.parseInt(count) < 3) {
            this.Record(Phone, Integer.parseInt(count) + 1);
            return true;
        } else {
            return false;
        }
    }
//    public void setCode(String Phone, String verifyCode) {
//        // 存入redis
//        if (jedis.get(Phone) == null || jedis.get(Phone) == "" || jedis.get(Phone).equals("")) {
//            jedis.set(Phone, verifyCode);
//            jedis.expire(Phone, 60);
//            System.out.println("new code:" + jedis.get(Phone));
//        }else{
//            System.out.println(verifyCode);
//            System.out.println("old code:"+ jedis.get(Phone));
//        }
//    }

    //    public String getCode(String Phone) {
//        String code = "123123213123";
//        if (jedis.get(Phone) != null ) {
//            code=jedis.get(Phone);
//        }
//        return code;
//    }
//
    public void setCode(String phone, String verifyCode) {
        jedis.set(phone, verifyCode);
        jedis.expire(phone, 60);
    }

    public void getCode(String phone) {
        // 存入redis
        String oldcode = jedis.get(phone);
        if (oldcode == null) {
            String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
            setCode(phone, verifyCode);
        }
        System.out.println(jedis.get(phone));
    }

    public boolean vaildCode(String phone, String verifyCode) {
        if (jedis.get(phone) == verifyCode || jedis.get(phone).equals(verifyCode)) {
            return true;
        } else {
            return false;
        }
    }
}
