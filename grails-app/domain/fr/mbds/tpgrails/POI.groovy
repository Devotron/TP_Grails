package fr.mbds.tpgrails

class POI {

    String nom
    String desc

    GeoLoc geopos
    // Reference au créateur du POI
    User auteur

    Date dateCreated
    Date lastUpdated


    static hasMany = [images: Illustration]

    static belongsTo = [grpoi: GrPOI]

    static constraints = {
    }

    static mapping = {
        images cascade: 'all-delete-orphan'
    }
}
