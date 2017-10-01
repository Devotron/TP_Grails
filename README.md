# Projet POI Grails

Projet réalisé par Michaël Gianfaldone et Estelle Rostan dans le cadre de l'enseignement "Serveur Grails" du master 2 MBDS.

## Informations

Base de donnée : H2 Database

Comptes :
- Utilisateur simple : user@unice.fr, pass
- Modérateur : modo@unice.fr, passm
- Admin : admin@unice.fr, passa

## Contraintes et besoins

[[https://github.com/Devotron/TP_Grails/blob/master/classes%20de%20l'application%20de%20gestion%20des%20POIs.png
|alt=classes de l'application de gestion des POIs]]

## Fonctionnalités implémentées

* Gestion des utilisateurs :
  - Accès au fonctionnalité du site dépendamment des droits utilisateurs
  - Modérateur peut modifier certaines informations des utilisateurs simples
  - Admin peut modifier/créer des utilisateurs
   
* Profil utilisateur : 
  Un utilisateur a accès à une page de profil sur laquelle il peut effectuer des modifications
  
* Création et édition de POIs et groupe de POIs où tous les attributs de ces derniers sont modifiables 
  
* Upload et affichage des images pour les POIs et les groupes de POIs

*  Sockage des images uploadées via les différents formulaires dans un serveur web Apache

   Configuré dans le fichier [application.groovy ](TP_Grails/grails-app/conf/application.groovy )
   
## Bonus

Aucun bonus terminé pour l'instant.
