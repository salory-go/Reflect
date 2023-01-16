package reflection.question;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
@SuppressWarnings("alls")
public class ReflectDemo02 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        //1.先获取User类的Class对象
        Class<?> usercalss = Class.forName("reflection.question.User");
        //2.public构造器
        Object o1 = usercalss.newInstance();
        System.out.println(o1);
        //3.public有参构造器
        Constructor<?> constructor = usercalss.getConstructor(String.class);
        Object o2 = constructor.newInstance("Alen");
        System.out.println(o2);
        //4.非public构造器
        Constructor<?> constructor1 = usercalss.getDeclaredConstructor(int.class, String.class);
        constructor1.setAccessible(true);
        Object zsg = constructor1.newInstance(19, "zsg");
        System.out.println(zsg);
    }
}
class User{
    private  int age;
    private String name = "Bob";

    public User(){

    }

    public User(String name) {
        this.name = name;
    }

    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
