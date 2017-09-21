package fr.mbds.tpgrails

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class IllustrationController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    static Boolean linkMe = false

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Illustration.list(params), model:[illustrationCount: Illustration.count()]
    }

    def show(Illustration illustration) {
        respond illustration
    }

    def create() {
        respond new Illustration(params)
    }

    @Transactional
    def save(Illustration illustration) {
        if (illustration == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (illustration.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond illustration.errors, view:'create'
            return
        }

        illustration.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'illustration.label', default: 'Illustration'), illustration.id])
                redirect illustration
            }
            '*' { respond illustration, [status: CREATED] }
        }
    }

    def edit(Illustration illustration) {
        respond illustration
    }

    @Transactional
    def update(Illustration illustration) {
        if (illustration == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (illustration.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond illustration.errors, view:'edit'
            return
        }

        illustration.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'illustration.label', default: 'Illustration'), illustration.id])
                redirect illustration
            }
            '*'{ respond illustration, [status: OK] }
        }
    }

    @Transactional
    def delete(Illustration illustration) {

        if (illustration == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        illustration.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'illustration.label', default: 'Illustration'), illustration.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'illustration.label', default: 'Illustration'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
