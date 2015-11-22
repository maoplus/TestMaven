package powermock;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Computer.class)
@PowerMockIgnore({ "javax.xml.*", "org.xml.sax.*", "org.apache.xerces.*",
        "org.springframework.context.*", "org.apache.log4j.*",
        "org.w3c.dom.*" })
public class MockTest {
    
    @Mock(name = "coumputer")
    private Computer c1;
    @InjectMocks
    Demo             d1        = new Demo();
                               
    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    Demo             d2;
    String           testvalue = "hello";
                               
    @Before
    public void prepare() {
        // PowerMockito.when(c1.getName()).thenReturn("thinkpad");
    }
    
    @Test
    public void mytest() throws IOException {
        System.out.println(d1.getCoumputer().getName());
    }
    
    @Test
    public void nomock() throws IOException {
        System.out.println(c1.getCpu());
    }
    
    @Test
    public void subMethod() {
        PowerMockito.when(d2.getCoumputer().getName()).thenReturn("macbook");
        System.out.println(d2.getCoumputer().getName());
    }
    
    public void myteste() {
        Set<Field> mockFields = Whitebox.getAllInstanceFields(this);
    }
    
    @Test(expected = ArithmeticException.class)
    public void getexception() {
        Computer c = new Computer();
        c.getException();
    }
    
    @Test
    public void prtTest() {
        PowerMockito.suppress(PowerMockito.method(Computer.class, "prtParent"));
        Thinkpad p = new Thinkpad();
        p.prtChild();
    }
    
    @Test
    public void verifyZeroInteractionsTest() {
        
        System.out.println(null == c1.getName());
        System.out.println(c1.getName());
        
    }
    
    @Test
    public void niceMock() {
        
        System.out.println(c1.getHasSSD());
    }
}
