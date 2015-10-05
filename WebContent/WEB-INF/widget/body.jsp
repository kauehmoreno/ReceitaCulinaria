<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<div class="container">
		<a class="navbar-brand" href="#">Culinarias Brasileiras</a>
		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#home">Cadastro de Receita</a></li>
			<li><a data-toggle="tab" href="#menu2" >Listagem de Receita</a></li>
			<li><a data-toggle="tab" href="#menu3">Menu 3</a></li>
		</ul>
		<div class="row">

		<div class="tab-content">
			<div class="col-md-12">
				<div class="jumbotron">
					<h2>
						Armazene aqui a sua receita deliciosa!
					</h2>
					<p>
						Acreditamos que essa sua receita seja uma delicia,por favor compartilhe-a conosco! 
					</p>
					
			</div>
		</div>
			<jsp:include page="cadastroReceita.jsp" />
			

		<div id="menu2" class="tab-pane fade">
			<jsp:include page="../../listaReceita.jsp"/>
		</div>
		<div id="menu3" class="tab-pane fade">
			<h3>Menu 3</h3>
			<p>Eaque ipsa quae ab illo inventore veritatis et quasi
				architecto beatae vitae dicta sunt explicabo.</p>
		</div>
	</div>
	</div>

</body>