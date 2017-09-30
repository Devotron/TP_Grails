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

    // Vérification des droits pour les cas du edit/update et delete
    def verificationDroits(User user) {

        boolean aLesDroits = false

        if ( springSecurityService.getPrincipal().getAt('authorities')[0].toString().equals('ROLE_MODERATEUR') ) {
            // MODERATEUR :
            Role porteeModo = Role.findByAuthority('ROLE_UTILISATEUR')

            println("Type d'utilisateur : ${user.getAuthorities()[0].authority}")

            if ( user.getAuthorities().contains(porteeModo) ) {
                println("Compte d'un utilisateur")
                aLesDroits = true
            } else {
                println("Compte d'un moderateur ou admin")
                aLesDroits = false
            }
        } else if ( springSecurityService.getPrincipal().getAt('authorities')[0].toString().equals('ROLE_ADMIN') ) {
            aLesDroits = true
        }

        return aLesDroits

    }

    def verificationTypeMAJ(User user) {
        def IDcourant = springSecurityService.currentUserId
        println("Utilisateur courant {$IDcourant}")

        boolean estProfil = false

        if ( IDcourant == user.id ) {
            estProfil = true
        }

        println(estProfil)
        return estProfil

    }

}
