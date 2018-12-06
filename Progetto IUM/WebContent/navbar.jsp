<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
float pricegadget = 0;
	float price = 0;
	String strDouble2 = "";


Cart cart = (Cart) request.getAttribute("cart");

  
	List<GadgetBean> gadgetscart = cart.getgadget(); 	
	   for(GadgetBean bean2cart: gadgetscart) {
	pricegadget = pricegadget + bean2cart.getprice();}
	   
		strDouble2 = String.format("%.2f", pricegadget);

	   
%>
<%@ page contentType="text/html; charset=UTF-8"
	import="java.util.*,progetto.*"%>
<header>

		<a id="title" href="home"> <img class="titolo"
			src="immagini/logo.png" title="Clicca per tornare alla home"></a> 
		

<div id="ricerca" class="ric">
			<form action="search" method="post">
				<input name="searchbar" type="search" placeholder="Ricerca"
					required="required"> <input id="search" type="image"
					name="search" src="immagini/search.png">
			</form>
		</div>
		<div id="carrellino">
<a href="cart" title="Clicca per visualizzare il carrello"> <span id="carrello" >Carrello:</span>
			<input type="text" value="<%=strDouble2%>€" readonly >
		</a>
		</div>
	<nav class="topnav" id="myTopnav">
<a href="javascript:void(0);" class="icon" onclick="myFunction()"><span
			id="menu">MENU &#9776;</span> </a>
		<a  href="home" title="Clicca per tornare alla home">Home</a>
		<a  href="gadget?action=read&sort=Accessori Cucito" title="Clicca per visualizzare gli accessori per cucito">Accessori Cucito</a>
		<a  href="gadget?action=read&sort=Filati" title="Clicca per visualizzare i filati">Filati</a>
		<a href="gadget?action=read&sort=Tessuti" title="Clicca per visualizzare i tessuti">Tessuti</a>
		<!--
			Creo il check del cookie per gestire la connessione
			 Così da cambiare in "Il tuo profilo" al posto di "Accedi"
			 In caso possa servire, vecchio pezzo di codice:
			 <a href="login.jsp">Accedi</a>
		/****************************************************************/
		Idea del codice di controllo per la scritta "Accedi" o "Il mio account":
			PS: attaccare la </> e la %, non entrano attaccati nel commento
		-->

		<%
			Cookie[] cookies2 = request.getCookies();
			boolean booleanLogin = false;

			if (cookies2 != null) {
				for (Cookie cookie : cookies2) {
					if (((cookie.getName()).equals("attempt")) && ((cookie.getValue()).equals("true"))) {
						String email3 = "noemail";
						if (request.getCookies() != null) {     
						    for (int i = 0; i < request.getCookies().length; i++) {
						        if (request.getCookies()[i].getName().equals("email")) {	
						        	email3 =  request.getCookies()[i].getValue();	
						        	if (email3.equals("duckpro@libero.it")){
										booleanLogin = true;
										%>
		<div class="dropdown" id="mydrop">

			<a href="javascript:void(0);" class="dropbtn" onclick="myFunction2()" title="Clicca per visualizzare le opzioni">Manager
				Account <span class="caret"></span>
			</a>

			<div class="dropdown-content" id="myDropdown">
			
				<a	href="manageraccount">La mia area</a>
				<a href="aggiungiprodotto">Inserisci Prodotto</a> <a
					href="deleteproduct">Controllo Prodotti</a> 
									<a href="order">Visulizza ordini</a>
					<a
					href="banned">Elimina Utenti</a> 
					<a href="logout">Logout</a>
			</div>
		</div>
		<% 
						        	}else{
						        		%>
		<div class="dropdown" id="mydrop">
			<a href="javascript:void(0);" class="dropbtn" onclick="myFunction2()" title="Clicca per visualizzare le opzioni a tua disposizione">Il
				mio Account <span class="caret"></span>
			</a>
			<div class="dropdown-content" id="myDropdown">
						
						<a	href="myaccount" title="Clicca per visualizzare la tua area personale">La mia area</a>
				<a href="order" title="Clicca per visualizzare i tuoi acquisti">I Miei Acquisti</a> 
				<a href="wishes" title="Clicca per visualizzare la tua lista desideri">La mia lista
					desideri</a>
					<a href="review" title="Clicca per visualizzare le recensioni da te lasciate">Angolo Recensioni</a>
					<a href="client" title="Clicca per visualizzare i tuoi dati">Dati Personali</a> 
					<a href="logout" title="Clicca per eseguire il logout">Logout</a>
			</div>
		</div>
	
		<% 						        		booleanLogin = true;
}
						        }
						    }
						        } 
	
					}
				}
				if (!booleanLogin) {
					out.println("<a href=" + "\"login\"" + "> Accedi </a>");
				}
			}
		%>

 
		
		
			<div id="rice" class="ric">
		<form action="search" method="post">
				<input name="searchbar" type="search" placeholder="Ricerca"
					required="required">
			</form>
		</div>
			<a href="javascript:void(0);" class="imgsearch" onclick="searchFunction()"><img
					  id="search2" src="immagini/search.png"></a>
			
			  
	</nav>
	<div id="sopra" class="sopra">
		
		</div>
		
		<script>
		$('.dropbtn').click(function(e){
		    $('.dropbtn').css("color", "#c0c0c0");
		    $(this).css("color", "#909245");
		});
		</script>
				
	<script>
			function myFunction() {
			    var x = document.getElementById("myTopnav");
			    var y = document.getElementById("mydrop");

			    if (x.className == "topnav") {
			        x.className += " responsive";
			    } else {
			        x.className = "topnav";
			    }
			 
	 
			    if (y.className == "dropdown") {
			        y.className += " responsive";
			    } else {
			        y.className = "dropdown";
			    }
			}
			
		
				</script>

<script>
function searchFunction() {

var z = document.getElementById("rice");
var x = document.getElementById("myTopnav");

if (z.className == "ric") {
    z.className += " responsive";
} else {
    z.className = "ric";
}

if (x.className == "topnav") {
    x.className += " res";
} else {
    x.className = "topnav";
}


}
</script>

	<script>
/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
function myFunction2() {
    document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(e) {
  if (!e.target.matches('.dropbtn')) {
    var myDropdown = document.getElementById("myDropdown");
      if (myDropdown.classList.contains('show')) {
        myDropdown.classList.remove('show');
      }
  }
}
</script>

<script>
var navbar = document.getElementById("myTopnav");
var sticky = navbar.offsetTop;

function Function2() {
  if (window.pageYOffset >= sticky) {
    navbar.classList.add("sticky")
  } else {
    navbar.classList.remove("sticky");
  }
}
</script>

</header>