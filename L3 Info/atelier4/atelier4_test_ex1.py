# -*- coding: utf-8 -*-
"""
Auteurs : Félicien BERTRAND, Jean BERTRAND
Date : 14/09/2021
Version : 1
Description : Test de l'exercice 1 de l'atelier 4
"""

import atelier4_ex1
full_name = atelier4_ex1.full_name
is_mail = atelier4_ex1.is_mail

#Exercice 1
def test_full_name()-> bool:
    """
    Test de la fonction full_name
    outputs:
        bool: True si le test est réussi
              False en cas d'échec
    """
    print("TEST full_name")
    lst_str_test = [' ', 'bisgambiglia paul', 'a b', 'üéì éàô'] #Chaînes de test
    lst_str_attendu = [' ', 'BISGAMBIGLIA Paul', 'A B', 'ÜÉÌ Éàô'] #Retours attendus
    succes = True #Résultat global du test
    nb_tests = len(lst_str_test) #Nombre de tests
    for i in range(nb_tests):
        str_test = lst_str_test[i]
        str_attendu = lst_str_attendu[i]
        str_obtenu = full_name(str_test)
        print("str_arg :", str_test)
        print("Attendu :", str_attendu)
        print("Obtenu :", str_obtenu)
        if str_attendu == str_obtenu:
            print("SUCCES\n")
        else:
            print("ECHEC\n")
            succes = False
    if succes:
        print("Test réussi")
    else:
        print("Test échoué")
    return succes

test_full_name()

def test_is_mail()-> bool:
    """
    Test de la fonction is_mail
    outputs:
        bool: True si le test est réussi
              False en cas d'échec
    """
    print("\nTEST is_mail\n")
    lst_str_test = ['bisgambiglia_paul@univ-corse.fr',
                    '@univ-corse.fr',
                    'bisgambiglia_paulOuniv-corse.fr',
                    'bisgambiglia_paul@uni-corse.fr',
                    'bisgambiglia_paul@univ-corsePOINTfr'] #Chaînes de test
    #Retours attendus
    lst_tuple_attendu = [(1, 6456), (0, 1), (0, 2), (0, 3), (0, 4)]
    succes = True #Résultat global du test
    nb_tests = len(lst_str_test) #Nombre de tests
    for i in range(nb_tests):
        str_test = lst_str_test[i]
        tuple_attendu = lst_tuple_attendu[i]
        tuple_obtenu = is_mail(str_test)
        print("str_arg :", str_test)
        print("Attendu :", tuple_attendu)
        print("Obtenu :", tuple_obtenu)
        if (tuple_attendu == tuple_obtenu
                or tuple_attendu[0] == 1 and tuple_obtenu[0] == 1): # (1, x)
            print("SUCCES\n")
        else:
            print("ECHEC\n")
            succes = False
    if succes:
        print("Test réussi")
    else:
        print("Test échoué")
    return succes

test_is_mail()
