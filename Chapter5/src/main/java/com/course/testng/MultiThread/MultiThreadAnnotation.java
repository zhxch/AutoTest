package com.course.testng.MultiThread;

import org.testng.annotations.Test;

/**
 * @Description: TestNG多线程测试
 * @Author: zhangxiaochen
 * @CreateDate: 2018/7/12 17:15
 */
public class MultiThreadAnnotation {
    @Test(invocationCount = 10, threadPoolSize = 3)
    public void testMultiThread(){
        System.out.println(1);
        System.out.printf("Thread Id: %s%n", Thread.currentThread().getId());
    }
}
