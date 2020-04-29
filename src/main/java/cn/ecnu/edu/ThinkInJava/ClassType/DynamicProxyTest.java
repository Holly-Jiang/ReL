package cn.ecnu.edu.ThinkInJava.ClassType;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void consumer(Interface proxy){
        proxy.doSometing();
        proxy.doSometingElse("bbb");
    }

    public static void main(String[] args) {
        Interface realObject =new RealObject();

        Interface dp=(Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
                new Class[]{Interface.class},new DynamicProxyHander(realObject));
        consumer(dp);
    }
}
 interface  Interface{
    public void doSometing();
    public  void doSometingElse(String ee);
 }

 class RealObject implements Interface{

     @Override
     public void doSometing() {
         System.out.println("doSometing");
     }

     @Override
     public void doSometingElse(String ee) {
         System.out.println("doSometingElse: "+ee);
     }
 }

 class DynamicProxyHander implements InvocationHandler{
    private Interface proxy;

     public DynamicProxyHander(Interface proxy) {
         this.proxy=proxy;
     }

     @Override
     public Object invoke(Object proxied, Method method, Object[] args) throws Throwable {
         System.out.println(proxied.getClass()+","+method+","+args);

         return method.invoke(proxy,args);
     }
 }

