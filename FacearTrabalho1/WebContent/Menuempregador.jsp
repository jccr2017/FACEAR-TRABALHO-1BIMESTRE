<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MenuEmpregador</title>


<style type="text/css">



#nav {
       padding:30px;
       /*float:left;*/
       width:100%;
       background-color:#363636;
}

#nav ul {
        font:16px arial,tahoma,verdana;
		list-style:none;
		margin:0;
		padding:0;
}
#nav ul li {
         float:left;
		 position:relative;
		 display:block;
}
#nav ul li a {
           color:#555;
		   background:#fff;
		   text-decoration:none;
		   margin:0 1px;
		   padding:15px 20px;
		   border-top:1px solid #555;
		   display:block;
}
#nav li ul {
          display:none;
}
#nav ul li a:hover {
                 background:#066;
				 color:#fff;
}
#nav li:hover ul {
               display:block;
			   position:relative;
}
#nav li:hover li {
              float:none;
			  font-size:12px;
}
#nav li:hover a {
              background:#333;
			  color:#fff;
}
#nav li:hover li a:hover {
                      background:#222;
}
</style>




</head>
<body>


<div id="nav">
    
    <ul>
	 <!-- <li><a href="#">Contato</a></li> -->   
	 

		<li><a href="#">Op��es</a>
		
		    <ul>
 
 
		        <li><a href="/FacearTrabalho1/ObterEmpregadorServlet?id=${empregador.id}">Alterar Conta</a></li>
			    <li><a href="/FacearTrabalho1/ObterExcluir?id=${empregador.id}">Excluir conta</a></li>
				<li><a href="/FacearTrabalho1/ObterLista" >Listar Servi�os</a></li>
			
				
				

			</ul>
		 
		</li>
		
		<!--  
				<li><a href="#">Design Web</a>
		
		    <ul>
			    <li><a href="#">Photoshop</a></li>
				<li><a href="#">Firework</a></li>
				<li><a href="#">Corel draw</a></li>
				<li><a href="#">Flash</a></li>
			</ul>
		
		</li>-->


       <!-- <li><a href="#">Contato</a></li>  -->
		<li><a href="inicial.html">Sair</a></li>
	</ul>
		   
</div>


</body>
</html>