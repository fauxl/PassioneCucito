


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
<title>PassioneCucito.com - Il cucito a casa tua!</title>
<meta name="description"
	content="PassioneCucito è il posto giusto dove comprare matasse e filati comodamente da casa">
<meta name="robots" content="index,follow,noodp" />
<%@ include file="head.jsp"%>

</head>

<body onscroll="Function2()">
	<%@ include file="navbar.jsp"%>
	<div id="centro">
	<img class="mySlides" src="immagini/sfondo.jpg" width=100%> 
	</div>

	<script>
var myIndex = 0;
carousel();

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 10000); // Change image every 5 seconds
}
</script>


	<div id="goods" class="bx-wrapper">

		<h2>Novità Prodotti</h2>
		<hr>
		<div id="newg" class="bx-viewport" style="width: 102%; overflow: hidden; position: relative; height: 275px;">
		<div class="slider1" style="width: 155%; position: relative; z-index:0; transition-duration: 0s; transform: translate3d(-630px, 0px, 0px);">

			<%
					if (gadgets != null && gadgets.size() != 0) {
						Iterator<?> it = gadgets.iterator();
						while (it.hasNext() ) {
							GadgetBean bean = (GadgetBean) it.next();
				%>
			<p class="slide"  style ="margin-left:25px; margin-right: 15px;">
				<a href="oggetto?action=read&id=<%=bean.getcode()%>" title="Clicca per visualizzare il prodotto"> <img
					src=<%=bean.getimage()%> width="150" height="160"> <br><%=bean.getname()%>
					 <br><%=bean.gettype()%> 
				</a>
			</p>
			<%
					}
					}
					
				%>
		</div>
		</div>
	
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>