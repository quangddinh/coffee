package com.qh.bean;

import com.qh.pojo.User;
import com.qh.service.UserService;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.Transient;

/**
 *
 * @author Dinh Quang
 */
@ManagedBean
@Named(value = "userBean")
@RequestScoped
public class UserBean {

    public UserBean() {
    }
    private String name;
    private String userName;
    private String password;
    @Transient
    private String confirmPassword;
    private static UserService userService = new UserService();

    public String registerAccount() {
        if (!this.password.isEmpty() && this.password.equals(this.confirmPassword)) {
            User u = new User();
            u.setName(name);
            u.setUsername(userName);
            u.setPassword(password);
            if (userService.addUser(u) == true) {
                return "login?faces-redirect=true";
            }
        }
        return "register";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}
