package fr.mbds.tpgrails

class GrPOI {

    String nom
    List pois

    static hasMany = [images: Illustration, pois: POI]

    static constraints = {
    }
}
