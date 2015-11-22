package com.xiajiajia.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.xiajiajia.test.bean.TradeDetail;
import com.xiajiajia.test.impl.TradeDao;
import com.xiajiajia.test.impl.TradeServiceImpl;

@RunWith(Parameterized.class)
public class TradeServiceThreeTest {
    private static TradeDetail expectTradeDetail;
    @Mock
    private TradeDao           dao;
    @InjectMocks
    private TradeServiceImpl   tradeService = new TradeServiceImpl();
                                            
    private static TradeDetail withTradeId(final String tradeId) {
        createTradeDetail().setTradeId(tradeId);
        return expectTradeDetail;
    }
    
    @Parameters
    public static Collection<TradeDetail> data() {
        return Arrays.asList(withTradeId("1234"), withTradeId("456"));
    }
    
    public TradeServiceThreeTest(TradeDetail td) {
        this.expectTradeDetail = td;
    }
    
    @Before
    public void beforeSetUp() {
        System.out.println("enter before");
        MockitoAnnotations.initMocks(this);
        when(dao.getTradeDetail()).thenReturn(expectTradeDetail);
    }
    
    public static TradeDetail createTradeDetail() {
        expectTradeDetail = new TradeDetail();
        return expectTradeDetail;
    }
    
    @Test
    public void testGetDetail1() {
        try {
            assertEquals(expectTradeDetail.getTradeId(),
                    tradeService.getTradeId());
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
    
}
