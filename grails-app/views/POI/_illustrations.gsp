<g:if test="${this.POI.images}">
    <g:each in="${this.POI.images.sort{it.nom}}" id="files">
        <img src="${grailsApplication.config.fileServerUrl + it.nom}" />
    </g:each>
</g:if>