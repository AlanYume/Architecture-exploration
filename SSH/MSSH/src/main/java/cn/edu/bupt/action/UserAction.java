package cn.edu.bupt.action;

import cn.edu.bupt.model.User;
import cn.edu.bupt.service.UserService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.UUID;

@Controller("userAction")
public class UserAction {
    @Autowired
    private UserService userService;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public String reg() {
        user.setId(UUID.randomUUID().toString());
        user.setRegtime(new Date());
        try {
            userService.addUser(user);
            ServletActionContext.getContext().getSession().put("user", user);
            ServletActionContext.getContext().getSession().put("msg", "注册成功了，可以去登录了");
            return "success";
        } catch (final Exception e) {
            e.printStackTrace();
            ServletActionContext.getContext().getSession().put("msg", "注册失败了");
            return "error";
        }
    }

}
