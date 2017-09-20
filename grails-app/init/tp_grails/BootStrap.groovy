package tp_grails

import fr.mbds.tpgrails.Role
import fr.mbds.tpgrails.User
import fr.mbds.tpgrails.UserRole

class BootStrap {

    def init = { servletContext ->

        if (Role.count == 0) {
            // Création des rôles utilisateurs
            def roleAdmin = new Role(authority: 'ROLE_ADMIN').save(flush: true, failOnError: true)
            def roleModerateur = new Role(authority: 'ROLE_MODERATEUR').save(flush: true, failOnError: true)
            def roleUtilisateur = new Role(authority: 'ROLE_UTILISATEUR').save(flush: true, failOnError: true)
            // Création de compte utilisateurs par défaut
            def utilisateur = new User(username: "user", password: "pass", nom: "Wyatt", prenom: "Trevor", dateNai: new Date(1985, 12, 12)).save(flush: true, failOnError: true)
            def utilisateur2 = new User(username: "doe@unice.fr", password: "pass", nom: "Doe", prenom: "John", dateNai: new Date(1960, 8, 15)).save(flush: true, failOnError: true)
            def moderateur = new User(username: "modo", password: "passm", nom: "Dorian", prenom: "Gray",dateNai: new Date(1995, 12, 12)).save(flush: true, failOnError: true)
            def administrateur = new User(username: "admin", password: "passa", nom: "Shwarz", prenom: "Arnold", dateNai: new Date(1980, 10, 12)).save(flush: true, failOnError: true)

            //<f:table collection="${POIList}" properties="['id', 'nom','desc', 'geopos', 'auteur']"/>
            //<f:table collection="${illustrationList}" properties="['id', 'nom', 'src']"/>
            //<f:table collection="${grPOIList}" properties="['id', 'nom']" />
            UserRole.create(utilisateur, roleUtilisateur, true)
            UserRole.create(utilisateur2, roleUtilisateur, true)
            UserRole.create(moderateur, roleModerateur, true)
            UserRole.create(administrateur, roleAdmin, true)


        }

    }
    def destroy = {
    }
}
