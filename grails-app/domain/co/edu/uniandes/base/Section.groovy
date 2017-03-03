package co.edu.uniandes.base

class Section {

    String name
	
	static hasMany = [groups: UserGroup]	
	static belongsTo = [base: Base]
	
    static constraints = {
		name size: 1..100, blank: false
    }
	
	String toString() {
		return name
	}
}
