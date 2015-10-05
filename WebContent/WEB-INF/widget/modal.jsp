<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="modal fade" id="modal-container-196738" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">

				<h4 class="modal-title" id="myModalLabel">Gostaria de anexar a foto da Receita?</h4>
			</div>
			<div class="modal-body">
				<form role="form" action="uploadFile" method="post"
					enctype="multipart/form-data">
					<div class="form-group">
						<label for="exampleInputFile"> Anexe a foto da receita </label> 
						<input type="file" name="uploadFile" /> 
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
						<input type="submit" value="Upload" class="btn btn-primary">
					</div>
				</form>
			</div>
		</div>

	</div>

</div>