package mvc2.controller;

import mvc2.model.User;
import mvc2.service.UserService;
import mvc2.view.UserView;

import java.util.Scanner;

public class UserController {
    private UserService service = new UserService();
    private UserView view = new UserView();
    private Scanner sc = new Scanner(System.in);
    public void run(){
        while(true){
            view.showMenu();
            int choice = sc.nextInt();
            sc.nextLine();//버퍼비우기

            switch(choice){
                case 1:
                    addUser();
                    break;
                case 2:
                    view.showUserList(service.getAllUsers());
                    break;
                case 3:
                    deleteUser();
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
    private void addUser(){
        System.out.println("이름 : ");
        String name = sc.nextLine();
        System.out.println("나이 : ");
        int age =sc.nextInt();
        sc.nextLine();
        service.addUser(name,age);
        view.showMessage("회원이 추가되었습니다!");
    }
    private void deleteUser(){
        System.out.println("삭제할 회원 이름: ");
        String name = sc.nextLine();
        boolean result = service.deleteUser(name);
        if(result){
            view.showMessage("회원이 삭제되었습니다.");
        }else{
            view.showMessage("해당 이름의 회원이 없습니다.");
        }
    }
}
