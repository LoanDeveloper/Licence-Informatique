let taches = document.querySelectorAll("li.tache");
const tache_a_effectuer = document.querySelector(".a_effectuer");
const tache_accomplies = document.querySelector(".accomplies");
const tache_invisible = document.querySelector(".tache--invisible");

// Supprimer une tache avec le bouton
taches.forEach(elem => {
    let boutons_x = elem.querySelector(".tache__btn--suppression");
    boutons_x.addEventListener("click", evt => {
        tache_a_effectuer.removeChild(elem);
    });
});

// Transférer une tache dans les taches accomplies
taches.forEach(elem => {
    let bouton_v = elem.querySelector(".tache__btn--validation");
    bouton_v.addEventListener("click", evt => {
        const copie = elem.cloneNode([true]);
        copie.classList.add("tache--accomplie");
        tache_a_effectuer.removeChild(elem);
        tache_accomplies.appendChild(copie);
    });
});

// Nouvelle tache
const bouton_form = document.querySelector(".tache__btn--validation-formulaire");
bouton_form.addEventListener("click", (e) => {
    e.preventDefault();
    const quoi = document.querySelector(".tache__quoi").value;
    const qui = document.querySelector(".tache__qui").value;

    const new_task = tache_invisible.cloneNode([false]);
    new_task.classList.remove("tache--invisible");
    new_task.querySelector("p.tache__quoi").textContent = quoi;
    new_task.querySelector("p.tache__qui").textContent = qui;
    tache_a_effectuer.appendChild(new_task);

    boutons_x = new_task.querySelector(".tache__btn--suppression");
    boutons_x.addEventListener("click", evt => {
        tache_a_effectuer.removeChild(new_task);
    });

    let bouton_v = new_task.querySelector(".tache__btn--validation");
    bouton_v.addEventListener("click", evt => {
        const copie = new_task.cloneNode([true]);
        copie.classList.add("tache--accomplie");
        tache_a_effectuer.removeChild(new_task);
        tache_accomplies.appendChild(copie);
    });

});
