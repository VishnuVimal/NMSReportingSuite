package com.beehyv.nmsreporting.dao.impl;

import com.beehyv.nmsreporting.dao.AbstractDao;
import com.beehyv.nmsreporting.dao.UserDao;
import com.beehyv.nmsreporting.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by beehyv on 22/2/17.
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {
    public User findByUserId(Integer userId) {
        return getByKey(userId);
    }

    public User findByUserName(String userName) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("userName", userName));
        return (User) criteria.uniqueResult();
    }

    public User findByEmailId(String emailId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("emailId", emailId));
        return (User) criteria.uniqueResult();
    }

    public List<User> getAllUsers() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("userId"));
        return (List<User>) criteria.list();
    }

    public List<User> getUsersByRole(String userRole) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("userRole", userRole));
        return (List<User>) criteria.list();
    }

    public List<User> getUsersByHierarchyLevel(String hierarchyLevel){
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("hierarchyLevel", hierarchyLevel));
        return (List<User>) criteria.list();
    }

    public List<User> getUsersByAccountStatus(String accountStatus) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("accountStatus", accountStatus));
        return (List<User>) criteria.list();
    }

    public void saveUser(User user) {
        persist(user);
    }

    public void deleteUser(User user) {
        delete(user);
    }
}
