package com.niuhp.userlogin.interceptor;

import com.niuhp.userlogin.util.ActionResult;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

public class LoginInterceptor extends MethodFilterInterceptor implements ActionResult {
    private static final long serialVersionUID = 1L;

    @Override
    protected String doIntercept(final ActionInvocation actionInvocation) throws Exception {
        final HttpSession session = ServletActionContext.getRequest().getSession();
        final Object admin = session.getAttribute("admin");
        if (admin != null) {
            return actionInvocation.invoke();
        }
        final Object user = session.getAttribute("user");
        if (user == null) {
            return PREPARE_LOGIN;
        }
        return actionInvocation.invoke();
    }

}
