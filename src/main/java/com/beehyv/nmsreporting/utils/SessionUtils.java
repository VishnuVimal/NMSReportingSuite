package com.beehyv.nmsreporting.utils;

import com.beehyv.nmsreporting.security.NMSRepAuthenticationToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Collection;

public class SessionUtils {

    private SessionUtils() {}

    public static String getUserRole() {
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        return session.getAttribute("role") == null ? null : (String) session.getAttribute("role");
    }

    public static String getUserLevel() {
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        return session.getAttribute("level") == null ? null : (String) session.getAttribute("level");
    }

    public static Session getCurrentSession() {
        Subject currentUser = SecurityUtils.getSubject();
        return currentUser.getSession();
    }

    public static ModelMap loginUser(String userId, String password, String role, String loginType, HttpServletResponse response) {
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        if ( !currentUser.isAuthenticated() ) {
            NMSRepAuthenticationToken token = new NMSRepAuthenticationToken(userId, password);
            token.setRememberMe(true);
            session.setAttribute("role", role);
            currentUser.login(token);
            ModelMap mp = new ModelMap();
            mp.addAttribute("msg", getCurrentUserId() + " logged in successfully!");
            Object[] cookies = response.getHeaders("Set-Cookie").toArray();
            String rememberMe = "";
            for (Object cookie :
                    cookies) {
                if ("rememberMe".equals(((String) cookie).split(";")[0].split("=")[0])) {
                    rememberMe = ((String) cookie).split(";")[0].split("=")[1];
                }
            }
            mp.addAttribute("JSESSIONID", getCurrentSession().getId());
            mp.addAttribute("rememberMe", rememberMe);
            return mp;
        } else {
            throw new IllegalStateException(SessionUtils.getCurrentUserId() + " logged in already! Logout and try again!");
        }
    }

    public static String getCurrentUserId() {
        Subject currentUser = SecurityUtils.getSubject();
        return (String) currentUser.getPrincipal();
    }

    public static void logoutCurrentUser() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
    }
}
