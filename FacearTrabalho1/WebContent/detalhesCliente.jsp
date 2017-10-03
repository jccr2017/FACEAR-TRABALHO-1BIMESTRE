<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalhes</title>

</head>
<body>


<%@ include file="Menuempregador.jsp" %>


<body bgcolor="#E8E8E8">  



</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>



	<form action="/FacearTrabalho1/AlterarClienteServlet" method="post">
	<center>
	
	
	
		ID:<input type="text" id="id" name="id" value="${cliente.id}" readonly="readonly"/>
		</br>
		</br>
		NOME:<input type="text" id="nome" name="nome" value="${cliente.nome}" readonly="readonly"/>

		EMAIL:<input type="text" id="email" name="email" value="${cliente.email}" readonly="readonly"/>
		</br>
		</br>
		CPF:<input type="text" id="cpf" name="cpf" value="${cliente.cpf}" readonly="readonly"/>

		CELULAR:<input type="text" id="celular" name="celular" value="${cliente.celular}" readonly="readonly"/>
		</br>

		SEXO:<input type="text" id="sexo" name="sexo" value="${cliente.sexo}" readonly="readonly"/>
		</br>
		</br>
		CIDADE:<input type="text" id="cidade" name="cidade" value="${cliente.cidade}" readonly="readonly"/>

		SERIAL:<input type="text" id="serial" name="serial" value="${cliente.serial}" readonly="readonly"/>
		</br>
		</br>
		


DATA:<input  style="height: 30px" size="50" type="text" id="data" name="data" value="${cliente.data}" readonly="readonly"/>
</br>
</br>


		HORA:<input type="text" id="hora" name="hora" value="${cliente.hora}" readonly="readonly"/>
		
		</br>
		</br>
		
		
		VALOR CONSERTO:<input  style="height: 30px" size="50" type="text" id="valorconserto" name="valorconserto" value="${cliente.valorconserto}"/>
</br>
</br>
		
		
			DEFEITO:<input  style="height: 30px" size="50" type="text" id="defeito" name="defeito" value="${cliente.defeito}"/>
</br>
</br>	

			STATUS:<input  style="height: 30px" size="50" type="text" id="status" name="status" value="${cliente.status}"/>
</br>
</br>	
		
		<input type="submit" value="Alterar"/>
		
		</center>
	</form>


</body>
</html>