<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	ClientBean client = (ClientBean) request.getAttribute("client");
	String email = (String) request.getAttribute("email");
	
	String	registra = (String) session.getAttribute("NewUser");
	
%>
	
<!DOCTYPE html>

<%@ page contentType="text/html; charset=UTF-8"
	import="java.util.*,progetto.*"%>

<html lang="it-IT">
<head>
<meta charset="utf-8" />
<title>Profilo Utente - PassioneCucito.com</title>
<meta name="description"
	content="Questo è il tuo profilo utente su ComicShop.it">
<meta name="robots" content="index,follow,noodp" />
<%@ include file="head.jsp"%>
</head>
<body onscroll="Function2()">
	<div class="container">
		<%@ include file="navbar.jsp"%>

		<div id="sopra">
			
		</div>

		<script>
		function ValidateEmail(email)
		{
		var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		if(email.value.match(mailformat))
		{
		return true;
		}
		else
		{
		alert("Hai inserito un indirizzo e-mail non valido!");
		email.focus();
		return false;
		}
		}
		</script>
		<script>
		function allLetter(name)
		{
		var letters = /^[A-Za-z]+$/;
		if(name.value.match(letters))
		{
		return true;
		}
		else
		{
		alert('Il nome deve contenere soltanto lettere');
		name.focus();
		return false;
		}
		}
		</script>
		<script>
		function allLetters(surname)
		{
		var letters = /^[A-Za-z]+$/;
		if(surname.value.match(letters))
		{
		return true;
		}
		else
		{
		alert('Il cognome deve contenere soltanto lettere');
		surname.focus();
		return false;
		}
		}
		</script>


		<div id="main">
		<ul class="breadcrumb">
				<li><a href="home.jsp">Home</a></li>
				<%if (email.equals("noemail")) {%>
				
				<% } else{%>
				<li><a href="myaccount">Il mio account</a></li>
				<%} %>
				<li class="active">I miei Dati</li>
			</ul>
			<h1>I miei Dati</h1>
			<hr>

			<form action="client" method="post">
				<input type="hidden" name="action" value="insert">

				<div id="table">
					<div id="row">

						<div id="dati1">
						<p>Nome:</p>
						<input name="name" type="text" maxlength="30" required onchange="allLetter(name)" value="<%=client.getName()%>">
				
				
							<p>Cellulare:</p>
							<input name="phone" type="text" maxlength="30" required onchange="phonenumber(phone)" value="<%=client.getPhone()%>">
							
							
							<p>Indirizzo:</p>
							<input name="address" type="text" maxlength="30" required value="<%=client.getAddress()%>">
							
						</div>
						
					

						<div id="dati2">
							<p>Cognome:</p>
							<input name="surname" type="text" maxlength="30" required onchange="allLetters(surname)" value="<%=client.getSurname()%>">

						
						<%if (email.equals("noemail")) {%>
							<p>E-mail:</p>
							<input name="email" type="email" maxlength="30" required value="<%=registra%>"  readonly="">
						<% } else{%>
							<p>E-mail:</p>
							<input name="email" type="text" maxlength="30" required value="<%=client.getEmail()%>" readonly="">
								<%} %>
		
							<p>Città:</p>
							<input name="city" type="text" maxlength="30" required value="<%=client.getCity()%>">
							
						</div>

						<div id="dati3">
							
							<p>CAP:</p>
							<input name="cap" type="text" maxlength="30" required value="<%=client.getCap()%>"> <br>
							
							<p>Password:</p>
							<input name="password" type="password" maxlength="30" required>

							
						</div>

						<div id="dati4">
							

							<p>Provincia:</p>
							<input name="region" type="text" maxlength="30" required value="<%=client.getRegion()%>">
							
							<p>Verifica password:</p>
							<input name="password2" type="password" maxlength="30" required>

							
						</div>
					</div>	
				</div>
				
					
						
						
						<div id="privacy2">
					<input type="checkbox" id="terms" required> Dichiaro di
					aver letto  i <a href="condizioni">Termini
						e le condizioni del servizio</a> e l'<a href="privacy">
						Informativa sulla privacy</a>.
					<p id="send2">
						<input type="submit" value="Conferma" title="Clicca per confermare">
					</p>
				</div>

			</form>
		</div>
			<%@ include file="footer.jsp"%>
		
	</div>
</body>
</html>