package com.yh.demo.dp.base;

import java.lang.reflect.Method;

/**
 * Created by yh on 2017/6/21.
 * reflection机制测试demo
 * 1.通过反射获取class对象，达到动态加载类的目的
 * 2.判断对象是不是某个类的实例
 * 3.创建具体对象
 * 4.获取某个类的方法集合
 * 5.获取某个类的构造器信息
 * 6.获取某个类的成员变量信息
 * 7.通过invoke调用方法
 * 8.通过反射创建数组
 *
 * 问题
 * Class这个类的实例是什么，代表什么含义
 * 搞清楚getConstructor()方法参数的含义
 */


public class ReflectionTest {

    public static void main(String args[]){
        testClassForName("com.yh.demo.dp.base.TestClass");
    }
    //1.通过反射获取class对象，达到动态加载类的目的
    //1.1 测试forName方法，用来获取对应的class
    public static void testClassForName(String className){
        try {
            Class c1 = Class.forName(className);
            System.out.println("类名为：" + c1.getName());
            //3.通过反射机制创建实例
            //3.1通过newInstance方式实现
            Object o1 = c1.newInstance();
            //3.2&5通过获取构造函数实现并使用构造器创建新的实例
            Object o3 = c1.getConstructor().newInstance();
            TestClass o2 = new TestClass();
            //设置initialize为false，使得不会调用到类的静态代码段;initialize表示class被load之后是不是需要被初始化
            Class c2 = Class.forName(className, false, Thread.currentThread().getContextClassLoader());
            System.out.println("禁用了static代码段, " + c1.getName());

            //1.2通过getClass()方法，获取class
            StringBuilder str = new StringBuilder("123");
            Class c3 = str.getClass();
            System.out.println("类名为：" + c3.getName());

            //2.除了instanceOf方法之外，利用isInstance()来判断对象是不是某个类的实例，该方法是个native的方法，调用底层接口实现
            if (o1 instanceof TestClass) System.out.println("o1是TestClass的一个实例 instanceof关键字实现");
            if (o1.getClass().isInstance(o2)) System.out.println("o1是TestClass的一个实例 通过class的isInstance实现");
            if (o1.getClass().isInstance(o3)) System.out.println("o1和03都是TestClass的实例");

            //4.测试通过获取的class，显示具体的method信息
            //4.1 通过getMethods方法获取class的所有public方法，包括继承于父类的方法
            Method[] methods = c1.getMethods();
            System.out.println("getMethods方法获取");
            for (Method m : methods
                 ) {
                System.out.println(m.getName());
            }
            //4.2 通过getDeclaredMethods，获取类的所有方法，包括protected，private；但是不包括继承的方法
            methods = c1.getDeclaredMethods();
            System.out.println("getDeclaredMethods方法获取");
            for (Method m : methods
                    ) {
                System.out.println(m.getName());
            }

            //6.通过class获取到变量信息,和method的实现类似
            Object[] vars = c1.getFields();
            System.out.println("getFields方法获取");
            for (Object var: vars
                 ) {
                System.out.println(var);
            }
            vars = c1.getDeclaredFields();
            System.out.println("getDeclaredFields方法获取");
            for (Object var: vars
                    ) {
                System.out.println(var);
            }

            //7.通过invoke调用类的方法，invoke的实现可以有两种，一种是通过jvm实现，一种是通过native方式调用底层接口实现
            Object result = c1.getMethod("method1", int.class, int.class).invoke(o1, 1, 4);
            System.out.println("调用o1的实例的add方法，结果为：" + result);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.print("classpath中不存在该类");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
