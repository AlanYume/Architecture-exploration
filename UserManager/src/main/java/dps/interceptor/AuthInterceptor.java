package dps.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(final ActionInvocation arg0) throws Exception {
        System.out.println("权限拦截器开始执行");
        final Object obj = ActionContext.getContext().getSession().get("username");
        final String strName = obj != null ? obj.toString() : "";
        if (strName.equals("abc")) {
            final String str = arg0.invoke();
            System.out.println("权限拦截器结束执行");
            return str;
        } else {
            ActionContext.getContext().getSession().put("tip", "还没登陆，不能查看机密信息");
            return "input";
        }
    }

}
