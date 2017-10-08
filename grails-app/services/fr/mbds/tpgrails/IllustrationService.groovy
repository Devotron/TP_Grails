package fr.mbds.tpgrails

import grails.gorm.transactions.Transactional
import org.springframework.web.multipart.MultipartFile

@Transactional
class IllustrationService {

    def grailsApplication

    def tryUpload(MultipartFile file) {
        if (file.empty) {
            // TODO : error handling
            return
        }
        String filename  = file.originalFilename

        // enregistrer l'illustration sur le serveur web de stockage de fichiers
        def cheminFichier = grailsApplication.config.uploadFolder + filename
        file.transferTo(new File(cheminFichier))

        return filename
    }

    def savePOIIllustration(def filename, POI poi) {
        def illustration = new Illustration()
        illustration.nom = filename

        if (poi != null) {
            poi.addToImages(illustration)
            poi.save flush: true
        }
        else {
            poi.save flush: true
        }
    }

    def saveGrPOIIllustration(def filename, GrPOI grPOI) {
        def illustration = new Illustration()
        illustration.nom = filename

        if (grPOI != null) {
            grPOI.addToImages(illustration)
            grPOI.save flush: true
        }
        else {
            grPOI.save flush: true
        }
    }
}
