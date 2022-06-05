console.log("Javascript chargé !")

const form = document.querySelector("#saisieNbTS") //input nbre de t-shirt
let msg = document.createElement("p")//message à afficher
const zone_ecriture = document.querySelector("#zoneRetourClient"); //zone d'écriture


form.addEventListener("change", e => {
    if (e.currentTarget.value == 1){
        msg.textContent = "Vous avez choisi de commander " + e.currentTarget.value + " tshirt, pour un montant de " + (15*e.currentTarget.value+5) + "€, les frais de ports s'élèvent à 5€";
        zone_ecriture.append(msg);
    }
    else if (e.currentTarget.value > 1) {
        if (e.currentTarget.value*15 >= 50) {
            msg.textContent = "Vous avez choisi de commander " + e.currentTarget.value + " tshirts, pour un montant de " + 15 * e.currentTarget.value + "€, les frais de ports sont offerts";
            zone_ecriture.append(msg);
        } else {
            msg.textContent = "Vous avez choisi de commander " + e.currentTarget.value + " tshirts, pour un montant de " + (5+15 * e.currentTarget.value) + "€, les frais de ports s'élèvent à 5€";
            zone_ecriture.append(msg);
        }
    }else{
        msg.textContent = "Veuillez saisir un nombre de tshirt supérieur à zéro";
        zone_ecriture.append(msg);
    }
})