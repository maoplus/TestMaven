package com.xiajiajia.test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.xiajiajia.mutiplethread.MultiThreadedRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;
import com.xiajiajia.test.bean.TradeDetail;
import com.xiajiajia.test.impl.TradeDao;
import com.xiajiajia.test.impl.TradeServiceImpl;
@RunWith(MultiThreadedRunner.class)
public class TradeServiceTwoTest {
    private   TradeDetail      td;
    @Mock
    private   TradeDao         dao;
    @InjectMocks
    private   TradeServiceImpl tradeService = new TradeServiceImpl();
    
    @BeforeClass
    public static void beforeClassSetUp() {
       
    }
    @Before
    public void beforeSetUp() {
        MockitoAnnotations.initMocks(this);
        createTradeDetail();
        td.setTradeId("456");
        when(dao.getTradeDetail()).thenReturn(createTradeDetail());
    }
    
    public   TradeDetail createTradeDetail() {
        if (null != td) {
            return td;
        }
        td = new TradeDetail();
        td.setTradeId("456");
        return td;
    }
    
    @Test
    public void testGetDetail1() {
        try {
            assertEquals("456", tradeService.getTradeId());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testGetDetail2() {
        td.setTradeId("123");
        try {
            tradeService.getTradeId();
        } catch (Exception e) {
            assertEquals("can not equal 123", e.getMessage());
        }
        
    }
    
    @Test
    public void testGetDetail3() {
        td.setTradeId("444");
        try {
            assertEquals("444", tradeService.getTradeId());
        } catch (Exception e) {
            fail(e.getMessage());
        }
        
    }
    
    @Test
    public void testGetDetail4() {
        td.setTradeId("999");
        try {
            assertEquals("999", tradeService.getTradeId());
        } catch (Exception e) {
            fail(e.getMessage());
        }
        
    }
    
    @Test
    public void testGetDetail5() {
        td.setTradeId("zzz");
        try {
            assertEquals("zzz", tradeService.getTradeId());
        } catch (Exception e) {
            fail(e.getMessage());
        }
        
    }
}
