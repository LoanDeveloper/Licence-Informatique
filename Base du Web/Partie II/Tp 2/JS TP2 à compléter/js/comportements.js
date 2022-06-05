console.log("Javascript !")


//Exercice 1

let bouton = document.querySelector("#boutonSupprimerEx1");
bouton.addEventListener("click", e => {
    document.querySelector("#ex1 li").remove();
})


//Exercice 2

const deplacer = document.getElementById("boutonDeplacerEx2");
const insertion = document.querySelector("#ex2 ul");
deplacer.addEventListener("click", e => {
    insertion.append(document.querySelector("#ex2 li"));
})

const creer = document.getElementById("boutonCreerEx2");
creer.addEventListener("click", () => {
    const nouveau_li = document.createElement('li');
    nouveau_li.textContent = "nouveau";
    insertion.append(nouveau_li);
})


//Exercice 3

const li_ex3 = document.querySelector("#ex3 ul");
li_ex3.addEventListener("click", () => {
    document.querySelector("#ex3 li").classList.add("invisible");
})

document.querySelector("#ex3 span").addEventListener("click", () => {
    document.querySelector("#ex3 li").classList.remove("invisible");
})


//Exercice 4

const liste = document.querySelectorAll("#ex4 ul li");
liste.forEach(elem => {
    elem.addEventListener("click", e => {
        elem.classList.add("invisible");
    })
})

const reafficher = document.querySelector("#ex4 span")
reafficher.addEventListener("click", () => {
    liste.forEach(elem => {
        elem.classList.remove("invisible");
    })
})


//Exercice 5

const liste_ex5 = document.querySelectorAll("#ex5 li");
liste_ex5.forEach(elem => {
    elem.addEventListener("click", () => {
        document.querySelector("#ex5 ul").append(elem);
    })
})


//Exercice 6

const liste_ex6 = document.querySelectorAll("#ex6 ul li");
liste_ex6.forEach(elem => {
    elem.addEventListener("click", () => {
        liste_ex6.forEach(elem2 => {
            if (elem2.getAttribute('class') == elem.getAttribute('class')){
                elem2.classList.add("invisible");
            }
        })
    })
})

const bouton_ex6 = document.querySelector("#ex6 span")
bouton_ex6.addEventListener("click", () => {
    liste_ex6.forEach(elem => {
        elem.classList.remove("invisible");
    })
})


