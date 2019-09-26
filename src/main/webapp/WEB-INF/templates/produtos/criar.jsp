<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="minha" tagdir="/WEB-INF/tags" %>

<!doctype html>
<html lang="en">
<head>
	<c:import url="/WEB-INF/templates/common/_metatags.jsp" />
	<c:import url="/WEB-INF/templates/common/_bootstrap_css.jsp" />	
	<title>Criar Usuário</title>
</head>
<body class="container">
	<h1>Criar Usuário</h1>
	<form method="post" action="/produtos">
		<div class="form-group">
			<minha:validatedinputtext rotulo="Nome" valor="${param.nome}"
				erroValidacao="${NomeInvalido}" invalido="${empty NomeInvalido}"
				textoPlaceholder="Seu Nome" 
				idCampo="nome-input" nomeCampo="nome" /> 
		</div>
		<div class="form-group">
			<minha:validatedinputtext rotulo="Descricao" valor="${param.descricao}"
				erroValidacao="${DescricaoInvalido}" invalido="${empty DescricaoInvalido}"
				textoPlaceholder="Seu Descricao"
				idCampo="Descricao-input" nomeCampo="Descricao" />	
		</div>
		<a href="/produtos" class="btn btn-danger">Cancelar</a>
		<button type="submit" class="btn btn-primary">Salvar</button>
	</form>

	<c:import url="/WEB-INF/templates/common/_bootstrap_js.jsp" />
</body>
</html>