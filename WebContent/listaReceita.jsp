<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="WEB-INF/widget/headers/headers.jsp" />
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<nav class="navbar navbar-default" role="navigation">
			<div class="navbar-header">

				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span><span
						class="icon-bar"></span><span class="icon-bar"></span><span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp">Cadastrar</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">

				<form class="navbar-form navbar-left" role="search" action="search">
					<div class="form-group">
						<input class="form-control" type="text" name="q" />
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
			</nav>
			<%-- logica para listar receitas(foto,dataPub,titulo de descricao) --%>
			<div class= "media">
				<div class="media-left media-middle">
    				<a href="#">
				      <img class="media-object" src="..." alt="...">
				    </a>
				 </div>
				 <div class="media-body">
				    <h4 class="media-heading">Middle aligned media</h4>
				    ...
				 </div>
			</div> 
		</div>
	</div>

</div>