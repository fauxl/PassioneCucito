<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% Boolean adminRoles = (Boolean) session.getAttribute("adminRoles");
if ((adminRoles == null) || (!adminRoles.booleanValue()))
{	
    response.sendRedirect("./myaccount");
    return;
}
%>

<!DOCTYPE html>

<html lang="it-IT">
<head>
<meta charset="utf-8" />
<title>Area Gestore - PassioneCucito.com</title>
<meta name="description" content="Questa è l'area gestore.">
<meta name="robots" content="noodp" />
<%@ include file="head.jsp"%>
</head>
<body onscroll="Function2()">

	
		<%@ include file="navbar.jsp"%>
	<div class="container">

		<div id="sopra">
			
		
		</div>

		<div id="main">
		<ul class="breadcrumb">
				<li><a href="home">Home</a></li>
				<li class="active">Manager area</li>
			</ul>	
		<h1>Manager Area</h1>
		<hr>
				
			<div class="area">
				<br> <br>
				
				<a href="aggiungiprodotto"><h2>Inserisci Prodotto</h2></a>
				<hr>
				Qui puoi inserire nuovi prodotti da vendere <br> <br>
				<br>
				<a href="deleteproduct"><h2>Controllo Prodotti</h2></a>
				<hr>
				In quest'area è possibile eliminare o modificare i prodotti in vendita  <br> <br>
				<br> 
				<a href="banned"><h2>Elimina Utente</h2></a>
				<hr>
				In quest'area è possibile eliminare gli utenti<br> <br>
				<br> 
				<a href="order"><h2>Visualizza Ordini</h2></a>
				<hr>
				Qui troverai tutti gli ordini effettuati dagli utenti <br> <br> <br>
				
					<a href="logout"><h2>Logout</h2></a>
				<hr>
			Qui puoi uscire dalla tua area e abbandonare la
					sessione.
			</div>
			<br>
			<br>
		</div>
			<%@ include file="footer.jsp"%>
		
		</div>
</body>
</html>