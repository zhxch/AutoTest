package com.course.testng;

import org.testng.annotations.Test;

/**
 * @Description: 依赖测试：test2依赖test1，如果test1执行成功，继续执行test2；如果test1执行失败，不执行test2
 * @Author: zhangxiaochen
 * @CreateDate: 2018/7/12 17:42
 */
public class DependTest {

    @Test
    public void test1(){
        System.out.println("test1 run");
        throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2 run");
    }
}
