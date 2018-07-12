package com.course.testng;

import org.testng.annotations.*;

/**
 * @Description: TestNG基本注解
 * @Author: zhangxiaochen
 * @CreateDate: 2018/7/12 11:40
 */
public class BasicAnnotation {

    //在每个测试方法执行之前都会执行
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod:在测试方法执行之前运行...");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("BeforeMethod:在测试方法执行之后运行...");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("BeforeClass:在该类执行之前运行...");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass:在该类执行之后运行...");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite:测试套件...");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite:测试套件...");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest:测试执行之前运行...");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest:测试执行之后运行...");
    }

    @Test
    public void testCase1(){
        System.out.println("Test:这是测试用例1...");
    }

    @Test
    public void testCase2(){
        System.out.println("Test:这是测试用例1...");
    }

}
