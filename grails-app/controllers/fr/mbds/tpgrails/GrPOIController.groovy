package fr.mbds.tpgrails

import org.springframework.web.multipart.MultipartFile
import org.springframework.web.multipart.MultipartHttpServletRequest

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class GrPOIController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    static Boolean linkMe = true
    static String joliNom = "Groupes de POI"

    def illustrationService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond GrPOI.list(params), model:[grPOICount: GrPOI.count()]
    }

    def show(GrPOI grPOI) {
        respond grPOI
    }

    def create() {
        respond new GrPOI(params)
    }

    @Transactional
    def save(GrPOI grPOI) {
        if (grPOI == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (grPOI.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond grPOI.errors, view:'create'
            return
        }

        grPOI.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'grPOI.label', default: 'GrPOI'), grPOI.id])
                redirect grPOI
            }
            '*' { respond grPOI, [status: CREATED] }
        }
    }

    def edit(GrPOI grPOI) {
        respond grPOI
    }

    @Transactional
    def update(GrPOI grPOI) {
        if (grPOI == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (grPOI.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond grPOI.errors, view:'edit'
            return
        }

        grPOI.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'grPOI.label', default: 'GrPOI'), grPOI.id])
                redirect grPOI
            }
            '*'{ respond grPOI, [status: OK] }
        }
    }

    @Transactional
    def updateCustom(GrPOI grPOI) {
        if (grPOI == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (grPOI.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond grPOI.errors, view:'edit'
            return
        }

        tryRequest(grPOI)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'grPOI.label', default: 'GrPOI'), grPOI.id])
                redirect grPOI
            }
            '*'{ respond grPOI, [status: OK] }
        }
    }

    def private tryRequest(GrPOI grPOI) {
        if (request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest mpr = (MultipartHttpServletRequest) request;
            MultipartFile file = (MultipartFile) mpr.getFile("file");

            def filename = illustrationService.tryUpload(file)

            if(filename != null) {
                illustrationService.saveGrPOIIllustration(filename, grPOI)
            }
        }
    }

    @Transactional
    def delete(GrPOI grPOI) {

        if (grPOI == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        grPOI.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'grPOI.label', default: 'GrPOI'), grPOI.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'grPOI.label', default: 'GrPOI'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
