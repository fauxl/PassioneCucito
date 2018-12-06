<%@ page import="sun.security.provider.VerificationProvider"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%	
	Cookie attempt = new Cookie("attempt", "");
	Cookie[] cookies = request.getCookies();
	for (Cookie cookie: cookies) {
		if ((cookie.getName()).equals("attempt")) {
			if(cookie.getValue().equals("true")) {
				attempt.setValue("true");
			}
			else if (cookie.getValue().equals("false")) {
				attempt.setValue("false");
			}
		}

			}
	String ver= (String) request.getAttribute("verifica");

	
%>

<!DOCTYPE html>

<%@ page contentType="text/html; charset=UTF-8"
	import="java.util.*,progetto.*, java.lang.*"%>

<html lang="it-IT">
<head>
<meta charset="utf-8" />
<title>Accedi/Registrati - ComicShop.it</title>
<meta name="description" content="Entra nel mondo di ComicShop!">
<meta name="robots" content="noodp" />
<%@ include file="head.jsp" %>
</head>
<body onscroll="Function2()">
	<div class="container">
		<%@ include file="navbar.jsp"%>

		<div id="sopra"></div>

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
		function ValidateEmail(email2)
		{
		var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		if(email2.value.match(mailformat))
		{
		return true;
		}
		else
		{
		alert("Hai inserito un indirizzo e-mail non valido!");
		email2.focus();
		return false;
		}
		}
		</script>

		<div id="main">
			<ul class="breadcrumb">
				<li>
					<a href="home">Home</a>
				</li>
				<li class="active">Autenticazione</li>
			</ul>
			<h1>Login/Registrazione</h1>
			
			<!--  Vedo cosa inserire dopo che l'uente ha sbagliato a fare login:
			<h4 align="right"> E-mail o Password errati, si prega di riprovare. </h4>
			out.println("<h4 align="+ "right"+ "> E-mail o password errati: si prega di riprovare. </h4>");
			-->
			<hr>
			<div id="tablelogin">
				<div id="rowlogin">
					<div id="registrazione">
						<h2>Registrazione</h2>
						<hr>
						<p>Registrati per poter effettuare acquisti e usufruire delle
							funzionalità
							 del sito!</p>

						<p>Inserisci il tuo indirizzo e-mail per iniziare la
							registrazione:</p>
							<form action="login" method="post">
								<input type="hidden" name="action" value="check">
								<input type="email" name="email2" onchange="ValidateEmail(email2)">
								<input type="submit" name="check" value="Registrati" onclick="redirect()" title="Clicca per eseguire la registrazione">
							</form>
								<% 	if (ver.equals("false")) { %>
						<h4> E-mail già presente nel database!</h4>
									<%}%>
					
							<script>
							
							function redirect(){
								alert("Controllo in corso");
							}
	
				</script>
						<%  %>
					</div>
					<div id="login">
			
						<h2>Login</h2>
						<hr>
						<form name="input" action="login" method="post">
						<input type="hidden" name="action" value="login">
						
							<p>E-mail:</p>
							<input id="username" type="email" name="email" onchange="ValidateEmail(email)" required="">
							<p>Password:</p>
							<input id="password" type="password" name="pass"> 
							<input type="submit" value="Accedi" title="Clicca per eseguire il login">
							<br>
							<% 		/* Se il login ha fallito */
							if (!(attempt.getValue()).equals("")) {
								if((attempt.getValue()).equals("false")) {
									out.println("<h4> E-mail o password errati: si prega di riprovare. </h4>");
								}
							}
							%>
							
						</form>
						
					<h4><span id="recovery"><a href="Send">Password dimenticata?</a></span></h4>
					</div>
				</div>
			</div>
		</div>	<%@ include file="footer.jsp"%>
		
	</div>
</body>
</html>