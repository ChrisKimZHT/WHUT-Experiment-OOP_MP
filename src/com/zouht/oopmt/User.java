package com.zouht.oopmt;

import java.util.Objects;
import java.util.Scanner;

public abstract class User {
    private String name;
    private String password;
    private String role;

    User(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public abstract void showMenu();

    public void setName(String value) {
        name = value;
    }

    public void setPassword(String value) {
        password = value;
    }

    public void setRole(String value) {
        role = value;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void showFileList() {
        String menu_str = """
                ========文件列表========
                WIP
                """;
        System.out.println(menu_str);
    }

    public void downloadFile() {
        String menu_str = """
                ========下载文件========
                WIP
                """;
        System.out.println(menu_str);
    }

    public void changeSelfPassword() {
        String menu_str = "========修改密码========";
        System.out.println(menu_str);
        String new_password, confirm_password;
        System.out.print("输入新密码: ");
        Scanner sc = new Scanner(System.in);
        new_password = sc.next();
        System.out.print("确认新密码: ");
        confirm_password = sc.next();
        if (Objects.equals(new_password, confirm_password)) {
            DataProcessing.updateUser(this.name, new_password, this.role);
            System.out.println("密码修改完成，注销登录后将生效");
        } else {
            System.out.println("两次密码不一致，请重试");
        }
    }

    public void exitSystem() {
        System.out.println("系统退出");
        System.exit(0);
    }
}

