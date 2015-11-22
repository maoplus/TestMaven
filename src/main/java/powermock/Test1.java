package powermock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

public class Test1 {
    public void looptest() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("loop again");
        }
    }
    
    public void threadUtil(Runnable run) throws InterruptedException {
        ExecutorService executorService = Executors
                .newSingleThreadScheduledExecutor();
        executorService.execute(run);
        executorService.shutdown();
        boolean isTimeOut = executorService.awaitTermination(3,
                TimeUnit.SECONDS);
        Assert.assertTrue("time out,maybe calling in an endless loop",
                isTimeOut);
    }
    
    @Test
    public void avoidInfiniteloop() throws InterruptedException {
        Runnable run = () -> {
            looptest();
        };
        threadUtil(run);
    }
}