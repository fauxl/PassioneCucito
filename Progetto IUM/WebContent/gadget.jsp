<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 	
	Collection<?> gadgets = (Collection<?>) request.getAttribute("gadgets");
	GadgetBean gadget = (GadgetBean) request.getAttribute("gadget");
	
	String sort = (String) request.getAttribute("sort");

%>

<!DOCTYPE html>

<%@ page contentType="text/html; charset=UTF-8"
	import="java.util.*,progetto.GadgetBean"%>


<html lang="it-IT">
<head>
<meta charset="utf-8" />
<title><%=sort %> - PassioneCucito.com</title>
<meta name="description"
	content="Tutti le novità in tema di gadget ed oggettistica">
<meta name="robots" content="noodp" />
<%@ include file="head.jsp"%>
</head>
<body onscroll="Function2()">

	<div class="container">

		<%@ include file="navbar.jsp"%>
		
		<div id="main">
		
		<ul class="breadcrumb">
				<li><a href="home">Home</a></li>
				<li class="active"><%=sort %></li>
			</ul>
			<h1><%=sort %></h1>
			<hr>

			<div id="table">
				<div id="row">
					<div id="parametri">
						<h3>Publisher:</h3>
						
						<form action="gadget" method="post">
							<select name="publisher">
								<option>Filtra per publisher</option>
								<option value="panini comics">Panini</option>
								<option value="dc comics">Dc comics</option>
								<option value="banpresto">Banpresto</option>
							</select> <br> 
							<h3>Categoria:</h3>
						

							<select name="tipo">
								<option>Filtra per tipo</option>
								<option value="Gadget">Gadget</option>
								<option value="Funko POP">Funko POP</option>
								<option value="Action Figure">Action Figures</option>
							</select> <input type="reset" onclick="window.location.href='http://localhost:8080/ProgettoWeb/gadget';" name="comic" value="Reset"> 
							<input type="submit" name="gadget" value="Aggiorna">
						</form>
						<br>
					</div>
					<div id="prodotti">
						<h3>Risultati</h3>
						<hr>
								<div id="prodotti" class="bx-viewport" style="width:100%; overflow: hidden; position: relative; height: 350px;">
		<div class="slider1" style="width: 155%; position: relative; z-index:0; transition-duration: 0s; transform: translate3d(-630px, 0px, 0px);">
						
						<%
							int i = 0;
							if (gadgets != null && gadgets.size() != 0) {
								Iterator<?> it = gadgets.iterator();
								while (it.hasNext() && i<10) {
									i++;
									GadgetBean bean = (GadgetBean) it.next();	
						%>
						<p class="slide" style ="margin-left:5px; margin-right: 5px;">
							<a href="oggetto?action=read&id=<%=bean.getcode()%>" title="Clicca per visualizzare il prodotto">  <img
								src=<%=bean.getimage()%> width="140" height="140"> <br>
								<%=bean.gettype()%> <br> <%=bean.getname()%>
							</a>
						</p>
						<%
						}
					 	%>
					</div>
					</div>
					<%} else { 
						%>
						<p id="else">Seleziona almeno un filtro prima di aggiornare la
							pagina.</p>
						<%
							}
						%>
						
					</div>
				
				</div>
			</div>
		</div>
			<%@ include file="footer.jsp"%>
		
	</div>
</body>
</html>