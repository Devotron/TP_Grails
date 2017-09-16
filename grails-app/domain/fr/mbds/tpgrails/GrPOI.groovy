package fr.mbds.tpgrails

class GrPOI {
    // Groupe POI
    String nom
    List pois

    static hasMany = [images: Illustration, pois: POI]

    static constraints = {
    }
}
