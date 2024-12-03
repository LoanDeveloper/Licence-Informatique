# exempleComposants

Clonez ce projet, exécutez le pour bien comprendre comment fonctionne un projet VueJS avec quelques composants :

- App.vue : composant de base qui est appelé par main.js
- HelloWorld.vue : composant appelé dans App.vue qui affiche deux titres et un bouton. Ce composant nécessite un paramètre.
- ComposantEnfant.vue : composant présent dans HelloWorld qui affiche un bouton mais qui va modifier une variable du composant parent.

## Installation

```sh
git clone https://gitlab.univ-lr.fr/ntrugeon/exempletp1vuejs.git
cd exempletp1vuejs
npm install
npm run dev
```

## Visualisation du site

- Ouvrez votre navigateur sur [http;//localhost:3000](http;//localhost:5173)
- Appuyez sur les boutons pour voir les effets.
- Rafraichissez la page pour réinitialiser la vue.

## Découverte du code

- Ouvrez le code avec Vscode.
- Analyser le code pour bien comprendre les mécanisme en jeu.

## Visualisation des composants avec VueDevTools

- Installez l'extension VueDevTools sur votre navigateur si ce n'est pas encore fait
- Dans les outils de développement de votre navigateur, affichez les outils VueJS pour comprendre
  - les différents composants
  - leurs variables et leurs changements
  - les props