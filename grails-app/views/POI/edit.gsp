<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'POI.label', default: 'POI')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <g:render template="../navbar" model="[navbar: myNavBar]" />
        <a href="#edit-POI" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label.poi" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label.poi" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="edit-POI" class="content scaffold-edit" role="main">
            <h1>Edition de point d'interêt</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.POI}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.POI}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.POI}" method="PUT">
                <g:hiddenField name="version" value="${this.POI?.version}" />
                <fieldset class="form">
                    <g:render template="champsPOI" model="[champs: champs]" />
                </fieldset>
                <g:render template="illustrations" model="[files: files]" />
                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
            <g:form resource="${this.POI}"  enctype="multipart/form-data" method="POST">
                <label>Rajouter une image</label>
                <input type="file" name="file" />
                <g:actionSubmit action="updateCustom"  class="save" value="${message(code: 'default.button.updateImage.label', default: 'Update image')}" />
            </g:form>
    </div>
    </body>
</html>
