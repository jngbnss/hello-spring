package mvc2.repository;

import mvc2.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User>userList = new ArrayList<>();

    public void save(User user){
        userList.add(user);
    }

    public List<User>findAll(){
        return userList;
    }
    public boolean deleteByName(String name) {
        return userList.removeIf(u -> u.getName().equals(name));
    }
}
