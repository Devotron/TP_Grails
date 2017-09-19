package fr.mbds.tpgrails

class POI {

    String nom
    String desc

    GeoLoc geopos
    // Reference au créateur du POI
    User auteur

    Date dateCreated
    Date lastUpdated


    static hasMany = [images: Illustration, grpois: GrPOI]

    static belongsTo = GrPOI

    //static mappedBy = [images: 'poi']

    static constraints = {
    }



    static mapping = {
        images cascade: 'all-delete-orphan'
    }
}
