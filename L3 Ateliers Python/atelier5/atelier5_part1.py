# -*- coding: utf-8 -*-
"""
Auteurs : Félicien BERTRAND, Jean BERTRAND
Date : 17/09/2021
Version : 1
Description : Exercices de la partie 1 de l'atelier 5
"""

import random as rd

#Exercice 1
def gen_list_random_int(int_nbr=10, int_binf=0, int_bsup=10)-> [int]:
    """
    Retourne une liste de valeurs tirées au hasard (avec random)

    inputs:
        int_nbr: int : Nombre de valeurs à tirer (10 par défaut)
        int_binf: int : Valeur min (inclus, 0 par défaut)
        int_bsup: int : Valeur max (exclus, 10 par défaut)

    outputs:
        [int]: Liste de valeurs tirées au hasard
    """
    lst_nbr = []
    for _ in range(int_nbr):
        nbr = rd.randint(int_binf, int_bsup-1)
        lst_nbr.append(nbr)
    return lst_nbr

print("10 valeurs:", gen_list_random_int())
print("5 valeurs:", gen_list_random_int(5))
print("10 valeurs de 1 (inclus) à 100 (exclus):\n", gen_list_random_int(10, 1, 100))


#Exercice 2
def mix_list(list_to_mix: list)-> list:
    """
    Retourne la liste en paramètre, après mélange de ses éléments

    inputs:
        list_to_mix: list : Liste à mélanger

    outputs:
        list: Liste mélangée
    """
    list_res = []
    taille = len(list_to_mix)
    #On récupère les éléments de list_to_mix un par un,
    #pour chaque élément on tire un nouvel indice
    #(entre 0 et le nombre d'éléments déjà placés dans list_res)
    #pour le placer dans list_res
    for ind_list_to_mix in range(taille):
        ind_list_res = rd.randint(0, ind_list_to_mix)
        list_res.insert(ind_list_res, list_to_mix[ind_list_to_mix])
    return list_res

def test_mix_list():
    """
    Test de la fonction mix_list
    """
    lst_sorted = [i for i in range(10)]
    print('Liste triée de départ', lst_sorted)
    mixed_list = mix_list(lst_sorted)
    print('Liste mélangée obtenue', mixed_list)
    print('Liste triée de départ après appel à mixList, elle doit être inchangée', lst_sorted)
    #assert (cf. doc en ligne) permet de vérifier qu’une condition
    #est vérifiée en mode debug (désactivable)
    assert lst_sorted != mixed_list, ("Les deux listes doivent être "
                                      "différentes après l'appel à mixList")
    assert len(lst_sorted) == len(mixed_list), ("Les deux listes doivent être "
                                                "de même longueur")
    for elt in lst_sorted:
        assert elt in mixed_list, ("La liste mélangée doit contenir "
            "les mêmes éléments que dans la liste de départ")

test_mix_list()

#Exercice 3
def choose_element_list(list_in_which_to_choose: list):
    """
    Retourne un élément au hasard de la liste en paramètre

    inputs:
        list_in_which_to_choose: list : Liste contenant l'élément tiré au sort

    outputs:
        Élément de la liste, choisi au hasard
    """
    #Indice de l'élément tiré au sort
    indice = rd.randint(0, len(list_in_which_to_choose)-1)
    the_chosen_one = list_in_which_to_choose[indice]
    return the_chosen_one

def test_choose_element_list():
    """
    Test de la fonction choose_element_list
    """
    lst_sorted = [i for i in range(10)]
    print('Liste triée de départ', lst_sorted)
    e1 = choose_element_list(lst_sorted)
    print('A la première exécution', e1, 'a été sélectionné')
    e2 = choose_element_list(lst_sorted)
    print('A la deuxième exécution', e2, 'a été sélectionné')
    assert e1 in lst_sorted or e2 in lst_sorted, ("L'élément "
        "sélectionné doit être dans la liste de départ")
    assert e1 != e2, ("Attention vérifiez votre code, "
        "pour deux sélections de suite l'élément sélectionné est le même !")

#test_choose_element_list()

#Exercice 4
def extract_elements_list(list_in_which_to_choose: list,
                          int_nbr_of_element_to_extract: int)-> list:
    """
    Retourne un certain nombre d'éléments choisis au hasard,
    parmi ceux de la liste en paramètre

    inputs:
        list_in_which_to_choose: list : Liste contenant les éléments tirés
                                        au sort
        int_nbr_of_element_to_extract: int : Nombre d'éléments à sélectionner

    outputs:
        list: Éléments de la liste, choisis au hasard
    """
    assert int_nbr_of_element_to_extract < len(list_in_which_to_choose), (
        "Le nombre d'éléments à sélectionner est trop élevé !")
    the_chosen_list = [] #Liste d'éléments sélectionnés
    #Liste de départ sans les éléments déjà sélectionnés
    list_not_chosen = list_in_which_to_choose.copy()
    #Chaque élément sélectionné est ajouté dans the_chosen_list
    #et est retiré de list_not_chosen pour éviter les répétitions
    for _ in range(int_nbr_of_element_to_extract):
        the_chosen_one = choose_element_list(list_not_chosen)
        the_chosen_list.append(the_chosen_one)
        list_not_chosen.remove(the_chosen_one)
    return the_chosen_list

def test_extract_element_list():
    """
    Test de la fonction extract_elements_list
    """
    lst_sorted = [i for i in range(10)]
    print('Liste de départ', lst_sorted)
    sublist = extract_elements_list(lst_sorted, 5)
    print('La sous liste extraite est', sublist)
    print('Liste de départ après appel de la fonction est', lst_sorted)
    for elt in sublist:
        assert elt in lst_sorted, ("La liste mélangée ne doit contenir "
                                   "que des éléments de la liste de départ")

#test_extract_element_list()
