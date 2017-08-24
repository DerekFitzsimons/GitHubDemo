package com.cop.spring.web.dao;

import java.util.Objects;
import javax.validation.constraints.Size;

public class Offer {

    private int id;

    @Size( min = 20, max = 255 )
    private String text;

    private User user;

    public Offer() {
        this.user = new User();
    }

    public Offer( User user, String text ) {
        this.user = user;
        this.text = text;
    }

    public Offer( int id, User user, String text ) {
        super();
        this.id = id;
        this.user = user;
        this.text = text;
    }

    @Override
    public boolean equals( Object obj ) {
        if( this == obj ) {
            return true;
        }
        if( obj == null ) {
            return false;
        }
        if( getClass() != obj.getClass() ) {
            return false;
        }
        final Offer other = (Offer) obj;
        if( !Objects.equals( this.text, other.getText() ) ) {
            return false;
        }
        return Objects.equals( this.user, other.getUser() );
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText( String text ) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser( User user ) {
        this.user = user;
    }
    public String getUsername(){
        return user.getUsername();
    }
    public void setUsername(String userName){
        user.setUsername(userName);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode( this.text );
        hash = 47 * hash + Objects.hashCode( this.user );
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append( "Offer{id=" ).append( id ).append( ", text=" ).append( text ).append( ", " );
        sb.append( "user=" ).append( user.getUsername() ).append( '}' );
        return sb.toString();
    }
    

}
