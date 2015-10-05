<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="home" class="tab-pane fade in active">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<form role="form" action="receita"
						name="receitaPublicada" method="post">
						<div class="form-group">

							<label for="exampleInputEmail1"> Titulo da Receita </label> <input
								class="form-control" name="tituloReceita" id="receitaTitulo"
								type="text">
						</div>
						<div class="form-group">
							<label for="comment">Digite a Receita:</label>
							<textarea class="form-control" rows="10" name="receita"
								id="receita"></textarea>
						</div>

						<button type="submit" class="btn btn-default">Postar</button>
					</form>
				</div>
				<div class="col-md-4"></div>
			</div>
		</div>
	</div>
</div>