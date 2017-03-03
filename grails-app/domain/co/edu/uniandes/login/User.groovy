package co.edu.uniandes.login

import co.edu.uniandes.base.Base

class User {

	transient springSecurityService

	String name
	String lastname
	String email
	String username
	String password
	
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	static belongsTo = [base: Base]

	static transients = ['springSecurityService']

	static constraints = {
		username blank: false, unique: true
		password blank: false
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role }
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}
	
	String toString() {
		return name + " " + lastname + " (" + username + ")"
	}
}
