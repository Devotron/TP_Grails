package fr.mbds.tpgrails

class Illustration {
    // src : url source de l'emplacement de l'image sur le serveur web
    String src
    String nom
    Date dateAjout

    static belongsTo = [poi: POI, grpoi: GrPOI]

    static constraints = {
    }
}
