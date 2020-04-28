package cn.ecnu.edu.ThinkInJava.Sets;

public class TextFileTest {
    public static void main(String[] args) {
MyException myException=new MyException();
try{
    myException.f();

}catch (MyException e){
    System.out.println("catched");
    System.out.println(e.getMessage());
}
    }
}

class MyException extends Exception{

    public void f() throws MyException{
        System.out.println("f():");
        throw new NullPointerException("WWWWWW");
    }
}
