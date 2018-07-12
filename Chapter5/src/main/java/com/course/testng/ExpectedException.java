package com.course.testng;

import org.testng.annotations.Test;

/**
 * @Description: java类作用描述
 * @Author: zhangxiaochen
 * @CreateDate: 2018/7/12 17:40
 */
public class ExpectedException {

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeException(){
        System.out.println("这是我的异常测试...");
        throw new RuntimeException();
    }
}
