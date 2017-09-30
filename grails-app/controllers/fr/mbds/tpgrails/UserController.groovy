package fr.mbds.tpgrails

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UserController {

    def userService

    // TODO : secure sur les actions non autorisées
    // TODO : Modifier l'ihm + secure taglib
    // TODO : password encodage
    // DONE : logout

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    static Boolean linkMe = true

    def springSecurityService

    //@Secured(value=["ROLE_ADMIN", "ROLE_MODERATEUR"], httpMethod='GET')
    def index(Integer max) {
        println("HI")
        params.max = Math.min(max ?: 10, 100)
        //respond User.list(params), model:[userCount: User.count()]
        //respond userService.listingUtilisateurs(), model:[userCount: userService.tailleListing()]
        render view: 'index', model: [userList: userService.listingUtilisateurs(), userCount: userService.tailleListing()]
    }

    def show(User user) {
        respond user
    }


    //@Secured(value=["ROLE_ADMIN"], httpMethod='POST')
    def create() {
        respond new User(params)
    }

    @Transactional
    def save(User user) {
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

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), user.id])
                redirect user
            }
            '*' { respond user, [status: CREATED] }
        }
    }

    def edit(User user) {
        respond user
    }

    @Transactional
    def update(User user) {
        println("Update : {$user}")
        if (user == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (user.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond user.errors, view:'edit'
            return
        }

        user.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), user.id])
                redirect(mapping : "userProfile", id: springSecurityService.principal.id)
            }
            '*'{ respond user, [status: OK] }
        }
    }

    @Transactional
    def delete(User user) {

        if (user == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

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
        User utilisateurCourant = userService.profilUtilisateur()
        render view: 'profil', model: [user: utilisateurCourant, ]
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
