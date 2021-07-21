package com.example.chapter3.homework;

import java.util.ArrayList;
import java.util.List;

public class TestDataSet {

    public static List<TestData> getData() {
        List<TestData> result = new ArrayList();
        result.add(new TestData("你好", "刚刚", "杨特"));
        result.add(new TestData("你好呀", "21:30", "王树红"));
        result.add(new TestData("哈哈哈", "19:20","楼sir"));
        result.add(new TestData("aaa", "17:35","吴朝晖"));
        result.add(new TestData("hhh", "12:03","人少波"));
        result.add(new TestData("ddd", "19:01","习大大"));
        result.add(new TestData("wwww", "10:09","特朗普"));
        result.add(new TestData("我不好", "10:23","普京"));
        result.add(new TestData("test", "15:19","Axe"));
        result.add(new TestData("test2", "19:52","Jane"));
        result.add(new TestData("测试文本", "9:19","Grace"));
        return result;
    }

}
