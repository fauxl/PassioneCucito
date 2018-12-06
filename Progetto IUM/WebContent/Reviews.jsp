<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Collection<?> reviews = (Collection<?>) request.getAttribute("reviews");
	String email = (String) request.getAttribute("email");
	Boolean RegisteredUserRoles = (Boolean) session.getAttribute("RegisteredUserRoles");
	 Boolean adminRoles = (Boolean) session.getAttribute("adminRoles");

	 if ((RegisteredUserRoles == null) || (!RegisteredUserRoles.booleanValue()))
	{
		 if ((adminRoles == null) || (!adminRoles.booleanValue()))
	{	
	    response.sendRedirect("./myaccount");
	    return;
	} 
	   
	}
	

%>

<!DOCTYPE html>

<%@ page contentType="text/html; charset=UTF-8"
	import="java.util.*,progetto.*"%>

<html lang="it-IT">
<head>
<meta charset="utf-8" />
<title>Recensioni Effettuate - PassioneCucito.com</title>
<meta name="description"
	content="Questa è la lista di tutti i tuoi desideri su PassioneCucito.com">
<meta name="robots" content="index,follow,noodp" />
<%@ include file="head.jsp"%>
</head>
<body onscroll="Function2()">
	<div class="container">
		<%@ include file="navbar.jsp"%>
		<div id="sopra">
		</div>
		
		
				<script>
					function updatereviews()
									  {
				 alert("Recensione rimossa");
									  }
		
				</script>
				
		<div id="main">
		<ul class="breadcrumb">
				<li><a href="home">Home</a></li>
				<%if (email.equals("duckpro@libero.it")) {%>
				
				<% } else{%>
				<li><a href="myaccount">Il mio account</a></li>
				<%} %>
				
				<li class="active">Angolo Recensioni</li>
			</ul>
			<h1>Recensioni Effettuate</h1>
			<hr>
					<div id="tabella" style="overflow-x:auto;">
				<table>
			
					<tr>
						<th>Immagine Articolo</th>
						<th>Nome</th>
						<th>Recensione</th>
							<th>Dettagli Prodotto</th>
						<th>Cancella Recensione</th>
						
					</tr>
			
					<%
						if (reviews != null && reviews.size() != 0) {
							Iterator<?> it = reviews.iterator();
							while (it.hasNext()) {
								RecensioneBean bean = (RecensioneBean) it.next();
					%>
						<tr>
						<td><img src=<%=bean.getimage()%> width="150" height="160"></td>
						<td><%=bean.getname()%></td>
						<td> <%=bean.getdescription2()%></td>
					<td><a href="oggetto?action=read&id=<%=bean.getcode()%>" title="Clicca per visualizzare i dettagli del prodotto">Dettagli</a></td>
				<td><a href="review?action=delete&id=<%=bean.getcode()%>" onclick="updatereviews()" title="Clicca per eliminare questa recensione">Elimina</a></td>
					
		
					</tr>
					
				
					<%
						}
						}
			
						 else {
					%>
					<tr>
						<td colspan="7">Non sono presenti articoli nella lista dei desideri</td>
					</tr>
					<%
						}
					%>
			</table>
			</div>
	</div>
		

		<%@ include file="footer.jsp"%>
			</div>
</body>
</html>