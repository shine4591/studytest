package com.andy.singleton.destroy;

import com.andy.singleton.lazy.LazyDoubleCheckSingleton;
import com.andy.singleton.lazy.PreventReflectSingleton;

import java.lang.reflect.Constructor;

//反射破坏单例示例
public class ReflectDestroyFailTest {

    public static void main(String[] args) {
//        try{
//            // 先正常执行
//            Object instanceA = PreventReflectSingleton.getInstance();
//            System.out.println("instanceA..." + instanceA);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        try{
//            // 再遭遇破坏
//            Constructor<?> c = PreventReflectSingleton.class.getDeclaredConstructor();
//            c.setAccessible(true);
//            Object instanceB = c.newInstance();
//            System.out.println("instanceB..." + instanceB);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        try{
            // 先遭遇破坏
            Constructor<?> c = PreventReflectSingleton.class.getDeclaredConstructor();
            c.setAccessible(true);
            Object instanceB = c.newInstance();
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
