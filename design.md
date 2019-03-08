Un document d'architecture 
- Fichier design.md à la racine du github qui reprend les grands éléments d'architecture 

<h1> Document d'architecture</h1>

Le projet est divisé en 6 packages:
 - métier
    Les classes métier du projet sont définies dans celui-ci:
      - Alergie.java
      - DateProposee.java
      - PreferenceAlimentaire.java
      - Reunion.java
      - Sondage.java
      - Utilisateur.java  
 - daoInterface
      - les interfaces des classes permettant d'effectuer les changements qu'on veut dans une table (CRUD). Les classes présentent dans ce package correspondent à celles métier
 - daoImplementation
      - les implementations des interfaces DAO
 - service
      - On utilise le framework jax-rs pour remplacer la couche servlet et créer des urls permettant l'affichage dese données contenues en base (ex: les utilisateurs, les utilisateurs participant à une reunion) 
 - servlet
      - Les classes présentent dans ce package permettent de créer des sondages et des utilisateurs via servlet. Cela permet également aux utilisateurs de répondre aux sondages.
 - jpa
      - Ce package contient notamment la classe JpaTest qui va initialiser la BDD.
 

