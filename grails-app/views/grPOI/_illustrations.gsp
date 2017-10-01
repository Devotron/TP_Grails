<g:each in="${this.grPOI.images.sort{it.nom}}" id="files">
    <img src="${grailsApplication.config.fileServerUrl + it.nom}" />
</g:each>