package com.zouht.oopmt;

import java.security.PublicKey;
import java.util.Scanner;

public class Admin extends User {
    Admin(String name, String password, String role) {
        super(name, password, role);
    }

    public boolean showMenu() {
        String menu_str = """
                ========档案管理员========
                1. 新增用户
                2. 删除用户
                3. 修改用户
                4. 查询用户
                5. 下载文件
                6. 文件列表
                7. 修改密码（本账号）
                8. 退出
                选择操作:""";
        System.out.println(menu_str);
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                addUser();
                break;
            case 2:
                deleteUser();
                break;
            case 3:
                changeUserInfo();
                break;
            case 4:
                queryUser();
                break;
            case 5:
                downloadFile();
                break;
            case 6:
                showFileList();
                break;
            case 7:
                changeSelfPassword();
                break;
            case 8:
                return false;
            default:
                System.out.println("选项错误");
        }
        return true;
    }

    public void changeUserInfo() {
        String menu_str = """
                ========修改用户========
                WIP
                """;
        System.out.println(menu_str);
    }

    public void addUser() {
        String menu_str = """
                ========新增用户========
                WIP
                """;
        System.out.println(menu_str);
    }

    public void deleteUser() {
        String menu_str = """
                ========删除用户========
                WIP
                """;
        System.out.println(menu_str);
    }

    public void queryUser() {
        String menu_str = """
                ========查询用户========
                WIP
                """;
        System.out.println(menu_str);
    }
}
