<div id="${champsPOI}">
    <f:display bean="POI" order="nom, desc, auteur, grpois"/>
    <f:with bean="POI">
        <ol class="property-list POI">

            <li class="fieldcontain">
                <span id="latitudelabel" class="property-label">Latitude</span>
                <div class="property-value" aria-labelledby="nom-label">${POI.geopos.latitude}</div>
            </li>
            <li class="fieldcontain">
                <span id="longitude-label" class="property-label">Longitude</span>
                <div class="property-value" aria-labelledby="nom-label">${POI.geopos.longitude}</div>
            </li>
    </f:with>
</div>