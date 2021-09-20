# -*- coding: utf-8 -*-
"""
Auteurs : Félicien BERTRAND, Jean BERTRAND
Date : 17/09/2021
Version : 1
Description : Exercices de la partie 1 de l'atelier 5
"""

import random as rd

#Exercice 1
def gen_list_random_int(int_nbr = 10, int_binf = 0, int_bsup = 10)-> [int]:
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
    list_mix = []
    taille = len(list_to_mix)
    for ind_list_to_mix in range(taille):
        ind_list_mix = rd.randint(0, ind_list_to_mix)
        list_mix.insert(ind_list_mix, list_to_mix[ind_list_to_mix])
    return list_mix

def test_mix_list():
    """
    Test de la fonction mix_list
    """
    lst_sorted = [i for i in range(10)]
    print(lst_sorted)
    print('Liste triée de départ', lst_sorted)
    mixed_list = mix_list(lst_sorted)
    print('Liste mélangée obtenue', mixed_list)
    print('Liste triée de départ après appel à mixList, elle doit être inchangée', lst_sorted)
    #assert (cf. doc en ligne) permet de vérifier qu’une condition
    #est vérifiée en mode debug (désactivable)
    assert lst_sorted != mixed_list, "Les deux listes doivent être différentes après l'appel à mixList..."

test_mix_list()