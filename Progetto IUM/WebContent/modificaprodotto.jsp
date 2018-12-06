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
	GadgetBean oggetto = (GadgetBean) request.getAttribute("oggetto");
	
%>
	
	

<!DOCTYPE html>

<%@ page contentType="text/html; charset=UTF-8"
	import="java.util.*,progetto.*"%>

<html lang="it-IT">
<head>
<meta charset="utf-8" />
<title>Modifica prodotto - PassioneCucito.com</title>
<meta name="description"
	content="Questo è il tuo profilo utente su ComicShop.it">
<meta name="robots" content="index,follow,noodp" />
<%@ include file="head.jsp"%>
</head>
<body onscroll="Function2()">
	<div class="container">
			<%@ include file="navbar.jsp"%>
	
			<script>
						function registrazione(){
						alert("Modifca prodotto riuscita");
						}
						</script>

		<div id="sopra">
			
		</div>

		<div id="main">
		<ul class="breadcrumb">
				<li><a href="home">Home</a></li>
				<li><a href="managerccount">Manager area</a></li>
				<li class="active">Inserimento Prodotto</li>
			</ul>
			<h1>Modifica Prodotto</h1>
			<hr>
			<br><br>

	<% if (oggetto.getname().equals("")) {	
	
	%>
	
		<h2>Inserimento Gadget</h2>
			<hr>
			<form action="modify" method="post" enctype="multipart/form-data">
				<input type="hidden" name="action" value="modifyg">
		
	
				<div id="table">
					<div id="row">

						<div id="dati1">
						<p>Codice:</p>
						<input name="codeg" type="text" maxlength="30" value="<%=oggetto.getcode()%>"  readonly="">
				
				
							<p>Nome:</p>
							<input name="name" type="text" maxlength="30" required value="<%=oggetto.getname()%>">
							
							
							<p>Tipo:</p>
							<input name="typeg" type="text" maxlength="30" required value="<%=oggetto.gettype()%>">
							
						</div>
						
					

						<div id="dati2">
							<p>Peso:</p>
							<input name="weight" type="text" maxlength="30" required value="<%=oggetto.getcategory()%>">

							<p>Dimensioni:</p>
							<input name="dimension" type="text" maxlength="30" required value="<%=oggetto.getdimension()%>">
							
							<p>Costo:</p>
							<input name="priceg" type="text" maxlength="30" required value="<%=oggetto.getprice()%>">

					
						</div>

						<div id="dati3">
							
							<p>Publisher:</p>
							<input name="publisherg" type="text" maxlength="30" required value="<%=oggetto.getpublisher()%>"> <br>
							
							
								<p>Immagine:</p>
						<label class="fileContainer">
							<span id="scritta">Clicca qui per caricare l'immagine</span>
					<input type="file" name="filename" accept="image/jpeg, image/png" >
							</label><br><br>
							
						</div>
						<div id="dati4">
							<p>Disponibilita:</p>
							<input name="availabilityg" type="text" maxlength="30" required value="<%=oggetto.getavailability()%>">
							
						<p>Descrizione:</p>
							<textarea name="description" rows="10" cols="18" required><%=oggetto.getdescription()%></textarea>
						</div>
					</div>	
				</div>
								
				<div id="privacy2">
					<p id="send2">
						<input type="submit"  name="submit" value="Conferma modifica" onclick="registrazione()">
					</p>
				</div>
			</form>
			<%
			}		
	
	%>
		</div>
			<%@ include file="footer.jsp"%>
		
	</div>


</body>
</html>