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

    public List<User> getAllActiveUsers();

    public List<User> getActiveUsersByRole(String userRole);

    public List<User> getActiveUsersByHierarchyLevel(String hierarchyLevel);

    public List<User> getActiveUsersByAccessPermissions(String hierarchyLevel, String userRole);

    public List<User> getUsersByAccountStatus(String accountStatus);

    public void saveUser(User user);
}
