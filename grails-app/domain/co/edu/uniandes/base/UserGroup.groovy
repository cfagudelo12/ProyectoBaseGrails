package co.edu.uniandes.base

import co.edu.uniandes.login.User;

class UserGroup {

    String name
	
	static hasMany = [members: User]	
	static belongsTo = [base: Base]
    static withTable="group_user"

	
    static constraints = {
		name size: 1..100, blank: false
    }
	
	String toString() {
		return name
	}
}
