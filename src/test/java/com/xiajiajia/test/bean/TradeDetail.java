package com.xiajiajia.test.bean;

import java.util.Random;

public class TradeDetail {
    private String tradeId;
    
    public String getTradeId() {
        return tradeId;
    }
    
    public void setTradeId(String tradeId) {
        System.out.println("set trade");
        this.tradeId = tradeId;
    }
    
    public void getName(String a, String b) {
        System.out.println(a + "." + b);
    }
    
    private String generateString() {
        Random ran = new Random();
        String value = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder ss = new StringBuilder();
        final int len = value.length();
        for (int i = 0; i < 10; i++) {
            ss.append(value.charAt(ran.nextInt(len)));
        }
        return ss.toString();
    }
    
    public void checkDB() {
        int count = 0;
        while (true) {
            count++;
            try {
                System.out.println(count);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
