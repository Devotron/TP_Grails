package fr.mbds.tpgrails

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class GeoLocController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond GeoLoc.list(params), model:[geoLocCount: GeoLoc.count()]
    }

    def show(GeoLoc geoLoc) {
        respond geoLoc
    }

    def create() {
        respond new GeoLoc(params)
    }

    @Transactional
    def save(GeoLoc geoLoc) {
        println(params)
        if (geoLoc == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (geoLoc.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond geoLoc.errors, view:'create'
            return
        }

        geoLoc.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'geoLoc.label', default: 'GeoLoc'), geoLoc.id])
                redirect geoLoc
            }
            '*' { respond geoLoc, [status: CREATED] }
        }
    }

    def edit(GeoLoc geoLoc) {
        respond geoLoc
    }

    @Transactional
    def update(GeoLoc geoLoc) {
        if (geoLoc == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (geoLoc.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond geoLoc.errors, view:'edit'
            return
        }

        geoLoc.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'geoLoc.label', default: 'GeoLoc'), geoLoc.id])
                redirect geoLoc
            }
            '*'{ respond geoLoc, [status: OK] }
        }
    }

    @Transactional
    def delete(GeoLoc geoLoc) {

        if (geoLoc == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        geoLoc.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'geoLoc.label', default: 'GeoLoc'), geoLoc.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'geoLoc.label', default: 'GeoLoc'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
