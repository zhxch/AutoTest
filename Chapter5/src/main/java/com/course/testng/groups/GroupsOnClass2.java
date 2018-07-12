package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * @Description: java类作用描述
 * @Author: zhangxiaochen
 * @CreateDate: 2018/7/12 17:09
 */
@Test(groups = "student")
public class GroupsOnClass2 {
    public void student1(){
        System.out.println("GroupsOnClass2中的student1运行...");
    }

    public void student2(){
        System.out.println("GroupsOnClass2中的student2运行...");
    }
}
