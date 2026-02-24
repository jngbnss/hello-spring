package mvc1.controller;

import mvc1.model.User;
import mvc1.view.UserView;

import java.util.Scanner;

public class UserController {
    private UserView view = new UserView();

    public void start(){
        Scanner sc = new Scanner(System.in);
        System.out.print("이름을 입력하세요. : ");
        String name = sc.nextLine();

        System.out.print("나이를 입력하세요. : ");
        int age = sc.nextInt();

        User user = new User(name, age);
        view.showUserInfo(user);
    }
}
