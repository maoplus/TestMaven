package com.xiajiajia.test.impl;

import com.xiajiajia.test.bean.TradeDetail;

public class TradeServiceImpl {
    private TradeDao dao;
    
    public String getTradeId() throws Exception {
        TradeDetail td = dao.getTradeDetail();
        String tradeId = td.getTradeId();
        if(tradeId.equals("123")){
            throw new Exception("can not equal 123");
        }
        return tradeId;
    }
}
