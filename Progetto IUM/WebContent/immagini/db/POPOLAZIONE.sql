/* INIZIO POPOLAZIONE DEL DATABASE*/
use fumetteria;

  
INSERT INTO Cliente VALUES 
	('Giovanni','Storti','giovannistorti@libero.it','0','1','nn','nnn','nnn','nn','ef');
INSERT INTO Cliente VALUES 
	('Gerardo','De Rosa','duckpro@libero.it','0','4','nn','nnn','nnn','nn','ef');    
INSERT INTO Cliente VALUES 
	('Giacomo','Poretti','giacomoporetti56@live.it','0','2','nn','nnn','nnn','nn','ef');
INSERT INTO Cliente VALUES 
	('Mario','Merola','merolamario1@gmail.com','0','3','nn','nnn','nnn','nn','ef');
INSERT INTO Cliente VALUES 
	('Andrea','Alongi','andrea_alongi@live.it','1','4','nn','nnn','nnn','nn','ef');
INSERT INTO Cliente VALUES 
	('Enzo','Salvi','enzosalvi@hotmail.it','2','5','nn','nnn','nnn','nn','ef');
INSERT INTO Cliente VALUES 
	('Tomás','Milián','t.milian@yahoo.it','0','6','nn','nnn','nnn','nn','ef');
INSERT INTO Cliente VALUES 
	('Valeria','Marini','valeria_marini@info.it','0','7','nn','nnn','nnn','nn','ef');
INSERT INTO Cliente VALUES 
	('Gigi','D Alessio','gigid.alessio@gmail.com','0','8','nn','nnn','nnn','nn','ef');
INSERT INTO Cliente VALUES 
	('Valentina','Nappi','valentinappi@gmail.com','0','9','nn','nnn','nnn','nn','ef');
INSERT INTO Cliente VALUES 
	('Manuela','Bosi','bosimanuela1981@live.it','0','10','nn','nnn','nnn','nn','ef');
INSERT INTO Cliente VALUES 
	('Luigino','D Agostino','gigidag@email.it','0','11','nn','nnn','nnn','nn','ef');
INSERT INTO Cliente VALUES 
	('Iva','Zanicchi','ivanazanicchi@gmail.com','2','12','nn','nnn','nnn','nn','ef');

/* DATI ORDINI */
INSERT INTO Ordine VALUES ('2017/01/09', '1' , '20', 'erger' , 'ergerg','giovannistorti@libero.it');
INSERT INTO Ordine VALUES ('2017/01/11', '2' , '20', 'erger' , 'ergerg','t.milian@yahoo.it');
INSERT INTO Ordine VALUES ('2017/01/12', '3' , '20', 'erger' , 'ergerg','enzosalvi@hotmail.it');
INSERT INTO Ordine VALUES ('2017/01/15', '4' , '20', 'erger' , 'ergerg','gigidag@email.it');
INSERT INTO Ordine VALUES ('2017/01/15', '5' , '20', 'erger' , 'ergerg','valentinappi@gmail.com');
INSERT INTO Ordine VALUES ('2017/01/15', '6' , '20', 'erger' , 'ergerg','bosimanuela1981@live.it');
INSERT INTO Ordine VALUES ('2017/01/12', '7' , '20', 'erger' , 'ergerg','andrea_alongi@live.it');

/* DATI FUMETTI */
INSERT INTO Fumetto VALUES ('F174823541','Shonen','4.50','Eiichiro Oda','Eiichiro Oda','Star Comics','Manga','In un mondo quasi interamente coperto dalla acqua e con poche e piccole isole abitate si è fortemente diffusa la pirateria, pratica che riceve una ulteriore spinta il giorno in cui Gold Roger, il re dei pirati, annuncia al mondo intero che ha nascosto un incredibile tesoro, il One Piece. Tra i tanti giovani sognatori che si mettono in viaggio alla ricerca dello One Piece vi è Monkey D. Rufy, giovane allegro e spensierato in possesso di un corpo di gomma, dal momento che da piccolo mangiò uno dei frutti del diavolo, misteriosi frutti in grado di donare incredibili poteri privando tuttavia della capacità di nuotare.
La storia inizia con Rufy che, alla deriva in una botte di legno, si imbatte nella nave della terribile piratessa Alvida, e segue le avventure di Rufy, seriamente intenzione a diventare il nuovo re dei pirati.
','One PIece','1','"immagini/op1.png"',false,'50');
INSERT INTO Fumetto VALUES ('F103480638','Shonen','4.20','Masashi Kishimoto','Masashi Kishimoto','Jump Comics','Manga','Naruto affronta tanti temi: la abbandono, il tradimento, la morte, la solitudine, la inferiorità, lo amore, la amicizia, il rispetto e il lottare per i propri sogni. Tutto questo però viene trattato con situazioni al limite dello impossibile e terribilmente demenziali (Gai sensei e Rock Lee su tutti) e combattimenti fluidi ed adrenalici con "cattivoni" dieccellenza (Zabuza, Gaara e Orochimaru tanto per citarne alcuni) che faranno le loro entrate e divideranno il pubblico in due fazioni: una che li amerà per i loro atteggiamenti fighi, e la altra che li odierà per il ruolo che avranno nella storia e per ciò che faranno ai nostri eroi... ma non vi dico di più, perchè Naruto è una serie che va seguita se siete fan di serie di azione, combattimento... favolose! ','Naruto ','1', '"immagini/na1.jpg"',false,'50');
INSERT INTO Fumetto VALUES ('F103480639','Shonen','4.20','Masashi Kishimoto','Masashi Kishimoto','Jump Comics','Manga','Naruto affronta tanti temi: la abbandono, il tradimento, la morte, la solitudine, la inferiorità, lo amore, la amicizia, il rispetto e il lottare per i propri sogni. Tutto questo però viene trattato con situazioni al limite dello impossibile e terribilmente demenziali (Gai sensei e Rock Lee su tutti) e combattimenti fluidi ed adrenalici con "cattivoni" dieccellenza (Zabuza, Gaara e Orochimaru tanto per citarne alcuni) che faranno le loro entrate e divideranno il pubblico in due fazioni: una che li amerà per i loro atteggiamenti fighi, e la altra che li odierà per il ruolo che avranno nella storia e per ciò che faranno ai nostri eroi... ma non vi dico di più, perchè Naruto è una serie che va seguita se siete fan di serie di azione, combattimento... favolose! ','Naruto ','2','"immagini/na2.jpg"',false,'50');
INSERT INTO Fumetto VALUES ('F174823543','Shonen','4.50','Eiichiro Oda','Eiichiro Oda','Star Comics','Manga','In un mondo quasi interamente coperto dalla acqua e con poche e piccole isole abitate si è fortemente diffusa la pirateria, pratica che riceve una ulteriore spinta il giorno in cui Gold Roger, il re dei pirati, annuncia al mondo intero che ha nascosto un incredibile tesoro, il One Piece. Tra i tanti giovani sognatori che si mettono in viaggio alla ricerca dello One Piece vi è Monkey D. Rufy, giovane allegro e spensierato in possesso di un corpo di gomma, dal momento che da piccolo mangiò uno dei frutti del diavolo, misteriosi frutti in grado di donare incredibili poteri privando tuttavia della capacità di nuotare.
La storia inizia con Rufy che, alla deriva in una botte di legno, si imbatte nella nave della terribile piratessa Alvida, e segue le avventure di Rufy, seriamente intenzione a diventare il nuovo re dei pirati.','One Piece','2','"immagini/op2.jpg"',false,'50');
INSERT INTO Fumetto VALUES ('F174823768','Avventura','18.00','Vaughan Brian K.','Chiang Cliff','BAO Publishing','Graphic Novel','It’s the day after Halloween in 1988 and Erin sets out on her very early morning paper run in the sleepy little town of Stony Stream, Ohio. But there are a trio of shadowy figures in black robes and a sack prowling the neighbourhood - are they trick or treaters who’ve stayed out far too late or… something else?','Paper girls','1','"immagini/pap1.png"',false,'50');
INSERT INTO Fumetto VALUES ('F174827653','Shonen','4.50','Matsuena Syun','Matsuena Syun','Planet Manga','Manga','Storia di Kenichi Shirahama, di 15 anni, la cui vita viene capovolta dall arrivo nella sua scuola della semplice ma bella e forte studentessa Miu Furinji.','Kenichi','3', '"immagini/kenichi3.jpg"',false,'50');
INSERT INTO Fumetto VALUES ('F174828688','Azione','12.00','M. Fraction','D. Aja','Panini Comics','Comics','Occhio di Falco è uno dei personaggi storici della Marvel. Creato nei mitici anni sessanta da Stan Lee e Don Heck sulle pagine di Iron Man, diede subito filo da torcere a Tony Stark, benché non avesse superpoteri e fosse solo dotato di una mira infallibile che lo rendeva un perfetto arciere. In combutta con la bella spia russa Vedova Nera, gli esordi di Clint Barton furono dunque all’insegna del crimine. Era un villain a tutti gli effetti ma poi Lee decise di farlo entrare nella seconda formazione dei Vendicatori, spiegando che il suo passato criminoso era stato provocato da una serie di fraintendimenti.','Occhio di Falco','1', '"immagini/occhio1.jpg"',false,'50');
INSERT INTO Fumetto VALUES ('F174823685','Seinen','6.50','OISHI Hiroto','OKADA Shinichi','Planet Manga','Manga','...E se fosse possibile schiavizzare qualcuno che avreste sempre voluto? Bene, questo è possibile tramite la SCM che permette di ridurre in schiavitù chi indossa una SCM, ma ad un prezzo: si deve prevalere sull altro, solo così il vincitore può sottomettere il perdente.','I miei 23 schiavi','3', '"immagini/233.jpg"',false,'50');
INSERT INTO Fumetto VALUES ('F174823589','Seinen','4.50','Oku Hiroya','Oku Hiroya','Planet manga','Manga','Kei Kurono, un ragazzo egoista ed insicuro, e Masaru Kato, suo amico di infanzia sono travolti da un treno della metropolitana nel tentativo di salvare la vita di un barbone caduto sulle rotaie. Invece di morire, una copia dei loro corpi viene richiamata in un appartamento in cui sono presenti altre persone, tutte appena morte nei più svariati modi. Le porte dell appartamento sono chiuse e il gruppo non può andarsene. Poco dopo una misteriosa sfera nera nota come Gantz si attiva, rivelando al suo interno diversi equipaggiamenti: una tuta nera fatta su misura per ciascuna persona presente, che dona al portatore forza, resistenza e velocità sovrumane, un controller, che funziona da radar, e tre diversi tipi di armi. Un testo sulla superficie esterna della sfera informa i presenti che le loro vite sono finite e che essi ora appartengono a lui.','Gantz','3','"immagini/gantz3.jpg"',false,'50');
INSERT INTO Fumetto VALUES ('F174825676','Shonen/splatter','5.50','Takahiro','Tashiro Tetsuya','Planet manga','Manga','Tatsumi, un giovane paesano, viaggia per la capitale con lo scopo di guadagnare un po  di soldi per il suo villaggio. Tuttavia, dopo aver scoperto che nell area dilaga una forte corruzione, il ragazzo entra a far parte del gruppo di assassini Night Raid (lett. "Raid notturno") per aiutarli a combattere l Impero e porre fine alla sua politica corrotta.','Akama ga kill','2', '"immagini/akame2.png"',false,'50');
INSERT INTO Fumetto VALUES ('F174823635','Shonen','4.20','Yanai Takumi','Sao Satoru','Star Comics','Manga',' A Tokyo, nel quartiere di Ginza, è apparso un portale dal quale fuoriesce un agguerrito drappello di mostri e soldati armati in stile medievale. L’esercito riesce a respingerlo e a penetrare nel gate, stabilendo un avamposto nell’altro mondo, popolato da elfi, stregoni e draghi... Il posto ideale per un ufficiale otaku! Il governo giapponese, intenzionato ad avviare i negoziati di pace, decide di presentare una delegazione delle Forze di Autodifesa, con Itami in prima linea, come prova della sua potenza al cospetto dei nobili dell’Impero. Nel frattempo ad Alnus compare una misteriosa elfa oscura in cerca di soccorsi per salvare il suo villaggio in pericolo…','Gate','4','"immagini/gate4.jpg"',false,'50');
INSERT INTO Fumetto VALUES ('F174823556','Comico','3.00','Gianfranco Cordara','Silvio Camboni','Panini Comics','Fumetto','X-Mickey is a comic series that ran in Italy in 2002 for 30 issues. It focuses on the adventures of Mickey Mouse into an alternate world of the supernatural being assisted by a Goofy-like werewolf named Pipwolf and an albino mouse named Manny. ','X-Mickey','5','"immagini/xm5.jpg"',false,'50');

/* DATI GADGET */
INSERT INTO Gadget VALUES ('G147866761','Action Figure','0,312 kg','19.99','Taglia: XL','Rei Ayanami','Banpresto','Rei Ayanami di Neon Genesis Evangelion, stile falce-da-combattimento','"immagini/rei.jpg"',false,'50');
INSERT INTO Gadget VALUES ('G583056392','Action Figure','1,754 kg','27.99','Scala 1:10','Superman','DC Comics','Mitica raffigurazione di Superman della prima serie!','"immagini/sup.jpg"',false,'50');
INSERT INTO Gadget VALUES ('G583056562','Action Figure','1,00 kg','30.00','Scala 1:20','Luffy','Banpresto','Luffy arrabbiato (su asta di mantenimento)','"immagini/luffy.jpg"',false,'50');
INSERT INTO Gadget VALUES ('G583056567','Funko POP','0,800 kg','15.00','Scala 1:25','Superman','DC Comics','Funk Pop di Superman: Stile volante','"immagini/popsup.jpg"',false,'50');
INSERT INTO Gadget VALUES ('G583056345','Funko POP','0,800 kg','15.00','Scala 1:25','Batman','DC Comics','Funko Pop di Batman: Stile frontale-fermo','"immagini/popbat.jpg"',false,'50');
INSERT INTO Gadget VALUES ('G583056467','Action Figure','1,50 kg','100.00','Scala 1:30','Batmobile','DC Comics','Prima versione della Batmobile, edizione limitata','"immagini/batmobile.jpg"',false,'50');
INSERT INTO Gadget VALUES ('G147866231','Gadget','0,150 kg','5.00','2*5 cm','Bleach','Panini Comics','Maschera di Bleach in due versioni differentI: rossa e nera','"immagini/bleach.jpg"',false,'50');

/* DATI GADGET ARTICOLATO DA */
INSERT Articolato_da VALUES ('G147866761','1','1');
INSERT Articolato_da VALUES ('G583056392','1','2');
INSERT Articolato_da VALUES ('G583056567','1','5');

/* DATI FUMETTI FORMATO DA */
INSERT Formato_da VALUES ('F174823541','1','1');
INSERT Formato_da VALUES ('F103480638','1','4');
INSERT Formato_da VALUES ('F174823768','1','6');

/* DATI WISHLIST FUMETTI */
INSERT Wishlist_Fumetto VALUES ('F174823768','giovannistorti@libero.it');
INSERT Wishlist_Fumetto VALUES ('F174823589','gigid.alessio@gmail.com');
INSERT Wishlist_Fumetto VALUES ('F174823556', 't.milian@yahoo.it');

/* DATI WISHLIST GADGET */
INSERT Wishlist_Gadget VALUES ('G583056345', 'giovannistorti@libero.it');
INSERT Wishlist_Gadget VALUES ('G583056562', 'giovannistorti@libero.it');
INSERT Wishlist_Gadget VALUES ('G147866231','t.milian@yahoo.it');
