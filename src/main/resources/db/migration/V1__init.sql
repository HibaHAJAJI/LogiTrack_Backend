CREATE TABLE clients (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         nom VARCHAR(50) NOT NULL,
                         email VARCHAR(100) NOT NULL UNIQUE,
                         telephone VARCHAR(50),
                         ville VARCHAR(50)
);

CREATE TABLE produits (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          nom VARCHAR(100) NOT NULL,
                          categorie VARCHAR(255),
                          prix DOUBLE NOT NULL,
                          quantite_stock INT NOT NULL
);

CREATE TABLE commandes (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           date_commande DATE,
                           statut VARCHAR(50),
                           client_id BIGINT NOT NULL,

                           CONSTRAINT fk_commande_client
                               FOREIGN KEY (client_id)
                                   REFERENCES clients(id)
);

CREATE TABLE ligne_commande (
                                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                quantite INT NOT NULL,
                                commande_id BIGINT NOT NULL,
                                produit_id BIGINT NOT NULL,

                                CONSTRAINT fk_ligne_commande
                                    FOREIGN KEY (commande_id)
                                        REFERENCES commandes(id),

                                CONSTRAINT fk_ligne_produit
                                    FOREIGN KEY (produit_id)
                                        REFERENCES produits(id)
);