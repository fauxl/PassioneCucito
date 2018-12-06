<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% Collection<?> clients = (Collection<?>) request.getAttribute("clients"); 
Boolean adminRoles = (Boolean) session.getAttribute("adminRoles");
if ((adminRoles == null) || (!adminRoles.booleanValue()))
{	
    response.sendRedirect("./myaccount");
    return;
}
%>

<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"
	import="java.util.*,progetto.*"%>

<html lang="it-IT">
<head>
<meta charset="utf-8" />
<title>Elimina utenti - PassioneCucito.com</title>
<meta name="description"
	content="Elimina gli utenti">
<meta name="robots" content="noindex,noodp" />
<%@ include file="head.jsp"%>
</head>

<body>
	<div class="container">
		<%@ include file="navbar.jsp"%>
		<div id="sopra"></div>
		<div id="main">
		<ul class="breadcrumb">
				<li><a href="home">Home</a></li>
				<li><a href="manageraccount">Manager Area</a></li>
				<li class="active">Elimina utenti</li>
			</ul>
			<h1>Elimina utenti</h1>
			<hr>
			<br>
			<script>
			function remove() {
				alert("Cliente bannato");
			}
			</script>
			<%
				if (clients != null) {
			%>
				<div id="tabella" style="overflow-x:auto;">
					<table>
						<tr>
							<th>E-mail</th>
							<th>Nome</th>
							<th>Cognome</th>
							<th>Numero ordini</th>
							<th>Cellulare</th>
							<th>Cancella dal database</th>
						</tr>
						<%
							if (clients != null && clients.size() != 0) {
								Iterator<?> it = clients.iterator();
								while (it.hasNext()) {
									ClientBean bean = (ClientBean) it.next();
						%>
									<tr>
										<td><%=bean.getEmail()%></td>
										<td><%=bean.getName()%></td>
										<td><%=bean.getSurname()%></td>
										<td><%=bean.getNordini()%></td>
										<td><%=bean.getPhone()%></td>
										<td><a href="banned?action=delete&id=<%=bean.getEmail()%>" onclick="remove()" title="Clicca per eliminare questo utente">Elimina</a></td>	
									</tr>
			<%
								}
							}
				} else {
			%>
						<tr>
							<td colspan="7">Non sono presenti clienti</td>
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