package fr.mbds.tpgrails

import org.springframework.web.multipart.MultipartFile
import org.springframework.web.multipart.MultipartHttpServletRequest

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class POIController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    static Boolean linkMe = true

    def illustrationService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond POI.list(params), model: [POICount: POI.count()]
    }

    def show(POI POI) {
        respond POI
    }

    def create() {
        respond new POI(params)
    }

    def upload() {
        def poi = new POI(params)

        if (request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest mpr = (MultipartHttpServletRequest) request;
            MultipartFile file = (MultipartFile) mpr.getFile("file");

            def filename = illustrationService.tryUpload(file)

            if(filename != null) {
                illustrationService.saveIllustration(filename, poi)
            }
            else {
                poi.save flush: true
            }
        }
        forward(action: "show", id: poi.id)
    }

    @Transactional
    def save(POI POI) {
        if (POI == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (POI.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond POI.errors, view: 'create'
            return
        }

        POI.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'POI.label', default: 'POI'), POI.id])
                redirect POI
            }
            '*' { respond POI, [status: CREATED] }
        }
    }

    def edit(POI POI) {
        respond POI
    }

    @Transactional
    def update(POI POI) {
        if (POI == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (POI.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond POI.errors, view: 'edit'
            return
        }

        POI.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'POI.label', default: 'POI'), POI.id])
                redirect POI
            }
            '*' { respond POI, [status: OK] }
        }
    }

    @Transactional
    def delete(POI POI) {

        if (POI == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        POI.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'POI.label', default: 'POI'), POI.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'POI.label', default: 'POI'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
