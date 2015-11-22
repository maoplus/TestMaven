package com.xiajiajia.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
class TradeValidator {
    public void validator(String request) throws Exception{
        if(null==request){
            throw new Exception("Request is null");
        }
        System.out.println("success");
    }
}
public class TradeService4Test {
  @Test
  public void shouldReturnRequestIsNull(){
      TradeValidator validator = new TradeValidator();
      try {
          validator.validator(null);
        fail("expect exception not occurred");//没有发生异常就报错
    } catch (Exception e) {
        assertEquals("Request is null",e.getMessage());
    }
  }
}
