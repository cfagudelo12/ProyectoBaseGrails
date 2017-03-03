package co.edu.uniandes.ldap


/**
 * Created by Juan Vazquez.
 * URL: http://javazquez.com/juan
 * Code is provide for educational purposes. Any use in a production system is at your own risk.
 */
import org.springframework.security.core.userdetails.User

class MyUserDetails extends User {
    // extra instance variables final String fullname final String email final String title
    String name
	String lastname
    String email

    MyUserDetails(String username, String password, boolean enabled, boolean accountNonExpired,
                  boolean credentialsNonExpired, boolean accountNonLocked, Collection authorities,
                  String name, String lastname, String email) {

        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities)

        this.name = name
		this.lastname = lastname
        this.email = email
    }
}