package com.xiajiajia.test;

import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import com.xiajiajia.test.bean.TradeDetail;

public class TestWhileTrue {
    private TradeDetail trade = new TradeDetail();
    @Rule
    public Timeout      t     = new Timeout(2, TimeUnit.SECONDS);
                              
    @Test
    public void mytest() {
        trade.checkDB();
    }
}
