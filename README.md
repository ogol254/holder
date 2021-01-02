# Devops Project

Cette webapp permet d'afficher une liste des 100 meilleurs films de tous les temps.

Son fonctionnement est le suivant:
- à l'initialisation:
  - elle récupère la Datasource JDBC via la ressources JNDI `jdbc/devopsdblocal`
  - elle peuple une table avec la liste des 100 meilleurs films
- à l'appel de la servlet, elle renvoit un contenu HTML.

La seule librairie nécessaire est celle des servlets qui est normalement fournie par le serveur d'application.

Pour construire le war : `mvn clean package`