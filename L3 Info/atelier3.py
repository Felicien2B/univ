# -*- coding: utf-8 -*-
"""
Auteurs : Félicien BERTRAND, Jean BERTRAND
Date : 12/09/2021
Version : 1
Description : Exercices de l'atelier 3
"""

import matplotlib.pyplot as plt

#Exercice 1
def somme1(lst: list)-> int:
    """
    Retourne la somme des valeurs d'une liste

    inputs:
        lst: list : Liste d'entiers

    outputs:
        int: Somme des entiers
    """
    somme = 0
    for i in range(len(lst)):
        somme += lst[i]
    return somme

def somme2(lst: list)-> int:
    """
    Retourne la somme des valeurs d'une liste

    inputs:
        lst: list : Liste d'entiers

    outputs:
        int: Somme des entiers
    """
    somme = 0
    for e in lst:
        somme += e
    return somme

def somme3(lst: list)-> int:
    """
    Retourne la somme des valeurs d'une liste

    inputs:
        lst: list liste d'entiers

    outputs:
        int: somme des entiers
    """
    somme = 0
    n = 0
    while n < len(lst):
        somme += lst[n]
        n += 1
    return somme

#Ici la version somme2 a l'air plus adaptée, elle récupère directement
#les éléments de la liste sans avoir à calculer sa longueur.

def test_exercice1():
    """Test des fonctions somme"""
    print("TEST SOMME")
    #test liste vide
    print("Test liste vide :", somme2([]))
    #test somme 11111
    lst1 = [1, 10, 100, 1000, 10000]
    print("Test somme 11111 :", somme2(lst1))

test_exercice1()

def moyenne(lst: list)-> float:
    """
    Retourne la valeur moyenne des éléments de la liste

    inputs:
        lst:list liste d'entiers

    outputs:
        float: moyenne des entiers
    """
    somme = somme2(lst)
    moy = 0
    if lst != []:
        moy = somme / len(lst)
    return moy

def test_moyenne():
    """Test de la fonction moyenne"""
    print("TEST MOYENNE")
    #test liste vide
    print("Test liste vide :", moyenne([]))
    #test moyenne -2 / 4 = -0.5
    lst = [-5, -2, 1, 4]
    print("Test moyenne -0.5 :", moyenne(lst))
    #test moyenne 150 / 5 = 30
    lst = [1, 0, 105, 14, 30]
    print("Test moyenne 30 :", moyenne(lst))

test_moyenne()

def nb_sup1(lst: list, e: int)-> int:
    """
    Retourne le nombre de valeurs supérieures à la valeur e choisie

    inputs:
        lst:list liste d'entiers
        e:int valeur à comparer avec celles de la liste

    outputs:
        int: nombre de valeurs supérieures à e
    """
    n = 0
    for i in range(len(lst)):
        if lst[i] > e:
            n += 1
    return n

def nb_sup2(lst: list, e: int)-> int:
    """
    Retourne le nombre de valeurs supérieures à la valeur e choisie

    inputs:
        lst:list liste d'entiers
        e:int valeur à comparer avec celles de la liste

    outputs:
        int: nombre de valeurs supérieures à e
    """
    n = 0
    for nb in lst:
        if nb > e:
            n += 1
    return n

def test_nb_sup():
    """Test des fonctions nb_sup"""
    print("TEST SUPERIEURES")
    #test liste vide
    print("Test liste vide :", nb_sup2([], 0))
    #test nb_sup 3
    lst = [-4, 3, 5, -1, 18]
    e = 2
    print("Test nb_sup 3 :", nb_sup2(lst, e))

test_nb_sup()

def moy_sup(lst: list, e: int)-> float:
    """
    Retourne la moyenne des valeurs supérieures à la valeur e choisie

    inputs:
        lst:list liste d'entiers
        e:int valeur à comparer avec celles de la liste

    outputs:
        float: moyenne des valeurs supérieures à e
    """
    moy = 0
    somme = 0
    for nb in lst:
        if nb > e:
            somme += nb
    if somme > 0:
        moy = somme / nb_sup2(lst, e)
    return moy

def test_moy_sup():
    """Test de la fonction moy_sup"""
    print("TEST MOYENNE SUP")
    #test liste vide
    print("Test liste vide :", moy_sup([], 0))
    #test moy_sup (3+5+8) / 2 = 6.5
    lst = [-4, 3, 5, -1, 8]
    e = 4
    print("Test moy_sup 6.5 :", moy_sup(lst, e))
    e = 10
    print("Test tous inférieurs :", moy_sup(lst, e))

test_moy_sup()

def val_max(lst: list)-> int:
    """
    Retourne la valeur max de la liste

    inputs:
        lst:list liste d'entiers

    outputs:
        int: valeur max de la liste
    """
    if len(lst) == 0:
        return 0
    maxi = lst[0]
    for e in lst:
        if maxi < e:
            maxi = e
    return maxi

def test_val_max():
    """Test de la fonction val_max"""
    print("TEST VALEUR MAX")
    #test liste vide
    print("Test liste vide :", val_max([]))
    #test val_max 8
    lst = [-4, 3, 8, -1, 0]
    print("Test val_max 8 :", val_max(lst))

test_val_max()

def ind_max(lst: list)-> int:
    """
    Retourne l'indice de la valeur max de la liste

    inputs:
        lst:list liste d'entiers

    outputs:
        int: indice du max de la liste (-1 si non présent)
    """
    if lst == []:
        ind = -1
    else:
        maxi = val_max(lst)
        for i in range(len(lst)):
            if lst[i] == maxi:
                ind = i
    return ind

def test_ind_max():
    """Test de la fonction ind_max"""
    print("TEST INDICE MAX")
    #test liste vide
    print("Test liste vide :", ind_max([]))
    #test ind_max 2
    lst = [-4, 3, 8, -1, 0]
    print("Test ind_max 2 :", ind_max(lst))

test_ind_max()


#Exercice 2
def position1(lst: list, e: int)-> int:
    """
    Retourne l'indice de l'entier e dans la liste

    inputs:
        lst:list liste d'entiers
        e:int une valeur de la liste

    outputs:
        int: indice de e dans la liste (-1 si non présent)
    """
    ind = -1
    for i in range(len(lst)):
        if lst[i] == e:
            ind = i
    return ind

def position2(lst: list, e: int)-> int:
    """
    Retourne l'indice de l'entier e dans la liste

    inputs:
        lst:list liste d'entiers
        e:int une valeur de la liste

    outputs:
        int: indice de e dans la liste (-1 si non présent)
    """
    i = 0
    while i < len(lst):
        if lst[i] == e:
            return i
        i += 1
    return -1

def test_position():
    """Test de la fonction position"""
    print("TEST POSITION")
    #test liste vide
    print("Test liste vide :", position1([], 0))
    #test position 1
    lst = [-4, 3, 8, -1, 0]
    e = 3
    print("Test position 1 :", position1(lst, e))

test_position()

def nb_occurences(lst: list, e: int)-> int:
    """
    Retourne le nombre d'occurences de e dans la liste

    inputs:
        lst:list liste d'entiers
        e:int une valeur de la liste

    outputs:
        int: nombre d'occurences de e
    """
    occur = 0
    for n in lst:
        if n == e:
            occur += 1
    return occur

def test_nb_occurences():
    """Test de la fonction nb_occurences"""
    print("TEST OCCURENCES")
    #test liste vide
    print("Test liste vide :", nb_occurences([], 0))
    #test nb_occurences 3
    lst = [4, -2, 8, -2, -2, 4]
    e = -2
    print("Test nb_occurences 3 :", nb_occurences(lst, e))

test_nb_occurences()

def est_triee1(lst: list)-> bool:
    """
    Retourne si la liste est triée par ordre croissant ou non

    inputs:
        lst:list liste d'entiers

    outputs:
        bool:liste triée ou non
    """
    tri = True
    for i in range(len(lst)-1):
        if lst[i] > lst[i+1]:
            tri = False
    return tri

def est_triee2(lst: list)-> bool:
    """
    Retourne si la liste est triée par ordre croissant ou non

    inputs:
        lst:list liste d'entiers

    outputs:
        bool:liste triée ou non
    """
    i = 0
    tri = True
    while(tri and i < len(lst)-1):
        if lst[i] > lst[i+1]:
            tri = False
        i += 1
    return tri

#La version est_triee2 est plus rapide car elle s'arrête
#dès qu'un élément n'est pas dans l'ordre.

def test_est_triee():
    """Test de la fonction est_triee"""
    print("TEST TRI")
    #test liste vide
    print("Test liste vide :", est_triee1([]))
    #test liste 1 nombre
    print("Test liste 1 nombre :", est_triee1([1]))
    #test liste triée
    lst = [-2, -1, 0, 1, 5]
    print("Test liste triée :", est_triee1(lst))
    #test liste non triée
    lst = [-2, -1, 8, 0, 0]
    print("Test liste non triée :", est_triee1(lst))

test_est_triee()

def position_tri(lst: list, e: int)-> int:
    """
    Retourne l'indice de l'entier e par recherche dichotomique

    inputs:
        lst:list liste d'entiers triée
        e:int entier

    outputs:
        int: indice de e dans la liste (-1 si non présent)
    """
    lst = sorted(lst) #liste triée
    debut = 0 #zone de recherche
    fin = len(lst)
    if fin == 0: #si la liste est vide
        return -1
    while debut <= fin: #condition d'arrêt
        milieu = (debut + fin) // 2 #milieu de la zone de recherche
        if lst[milieu] == e:
            return milieu
        #tant que e n'est pas trouvé, on divise la zone de recherche par 2
        if lst[milieu] < e:
            debut = milieu + 1
        else:
            fin = milieu - 1
    return -1 #si e n'est pas dans la liste

def test_position_tri():
    """Test de la fonction position_tri"""
    print("TEST POSITION TRI")
    #Test liste vide
    print("Test liste vide")
    test = position_tri([], 0)
    if test == -1: #Résultat attendu : -1
        print("SUCCES : ", end='')
    else:
        print("ECHEC : ", end='')
    print("Attendu : -1 / Obtenu :", test)
    #Tests valeurs introuvable, au début, au milieu, à la fin
    lst = [-2, -1, 0, 3, 4, 6, 8]
    lst = sorted(lst) #Liste supposée triée
    e = [5, -2, 3, 8] #Liste des valeurs e
    resultats = [-1, 0, 3, 6] #Résultats attendus
    tests = ["introuvable", "au début", "au milieu", "à la fin"]
    for i in range(len(e)): #Boucle de tests
        print("Test valeur", tests[i])
        test = position_tri(lst, e[i])
        if test == resultats[i]:
            print("SUCCES : ", end='')
        else:
            print("ECHEC : ", end='')
        print("Attendu :", resultats[i], "/ Obtenu :", test)

test_position_tri()

def a_repetitions(lst: list)-> bool:
    """
    Vérifie s'il y a des répétitions dans la liste

    inputs:
        lst: list : Liste d'entiers triée

    outputs:
        bool: True si répétitions
              False sinon
    """
    lst_t = []
    rep = False
    i = 0
    while(not rep and i < len(lst)):
        e = lst[i]
        if e not in lst_t:
            lst_t.append(lst[i])
            i += 1
        else:
            rep = True
    return rep

#Exercice 3
def separer(lst: list)-> list:
    """
    Retourne une liste d'entiers regroupés par leur signe
    (négatifs / nuls / positifs)

    inputs:
        lst:list liste d'entiers

    outputs:
        list: liste d'entiers regroupés
    """
    negatifs = 0 #compteur de négatifs
    lst_sep = [] #Nouvelle liste
    for i in range(len(lst)):
        if lst[i] < 0:
            negatifs += 1
            lst_sep.insert(0, lst[i]) #Ajout au début de la liste
        elif lst[i] == 0:
            lst_sep.insert(negatifs, lst[i]) #Ajout après les négatifs
        else:
            lst_sep.append(lst[i]) #Ajout à la fin de la liste
    return lst_sep

def test_separer():
    """Test de la fonction separer"""
    print("TEST SEPARATION")
    #test liste vide
    print("Test liste vide :", separer([]))
    #test 10 nombres
    lst = [0, -6, 9, 1, 3, -4, 0, -5, 0, 8]
    print("Test 10 nombres :", separer(lst))

test_separer()

#Exercice 4
def histo(lst_f: list)-> list:
    """
    Retourne une liste représentant l'histogramme d'une liste donnée

    inputs:
        lst_f:list liste d'entiers

    outputs:
        list: liste d'entiers (histogramme de lst_f)
    """
    lst_h = [0] * (val_max(lst_f)+1) #Initialisation avec liste de zéros
    for e in lst_f: #Chaque valeur incrémente sa case correspondante
        lst_h[e] += 1
    return lst_h

def est_injective(lst_f: list)-> bool:
    """
    Retourne si la fonction représentée par la liste est une injection

    inputs:
        lst_f:list liste d'entiers

    outputs:
        bool: True si injection
              False sinon
    """
    his = histo(lst_f) #On récupère la liste histogramme
    for e in his:
        if e > 1:
            return False
    return True

def est_surjective(lst_f: list)-> bool:
    """
    Retourne si la fonction représentée par la liste est une surjection

    inputs:
        lst_f: list : Liste d'entiers

    outputs:
        bool: True si surjection
              False sinon
    """
    his = histo(lst_f)
    for e in his:
        if e < 1:
            return False
    return True

def est_bijective(lst_f: list)-> bool:
    """
    Retourne si la fonction représentée par la liste est une bijection

    inputs:
        lst_f: list : Liste d'entiers

    outputs:
        bool: True si bijection
              False sinon
    """
    return est_injective(lst_f) and est_surjective(lst_f)

def test_histo():
    """Test des fonctions histo, injective, surjective, bijective"""
    print("TEST HISTO")
    #test non injective non surjective
    lst_f = [6, 5, 6, 8, 4, 2, 1, 5]
    print("Test histogramme :", histo(lst_f))
    print("Test non injective :", est_injective(lst_f))
    print("Test non surjective :", est_surjective(lst_f))
    print("Test non bijective :", est_bijective(lst_f))
    #test bijective
    lst_f = [6, 5, 3, 8, 4, 2, 1, 7, 0]
    print("Test histogramme :", histo(lst_f))
    print("Test injective :", est_injective(lst_f))
    print("Test surjective :", est_surjective(lst_f))
    print("Test bijective :", est_bijective(lst_f))

test_histo()

def affiche_histo(lst_f: list):
    """
    Affiche l'histogramme d'une liste d'entiers

    inputs:
        lst_f: list : Liste d'entiers'
    """
    lst_h = histo(lst_f)
    MAXOCC = val_max(lst_h)
    print("TEST HISTOGRAMME\n")
    print("F=", lst_f, "\n")
    print("HISTOGRAMME")
    for i in range(MAXOCC+1, 0, -1): #Affichage occurences
        for e in lst_h:
            if e >= i:
                occ = "   #"
            else:
                occ = "    "
            print(occ, end='')
        print("") #Retour à la ligne
    for i in range(len(lst_h)): #Affichage numéros des colonnes
        print("| --", end='')
    print("|\n  ", end='')
    for i in range(len(lst_h)):
        if i < 9:
            espace = "  "
        else: #Un espace en moins si nombre à 2 chiffres
            espace = " "
        print(i, espace, end='')
    print("")

def affiche_histo2(lst_f: list):
    """
    Affiche l'histogramme d'une liste d'entiers

    inputs:
        lst_f:list : Liste d'entiers'
    """
    plt.hist(lst_f)

def test_affiche_histo():
    """Test de l'affichage de l'histogramme"""
    lst_f = [1, 5, 5, 5, 9, 11, 11, 15, 15, 15]
    affiche_histo(lst_f)
    affiche_histo2(lst_f)

test_affiche_histo()


#Exercice 5
def test_present(present: callable):
    """
    Test de la fonction present

    inputs:
        present:callable : Fonction present
    """
    if present([], 0):
        print("ECHEC : test liste vide")
    else:
        print("SUCCES : test liste vide")
    lst = [10, 6, 7, 8, 9, 1, 2, 3, 4, 5]
    e = [10, 5, 9, 0] #Liste des valeurs e
    tests = ["debut", "fin", "milieu", "absence"] #Liste des tests
    succes = [True, True, True, False] #Résultats attendus des tests
    for i in range(len(e)):
        if present(lst, e[i]) == succes[i]:
            print("SUCCES : test", tests[i])
        else:
            print("ECHEC : test", tests[i])

#VERSION 1
def present1(lst, e):
    """Vérifie si un élément est présent dans la liste"""
    for i in range(0, len(lst), 1):
        if lst[i] == e:
            return True
#       else :              #Le else casse la boucle
#           return False
    return False #Erreur d'indentation

#VERSION 2
def present2(lst, e):
    """Vérifie si un élément est présent dans la liste"""
#   b = True
    b = False #False par défaut
    for i in range(0, len(lst), 1): #Erreur d'indentation
        if lst[i] == e:
            b = True
#       else:      #La fonction ne prend en compte que la dernière valeur
#           b = False
    return b

#VERSION 3
def present3(lst, e):
    """Vérifie si un élément est présent dans la liste"""
#   b = True #Inutilisé
#   for i in range(0, len(lst), 1):
#       return lst[i] == e    #Ne prend en compte que la première valeur
    return e in lst

#VERSION 4
def present4(lst, e):
    """Vérifie si un élément est présent dans la liste"""
    b = False
    i = 0
#   while (i < len(lst) and b): #b doit être False pour rentrer dans la boucle
    while (i < len(lst) and not b):
        if lst[i] == e:
            b = True
        i += 1 #i doit être incrémenté
    return b

print("TESTS PRESENT")
print("TEST 1")
test_present(present1)
print("TEST 2")
test_present(present2)
print("TEST 3")
test_present(present3)
print("TEST 4")
test_present(present4)

def test_pos(fonction_pos: callable):
    """
    Test de la fonction pos

    inputs:
        fonction_pos:callable : Fonction pos
    """
    if fonction_pos([], 0) == []:
        print("SUCCES : test liste vide")
    else:
        print("ECHEC : test liste vide")
    lst = [3, 4, 5, 7, 2, 7]
    e = [3, 7, 5, 1] #Liste des valeurs e
    tests = ["debut", "fin", "milieu", "absence"] #Liste des tests
    succes = [[0], [3, 5], [2], []] #Résultats attendus des tests
    for i in range(len(e)):
        if fonction_pos(lst, e[i]) == succes[i]:
            print("SUCCES : test", tests[i])
        else:
            print("ECHEC : test", tests[i])

#VERSION 1
def pos1(lst, e):
    """Retourne les positions d'apparition d'un élément dans la liste"""
#   lst_res = list(lst)
    lst_res = [] #Liste vide pour l'initialisation
    for i in range(0, len(lst), 1):
        if lst[i] == e:
            lst_res += [i]
    return lst_res

# VERSION 2
def pos2(lst, e):
    """Retourne les positions d'apparition d'un élément dans la liste"""
    lst_res = list(lst)
    for i in range(0, len(lst), 1):
        if lst[i] == e:
            lst_res[i] = i
        else:
            lst_res[i] = -1 #Valeur à retirer de la liste
    while -1 in lst_res:
        lst_res.remove(-1)
    return lst_res

# VERSION 3
def pos3(lst, e):
    """Retourne les positions d'apparition d'un élément dans la liste"""
    nb = lst.count(e)
    lst_res = [0]*nb
    occ = 0 #Compteur d'occurences dans la boucle
    for i in range(0, len(lst), 1):
        if lst[i] == e:
#           lst_res.append(i) #Ajoute les positions au lieu de remplacer les 0
            lst_res[occ] = i
            occ += 1
    return lst_res

# VERSION 4
def pos4(lst, e):
    """Retourne les positions d'apparition d'un élément dans la liste"""
    nb = lst.count(e)
    lst_res = [0]*nb
    j = 0
    for i in range(0, len(lst), 1):
        if lst[i] == e:
            lst_res[j] = i
            j += 1 #Il faut incrémenter j
    return lst_res

print("TESTS POS")
print("TEST 1")
test_pos(pos1)
print("TEST 2")
test_pos(pos2)
print("TEST 3")
test_pos(pos3)
print("TEST 4")
test_pos(pos4)
