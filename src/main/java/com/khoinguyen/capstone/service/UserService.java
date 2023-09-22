package com.khoinguyen.capstone.service;

import com.khoinguyen.capstone.entity.Role;
import com.khoinguyen.capstone.entity.User;

public interface UserService {
    public User save(User user);
    public Role save(Role role);
    public void addRoleToUser(String email, String roleName);
}
