package com.course.testng;

import org.testng.annotations.Test;

/**
 * @Description: TestNG超时测试
 * @Author: zhangxiaochen
 * @CreateDate: 2018/7/12 17:45
 */
public class TimeOutTest {

    @Test(timeOut = 3000)
    public void testSuccess() throws InterruptedException{
        Thread.sleep(2000);
    }

    @Test(timeOut = 2000)
    public void testFailed () throws InterruptedException{
        Thread.sleep(3000);
    }
}
