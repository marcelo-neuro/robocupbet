<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Robocup bet</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
</head>
<body class="bg-black container-fluid">
	<nav class="navbar navbar-expand-lg p-3 d-flex header-page">
		<a class="navbar-brand ms-5 fs-2 text-light" href="/robocupbet/">
			<span class="title-cup">RoboCup</span> BET
		</a>
		<div class="collapse navbar-collapse grid gap-0 column-gap-3"
			id="navbarNav">
			<ul class="navbar-nav ms-auto me-5 fs-5">
				<li class="nav-item p-3"><a class="nav-link text-white"
					href="/robocupbet/index">Apostas</a></li>
				<li class="nav-item p-3"><a class="nav-link text-white"
					href="/robocupbet/loja">Loja</a></li>
				<li class="nav-item p-3"><a class="nav-link text-white"
					href="/robocupbet/perfil.jsp">Perfil</a></li>
				<li class="nav-item p-3"><a class="nav-link text-white"
					href="/robocupbet/logout">Logout</a></li>
			</ul>
		</div>
	</nav>

	<main
		class="container d-flex flex-column justify-content-center align-items-center">

		<h1 class="title-cup mt-2">Integrantes</h1>

		<div
			class="d-flex flex-column align-items-center bg-fiap-grey form-usuario p-5">
			<h2 class="text-light">Equipe: ${equipe.nome}</h2>
			<div class="d-flex">
				<c:forEach items="${integrantes}" var="integrante">
					<div class="d-flex flex-column align-items-center mx-3">
						<img src="${integrante.urlFoto}" class="img-integrantes img-fluid">
						<h3 class="title-cup">${integrante.nome}</h3>
					</div>
				</c:forEach>
			</div>

			<a href="/robocupbet/index"
				class="btn btn-style w-75 text-light fw-bold mt-5"> Voltar </a>

		</div>

	</main>
</body>
</html>