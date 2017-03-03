import co.edu.uniandes.login.*
import co.edu.uniandes.base.*

class BootStrap {

    def init = { servletContext ->
		
		Base base = new Base(name: 'Proyecto Base');
		base.save(flush:true)

		def usuarios = crearUsuarios(base)
		
		def grupos = crearGrupos(base)
		
		crearSeccion(base, grupos, usuarios)
    }
    def destroy = {
		/**
		 * Á \u00C1
		 * á \u00E1
		 * É \u00C9
		 * é \u00E9
		 * Í \u00CD
		 * í \u00ED
		 * Ó \u00D3
		 * ó \u00F3
		 * Ú \u00DA
		 * ú \u00FA
		 * Ü \u00DC
		 * ü \u00FC
		 * ñ \u00F1
		 * Ñ \u00D0
		 * ¿ \u00BF
		 * @return
		 */
    }
	
	def crearUsuarios(base) {
		
		Role role1  = new Role(authority: "ROLE_ADMIN", base:base)
		Role role2  = new Role(authority: "ROLE_ESTUDIANTE", base:base)
		
		role1.save(flush: true)
		role2.save(flush: true)
		
		def usuarios = []
		usuarios.add(new User(name: 'Ricardo', lastname: 'Calle', email: 'cr.calle@uniandes.edu.co',username:'cr.calle', password:'12345', base:base))
		usuarios.add(new User(name: 'Luis David', lastname: 'Vargas Linares', email: 'ld.vargas@uniandes.edu.co',username:'ld.vargas', password:'12345', base:base))
		usuarios.add(new User(name: 'Christiano', lastname: 'Kruz', email: 'c.kruz@uniandes.edu.co',username:'c.kruz', password:'12345', base:base))
		usuarios.add(new User(name: 'Estudiante', lastname: 'Prueba 1', email: 'c.kraus@uniandes.edu.co',username:'uprueba1', password:'12345', base:base))
		usuarios.add(new User(name: 'Estudiante', lastname: 'Prueba 2', email: 'c.kraus@uniandes.edu.co',username:'uprueba2', password:'12345', base:base))
		usuarios.add(new User(name: 'Estudiante', lastname: 'Prueba 3', email: 'c.kraus@uniandes.edu.co',username:'uprueba3', password:'12345', base:base))
		usuarios.add(new User(name: 'Estudiante', lastname: 'Prueba 4', email: 'c.kraus@uniandes.edu.co',username:'uprueba4', password:'12345', base:base))
		usuarios.add(new User(name: 'Estudiante', lastname: 'Prueba 5', email: 'c.kraus@uniandes.edu.co',username:'uprueba5', password:'12345', base:base))
		usuarios.add(new User(name: 'Estudiante', lastname: 'Prueba 6', email: 'c.kraus@uniandes.edu.co',username:'uprueba6', password:'12345', base:base))
		usuarios.add(new User(name: 'Estudiante', lastname: 'Prueba 7', email: 'c.kraus@uniandes.edu.co',username:'uprueba7', password:'12345', base:base))
		usuarios.add(new User(name: 'Estudiante', lastname: 'Prueba 8', email: 'c.kraus@uniandes.edu.co',username:'uprueba8', password:'12345', base:base))
		usuarios.add(new User(name: 'Estudiante', lastname: 'Prueba 9', email: 'c.kraus@uniandes.edu.co',username:'uprueba9', password:'12345', base:base))
		
		for(variable in usuarios) {
			variable.save(flush: true)
		}
		
		UserRole.create usuarios[0],role1
		UserRole.create usuarios[1],role1
		UserRole.create usuarios[2],role1
		
		for(variable in usuarios) {
			UserRole.create variable,role2
		}
	
		return usuarios
	}
	
	def crearGrupos(base){
		def gr = []
		gr.add(new UserGroup(name: 'Grupo 1', members: [], base:base))
		gr.add(new UserGroup(name: 'Grupo 2', members: [], base:base))
		gr.add(new UserGroup(name: 'Grupo 3', members: [], base:base))
		
		for(variable in gr) {
			variable.save(flush: true)
		}
		
		return gr
	}
	
	def crearSeccion(base, grupos, usuarios){
		Section section = new Section(name: 'Seccion 1', groups: [], base:base)
		section.save(flush: true)
		
		UserGroup g = grupos[0]
		g.members.add(usuarios[3])
		g.members.add(usuarios[4])
		g.members.add(usuarios[5])
		g.save(flush: true)
		
		section.groups.add(g)
		
		g = grupos[1]
		g.members.add(usuarios[6])
		g.members.add(usuarios[7])
		g.members.add(usuarios[8])
		g.save(flush: true)
		
		section.groups.add(g)
		
		g = grupos[2]
		g.members.add(usuarios[9])
		g.members.add(usuarios[10])
		g.members.add(usuarios[11])
		g.save(flush: true)
		
		section.groups.add(g)		
		section.save(flush: true)
	}
}
