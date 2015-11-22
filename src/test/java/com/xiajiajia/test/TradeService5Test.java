package com.xiajiajia.test;

import java.util.Random;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.cglib.transform.impl.AccessFieldTransformer.Callback;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doAnswer;
import com.xiajiajia.test.bean.TradeDetail;

public class TradeService5Test {
    @Test
    public void testGetPrice() {
        TradeDetail d = Mockito.mock(TradeDetail.class);
        Mockito.doAnswer(new Answer<String>() {
            public String answer(InvocationOnMock invocation) {
                String v1 = (String) invocation.getArguments()[0];
                String v2 = (String) invocation.getArguments()[1];
                System.out.println(v1 + v2);
                return v1 + v2;
            }
        }).when(d).getName("tom", "xu");
        d.getName("tom", "xu");
    }
    private Answer<String> reverseMsg() {
        return new Answer<String>() {
            public String answer(InvocationOnMock invocation) {
                String v1 = (String) invocation.getArguments()[0];
                return v1  ;
            }
        };
    }
    @Test
    public void testGetPrice2() {
        TradeDetail d = Mockito.mock(TradeDetail.class);
      Mockito.when (d .getTradeId()).thenAnswer(reverseMsg());
    }
}
