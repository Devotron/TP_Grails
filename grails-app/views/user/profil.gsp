<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
    <title>Edition de profil</title>
</head>
<body>
<g:render template="../navbar" model="[navbar: myNavBar]" />
<a href="#edit-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
    </ul>
</div>
<div id="edit-profil" class="content scaffold-edit" role="main">
    <h1>Editer votre profil</h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${this.user}">
        <ul class="errors" role="alert">
            <g:eachError bean="${this.user}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>

    <g:form resource="${this.user}" method="PUT">
        <g:hiddenField name="version" value="${this.user?.version}" />
        <fieldset class="form">

            <f:field property="nom">
                <g:field type="text" name="nom" value="${user.nom}"/>
            </f:field>
            <f:field property="prenom">
                <g:field type="text" name="prenom" value="${user.prenom}"/>
            </f:field>
            <f:field property="username" label="Login" required="true">
                <g:field type="text" name="username" value="${user.username}"/>
            </f:field>
            <f:field property="password" label="Mot de passe" required="true">
                <g:passwordField name="password" value="${user.password}"/>
            </f:field>
            <f:field property="dateNaissance" label="Date de naissance"  required="true">
                <g:datePicker name="dateNai" value="${user.dateNai}" precision="day"/>
            </f:field>
            <f:field property="role">
                <g:field type="text" name="role" value="${profil}" disabled=""/>
            </f:field>

        </fieldset>
        <fieldset class="buttons">
            <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
        </fieldset>
    </g:form>
</div>
</body>
</html>
