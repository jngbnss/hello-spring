package mvc1.view;

import mvc1.model.User;

public class UserView {
    public void showUserInfo(User user){
        System.out.println("\n=====회원 정보=====");
        System.out.println("user.getName() = " + user.getName());
        System.out.println("user.getAge() = " + user.getAge());
    }
}
