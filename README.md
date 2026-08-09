







# 🚚 LogiTrack — API REST de Gestion Logistique

> API REST de gestion des clients, produits et commandes développée avec Spring Boot, Spring Data JPA et MySQL.

---

## 1. Présentation du projet

**LogiTrack** est une API REST développée pour gérer les opérations logistiques entre les clients et l'entrepôt.

L'application permet de gérer les clients, les produits, les commandes et les lignes de commande à travers des endpoints REST.

La deuxième partie du projet intègre également **Spring Security et JWT** afin de sécuriser l'accès à l'API et de gérer les autorisations selon les rôles des utilisateurs.

L'objectif principal est de proposer une API structurée, sécurisée et maintenable pour faciliter la gestion des opérations logistiques.

---

## 2. Problématique

La gestion des clients, des produits et des commandes peut devenir complexe lorsque les informations sont dispersées ou traitées manuellement.

LogiTrack propose une solution centralisée permettant de gérer ces informations à travers une API REST.

La sécurisation des accès permet également de protéger les données et de contrôler les fonctionnalités accessibles aux différents utilisateurs.

---

## 3. Fonctionnalités principales

### Gestion des clients

* Ajouter un client
* Afficher tous les clients
* Consulter un client par son identifiant
* Supprimer un client

### Gestion des produits

* Ajouter un produit
* Afficher tous les produits
* Consulter un produit par son identifiant
* Supprimer un produit
* Rechercher les produits par catégorie
* Rechercher les produits selon leur prix
* Afficher les produits avec un stock faible

### Gestion des commandes

* Créer une commande pour un client
* Ajouter un produit à une commande
* Afficher toutes les commandes
* Consulter une commande par son identifiant
* Rechercher les commandes d'un client
* Modifier le statut d'une commande
* Consulter le nombre total de commandes
* Identifier le produit le plus commandé

### Authentification et sécurité

* Créer un compte utilisateur
* Se connecter à l'API
* Générer un token JWT
* Protéger les endpoints REST
* Gérer les rôles utilisateurs
* Contrôler les autorisations avec Spring Security

### Recherche et performance

* Paginer les résultats
* Rechercher les données avec les Derived Queries
* Utiliser des requêtes personnalisées avec `@Query`
* Gérer les migrations de la base de données avec Flyway

### Documentation et tests

* Documenter l'API avec Swagger/OpenAPI
* Tester les endpoints avec Postman
* Tester les services avec JUnit et Mockito

---

# 4. Technologies utilisées

| Technologie           | Utilisation                                  |
| --------------------- | -------------------------------------------- |
| **Java 21**           | Langage principal                            |
| **Spring Boot**       | Développement de l'API REST                  |
| **Spring Web**        | Création des endpoints REST                  |
| **Spring Data JPA**   | Accès et manipulation des données            |
| **Hibernate**         | Mapping objet-relationnel                    |
| **Spring Security**   | Sécurisation de l'API                        |
| **JWT**               | Authentification des utilisateurs            |
| **MySQL**             | Base de données                              |
| **Flyway**            | Gestion des migrations de la base de données |
| **MapStruct**         | Conversion Entity ↔ DTO                      |
| **Lombok**            | Réduction du code répétitif                  |
| **Maven**             | Gestion des dépendances et compilation       |
| **Swagger / OpenAPI** | Documentation et test de l'API               |
| **Postman**           | Test des endpoints REST                      |
| **Docker**            | Conteneurisation de l'application            |
| **JUnit 5**           | Tests unitaires                              |
| **Mockito**           | Simulation des dépendances dans les tests    |
| **Git / GitHub**      | Versionnement du code                        |

---

# 5. Architecture

LogiTrack utilise une architecture en couches permettant de séparer les responsabilités de l'application.

```text
                  Client HTTP
                       │
                       ▼
                ┌─────────────┐
                │ Controller  │
                └──────┬──────┘
                       │
                       ▼
                ┌─────────────┐
                │   Service   │
                └──────┬──────┘
                       │
                       ▼
                ┌─────────────┐
                │ Repository  │
                └──────┬──────┘
                       │
                       ▼
                  ┌─────────┐
                  │  MySQL  │
                  └─────────┘
```

Les **Controllers** exposent les endpoints REST.

Les **Services** contiennent la logique métier de l'application.

Les **Repositories** utilisent Spring Data JPA pour communiquer avec la base de données.

Les **DTO** permettent de contrôler les données échangées entre l'API et le client.

**MapStruct** est utilisé pour effectuer les conversions entre les entités et les DTO.

---

# 6. Structure du projet

Le projet est organisé en plusieurs packages afin de séparer les différentes responsabilités.

```text
LogiTrack/
│
├── .idea/
│
├── .mvn/
│   └── wrapper/
│
├── src/
│   │
│   ├── main/
│   │   │
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── demo/
│   │   │
│   │   │               ├── auth/
│   │   │               │   ├── controller/
│   │   │               │   ├── dto/
│   │   │               │   └── service/
│   │   │               │       └── Impl/
│   │   │
│   │   │               ├── config/
│   │   │               ├── controller/
│   │   │               ├── dashboard/
│   │   │
│   │   │               ├── dto/
│   │   │               │   ├── client/
│   │   │               │   ├── commande/
│   │   │               │   ├── lignecommande/
│   │   │               │   └── produit/
│   │   │
│   │   │               ├── entity/
│   │   │               ├── enums/
│   │   │               ├── exception/
│   │   │               ├── mapper/
│   │   │               ├── repository/
│   │   │               ├── security/
│   │   │
│   │   │               ├── service/
│   │   │               │   └── ServiceImpl/
│   │   │
│   │   │               └── users/
│   │   │                   └── dto/
│   │   │
│   │   └── resources/
│   │       └── db/
│   │           └── migration/
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── demo/
│                       └── service/
│
├── Dockerfile
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .gitignore
└── README.md
```

Le dossier `target/` est généré automatiquement par Maven lors de la compilation et n'est pas nécessaire dans le repository GitHub.

---

# 7. Modélisation des données

L'application repose principalement sur les entités suivantes.

### Client

Le **Client** représente une personne ou une entreprise qui passe des commandes.

Attributs principaux :

```text
id
nom
email
telephone
ville
```

### Produit

Le **Produit** représente un article disponible dans l'entrepôt.

Attributs principaux :

```text
id
nom
categorie
prix
quantiteStock
```

### Commande

La **Commande** représente une commande passée par un client.

Attributs principaux :

```text
id
dateCommande
statut
```

Les statuts possibles sont :

```text
EN_ATTENTE
EXPEDIEE
LIVREE
```

### LigneCommande

La **LigneCommande** représente un produit associé à une commande.

Attributs principaux :

```text
id
quantite
```

Elle permet notamment de déterminer les produits contenus dans une commande et les quantités commandées.

### User

L'entité **User** représente un utilisateur autorisé à accéder à l'API.

Elle contient les informations nécessaires à l'authentification et à la gestion des rôles.

---

# 8. Sécurité avec Spring Security et JWT

L'API est sécurisée avec **Spring Security** et **JWT**.

Un utilisateur peut créer un compte puis se connecter afin d'obtenir un token JWT.

Ce token est ensuite utilisé pour accéder aux endpoints protégés.

### Inscription

```http
POST /api/auth/register
```

### Connexion

```http
POST /api/auth/login
```

Après une connexion réussie, l'API retourne les informations nécessaires à l'utilisateur ainsi que son token JWT et son rôle.

Le token est ensuite envoyé dans les requêtes protégées :

```http
Authorization: Bearer <JWT>
```

Cette architecture permet de sécuriser les ressources et de contrôler les autorisations des utilisateurs.

---

# 9. Pagination

La pagination permet d'éviter de récupérer toutes les données en une seule requête.

Les endpoints retournant des listes peuvent recevoir des paramètres comme :

```text
page
size
```

Exemple :

```http
GET /api/orders?page=0&size=10
```

Spring Data JPA utilise `Pageable` et `Page<T>` pour gérer les résultats paginés.

Une réponse paginée contient notamment :

```text
content
totalElements
totalPages
size
number
```

La pagination améliore les performances de l'API et permet de gérer efficacement un volume important de données.

---

# 10. Recherche avec Spring Data JPA

LogiTrack utilise les **Derived Queries** ainsi que les requêtes personnalisées avec **`@Query`**.

## Derived Queries

### Rechercher les commandes d'un client

```http
GET /api/orders/client/{clientId}
```

Cette fonctionnalité permet de récupérer les commandes associées à un client.

### Rechercher les produits par catégorie

```http
GET /api/products/category/{category}
```

Cette fonctionnalité permet de récupérer les produits appartenant à une catégorie donnée.

### Rechercher les produits selon le prix

```http
GET /api/products/price/{price}
```

Cette fonctionnalité permet de rechercher les produits selon le critère de prix défini dans le repository.

## Requêtes avec `@Query`

### Produits avec stock faible

```http
GET /api/products/low-stock
```

Cette requête permet d'identifier les produits dont la quantité en stock est faible.

### Nombre total de commandes

```http
GET /api/orders/count
```

Cette requête retourne le nombre total de commandes enregistrées.

### Produit le plus commandé

```http
GET /api/statistics/top-product
```

Cette requête permet d'identifier le produit ayant été le plus commandé.

---

# 11. Gestion des migrations avec Flyway

**Flyway** est utilisé pour gérer les modifications de la base de données de manière versionnée.

Les fichiers de migration sont placés dans :

```text
src/main/resources/db/migration
```

Chaque migration possède une version afin de conserver l'historique des modifications de la base de données.

Cette approche permet de maintenir une structure de base de données cohérente avec l'évolution de l'application.

---

# 12. Documentation de l'API avec Swagger

LogiTrack utilise **Swagger / OpenAPI** pour documenter l'API REST.

Swagger permet de consulter les endpoints, leurs paramètres, les modèles de données et de tester directement les requêtes.

L'interface Swagger est accessible à :

```text
http://localhost:8080/swagger-ui/index.html
```

### Capture Swagger

> La capture doit montrer clairement les principaux endpoints de l'API.
> ![img_1.png](img_1.png)

---

# 13. Tests avec Postman

Les endpoints REST ont été testés avec **Postman** afin de vérifier le fonctionnement de l'API.

Les tests concernent notamment :

* l'inscription ;
* la connexion ;
* les clients ;
* les produits ;
* les commandes ;
* la pagination ;
* les recherches ;
* les statistiques ;
* les endpoints sécurisés.

Pour les endpoints protégés, le JWT est envoyé dans l'en-tête :

```http
Authorization: Bearer <JWT>
```

### Capture Postman


![img_3.png](img_3.png)

---

# 14. Docker

L'application peut être conteneurisée avec **Docker**.

Le projet utilise un `Dockerfile` permettant de construire une image contenant l'application Spring Boot.


Avant de construire l'image Docker, il faut générer le fichier JAR :

```bash
mvn clean package
```

Construire ensuite l'image :

```bash
docker build -t logitrack-api .
```

Lancer le conteneur :

```bash
docker run -p 8080:8080 logitrack-api
```

L'API sera accessible sur :

```text
http://localhost:8080
```

Swagger sera accessible sur :

```text
http://localhost:8080/swagger-ui/index.html
```

---

# 15. Installation et lancement

## Prérequis

Pour exécuter le projet, il faut disposer de :

* Java 21
* Maven
* MySQL
* Git
* Postman
* Docker *(optionnel)*

---

## Cloner le dépôt

```bash
git clone LIEN_DE_VOTRE_REPOSITORY
```

---

## Accéder au projet

```bash
cd LogiTrack
```

---

## Compiler le projet

```bash
mvn clean install
```

---

## Lancer l'application

```bash
mvn spring-boot:run
```

Après le lancement, l'API est disponible sur :

```text
http://localhost:8080
```

Swagger :

```text
http://localhost:8080/swagger-ui/index.html
```

---

# 16. Configuration de la base de données

L'application utilise **MySQL** pour stocker les données.

La configuration de la connexion à la base de données doit être définie dans la configuration Spring Boot.

Exemple :

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/logitrack_db
spring.datasource.username=root
spring.datasource.password=********
```

La valeur réelle dépend de la configuration locale utilisée pour le projet.

Les informations sensibles ne doivent jamais être publiées dans GitHub.

---

# 17. Principaux endpoints REST

## Authentification

| Méthode | Endpoint             | Description     |
| ------- | -------------------- | --------------- |
| `POST`  | `/api/auth/register` | Créer un compte |
| `POST`  | `/api/auth/login`    | Se connecter    |

## Clients

| Méthode  | Endpoint            | Description          |
| -------- | ------------------- | -------------------- |
| `POST`   | `/api/clients`      | Ajouter un client    |
| `GET`    | `/api/clients`      | Afficher les clients |
| `GET`    | `/api/clients/{id}` | Consulter un client  |
| `DELETE` | `/api/clients/{id}` | Supprimer un client  |

### Pagination des clients

```http
GET /api/clients?page=0&size=10
```

---

## Produits

| Méthode  | Endpoint                            | Description                 |
| -------- | ----------------------------------- | --------------------------- |
| `POST`   | `/api/products`                     | Ajouter un produit          |
| `GET`    | `/api/products`                     | Afficher les produits       |
| `GET`    | `/api/products/{id}`                | Consulter un produit        |
| `DELETE` | `/api/products/{id}`                | Supprimer un produit        |
| `GET`    | `/api/products/category/{category}` | Rechercher par catégorie    |
| `GET`    | `/api/products/price/{price}`       | Rechercher selon le prix    |
| `GET`    | `/api/products/low-stock`           | Afficher les stocks faibles |

### Pagination des produits

```http
GET /api/products?page=0&size=10
```

---

## Commandes

| Méthode | Endpoint                         | Description                          |
| ------- | -------------------------------- | ------------------------------------ |
| `POST`  | `/api/orders`                    | Créer une commande                   |
| `POST`  | `/api/orders/{orderId}/products` | Ajouter un produit                   |
| `GET`   | `/api/orders`                    | Afficher les commandes               |
| `GET`   | `/api/orders/{id}`               | Consulter une commande               |
| `GET`   | `/api/orders/client/{clientId}`  | Rechercher les commandes d'un client |
| `PUT`   | `/api/orders/{id}/status`        | Modifier le statut                   |
| `GET`   | `/api/orders/count`              | Nombre total de commandes            |

### Pagination des commandes

```http
GET /api/orders?page=0&size=10
```

---

## Statistiques

| Méthode | Endpoint                      | Description              |
| ------- | ----------------------------- | ------------------------ |
| `GET`   | `/api/statistics/top-product` | Produit le plus commandé |

---

# 18. Diagrammes UML

Les diagrammes UML permettent de représenter la conception et le fonctionnement de LogiTrack.

## Diagramme de classes

Le diagramme de classes présente les principales entités du système ainsi que leurs relations.

**Capture à ajouter :**


![img_4.png](img_4.png)

---

## Diagramme de cas d'utilisation

Le diagramme de cas d'utilisation présente les acteurs du système et leurs interactions avec les fonctionnalités principales de l'API.

![img_5.png](img_5.png)

---

# 19. Contribution personnelle

J'ai réalisé le développement backend de LogiTrack.

Ma contribution a porté sur la conception et le développement des entités, repositories, services et controllers de l'application.

J'ai également travaillé sur les DTO, les mappers avec MapStruct, les Derived Queries, les requêtes `@Query` et la pagination avec Spring Data JPA.

J'ai implémenté l'authentification avec JWT et la sécurisation des endpoints avec Spring Security ainsi que la gestion des rôles.

J'ai également configuré Flyway pour les migrations de la base de données, Swagger pour la documentation de l'API, Docker pour la conteneurisation et effectué les tests des endpoints avec Postman.

---

# 20. Difficultés rencontrées

## Spring Security et JWT

J'ai rencontré des problèmes d'accès aux endpoints sécurisés, notamment des réponses `401 Unauthorized` et `403 Forbidden`.

Pour résoudre ces problèmes, j'ai vérifié la configuration de Spring Security, le filtre JWT, l'authentification et les autorisations liées aux rôles.

Cette difficulté m'a permis de mieux comprendre le fonctionnement de Spring Security et de l'authentification basée sur JWT.

---

## Pagination

La récupération de toutes les données dans une seule requête peut devenir problématique lorsque le volume de données augmente.

J'ai utilisé `Pageable` et `Page<T>` avec Spring Data JPA afin de retourner les résultats sous forme de pages.

Cette étape m'a permis de comprendre comment améliorer les performances des endpoints retournant de grandes quantités de données.

---

## Flyway

Les modifications successives de la structure de la base de données nécessitaient une gestion organisée des versions.

J'ai utilisé Flyway pour créer des migrations versionnées et automatiser leur exécution.

Cette difficulté m'a permis de mieux comprendre la gestion de l'évolution d'une base de données dans un projet Spring Boot.

---

## Entity et DTO

L'utilisation directe des entités dans les réponses de l'API peut créer un couplage entre la base de données et la couche REST.

J'ai utilisé des DTO et MapStruct afin de séparer les données internes des données exposées par l'API.

Cette approche permet d'obtenir une architecture plus propre et plus facile à maintenir.

---

# 21. Améliorations futures

Dans une prochaine version, il serait possible de :

* Ajouter davantage de tests d'intégration
* Améliorer la gestion globale des exceptions
* Ajouter des filtres avancés pour les commandes
* Automatiser davantage la gestion des stocks
* Ajouter des notifications lors des changements de statut
* Ajouter des statistiques logistiques supplémentaires
* Mettre en place une pipeline CI/CD
* Déployer l'API dans le cloud
* Ajouter une surveillance avec Prometheus et Grafana

Ces améliorations permettraient de rendre l'API plus robuste, performante et adaptée à un environnement professionnel.

---

# 22. Auteur

**Hiba Hajaji**

### Développeuse Full Stack Java

**Technologies principales :**

`Java` · `Spring Boot` · `Spring Data JPA` · `Spring Security` · `JWT` · `MySQL` · `Flyway` · `MapStruct` · `Swagger` · `Docker` · `Postman` · `Maven`

---

## 📌 Informations du projet

| Information          | Détail                |
| -------------------- | --------------------- |
| **Projet**           | LogiTrack             |
| **Type**             | API REST Backend      |
| **Langage**          | Java 21               |
| **Framework**        | Spring Boot           |
| **Base de données**  | MySQL                 |
| **Sécurité**         | Spring Security + JWT |
| **Documentation**    | Swagger / OpenAPI     |
| **Migration**        | Flyway                |
| **Tests API**        | Postman               |
| **Conteneurisation** | Docker                |
| **Frontend**         | Projet séparé         |







