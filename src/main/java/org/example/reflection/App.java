package org.example.reflection;

import java.lang.reflect.Method;

public class App {
    static void main() {
        Class<Users> obj = Users.class;
        System.out.println("Name: " + obj.getName());
//        System.out.println("--------------- Field Name ---------------");
//        Field[] fields = obj.getFields();
//        for (Field field : fields) {
//            System.out.println("Name: " + field.getName());
//        }
//        System.out.println("--------------- Method Name ---------------");
        Method[] methods = obj.getMethods();
        System.out.println("Number of methods: " + methods.length);
        for (Method method : methods) {
            System.out.println("Name: " + method.getName());
        }
        System.out.println("Number of get fields: " + obj.getFields().length);
        System.out.println("Number of get constructors: " + obj.getConstructors().length);
    }
}
