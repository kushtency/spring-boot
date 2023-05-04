package com.learn.quickstart.controller.user;

import com.learn.quickstart.dao.user.UserDAO;
import com.learn.quickstart.dao.user.UserDAOImpl;
import com.learn.quickstart.model.user.UserDTO;
import com.learn.quickstart.model.user.User;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/auth")
public class UserController {
    @Autowired
    private EntityManager entityManager;
    private UserDAO userDAO = new UserDAOImpl(entityManager);
    @PostMapping(path = "/login")
    public void loginUser(@RequestBody UserDTO userDTO){
        User u = userDAO.find(userDTO);
        System.out.println(u);
    }
}
