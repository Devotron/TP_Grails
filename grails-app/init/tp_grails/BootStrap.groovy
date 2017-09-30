package tp_grails

import fr.mbds.tpgrails.GeoLoc
import fr.mbds.tpgrails.GrPOI
import fr.mbds.tpgrails.Illustration
import fr.mbds.tpgrails.POI
import fr.mbds.tpgrails.Role
import fr.mbds.tpgrails.User
import fr.mbds.tpgrails.UserRole

import java.sql.Date


class BootStrap {

    def init = { servletContext ->

        if (Role.count == 0) {
            // Création des rôles utilisateurs
            def roleAdmin = new Role(authority: 'ROLE_ADMIN').save(flush: true, failOnError: true)
            def roleModerateur = new Role(authority: 'ROLE_MODERATEUR').save(flush: true, failOnError: true)
            def roleUtilisateur = new Role(authority: 'ROLE_UTILISATEUR').save(flush: true, failOnError: true)
            // Création de compte utilisateurs par défaut
            def utilisateur = new User(username: "user", password: "pass", nom: "Wyatt", prenom: "Trevor", dateNai: Date.parse("yyyy-MM-dd", "1985-04-03")).save(flush: true, failOnError: true)
            def utilisateur2 = new User(username: "doe@unice.fr", password: "pass", nom: "Doe", prenom: "John", dateNai: Date.parse("yyyy-MM-dd", "1960-08-15")).save(flush: true, failOnError: true)
            def moderateur = new User(username: "modo", password: "passm", nom: "Dorian", prenom: "Gray", dateNai: Date.parse("yyyy-MM-dd", "1995-12-12")).save(flush: true, failOnError: true)
            def administrateur = new User(username: "admin", password: "passa", nom: "Shwarz", prenom: "Arnold", dateNai: Date.parse("yyyy-MM-dd", "1980-10-12")).save(flush: true, failOnError: true)

            //  On sauvegarde les utilisateurs et leurs rôles
            //<f:table collection="${POIList}" properties="['id', 'nom','desc', 'geopos', 'auteur']"/>
            //<f:table collection="${illustrationList}" properties="['id', 'nom', 'src']"/>
            //<f:table collection="${grPOIList}" properties="['id', 'nom']" />
            UserRole.create(utilisateur, roleUtilisateur, true)
            UserRole.create(utilisateur2, roleUtilisateur, true)
            UserRole.create(moderateur, roleModerateur, true)
            UserRole.create(administrateur, roleAdmin, true)

            if (GrPOI.count == 0 && POI.count == 0) {

                for (int i = 0; i < 3; i++) {
                    // On crée le groupe et on garde une référence sur ce dernier
                    def groupe = new GrPOI(nom: "Groupe " + i).save(flush: true, failOnError: true)

                    for (int j = 0; j < 5; j++) {
                        // On crée un POI sans le persister et on garder une référence
                        def poi = new POI(nom: "POI " + j, desc: "POI " + j, auteur: utilisateur, geopos: new GeoLoc(latitude: 17.12, longitude: 7.14))

                        // On ajoute des illustrations au POI
                        Set<Illustration> illustrations = [new Illustration(nom: "placeholder140x110.png"), new Illustration(nom: "placeholder200x200.png")]
                        illustrations.each {
                            poi.addToImages(it)
                        }

                        // Puis on ajoute le POI précédemment créé dans le groupe
                        groupe.addToPois(poi)
                        // On sauvegarde le parent, qui s'occupera de sauvegarder ses fils
                        groupe.save(flush: true, failOnError: true)
                    }

                    def illustration = new Illustration(nom: "placeholder2430x970.png")
                    groupe.addToImages(illustration)
                }
            }
        }
    }

    def destroy = {
    }
}
