package com.course.testng;

import org.testng.annotations.Test;

/**
 * @Description: 理解TestNG的忽略测试
 * @Author: zhangxiaochen
 * @CreateDate: 2018/7/12 16:53
 */
public class IgnoreTest {

    @Test
    public void ignoreTest1(){
        System.out.println("IgnoreTest1执行...");
    }

    /**
     * @Test(enabled = false)中的enabled = false 参数表示忽略执行
     */
    @Test(enabled = false)
    public void ignoreTest2(){
        System.out.println("IgnoreTest2执行...");
    }

}
