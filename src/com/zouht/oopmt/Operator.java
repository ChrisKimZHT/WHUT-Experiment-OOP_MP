package com.zouht.oopmt;

import java.util.Scanner;

public class Operator extends User {
    Operator(String name, String password, String role) {
        super(name, password, role);
    }

    public boolean showMenu() {
        String menu_str = """
                ========档案录入员========
                1. 上传文件
                2. 下载文件
                3. 文件列表
                4. 修改密码（本账号）
                5. 退出
                选择操作:""";
        System.out.println(menu_str);
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                uploadFile();
                break;
            case 2:
                downloadFile();
                break;
            case 3:
                showFileList();
                break;
            case 4:
                changeSelfPassword();
                break;
            case 5:
                return false;
            default:
                System.out.println("选项错误");
        }
        return true;
    }

    public void uploadFile() {
        String menu_str = """
                ========上传文件========
                WIP
                """;
        System.out.println(menu_str);
    }
}
