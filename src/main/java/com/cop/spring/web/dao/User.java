/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cop.spring.web.dao;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author dfitzsimons
 */
@Entity( name = "users" )
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String authority;

    @NotBlank()
    @Email
    private String email;

    private boolean enabled = false;

    @NotBlank()
    @Size( min = 3, max = 60 )
    private String name;

    @NotBlank()
    @Pattern( regexp = "^\\S+$" )
    @Size( min = 3, max = 8 )
    private String password;

    @NotBlank()
    @Size( min = 1, max = 15 )
    @Pattern( regexp = "^\\w{1,}$" )
    @Id
    @Column( name = "username" )
    private String username;

    public User() {

    }

    public User( String username, String name, String email, String password, String authority, boolean enabled ) {
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.email = email;
        this.enabled = enabled;
        this.name = name;
    }

    public User( String username, String name, String email, String password, String authority ) {
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.email = email;
        this.enabled = true;
        this.name = name;
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
                } else if( !Objects.equals( this.name, other.getName() ) ) {
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

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode( this.authority );
        hash = 47 * hash + Objects.hashCode( this.email );
        hash = 47 * hash + Objects.hashCode( this.name );
        hash = 47 * hash + ( this.enabled
                             ? 1
                             : 0 );
        hash = 47 * hash + Objects.hashCode( this.username );
        return hash;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled( boolean enabled ) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append( "User{authority=" ).append( authority ).append( ", email=" ).append( email );
        sb.append( ", name=" ).append( name ).append( ", enabled=" ).append( enabled ).append( ", username=" );
        sb.append( username ).append( '}' );
        return sb.toString();
    }

}
