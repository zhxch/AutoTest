package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * @Description: java类作用描述
 * @Author: zhangxiaochen
 * @CreateDate: 2018/7/5 15:53
 */
public class GroupsOnMethod {

    @Test(groups = "server")
    public void test1(){
        System.out.println("这是服务端组的测试方法test11111");
    }
    @Test(groups = "server")
    public void test2(){
        System.out.println("这是服务端组的测试方法test22222");
    }
    @Test(groups = "client")
    public void test3(){
        System.out.println("这是客户端组的测试方法test33333");
    }
    @Test(groups = "client")
    public void test4(){
        System.out.println("这是客户端组的测试方法test44444");
    }

    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("这是服务端组测试方法运行之前运行的方法...");
    }
    @AfterGroups("server")
    public void afterGroupsOnServer(){
        System.out.println("这是服务端组测试方法运行之前运行的方法...");
    }

    @BeforeGroups("client")
    public void beforeGroupsOnClient(){
        System.out.println("这是客户端组测试方法运行之前运行的方法...");
    }
    @AfterGroups("client")
    public void afterGroupsOnClient(){
        System.out.println("这是客户端组测试方法运行之前运行的方法...");
    }
}
