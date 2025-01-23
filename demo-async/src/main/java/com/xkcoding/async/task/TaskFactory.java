package com.xkcoding.async.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 任务工厂
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-12-29 10:37
 */
@Component
@Slf4j
public class TaskFactory {

    /**
     * 模拟5秒的异步任务
     */
    @Async
    public Future<String> asyncTask1() throws InterruptedException {
        String result = doTask("asyncTask1", 5);
        return new AsyncResult<>(result);
    }

    /**
     * 模拟2秒的异步任务
     */
    @Async
    public Future<String> asyncTask2() throws InterruptedException {
        String result = doTask("asyncTask2", 2);
        return new AsyncResult<>(result);
    }

    /**
     * 模拟3秒的异步任务
     */
    @Async
    public Future<String> asyncTask3() throws InterruptedException {
        String result = doTask("asyncTask3", 3);
        return new AsyncResult<>(result);
    }

    /**
     * 模拟5秒的同步任务
     */
    public String task1() throws InterruptedException {
        return  doTask("task1", 5);
    }

    /**
     * 模拟2秒的同步任务
     */
    public String task2() throws InterruptedException {
       return doTask("task2", 2);
    }

    /**
     * 模拟3秒的同步任务
     */
    public String task3() throws InterruptedException {
        return doTask("task3", 3);
    }

    private String doTask(String taskName, Integer time) throws InterruptedException {
        log.info("{}开始执行，当前线程名称【{}】", taskName, Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(time);
        log.info("{}执行成功，当前线程名称【{}】", taskName, Thread.currentThread().getName());
        LocalDateTime now = LocalDateTime.now();
        // 格式化输出
        String formatted = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return formatted;
    }
}
