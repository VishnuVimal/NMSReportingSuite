package com.beehyv.nmsreporting.business;

import com.beehyv.nmsreporting.model.User;

import java.util.List;

/**
 * Created by beehyv on 23/2/17.
 */
public interface UserService {
    public User findUserByUserId(Integer userId);

    public User findUserByUserName(String userName);

    public List<User> getListOfUsers();

    public List<User> getListOfUsersByRole(String userRole);

    public List<User> getListOfUsersByLevel(String hierarchyLevel);

    public List<User> getListOfUsersByAccessPermissions(String hierarchyLevel, String userRole);

    public void createNewUser(User user);

    public void updateExistingUser(User user);

    public void deleteExistingUser(User user);

    public boolean isUserNameUnique(Integer userId, String userName);
}
