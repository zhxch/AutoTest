package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * @Description: java类作用描述
 * @Author: zhangxiaochen
 * @CreateDate: 2018/7/12 17:00
 */
@Test(groups = "student")
public class GroupsOnClass1 {

    public void student1(){
        System.out.println("GroupsOnClass1中的student1运行...");
    }

    public void student2(){
        System.out.println("GroupsOnClass1中的student2运行...");
    }
}
