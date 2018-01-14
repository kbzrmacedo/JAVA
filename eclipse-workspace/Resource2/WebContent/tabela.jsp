<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,
                  br.com.resourceit.dao.*,
                  br.com.resourceit.model.*,
                  javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

				 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    		<meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta http-equiv="X-UA-Compatible" content="ie=edge">
            <title>Produtos Resource</title>
    </head>	
	<body>  
    	<section id="bot" class="bg-color" style="padding:0px;">
    		<div class="container" style="margin-bottom: 20px;">
    				<div class="table-responsive"  style="overflow: auto; height: 400px;">
    					<form method="post" action="Remover">
    					<table class="table table-dark table-bordered table-hover">
    				    	<thead>
    				        	<tr class="warning" >
    				        		<th> ID </th>
    				          		<th>Nome do Produto</th>
    				         		<th>Valor</th>
    				          		<th>Taxa</th>
    				          		<th>Tipo</th>
    				          		<th>Remover</th>
    				        	</tr>
		    				       </thead>
							<%
					          DadoDao dao = new DadoDao();
					          List<Dado> dados = dao.getLista();
					             
					          for (Dado dado : dados) {
					        %>
				     	 	<tbody>
			         			<tr class="info">
			         				<td id="cod_prod">   <%=	dado.getCod_prod()  %>	</td>
				       				<td>   <%= 	dado.getProduto()   %>	</td>
				        			<td>R$ <%=  dado.getValor() 	%>	</td>
				        			<td>   <%= 	dado.getTaxa()      %>%	</td>
				        			<td>   <%= 	dado.getTipo()      %>	</td>	
				       			 	<td><button value="<%=dado.getCod_prod()%>" name="Delete" class="btn btn-danger" onclick="confirmarRemover()">Remover</button></td>
				       			 </tr>
		        	  		</tbody>
	          				<%
	           				  }
	          				 %> 
				    	</table>
				    	</form>
					</div>
			</div>	    
			<form action="RemoverTodos">
			<input type="submit" name="DeleteAll" class="btn btn-primary btn-sm" value="Remover Todos" onclick="confirmarRemoverAll()" style="padding: 10px;">
			</form>
		</section>
		<script>
			 function confirmarRemover(){
                       alert("Removido com sucesso!");
			 }
		</script>
		<script>
			 function confirmarRemoverAll(){
                       alert("TODOS os itens removido com Sucesso!");
                 
			 }
		</script>
   	</body>
</html>