# application console de simulation de l'algorithme Variable Neighbourhood Descent 

est une méthode métaheuristique pour résoudre un ensemble de problèmes et rendre la meilleure solution

 -----------------------------------------------------------------------
              LA STRUCTURE GENERALE DE  LALGORITHME VND              
 -----------------------------------------------------------------------              
          VND()                                                    
    DEBUT                                                            
     Choisir une solution initiale X0                               
         Xbest → X0                                                   
           TANT QUE Xbest peut être amélioré FAIRE                    
             POUR i allant de 1 à k FAIRE                             
               POUR TOUT (x') ∈ vi(x) FAIRE                                   
                  SI f(x') < f (Xbest) ALORS                          
                    Xbest → X'                                        
                    arrêter la boucle POUR                            
                    arrêter la boucle POUR                            
             FIN SI                                                   
         FIN POUR                                                    
         FIN TANT POUR                                                
         FIN TANT QUE                                                 
    FIN                                                              
 --------------------------------------------------------------------------------------------------------------------------------------
 après que notre prof mr BADDI Youssef nous a demandé un projet: application console de simulation de l'algorithme VND   /en java\

      on a realisé :
        - une classe abstract vnd ou il y'a des fonctions de base abstract
            - une class main dans laquelle on vous demande de choisir un exemple 
               - des exemples des problemes résolus par vnd algorithme 
                      -> 3 exemples (magic square - N Queens - dinner party)  
-----------------------------------------------------------------------------------------------------------------------------------------
-------------------------------
   # réaliser par: 
              - omar sanad                
                    - salaheddine razik    
                         - ghizlane mardy   
