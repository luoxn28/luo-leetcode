package com.luo.util;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.*;

/**
 * @author luoxiangnan
 * @date 2020-09-25
 */
public class ToStringUtilsTest {

    @Test
    public void toJSONString() throws ParseException {
        Model model = new Model();
        model.init();

        String json = ToStringUtils.toJSONString(model.toString());
        System.out.println("\n" + model.toString());
        System.out.println(json);

        Assert.assertEquals(JSON.parseObject(json, Model.class).toString(), model.toString());
        Assert.assertEquals(ToStringUtils.toObject(model.toString(), Model.class).toString(), model.toString());
    }

    @Data
    static class Base {
        private String aaa;

        public void init() {
            aaa = "aaa";
        }
    }

    @Data
    @ToString(callSuper = true)
    static class Model extends Base {
        private char char1;
        private Character char2;
        private short short1;
        private Short short2;
        private int int1;
        private Integer int2;
        private long long1;
        private Long long2;
        private float float1;
        private Float float2;
        private double double1;
        private Double double2;
        private Date date;

        private Person person;

        private int[] intArray;
        private List<Integer> intList;
        private List<Integer> intList2;
        private List<Person> intList3;
        private Set<Integer> intSet;
        private Set<List<Integer>> intListSet;
        private Map<String, String> stringMap;
        private Map<String, Person> objectMap;
        private Map<String, List<Person>> objectPersonMap;

        private Map<Person, Person> objectKeyPersonMap;

        public void init() {
            super.init();

            char1 = 'c';
            char2 = 'c';
            short1 = 0;
            short2 = 0;
            int1 = 1;
            int2 = 1;
            long1 = 2;
            long2 = 2L;
            float1 = -3.0f;
            float2 = 3.0f;
            double1 = -4.0;
            double2 = 4.0;
            date = DateUtils.setMilliseconds(new Date(), 0);

            person = new Person().init();

            intArray = new int[]{1, 2, 3};
            intList = Arrays.asList(1, 2, 3);
            intList2 = new ArrayList<>();
            intList3 = Arrays.asList(new Person().init(), new Person().init());
            intSet = new HashSet<>(Arrays.asList(1, 2, 3));
            intListSet = new HashSet<>();
            intListSet.add(Arrays.asList(1, 2, 3));
            stringMap = new HashMap<>();
            stringMap.put("name", "李四");
            objectMap = new HashMap<>();
            objectMap.put("data1", new Person());
            objectMap.put("data2", new Person());
            objectPersonMap = new HashMap<>();
            objectPersonMap.put("list1", Arrays.asList(new Person().init(), new Person().init()));

            objectKeyPersonMap = new HashMap<>();
            objectKeyPersonMap.put(new Person().init(), new Person().init());
        }
    }

    @Data
    static class Person {
        private int age;
        private String name;

        public Person init() {
            age = 1;
            name = "张三";
            return this;
        }
    }
}
