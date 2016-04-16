package dps.interceptor;

import dps.bean.SUser;
import dps.test.hibernateTest;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//权限验证拦截器
public class SAuthorityInterceptor implements MethodInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(hibernateTest.class);

    private SUser user;

    public void setUser(final SUser user) {
        this.user = user;
    }

    public Object invoke(final MethodInvocation arg0) throws Throwable {
        LOGGER.info("==拦截器===权限验证开始======");
        final String username = this.user.getUsername();
        final String methodName = arg0.getMethod().getName();
        if (!username.equals("admin") && !username.equals("register")) {
            System.out.println("没有任何执行权限");
            return null;
        } else if (username.equals("register") && methodName.equals("modify")) {
            System.out.println("register用户没有write权限");
            return null;
        } else {
            final Object obj = arg0.proceed();
            System.out.println("==拦截器===权限验证结束======");
            System.out.println();
            return obj;
        }
    }
}
