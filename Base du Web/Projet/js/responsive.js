console.log("Exécution du programme js responsive");

const menu = document.querySelector("#menu");
const div_navbar = document.querySelector("#navbar");
const footer = document.querySelector("footer");
const artist_input = document.querySelector("#artist_input");

//Responsive Design
if (window.innerWidth >= 500 || screen.width >= 500){
    menu.classList.add("defix");
    menu.classList.add("animation");
    div_navbar.appendChild(menu);
    artist_input.placeholder = "Artiste, concerts, venues";
    //format pc
    //console.log("pc");
}

//Changement automatique lors d'un changement de taille de la fenêtre
function reportWindowSize(){
    if (window.innerWidth <= 500 || screen.width <= 500){
        menu.classList.remove("defix");
        footer.appendChild(menu);
        //format telephone
        //console.log("tel2)
    }else{
        menu.classList.add("defix");
        div_navbar.appendChild(menu);
        artist_input.placeholder = "Artiste, concerts, venues";
        //format pc
        //console.log("pc2");
    }
}
window.addEventListener('resize', reportWindowSize);