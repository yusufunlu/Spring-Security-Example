package com.yusufu.springsecuritydemo.security;

import com.yusufu.springsecuritydemo.AuthGroupRepository;
import com.yusufu.springsecuritydemo.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * yusufu 25.10.2021 .
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;
    private AuthGroupRepository authGroupRepository;

    public UserDetailsServiceImpl(UserRepository userRepository, AuthGroupRepository authGroupRepository) {
        super();
        this.userRepository = userRepository;
        this.authGroupRepository = authGroupRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username not found: "+ username);
        }
        List<AuthGroup> authGroups = this.authGroupRepository.findByUsername(username);

        return new UserPrincipal(user,authGroups);
    }
}
