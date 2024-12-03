<template>
    <div class="container" id="panier">
      <div class="card text-center">
        <h3 class="card-header">Panier</h3>        
        <table class="table table-bordered table-striped">
          <thead>
            <tr>
             <th class="col-sm-4">Article</th>
             <th class="col-sm-2">Quantité</th>
             <th class="col-sm-2">Prix</th>
             <th class="col-sm-2">Total HT</th>
             <th class="col-sm-2" colspan="2"></th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(item, index) in panier">
              <td>{{ item.article }}</td>
              <td>{{ item.quantite }}</td> 
              <td>{{ (item.prix * 1).toFixed(2) }} €</td>
              <td>{{ (item.quantite * item.prix).toFixed(2) }} €</td>
              <td><button class="btn btn-info btn-block" @click="modifier(index)"><i class="fa fa-edit"></i></button></td>
              <td><button class="btn btn-danger btn-block" @click="supprimer(index)"><i class="fa fa-trash"></i></button></td>
            </tr> 
            <tr>
              <td colspan="3"></td>
              <td><strong>{{ total }} €</strong></td>
              <td colspan="2"><strong>TTC : {{ total * TVA }} €</strong></td>
            </tr> 
            <tr>
              <td><input type="text" class="form-control" v-model="input.article" ref="modif" placeholder="Article"></td>
              <td><input type="text" class="form-control" v-model.number="input.quantite" placeholder="Quantité"></td>
              <td><input type="text" class="form-control" v-model.number="input.prix" placeholder="Prix"></td>
              <td colspan="3"><button class="btn btn-primary btn-block" @click="ajouter()">Ajouter</button></td>
            </tr>
          </tbody>       
        </table>
      </div>
      <div v-if="poubelle.length > 0" class="card text-danger text-center">
        <h3 class="card-header">Poubelle</h3>
        <table class="table table-bordered table-striped">
          <thead>
            <tr>
                <th class="col-sm-4">Article</th>
                <th class="col-sm-2">Quantité</th>
                <th class="col-sm-2">Prix</th>
                <th class="col-sm-4" colspan="2"></th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(item, index) in poubelle">
              <td>{{ item.article }}</td>
              <td>{{ item.quantite }}</td>
              <td>{{ item.prix }}</td> 
              <td><button class="btn btn-success btn-block" @click="retablir(index)" title="Rétablir"><i class="fa fa-undo"></i></button></td>
              <td><button class="btn btn-danger btn-block" @click="supprimerDef(index)" title="Supprimer définitivement"><i class="fa fa-trash"></i></button></td>    
            </tr>  
          </tbody>       
        </table>
      </div> 
    </div>
</template>

<script setup>
import { ref, computed } from 'vue';

const modif = ref(null)

const panier = ref([
    {article: "Cahier", quantite: 2, prix: 5.30},
    {article: "Crayon", quantite: 4, prix: 1.10},
    {article: "Gomme", quantite: 1, prix: 3.25}
]);

const TVA = ref(1.20);

const input = ref({article: '', quantite: 0, prix: 0});

const poubelle = ref([
    {article: "test", quantite: 1, prix: 10}
]);

const total = computed(() => {
    let total = 0;
    panier.value.forEach(el => {
        total += el.prix * el.quantite;
    })
    return total.toFixed(2);
})

function ajouter() {
    if (input.value.article != '' && input.value.quantite >= 1 && input.value.prix > 0){
        panier.value.push(this.input)
        input.value = { article: '', quantite: 0, prix: 0 }
    }
}
        
function modifier(index) {
    if (input.value.article != '' && input.value.quantite >= 1 && input.value.prix > 0){
        input.value = panier.value[index]
        panier.value.splice(index, 1)
        modif.value.focus()
    }
    
}

function supprimer(index) {
    poubelle.value.push(panier.value[index]);
    panier.value.splice(index, 1);
}

function retablir(index){
    panier.value.push(poubelle.value[index]);
    poubelle.value.splice(index, 1);
}

function supprimerDef(index){
    poubelle.value.splice(index,1);
}
const ordonner = function (a, b) { 
    return (a.article.toUpperCase() > b.article.toUpperCase())
}
</script>

<style scoped>
@import url(https://use.fontawesome.com/releases/v5.7.2/css/all.css);
</style>