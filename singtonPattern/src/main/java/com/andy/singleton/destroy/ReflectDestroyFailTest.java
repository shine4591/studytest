package com.andy.singleton.destroy;

import com.andy.singleton.lazy.LazyDoubleCheckSingleton;
import com.andy.singleton.lazy.PreventReflectSingleton;

import java.lang.reflect.Constructor;

//反射破坏单例示例
public class ReflectDestroyFailTest {

    public static void main(String[] args) {
        //检查是不是懒加载
//        try{
//            Class.forName("com.andy.singleton.lazy.PreventReflectSingleton");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        try{
//            // 先正常执行
//            Object instanceA = PreventReflectSingleton.getInstance();
//            System.out.println("instanceA..." + instanceA);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        try{
//            // 再遭遇破坏
//            Constructor<?> c = PreventReflectSingleton.class.getDeclaredConstructor(String.class);
//            c.setAccessible(true);
//            Object instanceB = c.newInstance("fromReflect");
//            System.out.println("instanceB..." + instanceB);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        try{
            // 先遭遇破坏
            Constructor<?> c = PreventReflectSingleton.class.getDeclaredConstructor(String.class);
            c.setAccessible(true);
            Object instanceB = c.newInstance("fromReflect");
            System.out.println("instanceB..." + instanceB);
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            // 再正常执行
            Object instanceA = PreventReflectSingleton.getInstance();
            System.out.println("instanceA..." + instanceA);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
