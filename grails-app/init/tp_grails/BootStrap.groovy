package tp_grails

import fr.mbds.tpgrails.Role
import fr.mbds.tpgrails.User
import fr.mbds.tpgrails.UserRole

class BootStrap {

    def init = { servletContext ->

        if (Role.count == 0) {
            def roleAdmin = new Role(authority: 'ROLE_ADMIN').save(flush: true, failOnError: true)
            def roleModerateur = new Role(authority: 'ROLE_MODERATEUR').save(flush: true, failOnError: true)
            def roleUtilisateur = new Role(authority: 'ROLE_UTILISATEUR').save(flush: true, failOnError: true)

            def utilisateur = new User(username: "user", password: "pass").save(flush: true, failOnError: true)
            def moderateur = new User(username: "modo", password: "passm").save(flush: true, failOnError: true)
            def administrateur = new User(username: "admin", password: "passa").save(flush: true, failOnError: true)

            UserRole.create(utilisateur, roleUtilisateur, true)
            UserRole.create(moderateur, roleModerateur, true)
            UserRole.create(administrateur, roleAdmin, true)

        }

    }
    def destroy = {
    }
}
