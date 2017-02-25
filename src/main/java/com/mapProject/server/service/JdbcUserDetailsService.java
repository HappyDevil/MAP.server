package com.mapProject.server.service;

import com.mapProject.server.entity.User;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.logging.Logger;

@Component
public class JdbcUserDetailsService implements UserDetailsService {

    private static final Logger LOG = (Logger) LoggerFactory.getLogger(JdbcUserDetailsService.class);

    @Autowired
    private UserService userService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            username = URLDecoder.decode(username, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOG.info("### loadUserByUsername: " + e);
        }

        User user = userService.findUserByUsername(username);
        if (user == null) {
            LOG.info("User with username " + username + " not found in DB");
            throw new UsernameNotFoundException("User " + username + " not found in database.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, AuthorityUtils.createAuthorityList("USER", "write"));
    }
}