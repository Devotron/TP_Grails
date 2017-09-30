package fr.mbds.tpgrails

import grails.gorm.transactions.Transactional

import static fr.mbds.tpgrails.User.find
import static fr.mbds.tpgrails.User.get

@Transactional
class UserService {

    def springSecurityService

    //Récupération du profil client
    def profilUtilisateur() {
        return User.findById(springSecurityService.getCurrentUserId())
    }

    //Listing des utilisateurs, dépendemment des droits
    def listingUtilisateurs() {

        def listing
        println("[UserService] listingUtilisateurs")
        if ( springSecurityService.getAuthentication().getAuthorities().toArray().getAt(0).toString().equals('ROLE_ADMIN') ) {
            println("[UserService] Droit admin")
            listing = User.getAll()

        } else if ( springSecurityService.getAuthentication().getAuthorities().toArray().getAt(0).toString().equals('ROLE_MODERATEUR') ) {
            println("[UserService] Droit modérateur")


            Role porteeModo = Role.findByAuthority('ROLE_UTILISATEUR')

            listing = UserRole.findAllByRole(porteeModo)

        }

       return listing
    }

    //Taille du listing
    def tailleListing() {

        def taille

        if ( springSecurityService.getAuthentication().getAuthorities().toArray().getAt(0).toString().equals('ROLE_ADMIN') ) {
            taille = User.getCount()

        } else if ( springSecurityService.getAuthentication().getAuthorities().toArray().getAt(0).toString().equals('ROLE_MODERATEUR') ) {
            Role porteeModo = Role.findByAuthority('ROLE_UTILISATEUR')
            taille = UserRole.findAllByRole(porteeModo).toArray().size()
            println(taille)
        }

        return taille
    }


}
