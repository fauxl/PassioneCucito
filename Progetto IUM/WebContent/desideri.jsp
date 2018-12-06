<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Collection<?> orders = (Collection<?>) request.getAttribute("orders");
	Collection<?> gadgets = (Collection<?>) request.getAttribute("gadgets");
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
<title>La tua lista dei desideri - PassioneCucito.com</title>
<meta name="description"
	content="Questa è la lista di tutti i tuoi desideri su ComicShop.it">
<meta name="robots" content="index,follow,noodp" />
<%@ include file="head.jsp"%>
</head>
<body onscroll="Function2()">
	<div class="container">
		<%@ include file="navbar.jsp"%>
		<div id="sopra">
		</div>
		
		<div id="main">
		<ul class="breadcrumb">
				<li><a href="home">Home</a></li>
				<%if (email.equals("duckpro@libero.it")) {%>
				
				<% } else{%>
				<li><a href="myaccount">Il mio account</a></li>
				<%} %>
				
				<li class="active">La mia lista desideri</li>
			</ul>
			<h1>La mia lista dei desideri</h1>
			<hr>
		
			<script>
					function updatewishes()
									  {
				 alert("Prodotto rimosso dalla lista dei desideri");
									  }
					
					function updatecart()
					  {
				alert("Prodotto aggiunto al carrello");
					  }
				
				</script>
				
			
			
			
			<div id="tabella" style="overflow-x:auto;">
				<table>
			
					<tr>
						<th>Immagine Articolo</th>
						<th>Riferimento</th>
						<th>Prezzo</th>
						<th>Categoria</th>
						<th>Dettagli</th>
						<th>Cancella</th>
					</tr>
			
						<%
						if (gadgets != null && gadgets.size() != 0) {
							Iterator<?> it = gadgets.iterator();
							while (it.hasNext()) {
								GadgetBean bean = (GadgetBean) it.next();
					%>
						<tr>
						<td><img src=<%=bean.getimage()%> width="150" height="160"></td>
						<td><%=bean.getname()%> <%=bean.gettype()%> </td>
						<td><%=bean.getprice()%> €</td>
						<td><%=bean.getcategory()%></td>
						<td><a href="oggetto?action=read&id=<%=bean.getcode()%>"  title="Clicca per aggiungere il prodotto al carrello">Dettagli</a></td>
						<td><a href="wishes?action=delete&id=<%=bean.getcode()%>" onclick="updatewishes()"  title="Clicca per eliminare il prodotto dalla lista desideri">Elimina</a></td>
					

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