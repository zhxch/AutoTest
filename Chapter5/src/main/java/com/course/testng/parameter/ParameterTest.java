package com.course.testng.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @Description: java类作用描述
 * @Author: zhangxiaochen
 * @CreateDate: 2018/7/12 17:53
 */
public class ParameterTest {

    @Test
    @Parameters({"name", "age"})
    public void paramTest1(String name, int age){
        System.out.println("name = " + name + ", age = " + age);
    }
}
