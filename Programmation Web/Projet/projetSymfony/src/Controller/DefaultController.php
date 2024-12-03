<?php

namespace App\Controller;

use App\Entity\Commentaire;
use App\Entity\Produit;
use App\Form\CommentaireType;
use App\Form\VendreProduitType;
use App\Repository\CategorieRepository;
use App\Repository\CommentaireRepository;
use App\Repository\ProduitRepository;
use App\Repository\TagRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use ApiPlatform\Core\Annotation\ApiResource;

class DefaultController extends AbstractController
{
    #[Route('/', name: 'app_default')]
    public function index(CategorieRepository $cr): Response
    {
        $categories = $cr->findAll();
        return $this->render('default/index.html.twig', [
            'categories' => $categories
        ]);
    }

    #[Route('/produits', name: 'app_produits')]
    public function produits(ProduitRepository $pr): Response
    {
        $produits = $pr->findAll();
        return $this->render('default/produits.html.twig',
            ['produits' => $produits]
        );
    }

    #[Route('/produits/{id}', name: 'app_produits2')]
    public function produits2(int $id, ProduitRepository $pr): Response
    {
        $produits = $pr->findBy(['categorie' => $id]);
        return $this->render('default/produits.html.twig',
            ['produits' => $produits]
        );
    }

    #[Route("/produit/{id}", name:"app_produit")]
    public function produit(int $id,ProduitRepository $pr,CommentaireRepository $cr, Request $request): Response
    {
        $produit = $pr->findOneBy(['id'=>$id]);
        $commentaires = $cr->findBy(['produit' => $produit]);

        $commentaire = new Commentaire();
        $form = $this->createForm(CommentaireType::class, $commentaire);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
            $date = \DateTime::createFromFormat('Y-m-d', date('Y-m-d'));;
            $commentaire->setDate($date);
            $commentaire->setProduit($produit);
            $cr->save($commentaire,true);
            $produits = $pr->findAll();
            return $this->render('default/produits.html.twig',['produits' => $produits]);
        }

        return $this->render('default/produit.html.twig', [
            'produit' => $produit,
            'commentaires' => $commentaires,
            'form_commentaire' => $form
        ]);
    }

    #[Route('/vendre', name: 'app_vendre')]
    public function vendre(Request $request, ProduitRepository $pr): Response
    {
        $produit = new Produit();
        $form = $this->createForm(VendreProduitType::class, $produit);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
            $imageFile = $form->get('image')->getData();

            if ($imageFile){
                $destination = $this->getParameter('kernel.project_dir') . '/public/images';
                $originalFilename = pathinfo($imageFile->getClientOriginalName(), PATHINFO_FILENAME);
                $newFilename = $originalFilename . '.' . $imageFile->guessExtension();

                $imageFile->move(
                    $destination,
                    $newFilename
                );
                $produit->setImage($newFilename);
            }

            $pr->save($produit, true);

            return $this->redirectToRoute('app_produits');
        }

        return $this->render('default/vendre.html.twig',
            ['form_produit' => $form,
            'produit' => $produit]
        );
    }

    #[Route("/a_propos", name:"app_a_propos")]
    public function a_propos(): Response
    {
        return $this->render('default/a_propos.html.twig');
    }
}
