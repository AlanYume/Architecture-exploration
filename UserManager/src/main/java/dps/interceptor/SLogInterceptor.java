package dps.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//日志记录拦截器
public class SLogInterceptor implements MethodInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(SLogInterceptor.class);

    public Object invoke(final MethodInvocation arg0) throws Throwable {
        final String methodName = arg0.getMethod().getName();
        final Object obj = arg0.proceed();
        LOGGER.info("==拦截器===日志记录： 尝试执行" + methodName + "方法");
        return obj;
    }
}
