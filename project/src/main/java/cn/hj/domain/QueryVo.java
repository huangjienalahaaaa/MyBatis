package cn.hj.domain;

import java.io.Serializable;


public class QueryVo  implements Serializable {

    // 自己属性
    private String name;
    // user属性
    private User user;
    // role属性
    private Role role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
