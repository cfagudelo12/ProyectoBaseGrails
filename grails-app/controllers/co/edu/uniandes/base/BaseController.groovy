package co.edu.uniandes.base

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class BaseController {

	static scaffold = true
   
}
