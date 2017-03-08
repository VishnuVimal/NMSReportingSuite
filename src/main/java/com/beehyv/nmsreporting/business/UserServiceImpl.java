package com.beehyv.nmsreporting.business;

import com.beehyv.nmsreporting.dao.UserDao;
import com.beehyv.nmsreporting.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by beehyv on 23/2/17.
 */

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findUserByUserId(Integer userId) {
        return userDao.findByUserId(userId);
    }

    public User findUserByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    public List<User> getListOfUsers() {
        return userDao.getAllUsers();
    }

    public List<User> getListOfUsersByRole(String userRole) {
        return userDao.getUsersByRole(userRole);
    }

    public void createNewUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.saveUser(user);
    }

    public void updateExistingUser(User user) {
        User entity = userDao.findByUserId(user.getUserId());
        if(entity != null) {
            entity.setUserName(user.getUserName());
            if(!user.getPassword().equals(entity.getPassword())) {
                entity.setPassword(passwordEncoder.encode(user.getPassword()));
            }

            entity.setEmailId(user.getEmailId());
            entity.setName(user.getName());
            entity.setPhoneNumber(user.getPhoneNumber());
            entity.setUserRole(user.getUserRole());
            entity.setAccountStatus(user.getAccountStatus());
            entity.setCreatedByUser(user.getCreatedByUser());
            entity.setUserLocation(user.getUserLocation());
            entity.setCreationDate(user.getCreationDate());
            entity.setHierarchyLevel(user.getHierarchyLevel());
        }
    }

    public void deleteExistingUser(User user) {
        userDao.deleteUser(user);
    }

    public boolean isUserNameUnique(Integer userId, String userName) {
        User user = userDao.findByUserName(userName);
        return (user == null || ((userId != null) && (user.getUserId() == userId)));
    }
}
