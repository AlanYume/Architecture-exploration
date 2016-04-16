package com.niuhp.userlogin.action;

import com.niuhp.userlogin.domain.User;
import com.niuhp.userlogin.security.EncryptorMgr;
import com.niuhp.userlogin.service.UserService;
import com.niuhp.userlogin.util.ActionResult;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UserAction extends BasicAction implements ActionResult {

    private static final long serialVersionUID = -8044906775297267551L;

    private UserService userService;

    private int id;
    private String username;
    private String password;
    private String nickname;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(final UserService userService) {
        this.userService = userService;
    }

    public String login() {
        final HttpSession session = ServletActionContext.getRequest().getSession();
        password = EncryptorMgr.encrypt(password);
        final Object user = userService.userLogin(username, password);
        if (user == null) {
            return prepareLogin();
        }
        session.setAttribute("user", user);
        return USER_HOME;
    }

    public String register() {
        final User user = constructUser();
        userService.addUser(user);
        return PREPARE_LOGIN;
    }

    public String prepareLogin() {
        final HttpSession session = ServletActionContext.getRequest().getSession();
        final Object user = session.getAttribute("user");
        if (user != null) {
            return USER_HOME;
        }
        return PREPARE_LOGIN;
    }

    public String prepareRegister() {
        return PREPARE_REGISTER;
    }

    public String logout() {
        final HttpSession session = ServletActionContext.getRequest().getSession();
        session.removeAttribute("user");
        return PREPARE_LOGIN;
    }

    public String adminLogin() {
        final HttpSession session = ServletActionContext.getRequest().getSession();
        Object admin = session.getAttribute("admin");
        if (admin != null) {
            final List<User> users = userService.getUserList();
            final HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("users", users);
            return ADMIN_HOME;
        }

        final String relPasswd = username + "Root";
        if (relPasswd.equals(password)) {
            nickname = username;
            admin = constructUser();
            session.setAttribute("admin", admin);
            final List<User> users = userService.getUserList();
            final HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("users", users);
            return ADMIN_HOME;
        }
        return ADMIN_LOGIN;
    }

    public String adminLogout() {
        final HttpSession session = ServletActionContext.getRequest().getSession();
        session.removeAttribute("admin");
        return ADMIN_LOGIN;
    }

    public String resetPasswd() {
        if (password == null) {
            password = username;
        }
        password = EncryptorMgr.encrypt(password);
        userService.modifyPassword(id, password);
        return ADMIN_HOME;
    }

    public String deleteUser() {
        userService.deleteUser(id);
        return ADMIN_HOME;
    }

    private User constructUser() {
        final User user = new User();
        user.setId(id);
        user.setNickname(nickname);
        user.setUsername(username);
        password = EncryptorMgr.encrypt(password);
        user.setPassword(password);
        return user;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(final String nickname) {
        this.nickname = nickname;
    }

}
