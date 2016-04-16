package dps.client;

import dps.service.SUserService;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Client {
    @Test
    public void testSpringAOP() {
        final XmlBeanFactory factory =
                new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        final SUserService p = (SUserService) factory.getBean("test");
        p.view();
        p.modify();
    }
}
