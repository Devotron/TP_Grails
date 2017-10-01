package fr.mbds.tpgrails

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UserController {

    def userService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    static Boolean linkMe = true
    static String joliNom = "Utilisateurs"

    def springSecurityService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        //respond User.list(params), model:[userCount: User.count()]
        //respond userService.listingUtilisateurs(), model:[userCount: userService.tailleListing()]
        println(User.getAll().class.getTypeName())
        println(userService.listingUtilisateurs())

        render view: 'index', model: [userList: userService.listingUtilisateurs(), userCount: userService.tailleListing()]
    }

    def show(User user) {

        println("********************************")
        println("Show : (ID :{$user.id}, USERNAME : {$user.username}, ROLE : {$user.authorities.authority})")
        boolean permission = userService.verificationDroits(user)

        String roleU = userService.roleUtilisateur(user)

        if (permission) {
            println("Permission OK ${user.getAuthorities()[0].authority}")
            respond user, model: [role: roleU]

        } else {
            println("Permission KO ${user.getAuthorities()[0].authority}")
            flash.error = "Vous n'avez pas les permissions pour visualiser les informations de cet utilisateur"
            redirect(action:index())
            return
        }


    }


    def create() {
        println("********************************")
        println("Create : ")

        def rolesU = Role.getAll()

        render view: 'create', model: [user: new User(params), roles: Role.getAll().sort {-it.id}]

        //respond new User(params), model: []
    }

    @Transactional
    def save(User user) {
        println("********************************")
        println("Save : (ID :{$user.id}, USERNAME : {$user.username}")


        if (user == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (user.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond user.errors, view:'create'
            return
        }

        user.save flush:true
        UserRole.create(user, Role.findById(params['roles.authority']), true)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), user.id])
                redirect user
            }
            '*' { respond user, [status: CREATED] }
        }
    }

    def edit(User user) {
        println("********************************")
        println("Edit : (ID :{$user.id}, USERNAME : {$user.username}, ROLE : {$user.authorities.authority})")
        boolean permission = userService.verificationDroits(user)
        println("Permission : {$permission}")

        if ( permission ) {
            println("Permission OK ${user.getAuthorities()[0].authority}")
            println("User : (ID :{$user.id}")
            respond user

        } else {

            println("Permission KO ${user.getAuthorities()[0].authority}")
            flash.error = "Vous n'avez pas les permissions pour modifier cet utilisateur"
            redirect(action: index())
            return
        }
        respond user
    }

    @Transactional
    def update(User user) {
        println("********************************")
        println("Update : (ID :{$user.id}, USERNAME : {$user.username}, ROLE : {$user.authorities.authority})")


        if (user == null) {
            println("Update : user null")
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (user.hasErrors()) {
            println("Update : hasErrors")
            transactionStatus.setRollbackOnly()
            respond user.errors, view:'edit'
            return
        }

        user.save flush:true

        // Mise à jour d'un profil
        if ( userService.verificationTypeMAJ(user) ) {
            println("MAJ Profil")
            flash.message = "Modification du profil enregistrée"
            //redirect(action: profil(), params:[status: OK, user: user])
            redirect(url: "/user/profil")
            //forward action: "profil"
            return

        } else {
            println("Autre MAJ")
            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), user.id])
                    redirect user
                }
                '*'{ respond user, [status: OK] }
            }
        }

    }

    @Transactional
    def delete(User user) {
        println("********************************")
        println("Delete : {$user}")
        if (user == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        UserRole.findByUser(user).delete()

        user.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), user.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    def profil() {
        println("********************************")
        println("Profil : ")
        User utilisateurCourant = userService.profilUtilisateur()
        String roleU = UserRole.findByUser(utilisateurCourant).getRole().getAuthority()
        println(roleU)

        render view: 'profil', model:[user: utilisateurCourant, profil: roleU]
    }


    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
