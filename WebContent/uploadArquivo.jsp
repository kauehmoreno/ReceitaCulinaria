<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <jsp:include page = "WEB-INF/widget/headers/headers.jsp" /> 
  <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>
					Ola, aqui voce ira armezenar a foto da receita informada!
				</h2>
				<p>
					Acreditamos que essa sua receita eh uma delicia! Insira uma imagem para que todos possam ver a maravilha final eh essa sua receita.
				</p>
				<p>
					<a id="modal-196738" href="#modal-container-196738" role="button"
						class="btn" data-toggle="modal">Inserir a foto da receita</a>

					<jsp:include page="WEB-INF/widget/modal.jsp" />
				</p>
			</div>
		</div>
	</div>
</div>
