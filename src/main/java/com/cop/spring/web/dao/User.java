/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cop.spring.web.dao;

import javax.validation.constraints.*;

/**
 *
 * @author dfitzsimons
 */
public class User {

    private String authority;
    
    @NotBlank()
    @Email
    private String email;

    private boolean enabled = false;

    @NotBlank()
    @Pattern(regexp="^\\S+$")
    @Size(min=3,max=8)
    private String password;

    @NotBlank()
    @Size(min=1, max=15)
    @Pattern(regexp="^\\w{1,}$")
    private String username;
    

    public User() {

    }

    public User( String username, String email, String password, String authority ) {
        this.username = username;
        this.password = password;
        this.authority = authority;
    }


    public String getAuthority() {
        return authority;
    }

    public void setAuthority( String authority ) {
        this.authority = authority;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername( String username ) {
        this.username = username;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled( boolean enabled ) {
        this.enabled = enabled;
    }

}