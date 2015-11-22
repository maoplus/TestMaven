package guava;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multiset;

import junit.framework.Assert;

public class GuavaTest {
    @Test
    public void anymathsTest() {
        List<MyApple> al = Arrays.asList(new MyApple(1, "red", "shanghai"),
                new MyApple(2, "yello", "dongjing"),
                new MyApple(3, "gray", "niuyue"),
                new MyApple(4, "blue", "shandong"),
                new MyApple(5, "green", "henan"));
                
        boolean isRed = Iterables.any(al, new Predicate<MyApple>() {
            @Override
            public boolean apply(MyApple input) {
                return input.getColor().equals("red");
            }
        });
        Assert.assertTrue(isRed);
    }
    
    @Test
    public void getname() {
        getFullName(".");
        getFullName(".", "a", null, "", "c");
        getFullName(" *", null, null, "c");
        getFullName("#", null, "", null, "c", "b");
    }
    
    public void getFullName(String connector, String... name) {
        if (null == name || 0 == name.length) {
            return;
        }
        String fullName = Joiner.on(connector).join(
                Iterables.filter(Arrays.asList(name), new Predicate<String>() {
                    @Override
                    public boolean apply(String p) {
                        return !Strings.isNullOrEmpty(p);
                    }
                }));
        System.out.println(fullName);
    }
    
    @Test
    public void multisetTest() {
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("123");
        multiset.add("123");
        multiset.add("123");
        multiset.add("1234");
        System.out.println(multiset.count("123"));
        System.out.println(multiset);
    }
}
