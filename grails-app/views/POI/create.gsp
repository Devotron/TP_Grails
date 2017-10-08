<%@ page import="fr.mbds.tpgrails.Illustration" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'POI.label', default: 'POI')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
    <g:render template="../navbar" model="[navbar: myNavBar]" />
        <a href="#create-POI" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label.poi"/></g:link></li>
                <li><g:link class="create" action="create" controller="geoLoc"><g:message code="default.new.label.geoloc"></g:message></g:link></li>
            </ul>
        </div>
        <div id="create-POI" class="content scaffold-create" role="main">
            <h1>Création d'un point d'interêt</h1>
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
            <g:form resource="${this.POI}"  enctype="multipart/form-data"  method="POST">
                <fieldset class="form">
                    <g:render template="champsPOI" model="[champs: champs]" />
                </fieldset>
                <fieldset class="buttons">
                    <g:actionSubmit name="create" action="upload" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
