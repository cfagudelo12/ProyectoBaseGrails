package co.edu.uniandes.login

import co.edu.uniandes.base.Base

class Role {

	String authority
	
	static belongsTo = [base: Base]

	static mapping = {
		cache true
	}

	static constraints = {
		authority blank: false, unique: true
	}
	
	String toString() {
		return authority
	}
}
