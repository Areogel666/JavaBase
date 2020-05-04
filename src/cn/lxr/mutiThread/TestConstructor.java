package cn.lxr.mutiThread;

import org.junit.Ignore;
import org.junit.Test;

import java.util.stream.IntStream;

public class TestConstructor {

    @Test
    @Ignore
    public void test1() {
        IntStream.range(0, 6).boxed() //将数值流转化为Stream
                .map(i -> new Thread(() -> System.out.println(Thread.currentThread().getName())))
                .forEach(Thread::start);
    }

    @Test
    public void test2() {
        IntStream.range(0, 6).mapToObj(TestConstructor::createThreadName).forEach(Thread::start);
    }


    private static Thread createThreadName(int index) {
        return new Thread(() -> System.out.println(Thread.currentThread().getName())
                , "我的线程" + index);
    }
}
