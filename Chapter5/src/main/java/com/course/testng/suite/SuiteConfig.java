package com.course.testng.suite;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 * @Description: 测试主要的Test下面的方法，测试套件之前需要运行的资，公有资源
 * @Author: zhangxiaochen
 * @CreateDate: 2018/7/5 14:46
 */
public class SuiteConfig {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suit 运行啦...");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After suite 运行啦...");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest:测试执行之前运行...");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest:测试执行之后运行...");
    }
}