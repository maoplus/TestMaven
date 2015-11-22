package com.xiajiajia.test.impl;

import com.xiajiajia.test.bean.TradeDetail;

public class TradeDao {
    public TradeDetail getTradeDetail() {
        TradeDetail tradeDetail = new TradeDetail();
        tradeDetail.setTradeId("123456");
        return tradeDetail;
    }
}
