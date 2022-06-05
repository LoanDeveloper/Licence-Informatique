console.log("JS done !");


const images = document.querySelectorAll("#vignettes li");
const grande_image = document.querySelector("#grandeImage");
const figcaption = document.querySelector("#titreImage");
const figure = document.querySelector("#galerie figure");

grande_image.classList.remove("src");

images.forEach(elem => {
    elem.addEventListener("mouseenter", evt => {
        const e = evt.currentTarget.querySelector("img");
        const attribut = e.getAttribute("src");
        const attribut_split = attribut.split("/");
        grande_image.setAttribute("src", "images/grandes/" + attribut_split[2]);
        figcaption.textContent = e.getAttribute("alt");
    });
})

