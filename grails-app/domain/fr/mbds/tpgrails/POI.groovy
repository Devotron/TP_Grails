package fr.mbds.tpgrails

class POI {

    String nom
    String desc

    GeoLoc geopos
    User auteur

    static hasMany = [images: Illustration]

    static constraints = {
    }
}
