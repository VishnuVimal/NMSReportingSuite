package com.beehyv.nmsreporting.security;

import com.beehyv.nmsreporting.business.UserService;
import com.beehyv.nmsreporting.model.User;
import com.beehyv.nmsreporting.utils.SessionUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import static com.beehyv.nmsreporting.utils.Constants.Roles.*;
import static com.beehyv.nmsreporting.utils.Constants.Permissions.*;
import static com.beehyv.nmsreporting.utils.Constants.Level.*;

public class NMSRepRealm extends AuthorizingRealm{

    @Autowired
    private UserService userService;

    public NMSRepRealm() {
        setName("nmsRep-realm");
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo (PrincipalCollection pc){
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole(SessionUtils.getUserRole());
        if (MASTER_ADMIN_ROLE.equals(SessionUtils.getUserRole())){
            info.addStringPermission(CREATE_OR_MODIFY_NATIONAL_ACCOUNTS);
        } else if (ADMIN_ROLE.equals(SessionUtils.getUserRole())) {
            if (NATIONAL_LEVEL.equals(SessionUtils.getUserLevel())) {
                info.addStringPermission(CREATE_OR_MODIFY_NATIONAL_ACCOUNTS);
            } else if (STATE_LEVEL.equals(SessionUtils.getUserLevel())) {
                info.addStringPermission(CREATE_OR_MODIFY_STATE_ACCOUNTS);
            } else if (DISTRICT_LEVEL.equals(SessionUtils.getUserLevel())) {
                info.addStringPermission(CREATE_OR_MODIFY_DISTRICT_ACCOUNTS);
            } else if (BLOCK_LEVEL.equals(SessionUtils.getUserLevel())) {
                info.addStringPermission(CREATE_OR_MODIFY_BLOCK_ACCOUNTS);
            }
        }

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken at)
            throws AuthenticationException {
        NMSRepAuthenticationToken token = (NMSRepAuthenticationToken) at;
        String userName = token.getUsername();
        String role = SessionUtils.getUserRole();
        String level = SessionUtils.getUserLevel();

        User user = userService.findUserByUserName(userName);
        return new SimpleAuthenticationInfo(user.getUserId(), user.getPassword(), getName());
    }
}
