package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * @Description: java类作用描述
 * @Author: zhangxiaochen
 * @CreateDate: 2018/7/12 17:10
 */
@Test(groups = "teacher")
public class GroupsOnClass3 {
    public void teacher1(){
        System.out.println("GroupsOnClass3中的teacher1运行...");
    }

    public void teacher2(){
        System.out.println("GroupsOnClass3中的teacher2运行...");
    }
}
