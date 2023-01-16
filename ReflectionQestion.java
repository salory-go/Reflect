package reflection.question;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 反射问题引入
 */
public class ReflectionQestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
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

    }
}
