<table id="${table}">
    <thead>
    <tr>
        <th>Nom</th>
        <th>Description</th>
        <th>Lieu</th>
        <th>Groupes</th>
        <th>Auteur</th>
        <th>Images</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${POIList}" var="pois">
        <tr>
            <td>
                <a href="${createLink(action: 'show', params: [id: pois.id])}">${pois.nom}</a>
            </td>
            <td>
                ${pois.desc}
            </td>
            <td>
                <a href="${createLink(controller: 'GeoLoc', action: 'show', params: [id: pois.id])}">
                    Latitude :${pois.geopos.latitude} Longitude :${pois.geopos.longitude}
                </a>
            </td>
            <td>
                <g:each in="${pois.grpois.sort { it.nom }}">
                    <a href="${createLink(controller: 'GrPOI', action: 'show', params: [id: pois.id])}">
                        ${it.nom}
                    </a>
                </g:each>
            </td>
            <td>
                <a href="${createLink(controller: 'User', action: 'show', params: [id: pois.id])}">
                    ${pois.auteur.prenom} ${pois.auteur.nom}
                </a>
            </td>
            <td>
                <g:each in="${pois.images.sort { it.nom }}">
                    <a href="${createLink(controller: 'illustration', action: 'show', params: [id: it.id])}">
                        <img src="${grailsApplication.config.fileServerUrl + it.nom}"/>
                    </a>
                </g:each>
            </td>
            %{--<td><a href="/Localisation/show/${pois.id}">${pois.lattitude}</a></td>--}%
            %{--<td><a href="/Localisation/show/${pois.id}">${pois.country}</a></td>--}%
        </tr>
    </g:each>
    </tbody>
</table>