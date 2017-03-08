package com.beehyv.nmsreporting.dao;

import com.beehyv.nmsreporting.model.User;

import java.util.List;

/**
 * Created by beehyv on 22/2/17.
 */
public interface UserDao {
    public User findByUserId(Integer userId);

    public User findByUserName(String userName);

    public User findByEmailId(String emailId);

    public List<User> getAllUsers();

    public List<User> getUsersByRole(String userRole);

    public List<User> getUsersByHierarchyLevel(String hierarchyLevel);

    public List<User> getUsersByAccountStatus(String accountStatus);

    public void saveUser(User user);

    public void deleteUser(User user);
}
