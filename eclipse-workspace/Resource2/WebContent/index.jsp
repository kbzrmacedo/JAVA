<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,
                  br.com.resourceit.dao.*,
                  br.com.resourceit.model.*,
                  javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
				 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
	<head>
	  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	  <meta http-equiv="X-UA-Compatible" content="ie=edge">
	  <title>Produtos Resource</title>
	  <!--================================= Links==================================-->
	  <link href="bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" media="screen">
	  <link href="bootstrap/dist/css/bootstrap.css" rel="stylesheet" media="screen">
	  <link rel="stylesheet" href="bootstrap/dist/css/footer-basic-centered.css">
	  <!--  IMPORTS -->
	  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" 	 integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>

	  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>

	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
	  <script src=bootstrap/dist/js/bootstrap.bundle.js></script>
	  <script src="bootstrap/dist/jquery/jquery.min.js" type="text/javascript"></script>
	  <!--==========================Script de rolagem============================== -->  
	  <script>
		  $(document).ready(function(){
			  $(".navbar a, footer a[href='#mid']").on('click', function(event) {
			    if (this.hash !== "") {
			      event.preventDefault();
			      var hash = this.hash;
			      $('html, body').animate({
			        scrollTop: $(hash).offset().top
			      }, 900, function(){
			        window.location.hash = hash;
			      });
			    } 
			  });
			})
	  </script>	
	</head>   
	<body> 
		<script type="text/javascript" src="bootstrap/dist/js/bootstrap.js"></script>    
	    <script src="bootstrap/dist/jquery/jquery.maskMoney.js" type="text/javascript"></script>    
    	<nav class="navbar fixed-top navbar-expand-sm navbar-dark bg-dark">
       		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#nav-content" aria-controls="nav-content" aria-expanded="false" aria-label="Toggle navigation">
        		<span class="navbar-toggler-icon"></span>
    		</button>
    		<a class="navbar-brand" href="#top">Home</a>
    	<div class="collapse navbar-collapse" id="nav-content">   
        	<ul class="navbar-nav">
         		<li class="nav-item">
          			<a class="nav-link" href="#mid">Cadastro</a>
      			</li>
      			<li class="nav-item">
          			<a class="nav-link" href="#bot">Tabela</a>
      			</li>
      			<li class="nav-item">
          			<a class="nav-link" href="#footer">Extras</a>
      			</li>
  			</ul>
		</div>
</nav>
		<section class="bg-color" id="top">
    		<div id="cover-caption">
        		<div class="container">
		            <div class="col-sm-10 col-sm-offset-1" id="margem">
		            <img src="img/Logo.png"/>
		            	<h1>Bem vindo, Equipe Resource!</h1>
		            	<p>Fique a vontade em nosso site de cadastro de produtos. Qualquer problema pode contatar a equipe JAVALISTAS!<p>
		             	
                	</div>           
            	</div>
        	</div>
   		</section>     
    	<section class="bg-colorr" id="mid">
	        <center>
	        <br>
	        <h2 class="page-header">Cadastro de Produtos</h2>
	        <form name="form" action="add" method="get" id="form">
	        	<div class="input-group" style="width:20%;">
	            	<input class="form-control" type="text" name="produto" id="produto" placeholder="Nome do Produto..." required>
	            </div>              
	            <div class="input-group" style="width:20%;">
	            	<span class="input-group-addon" id="btnGroupAddon">R$</span> 
	                    <input class="form-control" type="text" name="valor" maxlength="9"  id="valor" placeholder="Valor em reais..." required>   
	                </div>               
	            <div class="input-group" style="width:20%;">
	            	<input class="form-control" type="text" name="taxa" id="taxa" maxlength="6" placeholder="Taxa em %..." required> 
	                <span class="input-group-addon" id="btnGroupAddon">%</span> 
	            </div>               
	            <div class="input-group" style="width:20%;">
	            	<input class="form-control" type="text" name="tipo" id="tipo" placeholder="Tipo de produto..." required>
	            </div>
	            <br> 
	            <input type="submit" name="enviar" class="btn btn-primary" value="Cadastrar" onclick="confirmar()"  >
	            <input type="reset" name="limpar" class="btn btn-danger" value="Limpar"> 
	            <br><br>     
	        </form>
	        <form enctype="multipart/form-data" method ="post" action="upload">
		        <div align="center">
		        	<input type="file" name="Importar" id="Importar" accept=".csv" required>
		            <input type="submit" name="submit" class="btn btn-primary" value="Importar" onclick="validar()"  >  
		        </div>
	        </form>
			<br><br><br>
	        </center>
   		</section>
    	<section class="bg-color" id="bot">
    		<h2 class="page-header">Todos os Produtos</h2>
      		<c:import url="tabela.jsp"></c:import>
        </section>
        <footer class="footer-basic-centered" id="footer">
			<p class="footer-company-motto">Extras</p>
			<p class="footer-links">
				<a href="https://facebook.com/resourceitsolutions/" target=“_blank” >Facebook</a>
				·
				<a href="https://www.instagram.com/resourceoficial/" target=“_blank” >Instagram</a>
				·
				<a href="http://www.resourceit.com/pt/" target=“_blank” >Site</a>
			</p>
			<p class="footer-company-name">Company ResourceIT &copy; 2017</p>
		</footer> 
		<!--=========================== Scripts========================================== -->	   
	    <script>
	     	jQuery("limpar[id=form]").val( '' );
		</script> 
		<script>
			function confirmar() {
				var produto = document.getElementById("produto").value;
				var valor = document.getElementById("valor").value;
				var taxa = document.getElementById("taxa").value;
				var tipo = document.getElementById("tipo").value;
				if(produto != "" && valor != "" && taxa != "" && tipo != ""){
			    	alert("Cadastrado com sucesso!");
				}
			}
		</script>
		<script>
		    $(function(){
		        $("#valor").maskMoney({thousands:'.'});
		        $("#taxa").maskMoney({decimal:'.'});
		    });	
		</script>   	   
		<script>
			function validar() {
				var importar = document.getElementById("Importar").value;
				if(importar != ""){
			    	alert("Importado com sucesso!");
			    	
				}
			}
		</script>
		
		<!--=============================================================================== -->	   
	</body>
</html>
