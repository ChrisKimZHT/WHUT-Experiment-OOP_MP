package com.zouht.oopmt;

import java.util.Enumeration;
import java.util.Hashtable;

public class DataProcessing {
    static Hashtable<String, User> users;

    static {
        users = new Hashtable<String, User>();
        users.put("jack", new Operator("jack", "123", "operator"));
        users.put("rose", new Browser("rose", "123", "browser"));
        users.put("kate", new Admin("kate", "123", "admin"));
    }

    private static User constructUser(String name, String password, String role) {
        User user;
        if (role.equalsIgnoreCase("admin")) {
            user = new Admin(name, password, role);
        } else if (role.equalsIgnoreCase("operator")) {
            user = new Operator(name, password, role);
        } else if (role.equalsIgnoreCase("browser")) {
            user = new Browser(name, password, role);
        } else {
            return null;
        }
        return user;
    }

    // 增加用户
    public static boolean addUser(String name, String password, String role) {
        if (users.containsKey(name))
            return false;
        User user = constructUser(name, password, role); // 构造一个具体的用户类
        if (user == null)
            return false;
        users.put(name, user);
        return true;
    }

    // 删除用户
    public static boolean deleteUser(String name) {
        if (users.containsKey(name)) {
            users.remove(name);
            return true;
        }
        return false;
    }

    // 修改用户数据
    public static boolean updateUser(String name, String password, String role) {
        if (!users.containsKey(name))
            return false;
        User user = constructUser(name, password, role); // 构造一个具体的用户类
        if (user == null)
            return false;
        users.put(name, user);
        return true;
    }

    // 根据名称取得用户
    public static User searchUser(String name) {
        if (users.containsKey(name)) // 校验用户是否存在
            return users.get(name);
        return null;
    }

    // 校验密码后取得用户
    public static User checkPassword(String name, String password) {
        if (users.containsKey(name)) { // 校验用户是否存在
            User user = users.get(name);
            if (user.getPassword().equals(password)) // 校验用户密码
                return user;
        }
        return null;
    }

    // 取得所有用户数据
    public static Enumeration<User> getAllUser() {
        return users.elements();
    }
}
