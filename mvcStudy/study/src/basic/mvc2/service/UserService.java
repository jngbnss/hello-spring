package mvc2.service;

import mvc2.model.User;
import mvc2.repository.UserRepository;

import java.util.List;

public class UserService {
    private UserRepository repository = new UserRepository();
    public void addUser(String name, int age){
        User user = new User(name, age);
        repository.save(user);
    }
    public List<User>getAllUsers(){
        return repository.findAll();
    }
    public boolean deleteUser(String name){
        return repository.deleteByName(name);
    }
}
