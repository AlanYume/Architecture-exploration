package dps.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author yume
 *
 */
public class UserAction extends ActionSupport {
    private String username;
    private String password;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    //用户登录action
    public String login() throws Exception {
        //定义返回值变量
        String strReturn = INPUT;
        //义务逻辑判断
        if (this.username.equals("abc") && this.password.equals("123")) {
            //把用户名存放到session中
            ActionContext.getContext().getSession().put("username", this.username);
            strReturn = SUCCESS;
        } else {
            ActionContext.getContext().getSession().put("tip", "登录失败");
        }
        return strReturn;
    }

    //用户注册action
    public String regist() throws Exception {
        //定义返回值变量
        final String strReturn = SUCCESS;
        //注册业务逻辑
        ActionContext.getContext().getSession().put("tip", "注册成功");
        return strReturn;
    }

    //用户登陆后查看机密信息action
    public String secret() throws Exception {
        //定义返回值变量
        final String strReturn = SUCCESS;
        System.out.println("执行secret操作");
        return strReturn;
    }
}
