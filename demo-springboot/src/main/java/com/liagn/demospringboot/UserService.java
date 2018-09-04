package com.liagn.demospringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao userRepository;
    public User findUserByName(String username){
        return userRepository.findByUsername(username);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> findUserById(long id){
        return userRepository.findById(id) ;
    }

    public User updateUser(User user){
        return userRepository.saveAndFlush(user);
    }

    public void deleteUser(long id){
        userRepository.deleteById(id);
    }
}
