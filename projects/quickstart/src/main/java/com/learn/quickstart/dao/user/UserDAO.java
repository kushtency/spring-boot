package com.learn.quickstart.dao.user;

import com.learn.quickstart.model.user.User;
import com.learn.quickstart.model.user.UserDTO;

public interface UserDAO {
    boolean save(User user);
    User find(UserDTO user);
}
