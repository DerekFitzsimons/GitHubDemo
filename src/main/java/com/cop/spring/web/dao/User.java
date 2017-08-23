/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cop.spring.web.dao;

import java.util.Objects;
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
    @Pattern( regexp = "^\\S+$" )
    @Size( min = 3, max = 8 )
    private String password;

    @NotBlank()
    @Size( min = 1, max = 15 )
    @Pattern( regexp = "^\\w{1,}$" )
    private String username;

    public User() {

    }

    public User( String username, String email, String password, String authority ) {
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.email = email;
        this.enabled = true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode( this.authority );
        hash = 47 * hash + Objects.hashCode( this.email );
        hash = 47 * hash + ( this.enabled
                             ? 1
                             : 0 );
        hash = 47 * hash + Objects.hashCode( this.username );
        return hash;
    }

    @Override
    public boolean equals( Object obj ) {
        boolean output = true;
        if( this != obj ) {
            if( obj == null ) {
                output = false;
            } else if( getClass() != obj.getClass() ) {
                output = false;
            } else {
                final User other = (User) obj;
                if( this.enabled != other.isEnabled() ) {
                    output = false;
                } else if( !Objects.equals( this.authority, other.getAuthority() ) ) {
                    output = false;
                } else if( !Objects.equals( this.email, other.getEmail() ) ) {
                    output = false;
                } else if( !Objects.equals( this.username, other.getUsername() ) ) {
                    output = false;
                }
            }
        }

        return output;

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
