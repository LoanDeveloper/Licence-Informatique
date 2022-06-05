console.log("Exécution du programme js comportements");


//Constantes && variables communes
const rechercher = document.querySelector("#bouton_rechercher");
const article_invisible = document.querySelector("article.invisible").cloneNode([true]);
const favoris_result = document.querySelector("#favoris_result");
const favorites_counter_p = document.querySelector("#favorites_counter_p");
const section_erreur = document.querySelector("#section_erreur_ajax");
const erreurElement = document.querySelector("#erreurAjax");


//Récupération des artistes présents dans la BDD BandsInTown
function getArtistEvent() {
    //récupération de l'artiste actuel
    let artist = document.querySelector("#artist_input").value;

    //requête Ajax
    let requete = "https://rest.bandsintown.com/artists/" + artist + "/events?app_id=3cd4f4d49418f9b180faefdd86a25000";
    //tests
    //console.log("requete: " + requete);

    // Tentative de récupération d'une donnée externe
    const request = axios.get(requete);
    // Si la promesse est tenue, exécuter la fonction afficherArtistEvent
    request.then(afficherArtistEvent);
    // Si la promesse n'est pas tenue, exécuter la fonction afficherErreurAjax
    request.catch(afficherErreurAjax);
}


//affichage des artistes récupérés
function afficherArtistEvent(reponseAjax){
    //Suppression de l'erreur (si elle est présente sur le DOM)
    if (section_erreur.contains(erreurElement)){
        section_erreur.removeChild(erreurElement);
    }

    //Suppression des articles présents dans la section result sur le DOM
    deleteArticlesResult();

    //constantes BDD + nom de l'artiste
    const data = reponseAjax.data;
    let artist = document.querySelector("#artist_input").value;
    let artistName = document.querySelector("#artistName");

    //récupération de l'artiste actuel
    artistName.textContent = artist;

    //tests
    //console.log(data);

    //boucle qui parcourt tous les éléments de la requête Ajax
    data.forEach(elem => {

        //clone article vide (article de référence présent sur la page)
        let article_elem = article_invisible.cloneNode([true]);
        article_elem.classList.remove("invisible");

        //tests
        //console.log(article_elem);

        //modification du contenu de l'article
        article_elem.children[0].children[0].textContent = elem.starts_at;
        article_elem.children[0].children[1].textContent = elem.venue.name + ", " +elem.venue.city;;
        article_elem.children[1].children[0].setAttribute("href",elem.url);

        //Section résultat
        let section_result = document.querySelector("#result");

        //Pour éviter les doublons
        if (article_elem != section_result.lastElementChild){
            section_result.appendChild(article_elem);
        }

        //Ajout de la fonctionnalité pour placer un événement dans les favoris
        let favorites_star = document.querySelectorAll(".material-icons-outlined.star");
        favorites_star.forEach(e => {
            //tests
            //console.log(e);

            //Listener du bouton favoris associé à chaque articles
            e.addEventListener("click", putFavoris);
        })
    });

    //Récupération de la section result
    let section_result = document.querySelector("#result");

    //Suppression du dernier article qui est vide (article cloner de référence)
    section_result.lastElementChild.remove();
}


//Affichage de l'erreur Ajax sur le DOM
function afficherErreurAjax(){
    //récupération de la requête
    let artist = document.querySelector("#artist_input").value;
    let requete = "https://rest.bandsintown.com/artists/" + artist + "/events?app_id=db2d9ab207b873e3336d985c9f200b54";

    //re-test de la requête
    const  request = axios.get(requete);
    request.then(afficherArtistEvent);
    request.catch(erreurAffichage());

    //Suppression des articles présent sur la page
    deleteArticlesResult();

    //Suppression du nom de l'article dans la section result sur le DOM
    let artist_name = document.querySelector("#artistName");
    artist_name.textContent = "";

    //Affichage sur la page si la requête ne fonctionne pas une seconde fois
    function erreurAffichage(){
        //Modification du paragraphe qui affiche l'erreur
        erreurElement.textContent = "Veuillez saisir correctement le nom de votre artiste ";
        //affichage de la requete dans la console
        console.log("Requete error : "+requete)
        //affichage sur le DOM
        section_erreur.appendChild(erreurElement);
    }
}


//Fonctionnalité pour placer un événement dans les favoris
function putFavoris(){
    //Variable qui récupère le compteur actuel sur le DOM
    let cpt_DOM = document.querySelector("#favorites_counter_p").textContent;

    //on transforme le compteur : str -> int
    let int_cpt_DOM = parseInt(cpt_DOM);

    //Coloration des étoiles quand on clique dessus + copie des favoris dans la section favoris
    if (this.textContent == "star_outline"){    //étoile avec contours
        //tests
        //console.log("test");

        //affichage de l'étoile remplie (coloré)
        this.textContent = "star";
        this.classList.toggle("yellow_star");

        //copy de l'article concerné
        let elem_copy = this.parentElement.parentElement.cloneNode([true]);

        //affichage sur le DOM
        favoris_result.appendChild(elem_copy);

        //Incrémentation du compteur de favoris
        int_cpt_DOM++;

        //actualisation du compteur de favoris sur le DOM
        favorites_counter_p.textContent = int_cpt_DOM;
    } else{                                     //étoile remplie
        //tests
        //console.log("test");

        //copy de l'article sélectionné dans la section search
        let elem_search = this.parentElement.parentElement;

        //parcours de la section favoris pour supprimer l'article sélectionné
        let favoris_result_all = favoris_result.querySelectorAll(".article");
        favoris_result_all.forEach(elem_favoris => {
            //tests
            //console.log(elem_favoris);
            //console.log(elem_search);

            //si l'article correspond à l'article selectionné dans la section search, on le supprime
            if (elem_favoris.isEqualNode(elem_search)){
                favoris_result.removeChild(elem_favoris);
            }
        })

        //on décrémente le compteur de 1
        if (int_cpt_DOM > 0){
            int_cpt_DOM = (int_cpt_DOM-1);

            //actualisation du compteur de favoris sur le DOM
            favorites_counter_p.textContent = int_cpt_DOM;
        }

        //affichage de l'étoile avec les contours
        this.textContent = "star_outline";
        this.classList.toggle("yellow_star");
    }
}


function deleteArticlesResult(){
    //Récupération de tous les articles présent dans la section search result
    let section_result = document.querySelector("#result");
    let section_result_all = section_result.querySelectorAll(".article");

    //parcours de tous les articles présents dans la section result
    section_result_all.forEach(article => {
        //si l'article n'est pas l'article invisible de référence, on le supprime
        if (!article.classList.contains("invisible")){
            section_result.removeChild(article);
        }
    })
}


//Listener bouton rechercher
rechercher.addEventListener("click",getArtistEvent);