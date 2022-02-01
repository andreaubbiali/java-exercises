### Correzioni con professore (dopo call con lui)

# eccezioni
Non creare le eccezioni così a caso, non hanno senso come le ho fatte. Solitamente un'eccezione riguarda un problema (IllegalArgumentException l'argomento non va bene, IndexOutOfBound indice ecc... ) Io invece è come se avessi creato una maxi-eccezione che riguarda tutto e fa schifo.

# classe Durata
Potrebbe anche starci come l'ho fatta (ho fatto una classe mutabile mentre lui ha usato un record) ma come l'ho implementata non va bene. Potrebbero esserci dei problemi perchè con gli add e i remove potrebbe andare sotto zero i minuti.
Un modo migliore per tenere sempre controllato che la durata sia apposto (maggiore o uguale a zero) è utilizzare un record (immutabile) e ritornare sempre la Durata.

# classe brano
Con l'equals che ho implementato due brani in due playlist diverse sono uguali.. Non è come richiesto (in realtà non era proprio richiesto di fare l'override)


# classe album
* Come mai alcuni campi sono final e altri no (pirla).
* Nel costruttore di album ho usato una mappa, giustamente ho fatto notare che utilzizando una hashLinkedMap manteniamo in ordine. Giustamente mi ha fatto capire che se per caso dovessero eliminare HashLinkedMap salta tutta la nostra api. La cosa migliore è implementare utilzzando due array che sono strutture elementari (che quindi hanno tutti i linguaggi) e li posso utilizzare per costruire l'oggetto ordinato come richiesto. Quindi il problema qua era che chi volesse usare la mia api deve per forza usare hashLinkedMap ma non tutti i linguaggi ce l'hanno.

* getBranoByTitolo potevi utilizzare invece che l'iteratore un for range
* ocio agli equals

# classe playlist
* Perchè hai fatto l'interface? altre classi la utilizzano? no... Potrei averla scritta per stipulare il contratto però se lo fai per quel motivo aggiungi almeno i commenti.
* getBraniByAlbum perchè torni una copia della lista? Nella richiesta parlava di un enumeratore quindi lui voleva un iteratore. Perchè è meglio un iteratore? perchè in questo modo l'utente non deve allocare una lista di 100 elementi e iterarla per fare quello che gli serve. Utilizzando l'iteratore non lo obblighi ad allocare nulla e può utilizzarlo meglio.


# general
* Quando fai override di equals è buona cosa fare anche l'hashcode (cerca il perchè)
e oltre tutto gli equals non li ho implementati nel modo giusto
* Spiega BENE l'invariante. Indica i null/ not null maggiore di zero ecc..
* Ricordati che per CONFRONTARE le STRINGHE devi usare equals
* Nel fare delle API devi sempre pensare che chi vuole collegarsi non sempre utilizza linguaggi ricchi, potrebbe utilizzare linguaggi con strutture dati povere e quindi impossibilitato/ gli rendi difficile l'utilizzo della tua api. Per questo il professore utilizza maggiormente gli array piuttosto che altre strutture.
* Perchè nella classe Playlist il professore non ha usato i campi final? (Questa è una mia risposta quindi non so se sia vero): il nome e la durata non sono final perchè essendo la classe mutabile essi potrebbero mutare. La lista viene invece messa a final perchè è comunque mutabile l'elemento della lista ma non mutabile il puntatore a tale lista.
* Dai un'occhiata all'implementazione del professore di Durata che è bellissima.
* Durata è stata creata in modo immutabile perchè "dato che le sue istanze (usate all’interno delle altre classi) saranno presumibilmente passate come parametri e restituite da diversi metodi, è bene che il tipo sia immutabile (per evitare la necessità di proteggerne ogni volta le istanze con delle copie)".
* in brano è stato per esempio implementato un iteratore utilizzabile in modo tale che l'array non sia strutturalmente modificabile. Infatti implementando un iteratore puoi implementare il metodo "remove" ma nel nostro caso (come default) non avendolo implementato sarà tornato UnsupportedOperationException. Così l'array non sarà in alcun modo modificabile.

### MIEI PENSIERI
(in riferimento alla soluzione) I brani non devono essere condivisi tra più album. Per questo motivo creando una inner class (brano è interno ad album). Per costruire un album abbiamo solo un costruttore il quale riceve due liste e il nome dell'album. ogni brano satà costruito dall'album dato che il suo costruttore è privato e quindi non accessibile dall'esterno.
In poche parole: abbiamo fatto si che brano abbia un costruttore privato e quindi istanziabile solo da album (in questo modo due album non possono condividere lo stesso oggetto)
 
