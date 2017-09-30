<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>

    <g:render template="navbar" model="[navbar: myNavBar]" />

    <div class="svg" role="presentation">
        <div class="grails-logo-container">
            <asset:image src="grails-cupsonly-logo-white.svg" class="grails-logo" />
        </div>
    </div>

    <div id="content" role="main">
        <section class="row colset-2-its">
            <h1>Projet "Gestion de points d'interêt"</h1>

            <p>
                Ci-dessous, vous pourrez retrouvez les fonctionnalité implementées.
                Toute fonctionnalité partiellement implementé sera précisé avec leur état d'avancement.
                <ul class="accordion">
                    <li>Securisation des accès au fonctionnalité du site :
                    (InterceptURL + secure taglib + verification des permissions
                    lors des appels d'action controlleur)</li>
                </ul>


            </p>

            <div id="controllers" role="navigation">
                <h2>Controlleurs disponnibles :</h2>
                <ul>
                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                        <li class="controller">
                            <g:link controller="${c.logicalPropertyName}">Controlleur ${c.name}</g:link>
                        </li>
                    </g:each>
                    <li class="controller">
                        <g:link controller="user" action="profil">Profil utilisateur</g:link>
                    </li>
                </ul>
            </div>
        </section>
    </div>

</body>
</html>
