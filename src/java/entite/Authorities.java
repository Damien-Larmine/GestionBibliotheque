package entite;
// Generated 18 mars 2016 10:01:01 by Hibernate Tools 4.3.1



/**
 * Authorities generated by hbm2java
 */
public class Authorities  implements java.io.Serializable {


     private String username;
     private Users users;
     private String authority;

    public Authorities() {
    }

    public Authorities(Users users, String authority) {
       this.users = users;
       this.authority = authority;
    }
   
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    public String getAuthority() {
        return this.authority;
    }
    
    public void setAuthority(String authority) {
        this.authority = authority;
    }




}


