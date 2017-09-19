package fr.mbds.tpgrails

class GrPOI {
    // Groupe POI
    String nom
    List pois

    Date dateCreated
    Date lastUpdated

    static hasMany = [images: Illustration, pois: POI]

    static constraints = {
    }

    static mapping = {
        images cascade: 'all-delete-orphan'
    }
}
