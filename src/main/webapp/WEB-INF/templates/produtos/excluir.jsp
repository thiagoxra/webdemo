<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="minha" tagdir="/WEB-INF/tags" %>

<!doctype html>
<html lang="en">
<head>
	<c:import url="/WEB-INF/templates/common/_metatags.jsp" />
	<c:import url="/WEB-INF/templates/common/_bootstrap_css.jsp" />	
	<title>Editar Usuário</title>
</head>
<body class="container">
	<h1>Excluir Produto</h1>

	<form method="post" action="/produtos/delete/${Produto.id}">
		<div class="form-group">
		<minha:validatedinputtext rotulo="Nome" valor="${Produto.nome}"
			erroValidacao="${NomeInvalido}" invalido="${empty NomeInvalido}"
			textoPlaceholder="Nome do Produto" 
			idCampo="nome-input" nomeCampo="nome" editavel="disabled"/> 
		</div>
		<div class="form-group">
			<minha:validatedinputtext rotulo="Preco" valor="${Produto.preco}"
				erroValidacao="${PrecoInvalido}" invalido="${empty PrecoInvalido}"
				textoPlaceholder="Preço do Produto"
				idCampo="preco-input" nomeCampo="preco" editavel="disabled"/>	
		</div>

		<a href="/produtos" class="btn btn-danger">Cancelar</a>
		<button type="submit" class="btn btn-primary">Remover</button>
	</form>

	<c:import url="/WEB-INF/templates/common/_bootstrap_js.jsp" />
</body>
</html>