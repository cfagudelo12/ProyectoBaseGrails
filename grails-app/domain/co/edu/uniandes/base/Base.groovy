package co.edu.uniandes.base

import co.edu.uniandes.login.*

class Base {

    String name
	
	static hasMany = [users:User, roles:Role, groups:UserGroup, sections:Section]
	
    static constraints = {
		name size: 1..100, blank: false
    }
	
	String toString() {
		return name
	}
}
