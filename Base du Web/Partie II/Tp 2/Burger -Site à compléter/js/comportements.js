console.log("JavaScript fonctionne !")

const burger = document.querySelector("#ouverture_menu");
const menu = document.querySelector(".menu-principal");
const croix = document.querySelector("#fermeture_menu");

burger.addEventListener("click", ouvrirMenu);
croix.addEventListener("click", fermetureMenu);

function ouvrirMenu(){
    menu.classList.add("ouvert");
}

function fermetureMenu(){
    menu.classList.remove("ouvert");
}