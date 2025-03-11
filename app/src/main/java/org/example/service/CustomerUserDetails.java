package org.example.service;

import org.example.entities.UserInfo;
import org.example.entities.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class CustomerUserDetails extends UserInfo implements UserDetails { // Fixed multiple inheritance issue

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities; // Fixed missing assignments

    public CustomerUserDetails(UserInfo byUsername) {
        this.username = byUsername.getUsername();
        this.password = byUsername.getPassword();
        List<GrantedAuthority> auths = new ArrayList<>();

        for (UserRole role : byUsername.getRoles()) {
            auths.add(new SimpleGrantedAuthority(role.getName().toUpperCase(Locale.ROOT)));
        }

        this.authorities = auths; // Fixed missing assignment
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // Implemented missing method
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username; // Fixed typo (was 'usrename')
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
