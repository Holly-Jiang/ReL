package cn.ecnu.edu.ThinkInJava.ClassType;

public class ClassTest {
    public void f(){
        System.out.println("f");
    }
    public static void main(String[] args) {
        ClassTest ct=new ClassTest();
        Class<ClassTest> cl=ClassTest.class;

        System.out.println("getSuperclass:"+cl.getSuperclass());
        try {
            ClassTest ct1=cl.newInstance();
            System.out.println("newInstance complete");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(Class.forName("cn.ecnu.edu.ThinkInJava.ClassType.ClassTest"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
