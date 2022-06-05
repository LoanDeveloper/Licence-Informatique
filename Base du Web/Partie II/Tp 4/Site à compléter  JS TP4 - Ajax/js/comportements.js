    console.log("Exécution du programme comportement.js");

    document.querySelector("#recupObjet .bouton").addEventListener('click', recupererUnObjet);
    document.querySelector("#recupTableau .go").addEventListener('click',recupererUnTableau);

    function recupererUnObjet() {
        // Tentative de récupération d'une donnée externe 
        const promesseRecupUnePersonne = axios.get('https://prodrigu.lpmiaw.univ-lr.fr/mineure-info-1/ajax/recupererUnePersAuHasard/');

        // Si la promesse est tenue, exécuter la fonction afficherPersonneAuHazard
        promesseRecupUnePersonne.then(afficherPersonneAuHasard);

        // Si la promesse n'est pas tenue, exécuter la fonction afficherErreurAjax
        promesseRecupUnePersonne.catch(afficherErreurAjax);
    }

    // Fonction de traitement de l'appel ajax à recupererUnePersAuHasard
    function afficherPersonneAuHasard(reponseAjax) {
        // le paramère reponseAjax contient à présent la réponse donnée par le serveur à l'appel Ajax.
        // Il faut donc placer ici les instructions permettant le traitement de cette donnée
        const prenom = reponseAjax.data.prenom;
        const resultat = document.querySelector(".resultat");

        //console.log(reponseAjax);
        //console.log(prenom);
        resultat.textContent = "Résultat : " + prenom;
    } //afficherPersonneAuHasard

    function afficherErreurAjax(erreur) {
        console.log(erreur);
    } //afficherErreurAjax

    function recupererUnTableau() {
        const request = axios.get('https://prodrigu.lpmiaw.univ-lr.fr/mineure-info-1/ajax/recupererLesPers/');

        request.then(afficherTableauPersonnes);
        request.catch(afficherErreurAjax);
    }

    function afficherTableauPersonnes(lesPersonnes){
        const article2 = document.querySelector("#recupTableau");

        const ul = document.createElement("ul");
        article2.appendChild(ul);

        lesPersonnes.data.forEach(elem => {
            let li = document.createElement("li");
            li.textContent += elem.prenom + " " + elem.nom;
            ul.appendChild(li);
            //console.log(elem.nom);
        })
    }