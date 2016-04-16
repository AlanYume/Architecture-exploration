package dps.test;

import dps.bean.MyClass;
import dps.bean.Student;
import dps.bean.User;
import dps.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

public class hibernateTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(hibernateTest.class);

    public static void main(final String[] args) {
        SessionFactory sf = null;
        Session session = null;

        // 每个 Hibernate 配置文件对应一个 Configuration 对象
        // 加载 Hibernate 的配置文件
        // configure() 方法不传参数时，默认加载 hibernate.cfg.xml 配置文件
        final Configuration cfg = new Configuration().configure();
        // 产生一个不可变的 SessionFactory 对象， SessionFactory 对象一旦创建完毕，
        // 即被赋予特定的配置信息（以后配置信息的改变不会影响到创建的SessionFactory 对象
        sf = cfg.buildSessionFactory();
        // SessionFactory 负责 Session 实例的创建
        session = sf.openSession();

        final Transaction tx = session.beginTransaction();
        final User user = new User("张三", "12345", 20, "男", new Date());
        session.save(user);
        tx.commit();
        LOGGER.debug("添加用户成功！");
    }

    @Test
    public void addUser() {
        final Session session = HibernateSessionFactory.getSession();
        final Transaction tx = session.beginTransaction();
        final User user = new User("段鹏松", "54321", 30, "男", new Date());
        session.save(user);
        tx.commit();
        LOGGER.debug("添加用户成功！");
        HibernateSessionFactory.closeSession();
    }

    @Test
    public void queryOneUser() {
        final Session session = HibernateSessionFactory.getSession();
        // 查询 id 为 20 的用户
        final User user = (User) session.get(User.class, 20);
        LOGGER.info("用户名：" + user.getName() + "，性别：" + user.getGender() + "，年龄：" + user.getAge()
                + "，生日：" + user.getBirthday());
        session.save(user);
        HibernateSessionFactory.closeSession();
    }

    @Test
    public void queryAllUser() {
        final Session session = HibernateSessionFactory.getSession();
        final String hql = "from User";
        final List<User> userList = session.createQuery(hql).list();
        for (final User user : userList) {
            LOGGER.info(
                    "用户名：" + user.getName() + "，性别：" + user.getGender() + "，年龄：" + user.getAge() +
                            "，生日：" + user.getBirthday());
        }
        HibernateSessionFactory.closeSession();
    }

    @Test
    public void updateUser() {
        final Session session = HibernateSessionFactory.getSession();
        final Transaction tx = session.beginTransaction();
        // 更新 id 为 20 的用户
        final User user = (User) session.get(User.class, 20);
        user.setAge(40);
        session.update(user);
        tx.commit();
        HibernateSessionFactory.closeSession();
    }

    @Test
    public void deleteUser() {
        final Session session = HibernateSessionFactory.getSession();
        final Transaction tx = session.beginTransaction();
        // 查询 id 为 20 的用户
        final User user = (User) session.get(User.class, 20);
        session.delete(user);
        tx.commit();
        HibernateSessionFactory.closeSession();
    }

    @Test
    public void OpAdd() {
        final Session session = HibernateSessionFactory.getSession();
        final Transaction tx = session.beginTransaction();
        final Student s1 = new Student("2014123001", "学生1", 20, new Date());
        final Student s2 = new Student("2014123002", "学生2", 19, new Date());
        final Student s3 = new Student("2014123003", "学生3", 21, new Date());
        final Student s4 = new Student("2014123004", "学生4", 20, new Date());
        final Student s5 = new Student("2014123005", "学生5", 24, new Date());
        final Student s6 = new Student("2014123006", "学生6", 20, new Date());
        final Student s7 = new Student("2014123007", "学生7", 22, new Date());
        final MyClass myClass = new MyClass("2014Java专业 ");
        s1.setMyClass(myClass);
        s2.setMyClass(myClass);
        s3.setMyClass(myClass);
        s4.setMyClass(myClass);
        s5.setMyClass(myClass);
        s6.setMyClass(myClass);
        s7.setMyClass(myClass);
        session.save(s1);
        session.save(s2);
        session.save(s3);
        session.save(s4);
        session.save(s5);
        session.save(s6);
        session.save(s7);
        tx.commit();
        HibernateSessionFactory.closeSession();
    }

    @Test
    public void OpHqlTest() {
        final Session session = HibernateSessionFactory.getSession();
        final String strHQl = "from Student s where s.sage<? ";
        final List<Student> myList = session.createQuery(strHQl).setParameter(0, 21).list();
        for (final Student s : myList) {
            LOGGER.info(s.toString());
        }
        HibernateSessionFactory.closeSession();
    }

    @Test
    public void OpHqlTest2() {
        final Session session = HibernateSessionFactory.getSession();
        final String strHQl = "from Student s where s.sage<:age ";
        final List<Student> myList = session.createQuery(strHQl).setParameter("age", 21).list();
        for (final Student s : myList) {
            LOGGER.info(s.toString());
        }
        HibernateSessionFactory.closeSession();
    }
}
