<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  
	session="true"
	%>
	
<% 
	 Boolean RegisteredUserRoles = (Boolean) session.getAttribute("RegisteredUserRoles");
	if ((RegisteredUserRoles == null) || (!RegisteredUserRoles.booleanValue()))
	{	
	    response.sendRedirect("./login");
	    return;
	}
	
%>
	
<!DOCTYPE html>

<html lang="it-IT">
<head>
<meta charset="utf-8" />
<title>Il mio account - PassioneCucito.com</title>
<meta name="description" content="Entra nel mondo di PassioneCucito.com">
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
				<li class="active">Il mio account</li>
			</ul>	
		<h1>Il mio Account</h1>
		<hr>
				
			<div class="area">
				<br> <br>
				
				<h2><a href="order">I Miei Acquisti</a></h2>
				<hr>

				Qui troverai tutti gli ordini da te effettuati
					nei dettagli.<br> <br> <br> <br>
		<h2>	<a href="wishes">La mia lista desideri</a></h2>
				<hr>
				Qui vi sono tutti i prodotti da te
					desiderati. <br> <br> <br> <br>
					
					
					<h2><a href="review">Angolo Recensioni</a></h2>
				<hr>
				Qui vi sono tutte le recensioni da te lasciate <br> <br> <br> <br>
					
				
		<h2><a href="client">I miei dati</a></h2> 
				<hr>
			In quest'area vi è la possibiità di
					consultare e modificare i dati da te inseriti.<br> <br>
				<br> <br>
				<h2><a href="logout">Logout</a></h2>
				<hr>
				
				Qui puoi uscire dalla tua area e abbandonare la
					sessione.
			</div>
		</div>
			<%@ include file="footer.jsp"%>
		
		</div>
</body>
</html>