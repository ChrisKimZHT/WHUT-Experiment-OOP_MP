package com.zouht.oopmt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String menu_str = """
                ========欢迎进入档案系统========
                1. 登录
                2. 退出
                选择操作:\040""";
        System.out.print(menu_str);
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if (choice == 1) {
            String name, password;
            System.out.print("输入用户名: ");
            name = sc.next();
            System.out.print("输入密码: ");
            password = sc.next();
            User user = DataProcessing.checkPassword(name, password);
            if (user == null) {
                System.out.println("密码错误，登陆失败。");
                return;
            }
            while (true) {
                user.showMenu();
            }
        }
    }
}
