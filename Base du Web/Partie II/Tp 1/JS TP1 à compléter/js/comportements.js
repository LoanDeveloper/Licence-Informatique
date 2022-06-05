console.log("Exécution du programme principal")

//Exercice 1
const msg = "J'ai trouvé "+document.querySelectorAll("#ingredients li").length+" ingrédients"
console.log(msg);

//Exercice 2
const elem = document.getElementById('elemEx2');
console.log(elem.classList);
elem.classList.remove('control');
elem.classList.add('inverse');

//Exercice 3
document.getElementById('reussite').textContent="ha ok, j'ai pas compris!";
const dogAlt = document.getElementById('dog').getAttribute('alt');
console.log(dogAlt);
document.getElementById('dog').setAttribute('figcaption',dogAlt);

//Exercice 4
document.getElementById('boutonEffacerEx4').addEventListener("click", () => {
    console.log("Evénement détecté !")
    document.querySelector("#figureEx4 img").classList.add('invisible');
});

document.getElementById('boutonAfficherEx4').addEventListener("click", () => {
    document.querySelector("#figureEx4 img").classList.remove('invisible');
});

document.getElementById('boutonDoubleEx4').textContent="Masquer";

document.getElementById('boutonDoubleEx4').addEventListener("click", () => {

    if (document.querySelector("#figureEx4 img").classList.contains('invisible')){
        document.getElementById('boutonDoubleEx4').textContent="Masquer";
        document.querySelector("#figureEx4 img").classList.remove('invisible');
    }else{
        document.getElementById('boutonDoubleEx4').textContent="Afficher";
        document.querySelector("#figureEx4 img").classList.add('invisible');
    }
});

//Exercice 5
document.querySelectorAll("#ex5 .liste_tetes li>img").forEach(element=>{element.classList.add('penche')});
document.querySelectorAll("h2").forEach(element=>{element.classList.add('elargi')});

//Exercice 6

document.querySelector("#ex6 p img").addEventListener("click", () => {
    document.querySelector("#ex6 p img").classList.toggle('penche');
});

document.querySelectorAll("#ex6 ul li img").forEach(elem => {
    elem.addEventListener("mouseover", () => {
        elem.classList.add("penche");
    })
    elem.addEventListener("mouseleave", () => {
        elem.classList.remove("penche");
    })
});