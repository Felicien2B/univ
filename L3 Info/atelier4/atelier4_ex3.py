# -*- coding: utf-8 -*-
"""
Auteurs : Félicien BERTRAND, Jean BERTRAND
Date : 16/09/2021
Version : 1
Description : Exercice 3 de l'atelier 4
"""

from atelier4_ex2 import dictionnaire
import random as rd

def places_lettre(ch: str, mot: str)-> [int]:
    """
    Retourne les positions d'une lettre dans un mot

    inputs:
        ch: str : Lettre
        mot: str : Mot

    outputs:
        [int]: Positions de la lettre dans le mot (vide si lettre absente)
    """
    lpos = []
    len_mot = len(mot)
    for i in range(len_mot):
        if mot[i] == ch:
            lpos.append(i)
    return lpos

def output_str(mot: str, lpos: [int])-> str:
    """
    Retourne le mot avec des lettres cachées (remplacées par des tirets)

    inputs:
        mot: str : Mot
        lpos: [int] : Positions des lettres à afficher

    outputs:
        [str]: Mot avec lettres cachées
    """
    caracteres = ""
    len_mot = len(mot)
    for i in range(len_mot):
        if i in lpos:
            caracteres += mot[i]
        else:
            caracteres += "_"
        caracteres += " "
    return caracteres

def run_game():
    """
    Lance le jeu du pendu
    """
    C5 = ""
    C4 = "|---] "
    C3 = "| O "
    C2 = "| T "
    C1 = "|/ \ "
    C0 = "|______"
    PENDU = [C5, C4, C3, C2, C1, C0] #Affichage du pendu
    LIGNES = len(PENDU)
    lst_mot = dictionnaire("littre.txt")
    n_mots = len(lst_mot)
    mot = lst_mot[rd.randint(0, n_mots)] #Tirage au sort du mot à trouver
    lpos_trouve = [] #Pos des lettres trouvées
    trouve = False #True quand le mot est trouvé
    coups = 5 #Coups restants
    while not trouve and coups > 0:
        print(output_str(mot, lpos_trouve)) #Affichage du mot caché
        print("Coups restants :", coups)
        lettre = ""
        while lettre == "":
            lettre = input("Proposez une lettre : ")
        lettre = lettre[0] #Une seule lettre
        lpos_prop = places_lettre(lettre, mot) #Pos de la lettre proposée
        #Vérification de la présence de la lettre proposée
        if lpos_prop == []:
            coups -= 1
        elif lpos_prop[0] in lpos_trouve:
            print("Lettre déjà trouvée")
        else:
            lpos_trouve += lpos_prop
        #Affichage du pendu en fonction des coups restants
        for i in range(LIGNES-coups):
            print(PENDU[i])
        if len(lpos_trouve) == len(mot): #Si le mot est trouvé
            trouve = True
    #Fin de partie
    if trouve:
        print(mot, "a été trouvé")
    else:
        print(mot, "n'a pas été trouvé")

run_game()
