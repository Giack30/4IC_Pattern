# Progetto iteratore
è un progetto in javaFx dove si mostra l'utilizzo dell'oggetto Iteratore.<br>
Nel programma si può interagire sia con l'iteratore, ovvero scorrendo il contenitore senza interagirci, sia con il contenitore, andando a modificarne il contenuto.<br>
Si fa uso di 2 interfacce e 2 classi:<br>
Interfacce:<br>
-Container: interfaccia contenente i metodi condivisi da tutte le classi contenitori, compreso il metodo che restituisce l'iteratore specializzato;<br>
-Iterator: interfaccia contenente i metodi condivisi dagli iteratori.<br>
Classi:<br>
-ConcreteContainer: classe che estende l'interfaccia Container, è il contenitore vero e proprio, con i vari metodi per modificarne il contenuto;<br>
-ConcreteIterator: classe che estende l'interfaccia Iterator, ogni container ha la sua classe ConcreteIterator personalizzata, poichè ongi contenitore ha un modo diverso per accedere agli elementi.
