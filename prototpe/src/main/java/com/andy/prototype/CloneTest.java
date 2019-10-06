package com.andy.prototype;

import com.andy.prototype.model.ClassRoom;
import com.andy.prototype.model.Student;
import com.andy.prototype.util.CloneUtil;

public class CloneTest {

    public static void main(String[] args) throws Exception {{
        ClassRoom room = new ClassRoom();
        room.setName("class One");
        Student andy = new Student();
        andy.setAge(20);
        andy.setCountry("China");
        andy.setIsmale(true);
        andy.setName("Andy");
        andy.setClassRoom(room);

        // Andrew is same with Andy beside name
        Student andrew = new Student();
        andrew.setAge(andy.getAge());
        andrew.setCountry(andy.getCountry());
        andrew.setIsmale(andy.isIsmale());
        andrew.setName("Andrew");
        andrew.setClassRoom(andy.getClassRoom());

        // Tom is same with Andy beside name
        Student tom = (Student) andy.clone();
        tom.setName("Tom");

        System.out.println(tom.getClassRoom() == andy.getClassRoom());

        // Kitty is same with Andy beside name,  but in another school
        Student kitty = CloneUtil.deepClone(andy);
        System.out.println(kitty.getClassRoom().getName());
        System.out.println(andy.getClassRoom().getName());
        System.out.println(kitty.getClassRoom() == andy.getClassRoom());
    }


    }
}
