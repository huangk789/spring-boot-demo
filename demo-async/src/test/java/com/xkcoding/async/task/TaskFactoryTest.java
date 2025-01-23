package com.xkcoding.async.task;

import com.xkcoding.async.SpringBootDemoAsyncApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * <p>
 * 测试任务
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-12-29 10:49
 */
@Slf4j
public class TaskFactoryTest extends SpringBootDemoAsyncApplicationTests {
    @Autowired
    private TaskFactory task;

    /**
     * 测试异步任务
     */
    @Test
    public void asyncTaskTest() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        Future<String> asyncTask1 = task.asyncTask1();
        Future<String> asyncTask2 = task.asyncTask2();
        Future<String> asyncTask3 = task.asyncTask3();

        // 调用 get() 阻塞主线程
        String r1=   asyncTask1.get();
        log.info("r1={}",r1);
        String r2=    asyncTask2.get();
        log.info("r2={}",r2);
        String r3=   asyncTask3.get();
        log.info("r3={}",r3);
        long end = System.currentTimeMillis();

        log.info("异步任务全部执行结束，总耗时：{} 毫秒", (end - start));
    }

    /**
     * 测试同步任务
     */
    @Test
    public void taskTest() throws InterruptedException {
        long start = System.currentTimeMillis();
        String r1=   task.task1();
        String r2=   task.task2();
        String r3=   task.task3();
        long end = System.currentTimeMillis();

        log.info("同步任务全部执行结束，总耗时：{} 毫秒", (end - start));
    }
}
