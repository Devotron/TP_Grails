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
                <hr>
                <ul class="accordion">
                    <li>Accès aus fonctionnalités du site dépendamment des droits utilisateurs
                    Modérateur peut modifier certaines informations des utilisateurs simples</li>
                    <li>Admin peut modifier/créer/supprimer des utilisateurs</li>
                    <li>Profil utilisateur : Un utilisateur a accès à une page de profil sur laquelle il peut effectuer des modifications
                    </li>
                    <li>Création et édition de POIs et groupe de POIs où tous les attributs de ces derniers sont modifiables</li>
                    <li>Upload et affichage des images pour les POIs et les groupes de POIs</li>
                    <li>Stockage des images uploadées via les différents formulaires dans un serveur web Apache configuré dans le fichier application.groovy</li>

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
