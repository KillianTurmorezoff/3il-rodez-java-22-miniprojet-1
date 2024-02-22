## Ce que j'ai fait
Ce projet est presque complet, toutes les questions nécessaires sont traitées. Seul le générateur de carte avec le bruit de Perlin ne fonctionne pas. J'imagine que la solution est toute proche mais je n'ai pas trouvé. Aucun test unitaire n'a été effectué.

## Réponse aux questions
**Question :** pourquoi l'attribut graine est-il en final ?
**Réponse :** Il est `final` car sa référence ne changera pas au cours du programme.

**Question :** Réaliser l'architecture que prendrait la forme d'une telle modélisation sous forme d'un diagramme UML. Quelle serait la différence d'attributs et de méthodes entre ces classes ? Expliquer, en s'appuyant sur un exercice vu en cours, pourquoi c'est une mauvaise idée. Quelle est la solution qu'il faudrait préférer (et que l'on va préférer) ?
**Réponse :** C'est une mauvaise idée car il y a beaucoup d'héritage alors que l'on pourrait utiliser un enum, ce qui est bien plus clair à utiliser dans notre cas.

**Question :** quel type utilisez-vous ?
**Réponse :** des `double`.

**Question :** pourquoi sortir, selon vous, ce bout d'algorithme de la classe ?
**Réponse :** Faciliter la maintenance du code et le rendre modulaire.

## Retour personnel
Le début du projet était assez simple en soi, mais cela s'est **très** fortement compliqué à partir du titre _Un peu de modélisation objet dans votre Perlin ?_ L'aide d'outils extérieurs était nécessaire pour avancer dans ce projet.
