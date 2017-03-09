package com.beehyv.nmsreporting.dao.impl;

import com.beehyv.nmsreporting.dao.AbstractDao;
import com.beehyv.nmsreporting.dao.UserDao;
import com.beehyv.nmsreporting.model.User;
import com.beehyv.nmsreporting.utils.Constants;
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

    public List<User> getAllActiveUsers() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("userId"));
        criteria.add(Restrictions.eq("accountStatus", Constants.AccountStatus.ACTIVE));
        return (List<User>) criteria.list();
    }

    public List<User> getActiveUsersByRole(String userRole) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.and(Restrictions.eq("userRole", userRole),
                Restrictions.eq("accountStatus", Constants.AccountStatus.ACTIVE)));
        return (List<User>) criteria.list();
    }

    public List<User> getActiveUsersByHierarchyLevel(String hierarchyLevel){
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.and(Restrictions.eq("hierarchyLevel", hierarchyLevel),
                Restrictions.eq("accountStatus", Constants.AccountStatus.ACTIVE)));
        return (List<User>) criteria.list();
    }

    public List<User> getActiveUsersByAccessPermissions(String hierarchyLevel, String userRole) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.and(Restrictions.eq("hierarchyLevel", hierarchyLevel),
                Restrictions.eq("userRole", userRole), Restrictions.eq("accountStatus", Constants.AccountStatus.ACTIVE)));
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
}
