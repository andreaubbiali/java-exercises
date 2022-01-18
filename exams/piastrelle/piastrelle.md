# Piastrelle

STARTED: 14:35-17:30

## La traccia

La traccia inizia con l'elencazione di alcune delle entità utili a gestire
alcuni aspetti dell'attività di un piastrellista.

### La piastrella

Una **piastrella** è un elemento architettonico usato per rivestire la
superficie dei pavimenti; ne esistono di diversi tipi, ciascuno dei quali è
caratterizzato da una serie di caratteristiche, tra le quali almeno la
*superficie* e il *costo* unitario (che per semplicità assumeremo rappresentati
da numeri interi).

Esempi di piastrelle possono essere: triangolari (caratterizzate da base e
altezza), quadrate (caratterizzate dalla lunghezza del lato), romboidali
(caratterizzate dalla lunghezza delle due diagonali) e così via…

### La pavimentazione

Una **pavimentazione** è costituita da una collezione (finita e non vuota) di
piastrelle, o altre pavimentazioni; la sua *superficie* è pari alla somma delle
superfici di tutte le piastrelle che contiene (direttamente o indirettamente) e
il suo *costo* totale è dato dalla somma dei costi di tutte le piastrelle che
contiene. Evidentemente una pavimentazione non può contenere sé stessa
(direttamente o indirettamente).

Se ad esempio:

* la pavimentazione della cucina è fatta di 42 piastrelle quadrate di lato 2 e
  prezzo 3,
* quella del bagno è fatto di 65 piastrelle romboidali con diagonali di
  lunghezza 4 e 2 con prezzo 5 e
* la pavimentazione della casa è costituita da 1 pavimentazione della cucina più
  2 pavimentazioni del bagno,

la superficie della pavimentazione della casa è pari a

    42 x (2 x 2) + 2 x [65 x (4 x 2) / 2] = 688

dove il primo addendo corrisponde alla superficie della pavimentazione della
cucina, mentre la quantità tra parentesi quadre corrisponde alla superficie
della pavimentazione del bagno. Similmente, il costo della pavimentazione della
casa è dato da

    42 x 3 + 2 x [65 x 5] = 776

dove i due addendi sono rispettivamente i costi della pavimentazione della
cucina e dei due bagni.

### Cosa è necessario implementare

Dovrà implementare una gerarchia di oggetti utili a rappresentare piastrelle e
pavimentazioni e a conoscerne superfici e costi.

In particolare dovrà essere possibile creare piastrelle di diverso tipo (a
partire quanto meno dall'indicazione delle grandezze che le caratterizzano) e
pavimentazioni (a partire quanto meno dalle loro componenti).

Per verificare il comportamento del suo codice le può essere utile implementare
una *classe di test* che, leggendo dal flusso di ingresso un elenco di azioni,
le realizzi (creando le necessarie istanze di oggetti d'appoggio).

Le azioni, indicate una per riga, sono specificate da un carattere seguito da
uno o più numeri interi; ciascuna azione determina la creazione di una
piastrella o pavimentazione, che si considerano pertanto indicizzate dal numero
di riga in cui sono state create (le righe sono numerate a partire da 0). Le
azioni sono:

* `Q` seguita da due interi, crea una piastrella quadrata di lato e costo
  assegnato;
* `R` seguita da tre interi, crea una piastrella romboidale di diagonali e costo
  assegnate;
* `T` seguita da tre interi, crea una piastrella triangolare di base, altezza e
  costo assegnati;
* `P` seguita da *2n* interi, crea una pavimentazione; le *n* coppie di interi
  rappresentano ciascuna la quantità e l'indice di una delle *n* piastrelle o
  pavimentazioni di cui è costituita.

Assuma che gli indici delle piastrelle, o pavimentazioni, che seguono la lettera
`P` siano distinti e strettamente minori del numero di riga in cui compaiono
(questo garantisce che le pavimentazioni siano in effetti insiemi e che una
pavimentazione non comprenda mai, neppure indirettamente, sé stessa); assuma
anche che le dimensioni siano sempre scelte in modo tale che la superficie
risultante sia intera.

Una volta lette tutte le azioni, l'esecuzione della classe di test termina
stampando una linea per ciascuna pavimentazione creata (in ordine di creazione)
contenente due interi (separati dal segno di tabulazione) corrispondenti alla
sue superficie e costo.

L'elenco di azioni che rappresenta le pavimentazioni dell'esempio nella sezione
precedente è:

    Q 2 3
    P 42 0
    R 4 2 5
    P 65 2
    P 1 1 2 3

le prime due righe creano le piastrelle quadrate e la pavimentazione della
cucina (che è quindi indicizzata dal numero 1), le righe di numero 2 e 3 creano
le piastrelle romboidali e la pavimentazione del bagno (indicizzata dal numero
3) e l'ultima riga crea la pavimentazione della casa (data da 1 pavimentazione
della cucina, di indice 1, e 2 pavimentazioni del bagno, di indice 3).

A fronte di tali azioni, la classe di test emette

    168	126
    260	325
    688	776

nel flusso d'uscita, dove l'ultima riga riporta i numeri calcolati nella
precedente sezione, mentre le prime due sono il valori relativi rispettivamente
a cucina e bagno.

**Nota bene**: è possibile implementare anche altri tipi di piastrelle oltre a
quadrati, rombi e triangoli (aggiungendo le opportune azioni alla classe di
test), così come potrebbe essere opportuno aggiungere altri costruttori, o
competenze *adeguate* (nel senso del termine illustrato durante il corso),
rispetto a quelle strettamente necessarie per implementare la classe di test.