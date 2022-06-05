/* chat.js */
console.log("Programme JavaScript !");

// Initialisation de Firebase
// infos de configuration pour l'accès à la BD du chat   
const config = {
    apiKey: "AIzaSyADU89ardUsGLoMDG8n-1V2wIh9GegCbVI",
    authDomain: "chat-58d1a.firebaseapp.com",
    databaseURL: "https://chat-58d1a.firebaseio.com",
    projectId: "chat-58d1a",
    storageBucket: "chat-58d1a.appspot.com",
    messagingSenderId: "526648232449",
    appId: "1:526648232449:web:c011afb7d75d894d27ce00",
    measurementId: "G-2FBR9W3D1H"
}

//Initialisation
firebase.initializeApp(config);

// Récupération des noeuds de la BD
// A compléter
const racineBD = firebase.database();
const BDMessages = racineBD.ref('Messages');
const liAll = document.querySelectorAll("#messages li");

const pseudo = document.querySelector("#formulaire input[name=pseudo]");
const msg = document.querySelector("#formulaire input[name=message]");

const form = document.querySelector("#formulaire");
/****** Mise en place des écouteurs d'événements ********/

// Lorsque ce prog se connecte à la BD Firebase
// Il reçoit un événement child_added pour chaque enregistrement de la BD 
BDMessages.on('child_added', insererDansLaPage);

liAll.forEach(elem => {
    elem.on('child_removed', retirer);
})

// Quand on valide le formulaire, ajouter le nouveau message dans la BD 
// A compléter²
form.addEventListener("submit", (e) => {
    e.preventDefault();

    let auteur = pseudo.value;
    let message = msg.value;

    let push = { 'auteur' : auteur, 'texte' : message};
    BDMessages.push(push);
})

function retirer(){
    console.log("reussi");
}
// Quand un message est supprimé de la BD, l'enlever de la page
// A compléter

// La mise en place de l'écouteur d'événement pour pour la suppression d'un message par l'internaute et fait dans la fonction d'affichage du message dans la page

/****** Fin des écouteurs d'événements ***********/

/****** Gestionnaires d'événements **************/
function insererDansLaPage(donnee){
    console.log(donnee.val());
    const pseudo = document.querySelector("#formulaire input[name=pseudo]").value;
    const msg = document.querySelector("#formulaire input[name=message]").value;

    const li = document.createElement("li");
    const i = document.createElement("i");
    const auteur = document.createElement("span");
    const message = document.createElement("span");
    const ul = document.querySelector("#messages");

    i.classList.add("fa");
    i.classList.add("fa-trash");
    auteur.classList.add("auteur");
    message.classList.add("contenuMessage");
    auteur.textContent = donnee.val().auteur;
    message.textContent = donnee.val().texte;

    ul.appendChild(li);
    li.appendChild(i);
    li.appendChild(auteur);
    li.appendChild(message);
}