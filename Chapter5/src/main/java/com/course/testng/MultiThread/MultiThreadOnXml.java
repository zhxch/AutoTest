package com.course.testng.MultiThread;

import org.testng.annotations.Test;

/**
 * @Description: java类作用描述
 * @Author: zhangxiaochen
 * @CreateDate: 2018/7/12 17:16
 */
public class MultiThreadOnXml {
    @Test
    public void test1(){
        System.out.printf("Thread Id: %s%n", Thread.currentThread().getId());
    }

    @Test
    public void test2(){
        System.out.printf("Thread Id: %s%n", Thread.currentThread().getId());
    }
    @Test
    public void test3(){
        System.out.printf("Thread Id: %s%n", Thread.currentThread().getId());
    }
}
