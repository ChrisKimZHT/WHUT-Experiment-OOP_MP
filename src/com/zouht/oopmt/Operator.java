package com.zouht.oopmt;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Operator extends User {
    Operator(String name, String password, String role) {
        super(name, password, role);
    }

    public void showMenu() {
        while (true) {
            String menu_str = """
                    ========档案录入员========
                    1. 上传文件
                    2. 下载文件
                    3. 文件列表
                    4. 修改密码（本账号）
                    5. 注销登录
                    6. 退出系统
                    选择操作:\040""";
            System.out.print(menu_str);
            Scanner sc = new Scanner(System.in);
            int choice;
            // 选项合法性检查
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("选项错误，请重试");
                continue;
            }
            switch (choice) {
                case 1 -> uploadFile();
                case 2 -> downloadFile();
                case 3 -> showFileList();
                case 4 -> changeSelfPassword();
                case 5 -> {
                    return;
                }
                case 6 -> exitSystem();
                default -> System.out.println("选项错误，请重试");
            }
        }
    }

    public void uploadFile() {
        String menu_str = """
                ========上传文件========
                WIP
                """;
        System.out.println(menu_str);
    }
}
