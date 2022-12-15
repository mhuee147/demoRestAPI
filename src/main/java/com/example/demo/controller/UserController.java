package com.example.demo.controller;

import com.example.demo.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")

public class UserController {
    static List<User> userList = new ArrayList<>();
    static {
        userList.add(new User(1, "hue", "mmhuee@gmail.com", "0123456789"));
        userList.add(new User(2, "cuong", "cuongnn@gmail.com", "0999987265"));
        userList.add(new User(3, "nam", "nam@gmail.com", "09999828250"));
        userList.add(new User(4, "tu", "tu@gmail.com", "0987567700"));
        userList.add(new User(5, "quan", "quan@gmail.com", "01234256789"));

    }
    @GetMapping("/getAllUser")
    public List<User> getAllUser() {
        return userList;
    }
    //findById
    private User getUser(int id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
            
        }
        return null;
    }
   @PostMapping()
    public List<User> addUser (@RequestBody User user) {
        userList.add(user);
        return userList;
    }
    @PutMapping("/{id}")
    public List<User> updateUser (@PathVariable int id, @RequestBody User user) {
        userList.remove(getUser(id));
        user.setId(id);
        userList.add(user);
        return userList;
    }
    
    @DeleteMapping("/{id}")
    public List<User> deleteUser(@PathVariable int id) {
        userList.remove(getUser(id));
        return userList;
    }
}
