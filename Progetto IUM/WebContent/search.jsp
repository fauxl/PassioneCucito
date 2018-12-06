<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

	Collection<?> gadgets = (Collection<?>) request.getAttribute("gadgets");
	GadgetBean gadget = (GadgetBean) request.getAttribute("gadget");
%>
<!DOCTYPE html>

<%@ page contentType="text/html; charset=UTF-8"
	import="java.util.*,progetto.*"%>

<html lang="it-IT">
<head>
<meta charset="utf-8" />
<title>Ricerca - PassioneCucito.com</title>
<meta name="description"
	content="Tutti i nostri prodotti.">
<meta name="robots" content="noodp" />
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
				<li class="active">Ricerca</li>
			</ul>
			<h1>Risultati Ricerca</h1>
			<hr>
			<div id="table">
				<div id="row">

					<div id="categoria">
						<h3>Categorie</h3>
						<hr>
						<br> <br> <a href="comic"> Vai a Fumetti</a>
						<hr>
						<br> <a href="gadget"> Vai a Gadget</a>
						<hr>
					</div>

					<div id="prodotti">
						<h3>Risultati Ricerca </h3>
						<hr>
						<%
							boolean si = false;

					
				
							if (gadgets != null && gadgets.size() != 0) {
								Iterator<?> it = gadgets.iterator();
								si = true;
								while (it.hasNext()) {
									GadgetBean bean = (GadgetBean) it.next();
						%>
						<p>
							<a href="oggetto?action=read&id=<%=bean.getcode()%>"  title="Clicca per visualizzare i dettagli del prodotto"> <img
								src=<%=bean.getimage()%> width="140" height="140"> <br>
								<%=bean.gettype()%> <br> <%=bean.getname()%>
							</a>
						</p>
						<%
							}
							}
						%>
						<%
							if (si == false) {
						%>
						<p id="else">La ricerca non ha prodotto alcun risultato.</p>
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