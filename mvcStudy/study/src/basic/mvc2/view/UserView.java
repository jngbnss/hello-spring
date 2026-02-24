package mvc2.view;

import mvc2.model.User;

import java.util.List;

public class UserView {
    public void showMenu(){
        System.out.println("\n=====회원 관리 프로그램=====");
        System.out.println("1. 회원 추가");
        System.out.println("2. 회원 목록 조회");
        System.out.println("3. 회원 삭제");
        System.out.println("4. 종료");
        System.out.print("선택 : ");
    }
    public void showUserList(List<User> users){
        if(users.isEmpty()){
            System.out.println("등록된 회원이 없습니다.");
        }else{
            System.out.println("\n[회원 목록]");
            for (User user : users) {
                System.out.println("user = " + user);
            }
        }
    }
    public void showMessage(String msg){
        System.out.println("msg = " + msg);
    }
}
