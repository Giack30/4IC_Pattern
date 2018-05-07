Progetto iteratore

è un progetto in javaFx dove si mostra l'utilizzo dell'oggetto Iteratore.

Nel programma si può interagire sia con l'iteratore, ovvero scorrendo il contenitore senza interagirci, sia con il contenitore, andando a modificarne il contenuto.

Si fa uso di 2 interfacce e 2 classi:
Interfacce:
-Container: interfaccia contenente i metodi condivisi da tutte le classi contenitori, compreso il metodo che restituisce l'iteratore specializzato;
-Iterator: interfaccia contenente i metodi condivisi dagli iteratori.
Classi:
-ConcreteContainer: classe che estende l'interfaccia Container, è il contenitore vero e proprio, con i vari metodi per modificarne il contenuto;
-ConcreteIterator: classe che estende l'interfaccia Iterator, ogni container ha la sua classe ConcreteIterator personalizzata, poichè ongi contenitore ha un modo diverso per accedere agli elementi.