package fr.mbds.tpgrails

class POI {

    String nom
    String desc

    GeoLoc geopos
    // Reference au créateur du POI
    User auteur

    static hasMany = [images: Illustration]

    static constraints = {
    }
}
