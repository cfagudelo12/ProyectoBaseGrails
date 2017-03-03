package co.edu.uniandes.ldap

import co.edu.uniandes.base.Base
import co.edu.uniandes.login.*
import grails.transaction.Transactional
import org.springframework.ldap.core.DirContextAdapter
import org.springframework.ldap.core.DirContextOperations
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper

class MyUserDetailsContextMapper implements UserDetailsContextMapper {
	
	@Override
    @Transactional  // Services in Grails are transactional by default but it is normal class so we put this annotation
    public UserDetails mapUserFromContext(DirContextOperations ctx, String username, Collection authorities) {
		
		
		//Grab the specific Active Directory information you want
	    String name = ctx.attributes['givenName'].values[0]
	    String lastname = ctx.attributes['sn'].values[0]
	    String email = ctx.attributes['mail'].values[0].toString().toLowerCase()
	    
		User user = User.findByUsername(username)
		if(!user){
			Base base = Base.findAll {id == 1}[0]
			
			Role estudiante = Role.findAll {authority == 'ROLE_ESTUDIANTE'}[0]
			println estudiante
			
			user = new User(name: name, lastname: lastname, email: email, username: username, password: "12345fea", base:base)
			println ("*******"+user+"\n")
			user.save(flush: true)
			
			UserRole.create user,estudiante
			
			authorities = user.getAuthorities().collect { new SimpleGrantedAuthority(it.authority) }
		}
		
		def userDetails = new MyUserDetails(username, '', true, true, true, true,
			authorities, name, lastname, email)

		return userDetails
	}
	
	public void mapUserToContext(UserDetails user, DirContextAdapter ctx) {
	    throw new IllegalStateException("Only retrieving data from LDAP is currently supported")
	}

}