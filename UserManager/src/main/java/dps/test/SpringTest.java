package dps.test;

import dps.bean.IPerson;
import dps.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    public void testBean() {
        // 读取Spring配置文件
        final ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从Spring容器中获取id为p1的bean
        final Person p1 = act.getBean("p1", Person.class);
        p1.information();
    }

    @Test
    public void testRefBean() {
        final ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
        final IPerson chinese = act.getBean("chinese", IPerson.class);
        chinese.sayHello();
        chinese.drink();

        final IPerson american = act.getBean("american", IPerson.class);
        american.sayHello();
        american.drink();
    }

    @Test
    public void afterInitialization() {
        final ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
        final Person p1 = act.getBean("p2", Person.class);
        p1.information();
    }
}
