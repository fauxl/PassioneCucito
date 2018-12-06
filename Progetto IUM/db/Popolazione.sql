/* INIZIO POPOLAZIONE DEL DATABASE*/
use merceria;

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

INSERT INTO Ordine VALUES ('2017/01/09', '1' , '20', 'erger' , 'ergerg','giovannistorti@libero.it');
INSERT INTO Ordine VALUES ('2017/01/11', '2' , '20', 'erger' , 'ergerg','t.milian@yahoo.it');
INSERT INTO Ordine VALUES ('2017/01/12', '3' , '20', 'erger' , 'ergerg','enzosalvi@hotmail.it');
INSERT INTO Ordine VALUES ('2017/01/15', '4' , '20', 'erger' , 'ergerg','gigidag@email.it');
INSERT INTO Ordine VALUES ('2017/01/15', '5' , '20', 'erger' , 'ergerg','valentinappi@gmail.com');
INSERT INTO Ordine VALUES ('2017/01/15', '6' , '20', 'erger' , 'ergerg','bosimanuela1981@live.it');
INSERT INTO Ordine VALUES ('2017/01/12', '7' , '20', 'erger' , 'ergerg','andrea_alongi@live.it');

INSERT INTO Prodotto VALUES ('G147866761','3 Scampoli di Cotone ','Tessuti','12.50','45x55 cm','Animali II','Gutermann','Il set qui in vendita è composto da tre tagli di tessuto in cotone ognuno dei quali misura 45x55 cm. Il cotone e corposo e consistente. La fantasia presenta piccoli animali: volpi, pecore e cagnolini. I colori sono tonalità di beige rosato e grigio perla.','"immagini/3scampi.jpg"','50');
INSERT INTO Prodotto VALUES  ('G583056392','Var.p62 Viola Shock','Tessuti','4.00','45x55 CM','Scampolo di Stoffa ','Tula','Taglio di tessuto in cotone al 100% da 45x55 cm circa per lavori di cucito creativo.','"immagini/stoffa1.jpg"','50');
INSERT INTO Prodotto VALUES ('G583056562','Fustella per Feltro','Accessori Cucito','30.00','30x15 CM','Magnifico Bouquet','Sizzix','Con questa fustella potrai realizzare tutte le decorazioni floreali possibili e immaginabili. Infatti taglia diversi tipi di petali da assemblare in fiori di mille forme e colori. Se cerchi una fustella per decorazioni floreali questa è quella definitiva. Un acquisto sicuro e infinite possibilità di utilizzo, non fartela mancare mai','"immagini/bouquet.png"','50');
INSERT INTO Prodotto VALUES  ('G583056567','Telaio','Accessori Cucito','7.20','22 cm','Telaio Ricamo','Prym','Classico telaio per lavori di ricamo da 25 cm di diametro. La tela si monta allentato la apposita vite, si inserisce fra i due cerchi e si stringe saldamente in modo da tenerla ben tesa. Vite di stringimento robusta.','"immagini/telaio.jpg"','50');
INSERT INTO Prodotto VALUES  ('G583056345','(Alpaca)','Filati','6.65','Per Ferri 3-4','Sierra Andina ','Adriafil','Alpaca extrafine pura e preziosa. Proviene direttamente dal Peru’ dove vengono allevate le razze piu’ pregiate di questo meraviglioso animale. Disponibile in una ampia gamma di colori classici e di moda. Con la “Sierra Andina” di Adriafil possiamo scoprire la qualità più fine, soffice e calda dell’alpaca. Ne risulta un prodotto elegante ed attuale per una maglia esclusiva. 
La alpaca è una fibra pregiata e preziosa che in passato era riservata alla famiglia imperiale degli Incas. Ancora oggi, in Perù questo animale trova le migliori condizioni ambientali, gli allevatori riservano alla fibra trattamenti speciali; è importante ricordare che la materia prima più pregiata è quella EXTRAFINE, cioè quella prodotta da animali in giovani. La morbidezza del pelo è eccezzionale. La fibra, sottile e lunga, è resistente alla usura. Durante la filatura la fibra dell Alpaca mantiene tutte queste eccezionali qualità. Sono ben 14 i colori naturali di questo filato; gradazioni che vanno dalle varie sfumature di bianco, beige, cammello, al rosso-brunastro, al marrone, al nero. Adriafil ne propone le piu belle combinazioni. Ma va oltre: ti offre anche una gamma di colori esclusiva e introvabile. Prova una delle fibre piu vicino al cielo! ','"immagini/gomitolo1.jpg"','50');
INSERT INTO Prodotto VALUES  ('G583056467','Naturale Inca','Filati','5.60','Per Ferri 4-5','Lana Alpaca e Merinos','Adriafil','Un gomitolo in Lana Alpaca e Merinos dedicato ai clienti più esigenti che vogliono indossare una maglia ai ferri soffice, calda e confortevole. Lana Naturale Inca di Adriafil è composta al 50% di Alpaca Extrafine e 50% Lana merino, 100 metri per ogni gomitolo da 50 grammi, Ferri 4 - 5','"immagini/gomitolo2.jpg"','50');
INSERT INTO Prodotto VALUES  ('G147866231','Naturale','Filati','18.00','Per Ferri 4-5','Cachemire','Adriafil','Vuoi realizzare ai ferri o al uncinetto una maglia con il cachemire? Da Adriafil una fibra di qualità eccellente ad un prezzo super vantaggioso! La tessitura del cachemire è soffice, setosa e vellutata. Conferisce alla pelle una strabiliante sensazione di caldo e morbidezza. I capi realizzati in cachemire sono di ottima vestibilità e adatti ad essere indossati in tutte le stagioni.Disponibili gomitoli di varie colorazioni da 25gr per 87 metri circa. Tessuto realizzato in 100% puro cachemire di qualità italiana.','"immagini/gomitolo3.jpg"','50');
INSERT INTO Prodotto VALUES  ('G147864567','In lana e canapa','Filati','5.85','Per Ferri 5-6','Adriafil WoCa Filato BIO','Adriafil','I filati biologici da lavorare ai ferri sono sempre più richiesti da una clientela esigente e attenta al ambiente. Adriafil raccoglie subito le nuove tendenze e lo fa proponendo due nuovissimi filati biologici. WuCa è il primo che ti proponiamo ed è realizzato in lana e canapa che conferisce un aspetto irregolare alla vista e morbido e particolare al tatto. Trovi questo filato biologico in 10 nuovissime tonalità polverose.','"immagini/gomitolo4.jpg"','50');
INSERT INTO Prodotto VALUES  ('G147834132','Cashmere','Filati','4.35','Per Ferri 7-8','Charme','Adriafil','Il fascino della morbidezza del cachemire in una serie di colori alla moda: Adriafil Charme è una nuova proposta di successo. E’ un filato in lana grosso particolarmente ritorto e reso prezioso da una esclusiva composizione di cashmere, microfibra e fine lana merino. Difficile resistere al tatto.. e alla leggerezza! è ideale per chi vuole fare la maglia ai ferri e veder subito crescere il lavoro. Dato il suo spessore infatti si lavora con ferri particolarmente grandi e il lavoro cresce in fretta.','"immagini/gomitolo5.jpg"','50');
INSERT INTO Prodotto VALUES  ('G147864897','In lana e lino','Filati','5.85','Per Ferri 4-5','Adriafil WoLi Filato BIO','Adriafil','WoLi di Adriafil è la seconda proposta della nuova collezione Adriafil per i filati BIO. Si tratta di un filato realizzato in lana e lino che alla lavorazione crea una struttura irregolare che dona un aspetto naturale e "fatto a mano" molto gradevole.','"immagini/gomitolo6.jpg"','50');
INSERT INTO Prodotto VALUES  ('G147864345','4 Gomitoli 200gr','Filati','17.08','Per Ferri 4.5','Lotto Adriafil Duo','Adriafil','Adriafil Due è un filato perfetto per le mezze stagioni perchè è in cotone e lana, precisamente 52% lana e 48% cotone. Qui è in vendita un set da quattro gomitoli nei colore rosso. Puoi lavorarlo con i ferri del 4.5 o con uncinetto 3.5. In totale sono 200 grammi di filato.','"immagini/gomitolo7.jpg"','50');
INSERT INTO Prodotto VALUES  ('G142344345','3 Scampoli di Cotone','Tessuti','12.50','45x55 cm','Animali','Dailylike','Il set qui in vendita è composto da tre tagli di tessuto in cotone ognuno dei quali misura 45x55 cm. Il cotone e corposo e consistente. La fantasia presenta piccoli animali: fenicotteri, coccodrilli e procioni. I colori sono verde bosco, blu, grigio/avion.','"immagini/tessuti2.jpg"','50');

INSERT Articolato_da VALUES ('G147866761','1','1');
INSERT Articolato_da VALUES ('G583056392','1','2');
INSERT Articolato_da VALUES ('G583056567','1','5');

INSERT Wishlist_Prodotto VALUES ('G583056345', 'giovannistorti@libero.it');
INSERT Wishlist_Prodotto VALUES ('G583056562', 'giovannistorti@libero.it');
INSERT Wishlist_Prodotto VALUES ('G147866231','t.milian@yahoo.it');

INSERT  Recensione	VALUES ('1','Ottima lana','G583056345', 'giovannistorti@libero.it');
INSERT	Recensione	VALUES ('2','Nuovo? no lavato con perlana','G583056562', 'giovannistorti@libero.it');
INSERT  Recensione VALUES ('1','Bello','G147866231','t.milian@yahoo.it');