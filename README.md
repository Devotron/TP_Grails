# Projet POI Grails :
### Plateforme  de gestion de points d’intérêts

Projet réalisé par Michaël Gianfaldone et Estelle Rostan dans le cadre de l'enseignement "Serveur Grails" du master 2 MBDS.

   Sujet : [TP (PDF) : Création d'une plateforme de gestion de points d'intérêts ](http://cours.tokidev.fr/mbds/grails/tp_grails.pdf )


## Informations

- Base de donnée : H2 Database
- Serveur web Apache pour le stockage des images


Comptes :
- Utilisateur simple : user@unice.fr, pass
- Modérateur : modo@unice.fr, passm
- Admin : admin@unice.fr, passa

## Modèle de données en fonction des contraintes et besoins du TP

![classes de l'application de gestion des POIs](https://github.com/Devotron/TP_Grails/blob/master/classes%20de%20l'application%20de%20gestion%20des%20POIs.png)

## Fonctionnalités implémentées

* Gestion des utilisateurs :
  - Accès aus fonctionnalités du site dépendamment des droits utilisateurs
  - Modérateur peut modifier certaines informations des utilisateurs simples
  - Admin peut modifier/créer/supprimer des utilisateurs
   
* Profil utilisateur : 
  Un utilisateur a accès à une page de profil sur laquelle il peut effectuer des modifications
  
* Création et édition de POIs et groupe de POIs où presque tous les attributs de ces derniers sont modifiables (ref : partie bug connus)
  
* Upload et affichage des images pour les POIs et les groupes de POIs

*  Stockage des images uploadées via les différents formulaires dans un serveur web Apache

   Configuré dans le fichier [application.groovy ](TP_Grails/grails-app/conf/application.groovy )
   
## Bugs connus

* L'ajout et modification de groupes de POIs ne se fait en passant par le POI
* On ne peut pas supprimer les images depuis l'édition de POIs

 [Voir les open issues ](https://github.com/Devotron/TP_Grails/labels/bug )
 
## Améliorations possibles

 [Voir les open issues ]( https://github.com/Devotron/TP_Grails/issues?q=is%3Aopen+is%3Aissue+label%3Aenhancement )
   
## Bonus

      Aucun bonus terminé pour l'instant.

Commencé :
* Upload d'images en drag’n’drop 
* Map pour les POIs et les groupes
