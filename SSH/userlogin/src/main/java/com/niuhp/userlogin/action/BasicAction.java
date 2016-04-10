package com.niuhp.userlogin.action;

import com.niuhp.userlogin.util.ActionResult;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class BasicAction extends ActionSupport implements ActionResult {

    private static final long serialVersionUID = 1L;

    private HttpServletRequest request;

    public HttpServletRequest getRequest() {
        if (request == null) {
            request = ServletActionContext.getRequest();
        }
        return request;
    }

}
