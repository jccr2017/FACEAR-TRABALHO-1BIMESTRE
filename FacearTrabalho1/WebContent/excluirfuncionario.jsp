<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Excluir funcionario</title>
</head>
<body>

<%@ include file="Menufuncionario.jsp" %>

<body bgcolor="#E8E8E8">  


</br>
</br>
</br>
</br>
</br>
</br>



	<form action="/FacearTrabalho1/Excluirclientesemlista" method="post">
	
	<center> 
		ID:<input type="text" id="id" name="id" value="${cliente.id}" readonly="readonly"/>
		<br>
		<br>
		NOME:<input type="text" id="nome" name="nome" value="${cliente.nome}"/>
		
		EMAIL:<input type="text" id="email" name="email" value="${cliente.email}"/>
			<br>
			
			<p>Se tem certeza que deseja deletar a conta,clique no bot�o excluir </p>

		<input type="submit" value="Excluir"/>
		
		</center>
		
	</form>


</body>
</html>