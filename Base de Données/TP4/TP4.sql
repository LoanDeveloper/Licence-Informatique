-- Structure 

-- FILMS(nofilm, titre, #norealisateur, #noproducteur)
-- PROJECTION(#nofilm, nosalle, date_proj, heure)
-- JOUER(#nofilm, #noacteur)
-- VOIR(#nofilm, #nospect)
-- AIMER(#nofilm, #nospect)
-- INDIVIDUS (nopers, nompers)


-- 2.1. Opérateurs d’agrégation
-- 1. Nombre de films vus (Alias as nbre_films_vus) par spectateur (nom du spectateur et nombre de films), ordonnés
-- par nom de spectateur.

SELECT individus.nompers, COUNT(nofilm) as nbre_films_vus
FROM individus
JOIN voir ON individus.nopers = voir.nospect
GROUP BY individus.nopers
ORDER BY individus.nompers;


-- 2. Numéros, par ordre croissant, et noms des acteurs qui ont joué plus de 3 films (strictement).

SELECT DISTINCT jouer.noacteur, individus.nompers
FROM jouer
JOIN individus ON individus.nopers = jouer.noacteur
WHERE jouer.noacteur IN (SELECT noacteur
                         FROM jouer
                         GROUP BY noacteur
                         HAVING COUNT(nofilm) > 3)
ORDER BY jouer.noacteur;


-- 3. Numéros, croissants, et titres des films qui ont été aimés par plus de dix personnes (strictement).

SELECT DISTINCT aimer.nofilm, films.titre
FROM aimer
JOIN films ON films.nofilm = aimer.nofilm
WHERE aimer.nofilm IN (SELECT nofilm
                       FROM aimer
                       GROUP BY nofilm
                       HAVING COUNT(nospect) > 10)


-- 4. Titres des films et nombre de spectateurs (Alias as nbre_spectateurs) qui ont été vus par moins de 5 personnes
-- (strictement).

SELECT films.titre, COUNT(nospect) as nbre_spectateurs
FROM films
JOIN voir ON films.nofilm = voir.nofilm
GROUP BY films.nofilm
HAVING COUNT(nospect) < 5
ORDER BY films.titre;


-- 5. Nombre de personnes distinctes (Alias as nbre_films_de_matthieu_aimes) qui ont aimé les films réalisés par
-- Matthieu. Donnez deux requêtes possibles, dont une avec une sous-requête. Un seul dépôt Moodle.

SELECT COUNT(DISTINCT aimer.nospect) as nbre_films_de_matthieu_aimes
FROM aimer
JOIN films ON films.nofilm = aimer.nofilm
WHERE films.norealisateur = (SELECT nopers
                             FROM individus
                             WHERE nompers = 'Matthieu');

SELECT COUNT(DISTINCT aimer.nospect) as nbre_films_de_matthieu_aimes
FROM aimer
JOIN films ON films.nofilm = aimer.nofilm
JOIN individus ON individus.nopers = films.norealisateur
WHERE individus.nompers = 'Matthieu';

-- 6. Nombre d’acteurs (Alias AS nbre) qui ont produit un film. Donnez deux requêtes possibles, dont une avec une
-- sous-requête. Un seul dépôt Moodle.

SELECT COUNT(DISTINCT Films.noproducteur) as nbre
FROM Films
WHERE Films.noproducteur IN (SELECT DISTINCT jouer.noacteur
                             FROM jouer);

SELECT COUNT(DISTINCT Films.noproducteur) as nbre
FROM Films
JOIN (
    SELECT DISTINCT jouer.noacteur
    FROM jouer
) AS acteurs ON acteurs.noacteur = Films.noproducteur;

SELECT COUNT(DISTINCT Films.noproducteur) as nbre
FROM Films
JOIN jouer ON jouer.noacteur = Films.noproducteur;

-- 7. Titre des films, par ordre alphabétique, qui ont été aimés par le plus de personne (un maximum n’est pas néces-
-- saire unique). Attention : ALL et ANY ne fonctionnent pas sur Moodle.

SELECT DISTINCT films.titre
FROM films
WHERE films.nofilm IN (
    SELECT aimer.nofilm
    FROM aimer
    GROUP BY aimer.nofilm
    HAVING COUNT(aimer.nospect) = (
        SELECT MAX(nb)
        FROM (
            SELECT COUNT(aimer.nospect) as nb
            FROM aimer
            GROUP BY aimer.nofilm
        ) AS nbre_aimer 
    )
)

-- USE ALL AND ANY

SELECT DISTINCT films.titre
FROM films
WHERE films.nofilm IN (
    SELECT aimer.nofilm
    FROM aimer
    GROUP BY aimer.nofilm
    HAVING COUNT(aimer.nospect) >= ALL(
        SELECT COUNT(aimer.nospect) as nb
        FROM aimer
        GROUP BY aimer.nofilm
    )
)

SELECT DISTINCT films.titre
FROM films
JOIN aimer ON aimer.nofilm = films.nofilm
GROUP BY films.nofilm
HAVING COUNT(aimer.nospect) >= ALL(
    SELECT COUNT(aimer.nospect) as nb
    FROM aimer
    JOIN films ON films.nofilm = aimer.nofilm
    GROUP BY aimer.nofilm
)
-- ORDER BY films.titre ASC;




-- 2.2. Autres requêtes
-- 1. Titre, par ordre alphabétique, des films projetés en juillet 2012

SELECT films.titre
FROM films
JOIN projection ON films.nofilm = projection.nofilm
WHERE projection.date_proj BETWEEN '2012-07-01' AND '2012-07-31'
ORDER BY films.titre;

-- 2. Numéros, en ordre croissant, et noms des acteurs qui jouent dans un film qu’ils ont produit.

SELECT DISTINCT jouer.noacteur, individus.nompers
FROM jouer
JOIN individus ON individus.nopers = jouer.noacteur
JOIN (
    SELECT DISTINCT jouer.noacteur
    FROM jouer
    JOIN films ON films.nofilm = jouer.nofilm
    WHERE films.noproducteur = jouer.noacteur
) AS acteurs ON acteurs.noacteur = jouer.noacteur
ORDER BY jouer.noacteur ASC;

-- 3. Nom des individus, par ordre alphabétique, qui n’ont aimé aucun film.

SELECT individus.nompers
FROM individus
WHERE individus.nopers NOT IN (
    SELECT DISTINCT aimer.nospect
    FROM aimer
)
ORDER BY individus.nompers;

-- 4. Numéros, distinct, par ordre croissant, et noms des personnes qui ont vu au moins un film (voire plusieurs), mais
-- qui n’en ont aimé aucun. Donnez deux requêtes possibles (une avec NOT IN, une avec NOT EXISTS). Un seul dépôt
-- Moodle.
 
-- NOT IN

SELECT DISTINCT individus.nopers, individus.nompers
FROM individus
WHERE individus.nopers IN (
    SELECT DISTINCT voir.nospect
    FROM voir
)
AND individus.nopers NOT IN (
    SELECT DISTINCT aimer.nospect
    FROM aimer
)
ORDER BY individus.nopers;

-- NOT EXISTS

SELECT DISTINCT individus.nopers, individus.nompers
FROM individus
WHERE individus.nopers IN (
    SELECT DISTINCT voir.nospect
    FROM voir
)
AND NOT EXISTS (
    SELECT DISTINCT aimer.nospect
    FROM aimer
    WHERE aimer.nospect = individus.nopers
)
ORDER BY individus.nopers;



-- 5. Numéros distincts, par ordre croissant, des films que personne n’a aimé (c’est-à-dire qu’aucun des spectateurs
-- qui les a vus ne les a aimés). Donnez deux requêtes possibles (une avec NOT IN, une avec NOT EXISTS). Un seul
-- dépôt Moodle.

-- NOT IN
SELECT DISTINCT films.nofilm
FROM films
WHERE films.nofilm NOT IN (
    SELECT DISTINCT aimer.nofilm
    FROM aimer
)
ORDER BY films.nofilm;

-- NOT EXISTS

SELECT DISTINCT films.nofilm
FROM films
WHERE NOT EXISTS (
    SELECT DISTINCT aimer.nofilm
    FROM aimer
    WHERE aimer.nofilm = films.nofilm
)


-- 6. Numéros (producteur) et noms des producteurs qui ne voient que les films qu’ils produisent (il n’existe aucun film
-- qu’ils ont vus mais qu’ils n’ont pas produit). Donnez deux requêtes possibles (NOT IN ou NOT EXIST). Un seul dépôt
-- Moodle.

-- NOT IN

SELECT DISTINCT films.noproducteur, individus.nompers
FROM films
JOIN individus ON individus.nopers = films.noproducteur
WHERE films.noproducteur IN (
    SELECT DISTINCT voir.nospect
    FROM voir
)
AND films.noproducteur NOT IN (
    SELECT DISTINCT voir.nospect
    FROM voir
    JOIN films ON films.nofilm = voir.nofilm
    WHERE films.noproducteur != voir.nospect
)
ORDER BY films.noproducteur;

-- NOT EXISTS

SELECT DISTINCT films.noproducteur, individus.nompers
FROM films
JOIN individus ON individus.nopers = films.noproducteur
WHERE films.noproducteur IN (
    SELECT DISTINCT voir.nospect
    FROM voir
)
AND NOT EXISTS (
    SELECT DISTINCT voir.nospect
    FROM voir
    JOIN (
        SELECT DISTINCT voir.nospect, voir.nofilm
        FROM voir
        JOIN films ON films.nofilm = voir.nofilm
        WHERE films.noproducteur != voir.nospect
    ) AS films_vus ON films_vus.nospect = voir.nospect
    WHERE voir.nospect = films.noproducteur
)
ORDER BY films.noproducteur;

-- 7. Nom des individus qui sont à la fois : acteur, producteur et réalisateur

SELECT DISTINCT individus.nompers
FROM individus
WHERE individus.nopers IN (
    SELECT DISTINCT jouer.noacteur
    FROM jouer
)
AND individus.nopers IN (
    SELECT DISTINCT films.noproducteur
    FROM films
)
AND individus.nopers IN (
    SELECT DISTINCT films.norealisateur
    FROM films
)
ORDER BY individus.nompers ASC;

-- 8. Noms des personnes, par ordre alphabétique, qui ont vu tous les films

SELECT DISTINCT individus.nompers
FROM individus
JOIN (
    SELECT DISTINCT voir.nospect
    FROM voir
    GROUP BY voir.nospect
    HAVING COUNT(voir.nospect) = (
        SELECT COUNT(DISTINCT films.nofilm)
        FROM films
    )
) AS spectateurs ON spectateurs.nospect = individus.nopers
ORDER BY individus.nompers ASC;