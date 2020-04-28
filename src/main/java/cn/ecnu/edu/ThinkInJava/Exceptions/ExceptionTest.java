package cn.ecnu.edu.ThinkInJava.Exceptions;

public class ExceptionTest {
    public static void main(String[] args) {
        A a1 = new A();

        try {
            ;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            a1.dispose();
        }

        try {
            B b1 = new B();
            try {
                B b2 = new B();
                try{
                    ;
                }catch (Exception e){
                    e.printStackTrace(System.out);
                }finally {
                    b2.dispose();
                }
            } catch (Exception e) {
                e.printStackTrace(System.out);
            } finally {
                b1.dispose();
            }
        }catch (Exception e){
            e.printStackTrace(System.out);
        }finally {
        }

    }
}
class A{
    private static int  count=1;
    private final int id=count++;
    public void dispose(){
        System.out.println(this.getClass().toString()+id+"dispose");
    }
}
class B extends  A{
    public B() throws Exception{

    }
}