package com.beehyv.nmsreporting.security;

import org.apache.shiro.authc.UsernamePasswordToken;

public class NMSRepAuthenticationToken extends UsernamePasswordToken{


    public NMSRepAuthenticationToken() {
        super();
    }

    public NMSRepAuthenticationToken(String username, String password) {
        super(username, password);
    }
}