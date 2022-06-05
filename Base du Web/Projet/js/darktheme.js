console.log("Exécution du programme js darktheme");

const dark_mode_button = document.querySelector(".moon");
const body = document.querySelector("body");

//
//condition pour savoir si l'utilisateur à un thème par défaut en sombre ou clair pour adapter le thème par défaut de la page
/*if (window.matchMedia && window.matchMedia('(prefers-color-scheme: dark)').matches){
    document.documentElement.style.setProperty('--texte','#f1f1f1');
    document.documentElement.style.setProperty('--background','#333');
    //console.log("dark");
}else{
    document.documentElement.style.setProperty('--texte','#333');
    document.documentElement.style.setProperty('--background','#f1f1f1');
    //console.log("light")
}*/

//Cette fonction récupère le thème actuel afin d'inverser si l'utilisateur le souhaite
function toggleDarkMode(){
    const ul_navbar = document.querySelector("#menu ul");
    //si le thème est foncé, on le change en clair
    if(document.documentElement.style.getPropertyValue('--background') == '#333'){
        document.documentElement.style.setProperty('--texte','#333');
        document.documentElement.style.setProperty('--background','#f1f1f1');
        document.documentElement.style.setProperty('--background-transparent','#f1f1f1d8')
    //sinon, on change le thème en foncé
    }else{
        document.documentElement.style.setProperty('--texte','#f1f1f1');
        document.documentElement.style.setProperty('--background','#333');
        document.documentElement.style.setProperty('--background-transparent','#333')
    }
}

dark_mode_button.addEventListener("click",toggleDarkMode);