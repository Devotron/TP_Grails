package fr.mbds.tpgrails

class Illustration {

    String src
    String nom
    Date dateAjout

    static belongsTo = [poi: POI, grpoi: GrPOI]

    static constraints = {
    }
}
