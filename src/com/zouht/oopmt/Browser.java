package com.zouht.oopmt;

import java.util.Scanner;

public class Browser extends User {
    Browser(String name, String password, String role) {
        super(name, password, role);
    }

    public void showMenu() {
        String menu_str = """
                ========档案浏览员========
                1. 下载文件
                2. 文件列表
                3. 修改密码（本账号）
                4. 退出
                选择操作:""";
        System.out.println(menu_str);
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                downloadFile();
                break;
            case 2:
                showFileList();
                break;
            case 3:
                changeSelfPassword();
                break;
            case 4:
                exitSystem();
            default:
                System.out.println("选项错误");
        }
    }
}
