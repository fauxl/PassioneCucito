<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	
	Boolean adminRoles = (Boolean) session.getAttribute("adminRoles");
	if ((adminRoles == null) || (!adminRoles.booleanValue()))
	{	
	    response.sendRedirect("./myaccount");
	    return;
	}



	String prova = (String) request.getAttribute("verifica");

%>
	
<!DOCTYPE html>

<%@ page contentType="text/html; charset=UTF-8"
	import="java.util.*,progetto.*"%>

<html lang="it-IT">
<head>
<meta charset="utf-8" />
<title>Inserisci Prodotto - PassioneCucito.com</title>
<meta name="description"
	content="Qui puoi inserire i prodotti su PassioneCucito.com">
<meta name="robots" content="index,follow,noodp" />
<%@ include file="head.jsp"%>
</head>
<body onscroll="Function2()">
	<div class="container">
			<%@ include file="navbar.jsp"%>
	
			<script>
						function registrazione(){
						alert("Inserimento prodotto riuscito");
						}
						</script>

		<div id="sopra">
			
		</div>

		<div id="main">
		<ul class="breadcrumb">
				<li><a href="home">Home</a></li>
				<li><a href="manageraccount">Manager area</a></li>
				<li class="active">Inserisci Prodotto</li>
			</ul>
					
		<h1>Inserisci Prodotto</h1>
			<hr>
						
			<form action="aggiungiprodotto" method="post" enctype="multipart/form-data">
				<input type="hidden" name="action" value="insertg">
		
	
				<div id="table">
					<div id="row">

						<div id="dati1">
						<p>Codice:</p>
						<input name="codeg" type="text" maxlength="30" >
				
				
							<p>Nome:</p>
							<input name="name" type="text" maxlength="30" required >
							
							
							<p>Tipo:</p>
							<input name="typeg" type="text" maxlength="30" required>
						
						</div>
						
					

						<div id="dati2">
							<p>Peso:</p>
							<input name="weight" type="text" maxlength="30" required >

							<p>Dimensioni:</p>
							<input name="dimension" type="text" maxlength="30" required >
							
							<p>Costo:</p>
							<input name="priceg" type="text" maxlength="30" required>

					
						</div>

						<div id="dati3">
							
							<p>Publisher:</p>
							<input name="publisherg" type="text" maxlength="30" required > <br>
							
							
								<p>Immagine:</p>
						<label class="fileContainer">
							<span id="scritta">Clicca qui per caricare l'immagine</span>
					<input type="file" name="filename" accept="image/jpeg, image/png" required>
							</label><br><br>
							
						</div>
						<div id="dati4">
						
							<p>Disponibilita:</p>
							<input name="availabilityg" type="text" maxlength="30" required>
							<p>Descrizione:</p>
						<textarea name="description" rows="6" cols="19" required></textarea>
						
						</div>
					</div>	
				</div>
								
				<div id="privacy2">
					<p id="send2">
						<input type="submit"  name="submit" value="Conferma inserimento" onclick="registrazione()">
					</p>
				</div>
			</form>
		</div>
			<%@ include file="footer.jsp"%>
		
	</div>
</body>
</html>
