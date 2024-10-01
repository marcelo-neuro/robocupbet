<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RoboCupBet</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
</head>
<body class="bg-black">

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
					href="/robocupbet/logout">Logout</a></li>
			</ul>
		</div>
	</nav>

	<main
		class="container d-flex flex-column justify-content-center align-items-center">

		<h1 class="text-light">Loja de Itens</h1>
		
		<c:if test="${not empty errorMessage}">
            <script>
                alert('${errorMessage}');
            </script>
        </c:if>

		<div
			class="position-loja form-usuario mt-5 me-5 d-flex flex-column align-items-center">
			<p class="px-5 text-center text-light mt-2">FIAPoints:
				${usuario.pontos}</p>
		</div>

		<div
			class="form-usuario w-50 d-flex flex-column align-items-center mt-5 mb-5 bg-fiap-grey">

			<c:forEach items="${premios}" var="premio">
				<form class="d-flex flex-column align-items-center mt-5 mb-5"
					id="form-loja-${premio.id}" method="post"
					action="/robocupbet/loja?p=${premio.id}&v=${premio.valor}">
					<img src="${premio.urlFoto}" class="img-loja img-fluid">
					<h2 class="text-light">${premio.nome}</h2>
					<p class="fs-4 text-light">$${premio.valor}</p>
					
					<button class="btn btn-style text-light fw-bold m-3 px-5"
						id="butao" type="submit" name="idPremio	" value="${premio.id}">Comprar</button>
				</form>
				<span class="w-75 fiap-border"></span>
			</c:forEach>

		</div>

	</main>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>