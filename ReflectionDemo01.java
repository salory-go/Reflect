package reflection.question;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionDemo01 {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodname = properties.get("method").toString();

        //        使用反射机制
//        1.加载Class类
        Class cls = Class.forName(classfullpath);
//        2.通过cls得到加载的类的实例
        Object o = cls.newInstance();
        System.out.println("o的运行类型="+o.getClass());
//        3.在反射中，方法可为对象
        Method method = cls.getMethod(methodname);
//        4.通过方法对象调用方法
        method.invoke(o);


//        Field age = cls.getField("age");
//        System.out.println(age.get(o));
//        Constructor constructor = cls.getConstructor();
//        System.out.println(constructor);
//        Constructor constructor1 = cls.getConstructor(int.class);
//        System.out.println(constructor1);

        Field age = cls.getField("age");
        System.out.println(age.get(o));
        age.set(o,20);
        Object o2 = age.get(o);
        System.out.println(age.get(o));

    }
}
