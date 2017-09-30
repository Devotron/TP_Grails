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

    def saveIllustration(def filename, POI poi = null, GrPOI grpoi = null) {
        // initialisation
        def illustration = new Illustration()
        illustration.nom = filename
        illustration.poi = poi

        // sauvegarder les objets
        if (poi != null) {
            poi.addToImages(illustration)
            poi.save flush: true
        }

        if (grpoi != null) {
            grpoi.addToImages(illustration)
            grpoi.save flush: true
        }
    }
}
