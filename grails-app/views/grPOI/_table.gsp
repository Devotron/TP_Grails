<table id="${table}">
    <thead>
    <tr>
        <th>Nom</th>
        <th>Points d'interêts</th>
        <th>Images</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${grPOIList}" var="grpoi">
        <tr>
            <td>
                <a href="${createLink(action: 'show', params: [id: grpoi.id])}">${grpoi.nom}</a>
            </td>
            <td>
                <g:each in="${grpoi.pois.sort { it.nom }}">
                    <a href="${createLink(controller: 'POI', action: 'show', params: [id: it.id])}">${it.nom}</a>
                </g:each>
            </td>
            <td>
                <g:each in="${grpoi.images.sort { it.nom }}">
                    <a href="${createLink(controller: 'illustration', action: 'show', params: [id: it.id])}">
                        <img src="${grailsApplication.config.fileServerUrl + it.nom}"/>
                    </a>
                </g:each>
            </td>
        </tr>
    </g:each>
    </tbody>
</table>