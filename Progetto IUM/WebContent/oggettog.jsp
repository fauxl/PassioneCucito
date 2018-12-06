<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Collection<?> oggetti = (Collection<?>) request.getAttribute("oggetti");
Collection<?> reviews = (Collection<?>) request.getAttribute("reviews");

	GadgetBean oggetto = (GadgetBean) request.getAttribute("oggetto");
	
	String email = (String) request.getAttribute("email");
	String id = (String) request.getAttribute("id");
	String sort = (String) request.getAttribute("sort");
	
	boolean test = false;
	boolean prova = true;


%>


<!DOCTYPE html>

<%@ page contentType="text/html; charset=UTF-8"
	import="java.util.*,progetto.*"%>


<html lang="it-IT">
<head>
<meta charset="utf-8" />
<title><%=oggetto.getname()%> - Passione Cucito.com</title>
<meta name="description" content="Nome oggetto">
<meta name="robots" content="index,follow,noodp" />
<%@ include file="head.jsp"%>
</head>
<body onscroll="Function2()">
	<div class="container">
		<%@ include file="navbar.jsp"%>

		<div id="sopra">
	
		</div>
			<%  if (oggetto.getavailability()>0){ 
						prova = true;
			} else if (oggetto.getavailability()<=0){ 
						prova = false;
						} 		
							
			if (!(email.equals("noemail"))) { %>
		
				
				<script>
				function updatewishes()
				  {
				alert("Prodotto aggiunto alla lista dei desideri");
								  }
				
				function reviews()
				  {
				var z = document.getElementById("recensioni");
				
				if (z.className == "review") {
				    z.className += " responsive";
				} else {
				    z.className = "review";
				}
									
				}
				
				function updatecart()
				{
				alert("Prodotto aggiunto al carrello");
				}
				function updateconfront()
				{
					alert("Prodotto aggiunto al confronto");
						}
				</script>
				
					<% 	} else { %>	
				
				<script>

				function updatewishes()
									  {
				 alert("Devi essere loggato prima di aggiungere articoli alla lista dei desideri");
									  }
	
					function updatecart()
					  {
				alert("Prodotto aggiunto al carrello");
					  }
					function updateconfront()
					  {
				alert("Prodotto aggiunto al confronto");
					  }
				</script>
				
					<script>
			function reviews()
			  {
			alert("Devi essere loggato per poter aggiungere una recensione");
							  }
			</script>
				
				<% 	}  %>	
				
					<script>
				function nope()
				  {
			alert("Il prodotto non è al momento disponibile all'acquisto");
				  }
				
			</script>
				
							<script>
				function nope2()
				  {
			alert("Il gestore non può aggiungere prodotti alla lista desideri e al carrello!");
				  }
				</script>

				
				
		<div id="main">
		<ul class="breadcrumb">
				<li><a href="home">Home</a></li>
				<li><a href="gadget?action=read&sort=<%=oggetto.getcategory()%>"><%=oggetto.getcategory()%></a></li>
				<li class="active"><%=oggetto.getname()%></li>
				</ul>
			<h1><%=oggetto.getname()%></h1>
			<hr>
			<div id="table">
				<div id="row">
					<div id="oggettog">
						<p>
							<img src=<%=oggetto.getimage()%> >
					</div>

					<div id="descrizione2">
						<span>Descrizione:</span>
						<p><%=oggetto.getdescription()%></p>
						<hr>


						<div id="tabledes">
							<div id="rowdes">
								<div id="specs2">
									<span>Tipo:</span>
									<%=oggetto.gettype()%>
								<p>
										<span>Marca:</span>
										<%=oggetto.getpublisher()%>
								</p>
									<p>
										<span>Disponibilità:</span>
										<%if (prova == true){ %>
												Disponibile
										<%} else { %>
											Non Disponibile
									
									<%} %>
	
										
									</p>
							
								<p>	
										<span>Dimensioni:</span>
										<%=oggetto.getdimension()%>
									</p>
								<p>	
										<span>Prezzo:</span>
										<%=oggetto.getprice()%>
										&#8364;
									</p>
								</div>
								
							<div id="aggiungere">
								
								<div id="add">
									
							<%if (prova == true && !email.equals("duckpro@libero.it")){ %>
								<form action="carrello?action=read&id=<%=oggetto.getcode()%>" method="post">
									<input id="addcart" type="image" src="immagini/carrello2.png"
									title="Aggiungi al carrello" onclick="updatecart()">
										</form>
									<%} else if(email.equals("duckpro@libero.it")){ %>
									<input id="addcart" type="image" src="immagini/carrello2.png"
									title="Aggiungi al carrello" onclick="nope2()">

									<%} else { %>
										<input id="addcart" type="image" src="immagini/carrello2.png"
									title="Aggiungi al carrello" onclick="nope()">
	
									<%} %>
									
							<%if (!email.equals("duckpro@libero.it")){ %>
								<form action="wishlist?action=read&id=<%=oggetto.getcode()%>" method="post">
									<p>
										<input id="aggiungi" type="image" src="immagini/wishes.png"
											title="Aggiung alla lista dei desideri"  onclick="updatewishes()" title="Clicca per aggiungere il prodotto alla tua lista desideri">
									</p>
									</form>
										<%} else if(email.equals("duckpro@libero.it")){ %>
									<p>
										<input id="aggiungi" type="image" src="immagini/wishes.png"
											title="Aggiung alla lista dei desideri"	onclick="nope2()" title="Clicca per aggiungere il prodotto al carrello">
									</p>		
									<%} %>
									
						
								</div>
								<div id="add2">
									<span id="aggcar"><p>Aggiungi al carrello</p></span>
									<p>Aggiungi alla lista dei desideri</p>		
								</div>
								
							<%if (oggetto.getcategory().equals("Filati")) { %>	
								<select name="colore" required="required">
								<option>Scegli il colore desiderato</option>
								<option value="blu">Blu</option>
								<option value="rosso">Rosso</option>
								<option value="marrone">Marrone</option>
								<option value="giallo">Giallo</option>
								<option value="bianco">Bianco</option>
								<option value="viola">Viola</option>	
							</select>
								<% }%>
							</div>
							
							</div>
						</div>
					</div>
					
					</div>
				</div>
			
					
		<div id="consigliati">
						<h3>Recensioni</h3>
						<hr>
				
							<%
								if (reviews != null && reviews.size() != 0) {
									Iterator<?> it = reviews.iterator();
									while (it.hasNext()) {
										RecensioneBean bean = (RecensioneBean) it.next();
							%>
							<p >
						
								<span style="font-weight: bold;"><%=bean.getEmail()%>:</span>	<br><%=bean.getdescription()%>		
										<% if(email.equals(bean.getEmail())) 
										 test =  true;
										%>				
							</p>
							<%
								}
							
								}
							%>
							
							<% if(!test) { %>
							<span style="color: #909245;">Scrivi una recensione:</span>
							<a href="javascript:void(0);" id="reviews"  onclick=" reviews()"  title="Clicca per aggiungere una recensione"> Aggiungi una recensione</a>
						
							<form method="get" id="recensioni" class="review">
							<input type="hidden" name="action" value="insertrev">
											<input type="hidden" name="id" value=<%=id %>>
							
							
							<textarea name="description" id="insertr" maxlength="1000px" placeholder="Inserisci recensione"></textarea><br>
							<input type="submit" id="buttonr" value="Inserisci">
							
							</form>
								<%  } %>
						</div>
					<br>	<br>
			<div id="consigliati">
						<h3>Consigliati</h3>
						<hr>
							<div id="newg" class="bx-viewport" style="width: 100%; overflow: hidden; position: relative; height: 275px;">
		<div class="slider1" style="width: 155%; position: relative; z-index:0; transition-duration: 0s; transform: translate3d(-630px, 0px, 0px);">
						
							<%
								if (oggetti != null && oggetti.size() != 0) {
									Iterator<?> it = oggetti.iterator();
									while (it.hasNext()) {
										GadgetBean bean = (GadgetBean) it.next();
							%>
							<p class="slider"  style ="margin-left:25px; margin-right: 15px;">
								<a href="oggetto?action=read&id=<%=bean.getcode()%>" title="Clicca per visualizzare il prodotto"> <img
									src=<%=bean.getimage()%> width="150" height="160"> <br>
									<%=bean.gettype()%> <br> <%=bean.getname()%>
								</a>
							</p>
							<%
								}
								}
							%>
						</div>
		</div></div>

		</div>
			<%@ include file="footer.jsp"%>
		
	</div>
</body>
</html>