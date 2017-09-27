# siw-catalog

Si vuole realizzare il sistema informativo su Web per la gestione di un catalogo di prodotti. Possono accedere al sistema utenti generici e un amministratore. Il catalogo contiene l’elenco dei prodotti e i fornitori (uno o più) di ciascun prodotto. L’amministratore, previa autenticazione, può inserire e rimuovere un prodotto, o aggiornarne l’elenco dei fornitori (aggiungere o rimuovere un fornitore ad un prodotto). Per semplicità supponiamo che per ogni prodotto siano di interesse il nome, il prezzo, una descrizione, l’elenco dei fornitori. Di ogni fornitore sono di interesse il nome, l’indirizzo, l’email. L’associazione tra prodotto e fornitore è molti a molti. L’utente generico può accedere alle informazioni del catalogo attraverso diversi percorsi di navigazione, opportunamente predisposti (ad esempio, per fornitore, oppure per nome, etc.).

http://34.214.169.64:8080/
Credenziali : Username : admin Password : siw

Casi d'uso:

>Caso d'uso UC1: Inserimento di un nuovo Prodotto - Attore primario: un Amministratore    
Un Amministratore autenticato usa il Sistema per inserire un nuovo prodotto. Il Sistema restituisce una form. L'Amministratore compila la form e la invia al Sistema. Se i dati inseriti dall'Amministratore sono validi il Sistema registra il nuovo Prodotto e mostra la pagina contenente le informazioni altrimenti mostra nuovamente la form con degli  opportuni messaggi di errore.

>Caso d'uso UC2: Modifica di un Prodotto - Attore primario: un Amministratore
Un Amministratore autenticato usa il Sistema per modificare un prodotto esistente. L'Amministratore seleziona uno dei Prodotti registrati nel Sistema e preme sul pulsante “Modifica".  Il Sistema restituisce una form. L'Amministratore compila la form e la invia al Sistema. Se i dati inseriti sono validi il Sistema aggiorna i dati del Prodotto esistente e mostra la pagina contenente le informazioni altrimenti mostra nuovamente la form con degli opportuni messaggi di errore.

>Caso d'uso UC3: Cancellazione di un Prodotto - Attore primario: un Amministratore
Un Amministratore autenticato usa il Sistema per cancellare un prodotto.L’Amministratore sceglie uno dei prodotti mostrati dal sistema e clicca sul tasto “Elimina”. Il Sistema cancella il Prodotto selezionato e mostra la lista aggiornata dei Prodotti.

>Caso d'uso UC4: Consultazione dei Prodotti presenti nel Sistema - Attore: un Utente del Sistema
Un Utente vuole visualizzare i prodotti presenti nel Sistema. Il Sistema restituisce la lista di prodotti che ha registrato. L'Utente può selezionare un prodotto in particolare e visualizzarne le informazioni in dettaglio.

>Caso d'uso UC5: Consultazione dei Fornitori presenti nel Sistema - Attore: un Utente del Sistema
Un Utente vuole visualizzare i fornitori presenti nel Sistema. Il Sistema restituisce la lista dei prodotti che ha registrato. L'Utente può selezionare un prodotto in particolare e visualizzarne le informazioni in dettaglio.


Tabelle presenti nel database:


| Prodotto |      |             |        |           |
|:--------:|:----:|:-----------:|:------:|:---------:|
| _id_     | nome | descrizione | prezzo | image_uri | 



| Fornitore |      |           |       |          |
|:---------:|:----:|:---------:|:-----:|:--------:|
| _id_      | nome | indirizzo | email | telefono |



| fornitore_prodotti |             |
|:------------------:|:-----------:|
| fornitori_id       | prodotti_id |


Con vincolo di integrita referenziale tra fornitor_id e la tabella Fornitore e tra prodotti_id e la tabella Prodotto.

(Le primary keys sono in corsivo)

Politiche di FETCH e CASCADE di default.

Tecnologie utilizzate:
* Applicazione Spring Boot
* Autenticazione con Spring Security
* JPA framework per la persistenza 
* Utilizzo di Thymeleaf come template engine
* Deploy su AWS EC2
* Salvataggio dei dati su AWS RDS (PostgresSQL database engine)
* Frontend con controllo in Javascript 
